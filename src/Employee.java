import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop.Action;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import models.*;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
public class Employee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ArrayList<Product_Type> productTypes = new ArrayList<Product_Type>();
	private ArrayList<Product_Type> products = null;
	private ArrayList<Item> items = null;
	private DefaultTableModel dtm;
	private JTable table_4;
	private JTextField productName;
	private JTextField productType;
	private JTextField brand;
	private JTextField size;
	private JTextField prices;
	private JTextField quantity;
	private JTextField productId;
	private JTextField unit;
	private JTextField txtprodId;
	private JTextField txtQuantity;
	private JTextField txtStoreid;
	private JTextField txtStoreid_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRetailerApplication = new JLabel("Retailer Application");
		lblRetailerApplication.setBounds(385, 44, 214, 29);
		lblRetailerApplication.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentPane.add(lblRetailerApplication);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(805, 47, 97, 25);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(221, 160, 221));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(btnExit);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setBounds(153, 88, 97, 25);
		lblEmployee.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblEmployee);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(140, 511, 686, 29);
//		contentPane.add(scrollPane);

		
//		String[] columns = {"Product Name","Product Type","Brand","Size","Price","Quantity"};
//		dtm = new DefaultTableModel(null,columns);
//		
//		table_4 = new JTable(dtm);
//		scrollPane.setViewportView(table_4);
//		scrollPane.setVisible(false);
//		
//		contentPane.add(btnUpdate);
//		JComboBox comboBox_1 = new JComboBox();
//		comboBox_1.setBackground(new Color(221, 160, 221));
//
//		comboBox_1.setBounds(142, 13, 184, 27);
//		contentPane.add(comboBox_1);
//		comboBox_1.setVisible(false);
//				
//		JComboBox comboBox = new JComboBox();
//		comboBox.setBackground(new Color(221, 160, 221));
//		String producat_cat = null;
//		ArrayList<String> catg =  DatabaseUtilities.getProductCategory();
//		catg.set(0, "select");
//		for(String str: catg)
//			comboBox.addItem(str);		
//		comboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				String product_cat = (String) comboBox.getSelectedItem();
//				comboBox_1.removeAllItems();
//				if(product_cat.equals("select")){
//					comboBox_1.setVisible(false);
//					
//				}else{
//					comboBox_1.setVisible(true);
//					products = DatabaseUtilities.getProductType(product_cat.toLowerCase());
//				//	productType.addItem("select");
//					for(Product_Type prd: products)
//						comboBox_1.addItem(prd.getProduct_type_id() +": "+ prd.getProduct_type());
//				}				
//			}
//		});
//		comboBox.setBounds(152, 46, 184, 27);
//		contentPane.add(comboBox);
//		
		productName = new JTextField();
		productName.setBounds(324, 175, 188, 22);
		contentPane.add(productName);
		productName.setColumns(10);
		productName.setVisible(false);
		
		productType = new JTextField();
		productType.setBounds(669, 175, 183, 22);
		contentPane.add(productType);
		productType.setColumns(10);
		productType.setVisible(false);
		
		brand = new JTextField();
		brand.setBounds(324, 210, 188, 22);
		contentPane.add(brand);
		brand.setColumns(10);
		brand.setVisible(false);
		
		size = new JTextField();
		size.setBounds(669, 210, 183, 22);
		contentPane.add(size);
		size.setColumns(10);
		size.setVisible(false);
		
		prices = new JTextField();
		prices.setBounds(669, 245, 183, 22);
		contentPane.add(prices);
		prices.setColumns(10);
		prices.setVisible(false);
		
		quantity = new JTextField();
		quantity.setBounds(324, 285, 188, 22);
		contentPane.add(quantity);
		quantity.setColumns(10);
		quantity.setVisible(false);
		
		JLabel lblProductname = new JLabel("Product Name");
		lblProductname.setBounds(153, 173, 118, 25);
		lblProductname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblProductname);
		
		JLabel lblP = new JLabel("Product Type");
		lblP.setBounds(545, 175, 112, 20);
		lblP.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblP);
		
		productId = new JTextField();
		productId.setBounds(315, 140, 131, 22);
		contentPane.add(productId);
		productId.setColumns(10);
		
		JLabel lblProdcutId = new JLabel("Enter Product Id");
		lblProdcutId.setBounds(153, 141, 150, 19);
		lblProdcutId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblProdcutId);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(153, 211, 76, 19);
		lblBrand.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblBrand);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(545, 211, 62, 19);
		lblSize.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblSize);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(543, 243, 56, 19);
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(153, 286, 76, 19);
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblQuantity);
				
		txtStoreid_1 = new JTextField();
		txtStoreid_1.setBounds(608, 140, 116, 22);
		contentPane.add(txtStoreid_1);
		txtStoreid_1.setColumns(10);
		
		JLabel lblStoreaddress = new JLabel("Store Address");
		lblStoreaddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblStoreaddress.setBounds(596, 93, 306, 20);
		contentPane.add(lblStoreaddress);
		lblStoreaddress.setVisible(false);
		
		
		JButton btnSelect = new JButton("select");
		btnSelect.setBounds(755, 138, 97, 25);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int prodId = Integer.parseInt(productId.getText());
				int storeId = Integer.parseInt(txtStoreid_1.getText());
				ArrayList<Item> items = new ArrayList<Item>();
				items = DatabaseUtilities.getProduct(prodId,storeId);
				items.get(0);
				productName.setText(items.get(0).getProduct_name());
				productType.setText(items.get(0).getProduct_type());
				brand.setText(items.get(0).getBrand());
				size.setText(items.get(0).getSize());
				prices.setText(Integer.toString(items.get(0).getPrice()));
				quantity.setText(Integer.toString(items.get(0).getQuantity()));
				unit.setText(items.get(0).getUnit());
				txtStoreid_1.setText(Integer.toString(items.get(0).getStore_id()));
				lblStoreaddress.setText("Store Name:" + items.get(0).getStore_add());
				productName.setVisible(true);
				productType.setVisible(true);
				brand.setVisible(true);
				size.setVisible(true);
				prices.setVisible(true);
				quantity.setVisible(true);
				unit.setVisible(true);	
				lblStoreaddress.setVisible(true);
				
			}
		});
		btnSelect.setBackground(new Color(221, 160, 221));
		btnSelect.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(btnSelect);
		
		unit = new JTextField();
		unit.setBounds(324, 245, 188, 22);
		contentPane.add(unit);
		unit.setColumns(10);
		unit.setVisible(false);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setBounds(153, 245, 56, 20);
		lblUnit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblUnit);
		
		JButton btnUpdate = new JButton("Update Price");
		btnUpdate.setBounds(669, 283, 183, 25);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int prodId = Integer.parseInt(productId.getText());
			    int price = Integer.parseInt(prices.getText());
			    int quanty = Integer.parseInt(quantity.getText());
			    DatabaseUtilities.updateProduct(prodId,price,quanty);
			    JOptionPane.showMessageDialog(null, "Product updated");
			}
		});
		btnUpdate.setBackground(new Color(221, 160, 221));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(btnUpdate);
		
		JLabel lblProductId = new JLabel("Product Id");
		lblProductId.setBounds(153, 371, 118, 22);
		lblProductId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblProductId);
		
		txtprodId = new JTextField();
		txtprodId.setBounds(312, 372, 200, 22);
		contentPane.add(txtprodId);
		txtprodId.setColumns(10);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setBounds(545, 372, 76, 20);
		lblQuantity_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(lblQuantity_1);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(669, 372, 183, 22);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JButton btnAddProduct = new JButton("Update Stock");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> stock = new ArrayList<Integer>();
				int prodId = Integer.parseInt(txtprodId.getText());
				//String prodName = txtProdname.getText();
				//int brand = Integer.parseInt(txtBrand.getText());
				//int size = Integer.parseInt(txtSize.getText());
				//int unit = Integer.parseInt(txtUnit.getText());
				//int price = Integer.parseInt(txtPrice.getText());
				int quantity = Integer.parseInt(txtQuantity.getText());
				//int prodType = Integer.parseInt(txtProducttype.getText());
				int storeId = Integer.parseInt(txtStoreid.getText());
				stock = DatabaseUtilities.getQuantity(prodId,storeId);
			//	Product prod = new Product(prodId,prodType,brand,unit,price,size,prodName);
				
				if(quantity <= (stock.get(0)-stock.get(1))){
					DatabaseUtilities.updateStore(storeId,prodId,stock.get(1)+quantity);
				    JOptionPane.showMessageDialog(null, "Stock Updated");
				}
				else
					JOptionPane.showMessageDialog(null, "Quantity exceeding Store capacity");																		
			}
		});
		btnAddProduct.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnAddProduct.setBackground(new Color(221, 160, 221));
		btnAddProduct.setBounds(669, 407, 183, 25);
		contentPane.add(btnAddProduct);
		
		txtStoreid = new JTextField();
		txtStoreid.setBounds(312, 407, 200, 22);
		contentPane.add(txtStoreid);
		txtStoreid.setColumns(10);
		
		JLabel lblStoreid = new JLabel("Store Id");
		lblStoreid.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblStoreid.setBounds(153, 403, 72, 21);
		contentPane.add(lblStoreid);
		
		JLabel lblEnterStoreId = new JLabel("Enter Store Id");
		lblEnterStoreId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEnterStoreId.setBounds(479, 139, 112, 22);
		contentPane.add(lblEnterStoreId);
		

		
//		comboBox_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//				String product_type = (String) comboBox_1.getSelectedItem();
//				String[] inputs = product_type.split(":");
//				Integer product_type_id = Integer.parseInt(inputs[0]);
//				
//				items = DatabaseUtilities.getProductType(product_type_id);
//				scrollPane.setVisible(true);
//			    if(items.size() !=0){
//			      for(int i=0; i<items.size();i++){
//			    	  Vector<Object> data = new Vector<Object>();
//			    	  data.add(items.get(i).getProduct_name());
//			    	  data.add(items.get(i).getProduct_type());
//			    	  data.add(items.get(i).getBrand());
//			    	  data.add(items.get(i).getSize());
//			    	  data.add(items.get(i).getPrice());
//			    	  data.add(items.get(i).getQuantity());			    				    	  
//			    	  dtm.addRow(data);
//			      }			    
//			    }
//			}
//		});
		
		

	}
}
