package ClientGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import service1.PatientServiceGrpc;
import service1.Service1;
import service2.DosingScheduleServiceGrpc;
import service2.Service2;
import service2.Service2.MedicationAlertSummary;
import service3.RoomServiceGrpc;
import service3.Service3;
import service3.Service3.CleaningRoomResponse;
import service3.Service3.RoomTemperatureRequest;
import service3.Service3.RoomTemperatureResponse;

import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;


public class SmartHospitalApp extends JFrame {
	
	//variables:
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField PResponse; // Field for displaying patient details
    private JTextField Vresponse; // Field for displaying patient vitals
    private JTextField MedScheResponse; // Field for displaying medication schedule
    private JTextField AlertResponse; // Field for displaying alert medication summary
    private JTextField CleanResponse; // Field for displaying cleaning status
    private JTextField TempResponse; // Field for displaying room temperature

    // gRPC channel and stubs
  //Service 1
    private ManagedChannel channel;
    private PatientServiceGrpc.PatientServiceBlockingStub patientServiceBlockingStub;//Service 1
    private PatientServiceGrpc.PatientServiceStub patientServiceStub;
  //service2
    private ManagedChannel channel2;
    private DosingScheduleServiceGrpc.DosingScheduleServiceBlockingStub dosingScheduleServiceBlockingStub;//service2
    private DosingScheduleServiceGrpc.DosingScheduleServiceStub dosingScheduleServiceStub;
    private JTextField id1;
  //Service 3
    private ManagedChannel channel3;
    private RoomServiceGrpc.RoomServiceBlockingStub roomServiceBlockingStub;
    private RoomServiceGrpc.RoomServiceStub roomServiceStub;
    //private DosingScheduleServiceGrpc.DosingScheduleServiceBlockingStub dosingScheduleServiceBlockingStub;//service2
    //private DosingScheduleServiceGrpc.DosingScheduleServiceStub dosingScheduleServiceStub;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartHospitalApp frame = new SmartHospitalApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SmartHospitalApp() {
		setBackground(new Color(240, 240, 240));
		setTitle("SmartHospitalRoom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Method1: PatientID");
		lblNewLabel.setBounds(10, 44, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Method 2: Patient vitals");
		lblNewLabel_1.setBounds(10, 85, 170, 14);
		contentPane.add(lblNewLabel_1);
		
		PResponse = new JTextField();
		PResponse.setBounds(262, 41, 316, 20);
		contentPane.add(PResponse);
		PResponse.setColumns(10);
		
		Vresponse = new JTextField();
		Vresponse.setBounds(262, 82, 316, 20);
		contentPane.add(Vresponse);
		Vresponse.setColumns(10);
		
		JButton PatientIDBtn = new JButton("OK");
		PatientIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPatientDetails(); // Method to get patient details
			}
		});
		PatientIDBtn.setBounds(200, 40, 52, 23);
		contentPane.add(PatientIDBtn);
		
		JButton PvitalsBtn = new JButton("OK");
		PvitalsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPatientVitals();
			}
		});
		PvitalsBtn.setBounds(200, 81, 52, 23);
		contentPane.add(PvitalsBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Service 1: Patient Details");
		lblNewLabel_2.setBounds(159, 11, 170, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Service 2: Dosing Schedule");
		lblNewLabel_3.setBounds(159, 130, 170, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Method 1:medication Schedule");
		lblNewLabel_4.setBounds(10, 191, 181, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Method 2: Alert medication");
		lblNewLabel_5.setBounds(11, 216, 180, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton MedSchduleBtn = new JButton("OK");
		MedSchduleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMedicationSchedule();// trigger response
			}
		});
		MedSchduleBtn.setBounds(201, 187, 52, 23);
		contentPane.add(MedSchduleBtn);
		
		JButton AlertBtn = new JButton("OK");
		AlertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMedicationAlerts();
			}
		});
		AlertBtn.setBounds(201, 216, 52, 23);
		contentPane.add(AlertBtn);
		
		MedScheResponse = new JTextField();
		MedScheResponse.setBounds(263, 188, 316, 20);
		contentPane.add(MedScheResponse);
		MedScheResponse.setColumns(10);
		
		AlertResponse = new JTextField();
		AlertResponse.setBounds(263, 217, 316, 22);
		contentPane.add(AlertResponse);
		AlertResponse.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Service3: Room Service");
		lblNewLabel_6.setBounds(166, 271, 136, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Method 1: cleaning Room");
		lblNewLabel_7.setBounds(10, 324, 180, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Method 2: Room Temperature");
		lblNewLabel_8.setBounds(10, 352, 180, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton CleanBtn = new JButton("OK");
		CleanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCleaningRoom();
			}
		});
		CleanBtn.setBounds(200, 320, 52, 23);
		contentPane.add(CleanBtn);
		
		JButton TempBtn = new JButton("OK");
		TempBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getServiceRoom();
			}
		});
		TempBtn.setBounds(200, 348, 52, 23);
		contentPane.add(TempBtn);
		
		CleanResponse = new JTextField();
		CleanResponse.setBounds(262, 323, 316, 20);
		contentPane.add(CleanResponse);
		CleanResponse.setColumns(10);
		
		TempResponse = new JTextField();
		TempResponse.setBounds(262, 349, 316, 20);
		contentPane.add(TempResponse);
		TempResponse.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 272, 568, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 130, 568, 2);
		contentPane.add(separator_1);
		
		// Initialize gRPC clients
		 initializeGrpcClients();
	}
	
 //Service 1: Patient details  

	private void initializeGrpcClients() {
	    // Create a gRPC channel to communicate with the server
	    channel = ManagedChannelBuilder.forAddress("localhost", 50051)
	            .usePlaintext() // Use plain text communication (no encryption)
	            .build();
	
	    // Initialize stubs for each gRPC Patient details service 1
	    patientServiceBlockingStub = PatientServiceGrpc.newBlockingStub(channel);
	    patientServiceStub = PatientServiceGrpc.newStub(channel);
	    
	    
	    channel2 = ManagedChannelBuilder.forAddress("localhost", 50052)
	            .usePlaintext() // Use plain text communication (no encryption)
	            .build();
	    // Initialize stubs for Dosing Schedule service 2
	    dosingScheduleServiceBlockingStub = DosingScheduleServiceGrpc.newBlockingStub(channel2);
	    dosingScheduleServiceStub = DosingScheduleServiceGrpc.newStub(channel2);
	    
	    channel3 = ManagedChannelBuilder.forAddress("localhost", 50053)
	            .usePlaintext() // Use plain text communication (no encryption)
	            .build();
	    // Initialize stubs for room service service 3
	    roomServiceBlockingStub = RoomServiceGrpc.newBlockingStub(channel3);
	    roomServiceStub = RoomServiceGrpc.newStub(channel3);
	}

/**
 * Method to get patient details (unary RPC)
 */
	private void getPatientDetails() {
	    if (patientServiceBlockingStub == null) {
	        PResponse.setText("gRPC stub is not initialized.");
	        return;
	    }
	    try {
	        // Create a request for patient details
	        Service1.PatientRequest request = Service1.PatientRequest.newBuilder().setPatientId(222).build();
	        // Get the response from the server
	        Service1.PatientResponse response = patientServiceBlockingStub.getPatientDetails(request);
	        // Update the text field with the received details
	        PResponse.setText("Name: " + response.getName() + ", Code: " + response.getCode());
	    } catch (StatusRuntimeException e) {
	        // Handle the exception by displaying the error in the text field
	        PResponse.setText("RPC failed: " + e.getStatus());
	    }
	}

/**
 * Method to get patient vitals (server streaming RPC)
 */
	private void getPatientVitals() {
	    if (patientServiceStub == null) {
	        Vresponse.setText("gRPC stub is not initialized.");
	        return;
	    }
	    // Create a request for patient vitals
	    Service1.PatientRequest request = Service1.PatientRequest.newBuilder().setPatientId(123).build();
	    // Make a server streaming RPC call
	    patientServiceStub.getPatientVitals(request, new StreamObserver<Service1.PatientVitalsResponse>() {
	        @Override
	        public void onNext(Service1.PatientVitalsResponse value) {
	            // Update the text field with each received vital
	            Vresponse.setText("Blood Pressure: " + value.getBloodPressure() + ", Heartbeat: " + value.getHeartbeat());
	        }
	
	        @Override
	        public void onError(Throwable t) {
	            // Handle the error by displaying it in the text field
	            Vresponse.setText("Error: " + t.getMessage());
	        }
	
	        @Override
	        public void onCompleted() {
	            // Indicate that the streaming has finished
	            Vresponse.setText("Finished receiving vitals.");
	        }
	    });
	}
	
	// Service 2: method 1 . Get Medication Schedule (Unary RPC)

    private void getMedicationSchedule() {
    	    	
    	    if (dosingScheduleServiceBlockingStub == null) {
    	    	MedScheResponse.setText("gRPC stub is not initialized.");
    	        return;
    	    }
    	    try {
    	        // Create a request for patient details
    	        Service2.MedicationRequest request = Service2.MedicationRequest.newBuilder().setPatientId(222).build();
    	        // Get the response from the server
    	        Service2.MedicationResponse response = dosingScheduleServiceBlockingStub.getMedicationSchedule(request);
    	        // Update the text field with the received details
    	        MedScheResponse.setText("Name: " + response.getMedicamentName() + ", Dosage: " + response.getDosage());
    	    } catch (StatusRuntimeException e) {
    	        // Handle the exception by displaying the error in the text field
    	    	MedScheResponse.setText("RPC failed: " + e.getStatus());
    	    }
    	}

 // Service 2: Send Medication Alerts (Client Streaming RPC)
    
    private void sendMedicationAlerts() {
    	
    	    if (dosingScheduleServiceStub == null) {
    	        AlertResponse.setText("gRPC stub is not initialized.");
    	        return;
    	    }

    	    // Create a StreamObserver for sending medication alerts
    	    StreamObserver<Service2.MedicationAlert> requestObserver = dosingScheduleServiceStub.alertMedication(
    	        new StreamObserver<MedicationAlertSummary>() {
    	            @Override
    	            public void onNext(Service2.MedicationAlertSummary value) {
    	                // This is called when the server sends a response to the client
    	                AlertResponse.setText("Alert Summary: " + value.getSummary());
    	            }

    	            @Override
    	            public void onError(Throwable t) {
    	                // Handle errors that occur during the RPC
    	                AlertResponse.setText("Error: " + t.getMessage());
    	            }

    	            @Override
    	            public void onCompleted() {
    	                // Indicate that the server has finished sending responses
    	                //AlertResponse.setText("Alert process completed.");
    	            }
    	        }
    	    );

    	    try {
    	        // Send a few example MedicationAlert messages
    	        requestObserver.onNext(Service2.MedicationAlert.newBuilder().setDosageDetails("222").build());
    	        //requestObserver.onNext(Service2.MedicationAlert.newBuilder().setAlertMessage("Medication 2").build());
    	        
    	        // Complete the sending process
    	        requestObserver.onCompleted();
    	    } catch (Exception e) {
    	        // Handle exceptions that may occur while sending data
    	        requestObserver.onError(e);
    	    }
    	}
 // Service 3: method 1 . serviceRoom

    private void getCleaningRoom() {
    	    	
    	    if (dosingScheduleServiceBlockingStub == null) {
    	    	CleanResponse.setText("gRPC stub is not initialized.");
    	        return;
    	    }
    	    try {
    	        // Create a request for patient details
    	        Service3.CleaningRoomRequest request = Service3.CleaningRoomRequest.newBuilder().setRoomId(1).build();
    	        // Get the response from the server
    	        Service3.CleaningRoomResponse response = roomServiceBlockingStub.cleaningRoom(request);
    	        // Update the text field with the received details
    	        CleanResponse.setText("Status: " + response.getStatus());
    	    } catch (StatusRuntimeException e) {
    	        // Handle the exception by displaying the error in the text field
    	    	CleanResponse.setText("RPC failed: " + e.getStatus());
    	    }
    	}
// Service 3: method 1 . serviceRoom
    private void getServiceRoom() {
    	 if (roomServiceStub == null) {
    	        TempResponse.setText("gRPC stub is not initialized.");
    	        return;
    	    }

    	    // Create a StreamObserver to handle responses from the server
    	    StreamObserver<Service3.RoomTemperatureResponse> responseObserver = new StreamObserver<Service3.RoomTemperatureResponse>() {
    	        @Override
    	        public void onNext(Service3.RoomTemperatureResponse response) {
    	            // Update the text field with the received data from the server
    	            TempResponse.setText("Temperature response: " + response );
    	        }

    	        @Override
    	        public void onError(Throwable t) {
    	            // Handle errors by displaying them in the text field
    	            TempResponse.setText("Error: " + t.getMessage());
    	        }

    	        @Override
    	        public void onCompleted() {
    	            // Indicate that the communication has finished
    	            TempResponse.setText("Room service completed.");
    	        }
    	    };
    	    
    	    // Create a StreamObserver to send requests to the server
    	    StreamObserver<Service3.RoomTemperatureRequest> requestObserver = roomServiceStub.roomTemperature(responseObserver);

    	    // Send a few example RoomTemperatureRequest messages
    	    //for (int i = 0; i < 5; i++) {
            //    
            //    requestObserver.onNext(temperatureRequest);
            //    System.out.println("Sent RoomTemperatureRequest #" + (i + 1));
            //    try {
			//		TimeUnit.SECONDS.sleep(1);
			//	} catch (InterruptedException e) {
			//		// TODO Auto-generated catch block
			//		e.printStackTrace();
			//	}
            //}
    	    RoomTemperatureRequest temperatureRequest = RoomTemperatureRequest.newBuilder().setRoomId(1).build();
    	    requestObserver.onNext(temperatureRequest);
    	    // Complete the sending process
    	    //requestObserver.onCompleted();
    	}
    }
	
    
