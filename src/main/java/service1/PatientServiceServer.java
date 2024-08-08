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
    	//Runnable task = new Runnable() {
	    	 // takes the patient ID from the request
	        // Stream GRPC: sending multiple vitals signals
	        int patientId = request.getPatientId();
	        
	     // this makes the Simulation of the streaming for  vitals signals
	        for (int i = 0; i < 5; i++) {
	       // while(true) {
	        	
	        	// Creating  a new reply for blood pressure and heartbeats
	            PatientVitalsResponse vitalsResponse = PatientVitalsResponse.newBuilder()
	                    .setBloodPressure(120 + (int)Math.floor(Math.random() * 30 - 15))// range from 105 to 135 
	                    .setHeartbeat(80 + (int)Math.floor(Math.random() * 15))// range from 80 to 95.
	                    .build();
	            // building 5 response witng 5 second between after completing gets out of loop and finish
	            
	            try {
	            	Thread.sleep(5000);
	            	responseObserver.onNext(vitalsResponse);
    	
	            }catch (Exception e) {
	            	
	           }
    	}
        responseObserver.onCompleted();
    }
}


