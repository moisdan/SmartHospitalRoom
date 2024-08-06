package service2;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import service2.DosingScheduleServiceGrpc.DosingScheduleServiceImplBase;
import service2.Service2.MedicationAlert;
import service2.Service2.MedicationAlertSummary;
import service2.Service2.MedicationRequest;
import service2.Service2.MedicationResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DosingScheduleServer extends DosingScheduleServiceImplBase {
	
	public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        DosingScheduleServer server = new DosingScheduleServer();
        int port = 50052; // Port on which the server will listen

        // Build the server and start it
        Server grpcServer = ServerBuilder.forPort(port)
                .addService(server) // Add the implemented service
                .build()
                .start();

        System.out.println("DosingScheduleServer started, listening on " + port);
        grpcServer.awaitTermination(); // Keep the server running
    }

    @Override
    public void getMedicationSchedule(MedicationRequest request, StreamObserver<MedicationResponse> responseObserver) {
        // Extract patient ID from the request
        int patientId = request.getPatientId();

        // Dummy data for medication schedule
        String dosage = "10mg";
        String medicamentName = "Morphine";

        // Build the response
        MedicationResponse response = MedicationResponse.newBuilder()
                .setDosage(dosage)
                .setMedicamentName(medicamentName)
                .build();

        // Send the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted(); // Indicate the end of the RPC call
    }

    @Override
    public StreamObserver<MedicationAlert> alertMedication(StreamObserver<MedicationAlertSummary> responseObserver) {
        return new StreamObserver<MedicationAlert>() {
            List<String> alerts = new ArrayList<>();
            int skipped = 0;
            int confirmed = 0;

            @Override
            public void onNext(MedicationAlert alert) {
                // Process each medication alert
                String dosageDetails = alert.getDosageDetails();
                alerts.add(dosageDetails);

                // For simplicity, assume even indexes are confirmed doses, odd indexes are skipped doses
                if (alerts.size() % 2 == 0) {
                    confirmed++;
                } else {
                    skipped++;
                }
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors during streaming
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Once all alerts are received, send a summary
                String summary = "Confirmed doses: " + confirmed + ", Skipped doses: " + skipped;
                MedicationAlertSummary alertSummary = MedicationAlertSummary.newBuilder()
                        .setSummary(summary)
                        .build();

                // Send the summary to the client
                responseObserver.onNext(alertSummary);
                responseObserver.onCompleted(); // Indicate the end of the RPC call
            }
        };
    }
}
	

