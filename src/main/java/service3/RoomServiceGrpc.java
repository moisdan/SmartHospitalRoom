package service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service3.proto")
public final class RoomServiceGrpc {

  private RoomServiceGrpc() {}

  public static final String SERVICE_NAME = "service3.RoomService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service3.Service3.CleaningRoomRequest,
      service3.Service3.CleaningRoomResponse> getCleaningRoomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CleaningRoom",
      requestType = service3.Service3.CleaningRoomRequest.class,
      responseType = service3.Service3.CleaningRoomResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service3.Service3.CleaningRoomRequest,
      service3.Service3.CleaningRoomResponse> getCleaningRoomMethod() {
    io.grpc.MethodDescriptor<service3.Service3.CleaningRoomRequest, service3.Service3.CleaningRoomResponse> getCleaningRoomMethod;
    if ((getCleaningRoomMethod = RoomServiceGrpc.getCleaningRoomMethod) == null) {
      synchronized (RoomServiceGrpc.class) {
        if ((getCleaningRoomMethod = RoomServiceGrpc.getCleaningRoomMethod) == null) {
          RoomServiceGrpc.getCleaningRoomMethod = getCleaningRoomMethod = 
              io.grpc.MethodDescriptor.<service3.Service3.CleaningRoomRequest, service3.Service3.CleaningRoomResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.RoomService", "CleaningRoom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service3.Service3.CleaningRoomRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service3.Service3.CleaningRoomResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomServiceMethodDescriptorSupplier("CleaningRoom"))
                  .build();
          }
        }
     }
     return getCleaningRoomMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service3.Service3.RoomTemperatureRequest,
      service3.Service3.RoomTemperatureResponse> getRoomTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RoomTemperature",
      requestType = service3.Service3.RoomTemperatureRequest.class,
      responseType = service3.Service3.RoomTemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<service3.Service3.RoomTemperatureRequest,
      service3.Service3.RoomTemperatureResponse> getRoomTemperatureMethod() {
    io.grpc.MethodDescriptor<service3.Service3.RoomTemperatureRequest, service3.Service3.RoomTemperatureResponse> getRoomTemperatureMethod;
    if ((getRoomTemperatureMethod = RoomServiceGrpc.getRoomTemperatureMethod) == null) {
      synchronized (RoomServiceGrpc.class) {
        if ((getRoomTemperatureMethod = RoomServiceGrpc.getRoomTemperatureMethod) == null) {
          RoomServiceGrpc.getRoomTemperatureMethod = getRoomTemperatureMethod = 
              io.grpc.MethodDescriptor.<service3.Service3.RoomTemperatureRequest, service3.Service3.RoomTemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service3.RoomService", "RoomTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service3.Service3.RoomTemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service3.Service3.RoomTemperatureResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new RoomServiceMethodDescriptorSupplier("RoomTemperature"))
                  .build();
          }
        }
     }
     return getRoomTemperatureMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoomServiceStub newStub(io.grpc.Channel channel) {
    return new RoomServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoomServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RoomServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoomServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RoomServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class RoomServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void cleaningRoom(service3.Service3.CleaningRoomRequest request,
        io.grpc.stub.StreamObserver<service3.Service3.CleaningRoomResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCleaningRoomMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<service3.Service3.RoomTemperatureRequest> roomTemperature(
        io.grpc.stub.StreamObserver<service3.Service3.RoomTemperatureResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getRoomTemperatureMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCleaningRoomMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service3.Service3.CleaningRoomRequest,
                service3.Service3.CleaningRoomResponse>(
                  this, METHODID_CLEANING_ROOM)))
          .addMethod(
            getRoomTemperatureMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                service3.Service3.RoomTemperatureRequest,
                service3.Service3.RoomTemperatureResponse>(
                  this, METHODID_ROOM_TEMPERATURE)))
          .build();
    }
  }

  /**
   */
  public static final class RoomServiceStub extends io.grpc.stub.AbstractStub<RoomServiceStub> {
    private RoomServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomServiceStub(channel, callOptions);
    }

    /**
     */
    public void cleaningRoom(service3.Service3.CleaningRoomRequest request,
        io.grpc.stub.StreamObserver<service3.Service3.CleaningRoomResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCleaningRoomMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<service3.Service3.RoomTemperatureRequest> roomTemperature(
        io.grpc.stub.StreamObserver<service3.Service3.RoomTemperatureResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRoomTemperatureMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RoomServiceBlockingStub extends io.grpc.stub.AbstractStub<RoomServiceBlockingStub> {
    private RoomServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public service3.Service3.CleaningRoomResponse cleaningRoom(service3.Service3.CleaningRoomRequest request) {
      return blockingUnaryCall(
          getChannel(), getCleaningRoomMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RoomServiceFutureStub extends io.grpc.stub.AbstractStub<RoomServiceFutureStub> {
    private RoomServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RoomServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoomServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RoomServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service3.Service3.CleaningRoomResponse> cleaningRoom(
        service3.Service3.CleaningRoomRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCleaningRoomMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CLEANING_ROOM = 0;
  private static final int METHODID_ROOM_TEMPERATURE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoomServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoomServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLEANING_ROOM:
          serviceImpl.cleaningRoom((service3.Service3.CleaningRoomRequest) request,
              (io.grpc.stub.StreamObserver<service3.Service3.CleaningRoomResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ROOM_TEMPERATURE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.roomTemperature(
              (io.grpc.stub.StreamObserver<service3.Service3.RoomTemperatureResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoomServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service3.Service3.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoomService");
    }
  }

  private static final class RoomServiceFileDescriptorSupplier
      extends RoomServiceBaseDescriptorSupplier {
    RoomServiceFileDescriptorSupplier() {}
  }

  private static final class RoomServiceMethodDescriptorSupplier
      extends RoomServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoomServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (RoomServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoomServiceFileDescriptorSupplier())
              .addMethod(getCleaningRoomMethod())
              .addMethod(getRoomTemperatureMethod())
              .build();
        }
      }
    }
    return result;
  }
}
