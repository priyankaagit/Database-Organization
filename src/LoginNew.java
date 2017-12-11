import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.util.concurrent.atomic.AtomicInteger;
public class LoginNew extends JFrame {

	private JPanel contentPane;
	private JTextField txtTest;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(100000);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginNew frame = new LoginNew();
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
	public LoginNew() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(287, 176, 97, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(287, 210, 97, 23);
		getContentPane().add(lblNewLabel_1);
		
		JTextField txtFirstName = new JTextField();
		txtFirstName.setBounds(461, 177, 233, 22);
		getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JTextField textLastName = new JTextField();
		textLastName.setBounds(461, 211, 233, 22);
		getContentPane().add(textLastName);
		textLastName.setColumns(10);
		
		JTextField textEmail = new JTextField();
		textEmail.setBounds(461, 247, 233, 22);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEmailId.setBounds(287, 248, 97, 19);
		getContentPane().add(lblEmailId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPassword.setBounds(287, 283, 97, 23);
		getContentPane().add(lblPassword);
		
		JTextField textPhone = new JTextField();
		textPhone.setBounds(461, 321, 233, 22);
		getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(461, 284, 233, 22);
		contentPane.add(passwordField_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstName = txtFirstName.getText();	
				String lastName = textLastName.getText();
				String emailId = textEmail.getText();
				String password = passwordField_1.getText();
				String phoneNumber = textPhone.getText();
				String programId = firstName+Integer.toString(ID_GENERATOR.getAndIncrement());
				Customer cust = new Customer(firstName,lastName,emailId,password,phoneNumber,programId);
				DatabaseUtilities.insertCustomer(cust);
				
				JOptionPane.showMessageDialog(null, "Proceed to login");
				dispose();
				new MainWindow();
				MainWindow.main(null);
				
			}
		});
		btnRegister.setBackground(new Color(221, 160, 221));
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnRegister.setBounds(461, 356, 97, 29);
		getContentPane().add(btnRegister);
		
		
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPhoneNumber.setBounds(287, 320, 105, 23);
		getContentPane().add(lblPhoneNumber);
		
		JLabel lblRetailerServices = new JLabel("Retailer Application");
		lblRetailerServices.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblRetailerServices.setBounds(417, 29, 188, 23);
		getContentPane().add(lblRetailerServices);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPhone.setText(null);
				passwordField_1.setText(null);
				textEmail.setText(null);
				textLastName.setText(null);
				txtFirstName.setText(null);						
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setBounds(597, 356, 97, 29);
		getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(221, 160, 221));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnExit.setBounds(806, 28, 97, 25);
		getContentPane().add(btnExit);
		
		JLabel lblRegisterCustomer = new JLabel("Register Customer");
		lblRegisterCustomer.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRegisterCustomer.setBounds(173, 133, 159, 23);
		contentPane.add(lblRegisterCustomer);
		
		
		
		
	}
}
