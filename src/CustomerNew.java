import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;

public class CustomerNew extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel = new JLabel("Welcome ");
	String uName = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerNew frame = new CustomerNew();
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
	public CustomerNew(String userName){
		uName = userName; 
		initialize();
		lblNewLabel.setText("Welcome " + userName);
		
	}
	public CustomerNew() {
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
		lblRetailerApplication.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblRetailerApplication.setBounds(399, 28, 160, 30);
		getContentPane().add(lblRetailerApplication);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(221, 160, 221));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnExit.setBounds(718, 32, 97, 25);
		getContentPane().add(btnExit);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountNew n = new AccountNew(uName);
				n.setVisible(true);				
			}
		});
		btnAccount.setBackground(new Color(221, 160, 221));
		btnAccount.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAccount.setBounds(132, 154, 97, 25);
		getContentPane().add(btnAccount);
		
		JButton btnOrder = new JButton("Order Status");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnOrder.setBackground(new Color(221, 160, 221));
		btnOrder.setBounds(699, 151, 142, 30);
		getContentPane().add(btnOrder);
				
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(321, 89, 357, 54);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(411, 501, 142, 30);
		contentPane.add(btnNewButton);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(221, 160, 221));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		ArrayList<String> catg = DatabaseUtilities.getProductCategory();
		for(String str: catg){
			//System.out.println(str);
			comboBox.addItem(str);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
			}
		});
		comboBox.setBounds(280, 151, 168, 30);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 210, 709, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setColumnHeaderView(scrollBar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(492, 152, 174, 30);
		contentPane.add(comboBox_1);
	}
}
