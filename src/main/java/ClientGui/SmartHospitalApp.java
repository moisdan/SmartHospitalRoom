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

import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SmartHospitalApp extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField PResponse; // Field for displaying patient details
    private JTextField Vresponse; // Field for displaying patient vitals
    private JTextField MedScheResponse; // Field for displaying medication schedule
    private JTextField AlertResponse; // Field for displaying alert medication summary
    private JTextField CleanResponse; // Field for displaying cleaning status
    private JTextField TempResponse; // Field for displaying room temperature

    // gRPC channel and stubs
    private ManagedChannel channel;
    private PatientServiceGrpc.PatientServiceBlockingStub patientServiceBlockingStub;
    private PatientServiceGrpc.PatientServiceStub patientServiceStub;
    private JTextField id1;
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
		setBounds(100, 100, 470, 330);
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
		PResponse.setBounds(262, 41, 162, 20);
		contentPane.add(PResponse);
		PResponse.setColumns(10);
		
		Vresponse = new JTextField();
		Vresponse.setBounds(262, 82, 162, 20);
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
		lblNewLabel_2.setBounds(110, 19, 170, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Service 2: Dosing Schedule");
		lblNewLabel_3.setBounds(110, 110, 170, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Method 1:medication Schedule");
		lblNewLabel_4.setBounds(9, 135, 181, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Method 2: Alert medication");
		lblNewLabel_5.setBounds(10, 160, 180, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton MedSchduleBtn = new JButton("OK");
		MedSchduleBtn.setBounds(200, 131, 52, 23);
		contentPane.add(MedSchduleBtn);
		
		JButton AlertBtn = new JButton("OK");
		AlertBtn.setBounds(200, 160, 52, 23);
		contentPane.add(AlertBtn);
		
		MedScheResponse = new JTextField();
		MedScheResponse.setBounds(262, 132, 162, 20);
		contentPane.add(MedScheResponse);
		MedScheResponse.setColumns(10);
		
		AlertResponse = new JTextField();
		AlertResponse.setBounds(262, 161, 162, 20);
		contentPane.add(AlertResponse);
		AlertResponse.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Service3: Room Service");
		lblNewLabel_6.setBounds(116, 194, 136, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Method 1: cleaning Room");
		lblNewLabel_7.setBounds(10, 215, 180, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Method 2: Room Temperature");
		lblNewLabel_8.setBounds(10, 240, 180, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton CleanBtn = new JButton("OK");
		CleanBtn.setBounds(200, 211, 52, 23);
		contentPane.add(CleanBtn);
		
		JButton TempBtn = new JButton("OK");
		TempBtn.setBounds(200, 236, 52, 23);
		contentPane.add(TempBtn);
		
		CleanResponse = new JTextField();
		CleanResponse.setBounds(262, 212, 162, 20);
		contentPane.add(CleanResponse);
		CleanResponse.setColumns(10);
		
		TempResponse = new JTextField();
		TempResponse.setBounds(262, 240, 162, 20);
		contentPane.add(TempResponse);
		TempResponse.setColumns(10);
		
		id1 = new JTextField();
		id1.setBounds(110, 41, 86, 20);
		contentPane.add(id1);
		
		id1 = new JTextField();
		id1.setBounds(110, 41, 86, 20);
		contentPane.add(id1);
		id1.setColumns(10);
		id1.setColumns(10);
		
		// Initialize gRPC clients
		 initializeGrpcClients();
	}
	
   

private void initializeGrpcClients() {
    // Create a gRPC channel to communicate with the server
    channel = ManagedChannelBuilder.forAddress("localhost", 50051)
            .usePlaintext() // Use plaintext communication (no encryption)
            .build();

    // Initialize stubs for each gRPC service
    patientServiceBlockingStub = PatientServiceGrpc.newBlockingStub(channel);
    patientServiceStub = PatientServiceGrpc.newStub(channel);
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
}