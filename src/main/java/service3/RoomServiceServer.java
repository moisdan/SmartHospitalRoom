package service3;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import service3.RoomServiceGrpc.RoomServiceImplBase;
import service3.Service3.*;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class RoomServiceServer extends RoomServiceImplBase {
	
	public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start the gRPC server
        RoomServiceServer service = new RoomServiceServer();
        int port = 50053; // Port on which the server will listen

        Server grpcServer = ServerBuilder.forPort(port)
                .addService(service)
                .build()
                .start();

        System.out.println("RoomServiceServer started, listening on " + port);

        // Register the service with jmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "RoomService", port, "gRPC RoomService");
        jmdns.registerService(serviceInfo);

        // Keep the server running
        grpcServer.awaitTermination();
    }

    @Override
    public void cleaningRoom(CleaningRoomRequest request, StreamObserver<CleaningRoomResponse> responseObserver) {
        int roomId = request.getRoomId();
        String status = "Room " + roomId + " cleaned successfully";

        CleaningRoomResponse response = CleaningRoomResponse.newBuilder()
                .setStatus(status)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<RoomTemperatureRequest> roomTemperature(StreamObserver<RoomTemperatureResponse> responseObserver) {
        return new StreamObserver<RoomTemperatureRequest>() {
            @Override
            public void onNext(RoomTemperatureRequest request) {
                int temperature = 21 + (int)(Math.random() * 6 - 3); // random Temperature between 19-23.
                RoomTemperatureResponse response = RoomTemperatureResponse.newBuilder()
                        .setTemperature(temperature)
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}


