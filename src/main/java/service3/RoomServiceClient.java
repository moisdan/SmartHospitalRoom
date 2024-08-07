package service3;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import service3.RoomServiceGrpc.RoomServiceStub;
import service3.Service3.*;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;


public class RoomServiceClient {
	
	public static void main(String[] args) throws IOException, InterruptedException {
        // Discover the gRPC service with jmDNS
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        ServiceInfo serviceInfo = jmdns.getServiceInfo("_grpc._tcp.local.", "RoomService");
        if (serviceInfo == null) {
            System.err.println("RoomService not found");
            return;
        }

        String target = serviceInfo.getHostAddresses()[0] + ":" + serviceInfo.getPort();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();

        // Create stubs
        RoomServiceGrpc.RoomServiceBlockingStub blockingStub = RoomServiceGrpc.newBlockingStub(channel);
        RoomServiceStub asyncStub = RoomServiceGrpc.newStub(channel);

        // Unary RPC call
        CleaningRoomRequest cleaningRequest = CleaningRoomRequest.newBuilder().setRoomId(1).build();
        CleaningRoomResponse cleaningResponse = blockingStub.cleaningRoom(cleaningRequest);
        System.out.println("Cleaning Status: " + cleaningResponse.getStatus());

        // Bidirectional streaming RPC call
        StreamObserver<RoomTemperatureRequest> requestObserver = asyncStub.roomTemperature(new StreamObserver<RoomTemperatureResponse>() {
            @Override
            public void onNext(RoomTemperatureResponse response) {
                System.out.println("Temperature: " + response.getTemperature());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Temperature streaming completed.");
            }
        });

        for (int i = 0; i < 5; i++) {
            RoomTemperatureRequest temperatureRequest = RoomTemperatureRequest.newBuilder().setRoomId(1).build();
            requestObserver.onNext(temperatureRequest);
            TimeUnit.SECONDS.sleep(1);
        }

        requestObserver.onCompleted();
        TimeUnit.SECONDS.sleep(1); // Allow some time for responses

        channel.shutdownNow();
    }
}


