package service2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import service2.DosingScheduleServiceGrpc.DosingScheduleServiceBlockingStub;
import service2.DosingScheduleServiceGrpc.DosingScheduleServiceStub;
import service2.Service2.MedicationAlert;
import service2.Service2.MedicationRequest;
import service2.Service2.MedicationResponse;
import service2.Service2.MedicationAlertSummary;



public class DosingScheduleClient {
	
	 public static void main(String[] args) {
	        // Define the target server address
	        String target = "localhost:50052";
	        // Create a channel to connect to the server
	        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

	        // Create a blocking stub to call the unary RPC method
	        DosingScheduleServiceBlockingStub blockingStub = DosingScheduleServiceGrpc.newBlockingStub(channel);

	        // Create an asynchronous stub to call the streaming RPC method
	        DosingScheduleServiceStub asyncStub = DosingScheduleServiceGrpc.newStub(channel);

	        try {
	            // Prepare the request message with patient ID
	            MedicationRequest request = MedicationRequest.newBuilder().setPatientId(222).build();

	            // Call the unary RPC method and get the response
	            MedicationResponse response = blockingStub.getMedicationSchedule(request);

	            // Print the medication schedule received from the server
	            System.out.println("Medication Schedule: Dosage = " + response.getDosage() + ", Medicament Name = " + response.getMedicamentName());

	            // Call the streaming RPC method to send medication alerts
	            StreamObserver<MedicationAlert> requestObserver = asyncStub.alertMedication(new StreamObserver<MedicationAlertSummary>() {
	                @Override
	                public void onNext(MedicationAlertSummary value) {
	                    // Print the summary of medication alerts
	                    System.out.println("Medication Alert Summary: " + value.getSummary());
	                }

	                @Override
	                public void onError(Throwable t) {
	                    // Handle any errors during streaming
	                    t.printStackTrace();
	                }

	                @Override
	                public void onCompleted() {
	                    // Indicate the end of receiving the summary
	                    System.out.println("Finished sending medication alerts.");
	                }
	            });

	            // Send a few medication alerts
	            for (int i = 1; i <= 5; i++) {
	                MedicationAlert alert = MedicationAlert.newBuilder().setDosageDetails("Dose " + i).build();
	                requestObserver.onNext(alert);
	                Thread.sleep(3000);
	            }
	            // Complete the stream
	            requestObserver.onCompleted();

	            // Sleep to give the server time to process the alerts
	            Thread.sleep(3000);

	        } catch (StatusRuntimeException | InterruptedException e) {
	             //Handle exceptions and print error details
	           e.printStackTrace();
	        } finally {
	            // Shutdown the channel to free resources
	            channel.shutdownNow();
	        }
	    }
	}
	
