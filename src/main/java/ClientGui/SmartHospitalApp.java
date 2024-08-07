package ClientGui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private JTextField PResponse;
	private JTextField Vresponse;
	private JTextField MedScheResponse;
	private JTextField AlertResponse;
	private JTextField CleanResponse;
	private JTextField TempResponse;

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
			}
		});
		PatientIDBtn.setBounds(200, 40, 52, 23);
		contentPane.add(PatientIDBtn);
		
		JButton PvitalsBtn = new JButton("OK");
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
	}
}
