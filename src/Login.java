import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField textLastName;
	private JTextField textEmail;
	private JTextField textpassword;
	private JTextField textPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 963, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(208, 106, 97, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(208, 139, 97, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(317, 106, 116, 22);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBounds(317, 139, 116, 22);
		frame.getContentPane().add(textLastName);
		textLastName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(317, 174, 116, 22);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textpassword = new JTextField();
		textpassword.setBounds(317, 208, 116, 22);
		frame.getContentPane().add(textpassword);
		textpassword.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(208, 176, 97, 19);
		frame.getContentPane().add(lblEmailId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(208, 208, 97, 23);
		frame.getContentPane().add(lblPassword);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Proceed to login");
				frame.dispose();
				new MainWindow();
				//MainWindow.main(null);
			}
		});
		btnRegister.setBackground(new Color(221, 160, 221));
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnRegister.setBounds(322, 319, 111, 29);
		frame.getContentPane().add(btnRegister);
		
		textPhone = new JTextField();
		textPhone.setBounds(317, 243, 116, 22);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(208, 243, 97, 23);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblRetailerServices = new JLabel("Retailer Application");
		lblRetailerServices.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblRetailerServices.setBounds(317, 28, 188, 23);
		frame.getContentPane().add(lblRetailerServices);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPhone.setText(null);
				textpassword.setText(null);
				textEmail.setText(null);
				textLastName.setText(null);
				txtFirstName.setText(null);						
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setBounds(461, 319, 116, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(221, 160, 221));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnExit.setBounds(715, 28, 97, 25);
		frame.getContentPane().add(btnExit);
	}
}
