package generated.ds.service3;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class RoomService {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new Service3Impl())
                .build();

        server.start();
        System.out.println("Server started, listening on " + 50051);

        server.awaitTermination();
    }

    static class Service3Impl extends Service3Grpc.Service3ImplBase {
        //@Override
        public void service3_do(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
            String text = request.getText();
            int length = text.length();

            ResponseMessage response = ResponseMessage.newBuilder()
                    .setLength(length)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

