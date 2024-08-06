package service1;

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
    comments = "Source: service1.proto")
public final class PatientServiceGrpc {

  private PatientServiceGrpc() {}

  public static final String SERVICE_NAME = "service1.PatientService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service1.Service1.PatientRequest,
      service1.Service1.PatientResponse> getGetPatientDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatientDetails",
      requestType = service1.Service1.PatientRequest.class,
      responseType = service1.Service1.PatientResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service1.Service1.PatientRequest,
      service1.Service1.PatientResponse> getGetPatientDetailsMethod() {
    io.grpc.MethodDescriptor<service1.Service1.PatientRequest, service1.Service1.PatientResponse> getGetPatientDetailsMethod;
    if ((getGetPatientDetailsMethod = PatientServiceGrpc.getGetPatientDetailsMethod) == null) {
      synchronized (PatientServiceGrpc.class) {
        if ((getGetPatientDetailsMethod = PatientServiceGrpc.getGetPatientDetailsMethod) == null) {
          PatientServiceGrpc.getGetPatientDetailsMethod = getGetPatientDetailsMethod = 
              io.grpc.MethodDescriptor.<service1.Service1.PatientRequest, service1.Service1.PatientResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service1.PatientService", "GetPatientDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service1.Service1.PatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service1.Service1.PatientResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientServiceMethodDescriptorSupplier("GetPatientDetails"))
                  .build();
          }
        }
     }
     return getGetPatientDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service1.Service1.PatientRequest,
      service1.Service1.PatientVitalsResponse> getGetPatientVitalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatientVitals",
      requestType = service1.Service1.PatientRequest.class,
      responseType = service1.Service1.PatientVitalsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<service1.Service1.PatientRequest,
      service1.Service1.PatientVitalsResponse> getGetPatientVitalsMethod() {
    io.grpc.MethodDescriptor<service1.Service1.PatientRequest, service1.Service1.PatientVitalsResponse> getGetPatientVitalsMethod;
    if ((getGetPatientVitalsMethod = PatientServiceGrpc.getGetPatientVitalsMethod) == null) {
      synchronized (PatientServiceGrpc.class) {
        if ((getGetPatientVitalsMethod = PatientServiceGrpc.getGetPatientVitalsMethod) == null) {
          PatientServiceGrpc.getGetPatientVitalsMethod = getGetPatientVitalsMethod = 
              io.grpc.MethodDescriptor.<service1.Service1.PatientRequest, service1.Service1.PatientVitalsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "service1.PatientService", "GetPatientVitals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service1.Service1.PatientRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service1.Service1.PatientVitalsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PatientServiceMethodDescriptorSupplier("GetPatientVitals"))
                  .build();
          }
        }
     }
     return getGetPatientVitalsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PatientServiceStub newStub(io.grpc.Channel channel) {
    return new PatientServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PatientServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PatientServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PatientServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PatientServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PatientServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPatientDetails(service1.Service1.PatientRequest request,
        io.grpc.stub.StreamObserver<service1.Service1.PatientResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPatientDetailsMethod(), responseObserver);
    }

    /**
     */
    public void getPatientVitals(service1.Service1.PatientRequest request,
        io.grpc.stub.StreamObserver<service1.Service1.PatientVitalsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPatientVitalsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPatientDetailsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                service1.Service1.PatientRequest,
                service1.Service1.PatientResponse>(
                  this, METHODID_GET_PATIENT_DETAILS)))
          .addMethod(
            getGetPatientVitalsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                service1.Service1.PatientRequest,
                service1.Service1.PatientVitalsResponse>(
                  this, METHODID_GET_PATIENT_VITALS)))
          .build();
    }
  }

  /**
   */
  public static final class PatientServiceStub extends io.grpc.stub.AbstractStub<PatientServiceStub> {
    private PatientServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPatientDetails(service1.Service1.PatientRequest request,
        io.grpc.stub.StreamObserver<service1.Service1.PatientResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPatientDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPatientVitals(service1.Service1.PatientRequest request,
        io.grpc.stub.StreamObserver<service1.Service1.PatientVitalsResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPatientVitalsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PatientServiceBlockingStub extends io.grpc.stub.AbstractStub<PatientServiceBlockingStub> {
    private PatientServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public service1.Service1.PatientResponse getPatientDetails(service1.Service1.PatientRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPatientDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<service1.Service1.PatientVitalsResponse> getPatientVitals(
        service1.Service1.PatientRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPatientVitalsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PatientServiceFutureStub extends io.grpc.stub.AbstractStub<PatientServiceFutureStub> {
    private PatientServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PatientServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PatientServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PatientServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service1.Service1.PatientResponse> getPatientDetails(
        service1.Service1.PatientRequest request) {
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
    private final PatientServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PatientServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PATIENT_DETAILS:
          serviceImpl.getPatientDetails((service1.Service1.PatientRequest) request,
              (io.grpc.stub.StreamObserver<service1.Service1.PatientResponse>) responseObserver);
          break;
        case METHODID_GET_PATIENT_VITALS:
          serviceImpl.getPatientVitals((service1.Service1.PatientRequest) request,
              (io.grpc.stub.StreamObserver<service1.Service1.PatientVitalsResponse>) responseObserver);
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

  private static abstract class PatientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PatientServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service1.Service1.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PatientService");
    }
  }

  private static final class PatientServiceFileDescriptorSupplier
      extends PatientServiceBaseDescriptorSupplier {
    PatientServiceFileDescriptorSupplier() {}
  }

  private static final class PatientServiceMethodDescriptorSupplier
      extends PatientServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PatientServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PatientServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PatientServiceFileDescriptorSupplier())
              .addMethod(getGetPatientDetailsMethod())
              .addMethod(getGetPatientVitalsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
