package service1;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import service1.PatientServiceGrpc.PatientServiceImplBase;
import service1.Service1.PatientRequest;
import service1.Service1.PatientResponse;
import service1.Service1.PatientVitalsResponse;

public class PatientServiceServer extends PatientServiceImplBase {
	
	public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        PatientServiceServer server = new PatientServiceServer();
        int port = 50051; // Port on which server will listen

        // Build the server and start it
        Server grpcServer = ServerBuilder.forPort(port)
                .addService(server) // Add the implemented service
                .build()
                .start();

        System.out.println("PatientServiceServer started, listening on " + port);
        grpcServer.awaitTermination(); // Keep the server running
    }

    @Override
    public void getPatientDetails(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        // takes ID of the patient from the request
        int patientId = request.getPatientId();

        // the patient name goes here
        String name = "Moises Gonzalez"; // gives patient name based on patientId
        int code = 222; // gives patient code based on patientId

        // Building the response
        PatientResponse response = PatientResponse.newBuilder()
                .setName(name)
                .setCode(code)
                .build();

        // Send back the response to the client
        responseObserver.onNext(response);
        responseObserver.onCompleted(); // Indicate the end of the RPC call
    }
    
    
    // patient vitals from here
    @Override
    public void getPatientVitals(PatientRequest request, StreamObserver<PatientVitalsResponse> responseObserver) {
    	
    	 // takes the patient ID from the request
        // Stream GRPC: sending multiple vitals signals
        int patientId = request.getPatientId();
        
     // this makes the Simulation of the streaming for  vitals signals
        for (int i = 0; i < 5; i++) {
        	
        	// Creating  a new reply for blood pressure and heartbeats
            PatientVitalsResponse vitalsResponse = PatientVitalsResponse.newBuilder()
                    .setBloodPressure(120)
                    .setHeartbeat(80)
                    .build();
            
            responseObserver.onNext(vitalsResponse);
        }
        
        responseObserver.onCompleted();
    }
}


