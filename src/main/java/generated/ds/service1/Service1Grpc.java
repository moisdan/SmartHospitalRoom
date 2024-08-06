package generated.ds.service1;

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
 * <pre>
 * The service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: service1.proto")
public final class Service1Grpc {

  private Service1Grpc() {}

  public static final String SERVICE_NAME = "generated.ds.service1.Service1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.ds.service1.Service1OuterClass.PatientRequest,
      generated.ds.service1.Service1OuterClass.PatientResponse> getGetPatientDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatientDetails",
      requestType = generated.ds.service1.Service1OuterClass.PatientRequest.class,
      responseType = generated.ds.service1.Service1OuterClass.PatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.ds.service1.Service1OuterClass.PatientRequest,
      generated.ds.service1.Service1OuterClass.PatientResponse> getGetPatientDetailsMethod() {
    io.grpc.MethodDescriptor<generated.ds.service1.Service1OuterClass.PatientRequest, generated.ds.service1.Service1OuterClass.PatientResponse> getGetPatientDetailsMethod;
    if ((getGetPatientDetailsMethod = Service1Grpc.getGetPatientDetailsMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getGetPatientDetailsMethod = Service1Grpc.getGetPatientDetailsMethod) == null) {
          Service1Grpc.getGetPatientDetailsMethod = getGetPatientDetailsMethod = 
              io.grpc.MethodDescriptor.<generated.ds.service1.Service1OuterClass.PatientRequest, generated.ds.service1.Service1OuterClass.PatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "generated.ds.service1.Service1", "GetPatientDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.Service1OuterClass.PatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.Service1OuterClass.PatientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service1MethodDescriptorSupplier("GetPatientDetails"))
                  .build();
          }
        }
     }
     return getGetPatientDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.ds.service1.Service1OuterClass.PatientRequest,
      generated.ds.service1.Service1OuterClass.VitalResponse> getGetPatientVitalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatientVitals",
      requestType = generated.ds.service1.Service1OuterClass.PatientRequest.class,
      responseType = generated.ds.service1.Service1OuterClass.VitalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.ds.service1.Service1OuterClass.PatientRequest,
      generated.ds.service1.Service1OuterClass.VitalResponse> getGetPatientVitalsMethod() {
    io.grpc.MethodDescriptor<generated.ds.service1.Service1OuterClass.PatientRequest, generated.ds.service1.Service1OuterClass.VitalResponse> getGetPatientVitalsMethod;
    if ((getGetPatientVitalsMethod = Service1Grpc.getGetPatientVitalsMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getGetPatientVitalsMethod = Service1Grpc.getGetPatientVitalsMethod) == null) {
          Service1Grpc.getGetPatientVitalsMethod = getGetPatientVitalsMethod = 
              io.grpc.MethodDescriptor.<generated.ds.service1.Service1OuterClass.PatientRequest, generated.ds.service1.Service1OuterClass.VitalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "generated.ds.service1.Service1", "GetPatientVitals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.Service1OuterClass.PatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.ds.service1.Service1OuterClass.VitalResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Service1MethodDescriptorSupplier("GetPatientVitals"))
                  .build();
          }
        }
     }
     return getGetPatientVitalsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service1Stub newStub(io.grpc.Channel channel) {
    return new Service1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Service1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Service1FutureStub(channel);
  }

  /**
   * <pre>
   * The service definition
   * </pre>
   */
  public static abstract class Service1ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Unary RPC method
     * </pre>
     */
    public void getPatientDetails(generated.ds.service1.Service1OuterClass.PatientRequest request,
        io.grpc.stub.StreamObserver<generated.ds.service1.Service1OuterClass.PatientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPatientDetailsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Server-streaming RPC method
     * </pre>
     */
    public void getPatientVitals(generated.ds.service1.Service1OuterClass.PatientRequest request,
        io.grpc.stub.StreamObserver<generated.ds.service1.Service1OuterClass.VitalResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPatientVitalsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPatientDetailsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.ds.service1.Service1OuterClass.PatientRequest,
                generated.ds.service1.Service1OuterClass.PatientResponse>(
                  this, METHODID_GET_PATIENT_DETAILS)))
          .addMethod(
            getGetPatientVitalsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.ds.service1.Service1OuterClass.PatientRequest,
                generated.ds.service1.Service1OuterClass.VitalResponse>(
                  this, METHODID_GET_PATIENT_VITALS)))
          .build();
    }
  }

  /**
   * <pre>
   * The service definition
   * </pre>
   */
  public static final class Service1Stub extends io.grpc.stub.AbstractStub<Service1Stub> {
    private Service1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC method
     * </pre>
     */
    public void getPatientDetails(generated.ds.service1.Service1OuterClass.PatientRequest request,
        io.grpc.stub.StreamObserver<generated.ds.service1.Service1OuterClass.PatientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPatientDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Server-streaming RPC method
     * </pre>
     */
    public void getPatientVitals(generated.ds.service1.Service1OuterClass.PatientRequest request,
        io.grpc.stub.StreamObserver<generated.ds.service1.Service1OuterClass.VitalResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPatientVitalsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service definition
   * </pre>
   */
  public static final class Service1BlockingStub extends io.grpc.stub.AbstractStub<Service1BlockingStub> {
    private Service1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC method
     * </pre>
     */
    public generated.ds.service1.Service1OuterClass.PatientResponse getPatientDetails(generated.ds.service1.Service1OuterClass.PatientRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPatientDetailsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Server-streaming RPC method
     * </pre>
     */
    public java.util.Iterator<generated.ds.service1.Service1OuterClass.VitalResponse> getPatientVitals(
        generated.ds.service1.Service1OuterClass.PatientRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPatientVitalsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service definition
   * </pre>
   */
  public static final class Service1FutureStub extends io.grpc.stub.AbstractStub<Service1FutureStub> {
    private Service1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service1FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Unary RPC method
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.ds.service1.Service1OuterClass.PatientResponse> getPatientDetails(
        generated.ds.service1.Service1OuterClass.PatientRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPatientDetailsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PATIENT_DETAILS = 0;
  private static final int METHODID_GET_PATIENT_VITALS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PATIENT_DETAILS:
          serviceImpl.getPatientDetails((generated.ds.service1.Service1OuterClass.PatientRequest) request,
              (io.grpc.stub.StreamObserver<generated.ds.service1.Service1OuterClass.PatientResponse>) responseObserver);
          break;
        case METHODID_GET_PATIENT_VITALS:
          serviceImpl.getPatientVitals((generated.ds.service1.Service1OuterClass.PatientRequest) request,
              (io.grpc.stub.StreamObserver<generated.ds.service1.Service1OuterClass.VitalResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.ds.service1.Service1OuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service1");
    }
  }

  private static final class Service1FileDescriptorSupplier
      extends Service1BaseDescriptorSupplier {
    Service1FileDescriptorSupplier() {}
  }

  private static final class Service1MethodDescriptorSupplier
      extends Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service1MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service1FileDescriptorSupplier())
              .addMethod(getGetPatientDetailsMethod())
              .addMethod(getGetPatientVitalsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
