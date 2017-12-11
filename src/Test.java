import java.awt.BorderLayout;
import models.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import java.util.*;
import java.awt.Panel;

public class Test extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel = new JLabel("Welcome ");
	String uName = null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private ArrayList<Product_Type> products = null;
	private ArrayList<Item> items = null;
	private JTable orderTable;
	private DefaultTableModel dtm;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test(String userName){
		uName = userName; 
		initialize();
		lblNewLabel.setText("Welcome " + userName);
		
	}
	public Test() {
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
		lblRetailerApplication.setBounds(417, 25, 160, 30);
		getContentPane().add(lblRetailerApplication);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(221, 160, 221));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnExit.setBounds(832, 102, 142, 25);
		getContentPane().add(btnExit);
		
		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			//	RegisterWindow n = new RegisterWindow(uName);
				//n.setVisible(true);				
			}
		});
		btnAccount.setBackground(new Color(221, 160, 221));
		btnAccount.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAccount.setBounds(832, 66, 142, 25);
		getContentPane().add(btnAccount);
		
		JButton btnOrder = new JButton("Order Status");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnOrder.setBackground(new Color(221, 160, 221));
		btnOrder.setBounds(832, 25, 142, 30);
		getContentPane().add(btnOrder);
				
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(449, 52, 357, 54);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Place Order");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(435, 540, 124, 30);
		contentPane.add(btnNewButton);
		
		

		/*
		 *  Product Category
		 * 
		 */
		
		JComboBox<String> productCategory = new JComboBox<String>();
		productCategory.setBackground(new Color(221, 160, 221));
		productCategory.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		productCategory.setBounds(250, 194, 188, 30);
		contentPane.add(productCategory);
		
		JLabel lblNewLabel_1 = new JLabel("Product Category");
		lblNewLabel_1.setBounds(293, 169, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		
		/*
		 *  Product Type
		 * 
		 */
		String[] columns = {"Product Name","Price"};
		dtm = new DefaultTableModel(null,columns);
		
		JComboBox productType = new JComboBox();
		productType.setBounds(587, 196, 195, 30);
		contentPane.add(productType);
		productType.setVisible(false);
		
		JLabel product_type = new JLabel("Product");
		product_type.setBounds(707, 161, 114, 30);
		contentPane.add(product_type);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 319, 225, 108);
		contentPane.add(scrollPane);
		
		table_4 = new JTable(dtm);
		scrollPane.setViewportView(table_4);
		scrollPane.setVisible(false);
	
		
		
		
		
	

		
		String producat_cat = null;
		ArrayList<String> catg =  DatabaseUtilities.getProductCategory();
		catg.set(0, "select");
		for(String str: catg)
			productCategory.addItem(str);
		
		productCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product_cat = (String) productCategory.getSelectedItem();
				productType.removeAllItems();
				if(product_cat.equals("select")){
					productType.setVisible(false);
					
				}else{
					productType.setVisible(true);
					products = DatabaseUtilities.getProductType(product_cat.toLowerCase());
				//	productType.addItem("select");
					for(Product_Type prd: products)
						productType.addItem(prd.getProduct_type_id() +": "+ prd.getProduct_type());
				}
				
			}
		});
		
		//JPanel center = new JPanel(new GridLayout(0, 1));
	
		
	
		
		
		
		
		productType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String product_type = (String) productType.getSelectedItem();
				String[] inputs = product_type.split(":");
				Integer product_type_id = Integer.parseInt(inputs[0]);
				
				items = DatabaseUtilities.getProductType(product_type_id);
				scrollPane.setVisible(true);
			    if(items.size() !=0){
			      for(int i=0; i<items.size();i++){
			    	  Vector<Object> data = new Vector<Object>();
			    	  data.add(items.get(i).getProduct_name());
			    	  data.add(items.get(i).getPrice());
			    	  dtm.addRow(data);
			      }			    
			    }				
			}
		});


		
		
	//	center.setBorder(BorderFactory.createTitledBorder(catalog.getStoreName()));
	
		
		
	}
}
