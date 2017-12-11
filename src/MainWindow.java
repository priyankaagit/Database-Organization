import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.*;
public class MainWindow {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField passwordField;
	Connection connect = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	//	connect = DatabaseUtilities.connection();
	//	if(connect!=null)
	//		JOptionPane.showMessageDialog(null, "Connected to database");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 620);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubmit = new JButton("Login");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Submitted");
				String userName = textUsername.getText();
				String password = passwordField.getText(); 
				
				if(userName.equals("emp01") && password.equals("123")){
			//		textUsername.setText(null);
			//		passwordField.setText(null);
			//		Customer.main(null);
					frame.dispose();
					Employee n = new Employee();
					n.setVisible(true);
				}
				else{
					//JOptionPane.showMessageDialog(null, "Username or password not correct");				
				boolean status = DatabaseUtilities.selectUser(userName, password);
				if(status){
					frame.dispose();
					OrderWIndow n = new OrderWIndow(userName);
					n.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Username or password not correct");
				}
				
				}
			}
		});
		btnSubmit.setBackground(new Color(221, 160, 221));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSubmit.setBounds(373, 253, 94, 25);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUserName.setBounds(285, 153, 94, 25);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(285, 205, 94, 25);
		frame.getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(389, 153, 161, 24);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Retailer Application");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setBounds(373, 44, 180, 35);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(null);
				textUsername.setText(null);
			
			}
			
		});
		btnNewButton.setBounds(434, 291, 94, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.setBounds(768, 49, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(389, 205, 161, 25);
		frame.getContentPane().add(passwordField);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginNew n = new LoginNew();
				n.setVisible(true);
			}
		});
		btnSignup.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnSignup.setBackground(new Color(221, 160, 221));
		btnSignup.setBounds(479, 253, 97, 25);
		frame.getContentPane().add(btnSignup);
	}
}
