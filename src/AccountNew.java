import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountNew extends JFrame {

	private JPanel contentPane;
	private JTextField zipcode;
	JButton btnRegisterAddress = new JButton("Register");
	JLabel lblZipcode = new JLabel("Zipcode");
	String uName = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountNew frame = new AccountNew();
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
	public AccountNew() {
		initialize();
	}
	public AccountNew(String userName) {	
		uName = userName;
		initialize();
	}
	
	public void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblRetailerApplication = new JLabel("Retailer Application");
		lblRetailerApplication.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRetailerApplication.setBounds(387, 36, 185, 28);
		getContentPane().add(lblRetailerApplication);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(221, 160, 221));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnExit.setBounds(777, 38, 97, 25);
		getContentPane().add(btnExit);
		
		JTextField creditCardNumber = new JTextField();
		creditCardNumber.setBounds(340, 211, 339, 22);
		getContentPane().add(creditCardNumber);
		creditCardNumber.setColumns(10);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		lblCreditCardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCreditCardNumber.setBounds(171, 212, 162, 19);
		getContentPane().add(lblCreditCardNumber);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date");
		lblExpiryDate.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblExpiryDate.setBounds(171, 244, 162, 25);
		getContentPane().add(lblExpiryDate);
		
		JTextField expiryDate = new JTextField();
		expiryDate.setBounds(341, 246, 81, 22);
		getContentPane().add(expiryDate);
		expiryDate.setColumns(10);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCvv.setBounds(487, 246, 81, 19);
		getContentPane().add(lblCvv);
		
		JTextField cvv = new JTextField();
		cvv.setBounds(598, 246, 81, 22);
		getContentPane().add(cvv);
		cvv.setColumns(10);
		
		JButton btnRegisterCard = new JButton("Register");
		btnRegisterCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardNumber = creditCardNumber.getText();
				String expiryDt = expiryDate.getText();
				String cv = cvv.getText();
				DatabaseUtilities.insertCard(cardNumber,expiryDt,cv,uName);	
				JOptionPane.showMessageDialog(null, "Card Registered");
				
			}
		});
		btnRegisterCard.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnRegisterCard.setBackground(new Color(221, 160, 221));
		btnRegisterCard.setBounds(771, 194, 103, 25);
		getContentPane().add(btnRegisterCard);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardNumber = creditCardNumber.getText();
				String expiryDt = expiryDate.getText();
				String cv = cvv.getText();
				DatabaseUtilities.updateCard(cardNumber,expiryDt,cv,uName);	
				JOptionPane.showMessageDialog(null, "Card Updated");
				
			}
		});
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBounds(770, 231, 103, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creditCardNumber.setText(null);
				expiryDate.setText(null);
				cvv.setText(null);
				DatabaseUtilities.deleteCard(uName);	
				JOptionPane.showMessageDialog(null, "Card Deleted");
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.setBounds(772, 266, 102, 25);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblAddress = new JLabel("Street ");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblAddress.setBounds(183, 369, 81, 16);
		getContentPane().add(lblAddress);
		
		JTextField street = new JTextField();
		street.setBounds(340, 367, 339, 22);
		getContentPane().add(street);
		street.setColumns(10);
		
		JLabel lblApartment = new JLabel("Apartment");
		lblApartment.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblApartment.setBounds(180, 402, 97, 16);
		getContentPane().add(lblApartment);
		
		JTextField apartment = new JTextField();
		apartment.setBounds(340, 400, 339, 22);
		getContentPane().add(apartment);
		apartment.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCity.setBounds(183, 431, 81, 19);
		getContentPane().add(lblCity);
		
		JTextField city = new JTextField();
		city.setBounds(340, 430, 116, 22);
		getContentPane().add(city);
		city.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblState.setBounds(183, 461, 81, 16);
		getContentPane().add(lblState);
		
		JTextField state = new JTextField();
		state.setBounds(340, 459, 116, 22);
		getContentPane().add(state);
		state.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblCountry.setBounds(470, 460, 81, 19);
		getContentPane().add(lblCountry);
		
		JTextField country = new JTextField();
		country.setBounds(563, 459, 116, 22);
		getContentPane().add(country);
		country.setColumns(10);
		
		
		btnRegisterAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = street.getText();	
				String apt = apartment.getText();
				String cty = city.getText();
				String stat = state.getText();
				String ctry = country.getText();
				String zpcd = zipcode.getText();
				Address ad = new Address(str,apt,cty,stat,ctry,zpcd);
				DatabaseUtilities.insertAddress(ad,uName);	
				JOptionPane.showMessageDialog(null, "Address Registered");			
			}
		});
		btnRegisterAddress.setBackground(new Color(221, 160, 221));
		btnRegisterAddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnRegisterAddress.setBounds(771, 367, 103, 30);
		getContentPane().add(btnRegisterAddress);
		
		JButton btnUpdateAddress = new JButton("Update");
		btnUpdateAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				String str = street.getText();	
				String apt = apartment.getText();
				String cty = city.getText();
				String stat = state.getText();
				String ctry = country.getText();
				String zpcd = zipcode.getText();
				Address ad = new Address(str,apt,cty,stat,ctry,zpcd);
				DatabaseUtilities.updateAddress(ad,uName);
				JOptionPane.showMessageDialog(null, "Address Updated");
				
			}
		});
		btnUpdateAddress.setBackground(new Color(221, 160, 221));
		btnUpdateAddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnUpdateAddress.setBounds(771, 410, 103, 28);
		getContentPane().add(btnUpdateAddress);
		
		JButton btnDeleteAddess = new JButton("Delete");
		btnDeleteAddess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = street.getText();	
				String apt = apartment.getText();
				String cty = city.getText();
				String stat = state.getText();
				String ctry = country.getText();
				String zpcd = zipcode.getText();
				Address ad = new Address(str,apt,cty,stat,ctry,zpcd);
				DatabaseUtilities.deleteAddress(ad,uName);
				JOptionPane.showMessageDialog(null, "Address Deleted");
				street.setText(null);
				apartment.setText(null);
				city.setText(null);
				state.setText(null);
				country.setText(null);
				zipcode.setText(null);	
				
				
			}
		});
		btnDeleteAddess.setBackground(new Color(221, 160, 221));
		btnDeleteAddess.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnDeleteAddess.setBounds(771, 451, 103, 28);
		getContentPane().add(btnDeleteAddess);
		
		
		lblZipcode.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblZipcode.setBounds(482, 432, 69, 17);
		contentPane.add(lblZipcode);
		
		zipcode = new JTextField();
		zipcode.setBounds(563, 430, 116, 22);
		contentPane.add(zipcode);
		zipcode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Credit Card Detail");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(121, 155, 146, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddressDetail = new JLabel("Address Detail");
		lblAddressDetail.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAddressDetail.setBounds(121, 312, 146, 25);
		contentPane.add(lblAddressDetail);
	}
}
