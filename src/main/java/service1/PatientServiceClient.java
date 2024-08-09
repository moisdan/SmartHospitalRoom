package service1;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import service1.PatientServiceGrpc.PatientServiceBlockingStub;
import service1.PatientServiceGrpc.PatientServiceStub;
import service1.Service1.PatientRequest;
import service1.Service1.PatientResponse;
import service1.Service1.PatientVitalsResponse;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import service1.PatientServiceGrpc.PatientServiceBlockingStub;
import service1.PatientServiceGrpc.PatientServiceStub;
import service1.Service1.PatientRequest;
import service1.Service1.PatientResponse;
							// for JMdns imports
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class PatientServiceClient {

	public static void main(String[] args) {
        // Define the target server address
        String target = "localhost:50051";
        
        // Discover the service with JmDNS if available
        ServiceInfo serviceInfo = discoverServiceWithJmDNS();
        if (serviceInfo != null) {
            target = serviceInfo.getHostAddresses()[0] + ":" + serviceInfo.getPort();
        }
        
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

        // Create a blocking stub to call the unary RPC method
        PatientServiceBlockingStub blockingStub = PatientServiceGrpc.newBlockingStub(channel);

        // Create an asynchronous stub to call the streaming RPC method
        PatientServiceStub asyncStub = PatientServiceGrpc.newStub(channel);

        try {
            // Prepare the request message with patient ID
            PatientRequest request = PatientRequest.newBuilder().setPatientId(1).build();

            // Call the unary RPC method and get the response
            PatientResponse response = blockingStub.getPatientDetails(request);

            // Print the patient details received from the server
            System.out.println("Patient Details: Name = " + response.getName() + ", Code = " + response.getCode());

            // Call the streaming RPC method to get patient vitals
            asyncStub.getPatientVitals(request, new StreamObserver<PatientVitalsResponse>() {
                @Override
                public void onNext(PatientVitalsResponse value) {
                    System.out.println("Blood Pressure: " + value.getBloodPressure() + ", Heartbeat: " + value.getHeartbeat());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Errorxxx: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("Finished receiving vitals.");
                }
            });

            // Sleep to give the server time to send all the responses
            Thread.sleep(45000);

        } catch (StatusRuntimeException | InterruptedException e) {
            // Handle exceptions and print error details
            System.err.println("RPC failed: " + ((StatusRuntimeException) e).getStatus());
        } finally {
            // Shutdown the channel to free resources
           channel.shutdownNow();
        }
    }
	private static ServiceInfo discoverServiceWithJmDNS() { //added for the JMdns
        try {
            // Create a JmDNS instance and start service discovery
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Starting service discovery...");

            ServiceInfo serviceInfo = jmdns.getServiceInfo("_grpc._tcp.local.", "PatientService");
            if (serviceInfo != null) {
                System.out.println("PatientService discovered with JmDNS:");
                System.out.println("Service Name: " + serviceInfo.getName());
                System.out.println("Service Type: " + serviceInfo.getType());
                System.out.println("Service Host: " + serviceInfo.getHostAddresses()[0]);
                System.out.println("Service Port: " + serviceInfo.getPort());
            }
            return serviceInfo;
        } catch (IOException e) {
            System.err.println("Failed to discover service with JmDNS: " + e.getMessage());
            return null;
        }
    }
}

	
