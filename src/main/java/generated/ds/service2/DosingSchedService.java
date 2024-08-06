package generated.ds.service2;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class DosingSchedService {
	
	    public static void main(String[] args) throws IOException, InterruptedException {
	        Server server = ServerBuilder.forPort(50052)
	                .addService(new Service2Impl())
	                .build();

	        server.start();
	        System.out.println("Server started, listening on " + 50052);

	        server.awaitTermination();
	    }

	    static class Service2Impl extends Service2Grpc.Service2ImplBase {
	        //@Override
	        public void  DosingSchedServicedo(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
	            String text = request.getText();
	            int length = text.length();

	            for (int i = 0; i < length; i++) {
	                ResponseMessage response = ResponseMessage.newBuilder()
	                        .setLength(length)
	                        .build();
	                responseObserver.onNext(response);
	                
	                try {
	                    Thread.sleep(1000); // Simulate delay for streaming response
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }

	            responseObserver.onCompleted();
	        }
	    }
	}


