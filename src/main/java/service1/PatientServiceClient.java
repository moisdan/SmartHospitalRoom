package service1;


import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import service1.PatientServiceGrpc.PatientServiceBlockingStub;
import service1.Service1.PatientRequest;
import service1.Service1.PatientResponse;

public class PatientServiceClient {

	public static void main(String[] args) {
        // Define the target server address
        String target = "localhost:50051";
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

        // Create a blocking stub to call the server
        PatientServiceBlockingStub blockingStub = PatientServiceGrpc.newBlockingStub(channel);

        try {
            // Prepare the request message with patient ID
            PatientRequest request = PatientRequest.newBuilder().setPatientId(1).build();

            // Call the unary RPC method and get the response
            PatientResponse response = blockingStub.getPatientDetails(request);

            // Print the patient details received from the server
            System.out.println("Patient Details: Name = " + response.getName() + ", Code = " + response.getCode());

        } catch (StatusRuntimeException e) {
            // Handle exceptions and print error details
            System.err.println("RPC failed: " + e.getStatus());
        } finally {
            // Shutdown the channel to free resources
            channel.shutdownNow();
        }
    }
}
	
