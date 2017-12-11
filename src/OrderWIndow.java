import java.awt.BorderLayout;
import models.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
import javax.swing.JCheckBox;

public class OrderWIndow extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel = new JLabel("Welcome ");
	String uName = null;
	private ArrayList<Product_Type> products = null;
	private ArrayList<Item> items = null;
	private JTable orderTable;
	private DefaultTableModel dtm;
	private DefaultTableModel ost;
	private ArrayList<Item> orders;
	private JTextField order_id;
	private JTable orderStatus;
	private Integer orderNumber = null;
	private JLabel productCat = null;
	private JComboBox<String> productCategory = null;
	private JLabel orderStatusLabel = null;
	private Order order = null;
	private JComboBox productType = null;
	private int totalPrice = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderWIndow frame = new OrderWIndow();
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
	public OrderWIndow(String userName) {
		uName = userName;
		initialize();
		lblNewLabel.setText("Welcome " + userName);

	}

	public OrderWIndow() {
		initialize();
	}

	public void initialize() {
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
		btnExit.setBounds(813, 67, 87, 25);
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
		btnAccount.setBounds(708, 67, 98, 25);
		getContentPane().add(btnAccount);

		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(361, 52, 311, 54);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(true);

		/*
		 * 
		 * New Order
		 * 
		 */

		JLabel labelNewOrder = new JLabel("");
		labelNewOrder.setBounds(119, 200, 142, 25);
		contentPane.add(labelNewOrder);

		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewOrder.setBackground(new Color(221, 160, 221));
		btnNewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order = new Order();
				orderNumber = DatabaseUtilities.selectOrderNumber();
				labelNewOrder.setVisible(true);
				labelNewOrder.setText("Order Number:"+String.valueOf(orderNumber));
				order.setOrder_id(orderNumber);
				productCat.setVisible(true);
				productCategory.setVisible(true);
			}
		});
		btnNewOrder.setBounds(119, 160, 142, 27);
		contentPane.add(btnNewOrder);

		/*
		 * Product Category
		 * 
		 */

		productCat = new JLabel("Product Category");
		productCat.setFont(new Font("Times New Roman", Font.BOLD, 17));
		productCat.setBounds(291, 160, 146, 22);
		contentPane.add(productCat);
		productCat.setVisible(false);

		productCategory = new JComboBox<String>();
		productCategory.setBackground(new Color(221, 160, 221));
		productCategory.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		productCategory.setBounds(435, 161, 174, 25);
		contentPane.add(productCategory);
		productCategory.setVisible(false);

		ArrayList<String> catg = DatabaseUtilities.getProductCategory();
		catg.set(0, "select");
		for (String str : catg)
			productCategory.addItem(str);

		/*
		 * Product Type
		 * 
		 */
		String[] columns = { "Product Name", "Price", "Quanity" };
		dtm = new DefaultTableModel(null, columns);
		dtm.fireTableDataChanged();

		productType = new JComboBox();
		productType.setBounds(726, 162, 174, 25);
		contentPane.add(productType);
		productType.setVisible(false);

		JLabel product_type_lable = new JLabel("Product");
		product_type_lable.setFont(new Font("Times New Roman", Font.BOLD, 17));
		product_type_lable.setBounds(637, 160, 77, 27);
		contentPane.add(product_type_lable);
		product_type_lable.setVisible(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(305, 214, 595, 108);
		contentPane.add(scrollPane);
		scrollPane.setVisible(true);

		orderTable = new JTable(dtm);
		scrollPane.setViewportView(orderTable);

		/*
		 * Place holder for total price
		 */
		JLabel total = new JLabel("");
		total.setFont(new Font("Tahoma", Font.PLAIN, 13));
		total.setBounds(305, 335, 142, 25);
		contentPane.add(total);

		order_id = new JTextField();
		order_id.setText("Enter Order Number");
		order_id.setBounds(119, 445, 142, 25);
		contentPane.add(order_id);
		order_id.setColumns(10);

		JScrollPane orderStatusPanel = new JScrollPane();
		orderStatusPanel.setBounds(305, 408, 595, 99);
		contentPane.add(orderStatusPanel);
		String ostColumns[] = { "OrderNumber", "Product", "Quantity", "Price" };
		ost = new DefaultTableModel(null, ostColumns);
		orderStatus = new JTable(ost);
		orderStatusPanel.setViewportView(orderStatus);

		JLabel orderstatus = new JLabel("");
		orderstatus.setBounds(672, 271, 77, 30);
		contentPane.add(orderstatus);
		orderStatus.setVisible(false);
		orderstatus.setVisible(false);

		JButton btnOrder = new JButton("Order Status");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oder_id = (String) order_id.getText();
				if (oder_id == null || !isNumeric(oder_id)) {
					orderstatus.setText("Invalid Order Id");
				} else {
					orderstatus.setVisible(true);
					orderStatus.setVisible(true);
					orderStatusLabel.setVisible(true);
					ost.getDataVector().removeAllElements();
					ost.fireTableDataChanged();
					int orderid = Integer.parseInt(oder_id.toString()); // {"OrderNumber","Product","Quantity","Price","Status"};
					Order order = DatabaseUtilities.getOrderDetail(orderid);
					orderStatusLabel.setText("Status :" +order.getStatus());
					for (Map.Entry<Integer, Item> entry : order.getItems().entrySet()) {
						Item it = entry.getValue();
						Vector<String> row = new Vector<String>();
						row.add(oder_id);
						row.add(it.getProduct_name());
						row.add(String.valueOf(it.getQuantity()));
						row.add(String.valueOf(it.getPrice()));
						ost.addRow(row);
					}

				}
			}
		});

		btnOrder.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnOrder.setBackground(new Color(221, 160, 221));
		btnOrder.setBounds(119, 411, 142, 25);
		getContentPane().add(btnOrder);
		JButton placeOrder = new JButton("Place Order");
		productCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeOrder.setVisible(true);
				String product_cat = (String) productCategory.getSelectedItem();

				if (product_cat.equals("select")) {

					productType.setVisible(true);

				} else {
					productType.setVisible(true);
					product_type_lable.setVisible(true);
					products = DatabaseUtilities.getProductType(product_cat.toLowerCase());
					productCat.setVisible(true);
					for (Product_Type prd : products) {
						String it = String.valueOf(prd.getProduct_type_id()) + ": " + prd.getProduct_type();
						boolean found = false;
						for (int i = 0; i < productType.getItemCount(); i++) {
							String opt = (String) productType.getItemAt(i);
							if (opt.equals(it))
								found = true;
						}
						if (!found) {
							productType.addItem(it);
						}
					}
				}

			}
		});
		


		productType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.getDataVector().removeAllElements();
				dtm.fireTableDataChanged();
				String product_type = (String) productType.getSelectedItem();
				String[] inputs = product_type.split(":");
				Integer product_type_id = Integer.parseInt(inputs[0]);
				orders = new ArrayList<Item>();
				items = DatabaseUtilities.getProductType(product_type_id);
				scrollPane.setVisible(true);
				
				if (items.size() != 0) {
					for (int i = 0; i < items.size(); i++) {
						Vector<Object> data = new Vector<Object>();
						data.add(items.get(i).getProduct_name());
						data.add(items.get(i).getPrice());
						data.add(0);
						dtm.addRow(data);

					}
				}
			}
		});

		
		placeOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rows = dtm.getRowCount();
				Vector<String> itemLine = new Vector<String>();
				itemLine.add(String.valueOf(order.getOrder_id()));
				orderStatus.setVisible(true);
				for (int i = 0; i < items.size(); i++) {
					Item item = items.get(i);
					if(item.getQuantity()!=0){
					order.getItems().put(item.getProduct_id(), item);
					totalPrice +=item.getPrice() * item.getQuantity();
					itemLine.add(item.getProduct_name());
					itemLine.add(String.valueOf(item.getPrice()));
					itemLine.add(String.valueOf(item.getQuantity()));
				
					ost.addRow(itemLine);
					}
				}
				if(totalPrice !=0)
				total.setText("Total Price: "+ String.valueOf(totalPrice));
				
				System.out.println("Ordered Items are:");
				
				for (Map.Entry<Integer, Item> entry : order.getItems().entrySet()) {
					Item it = entry.getValue();
					System.out.println(it.getProduct_name() + it.getPrice() + it.getQuantity());
				}
				DatabaseUtilities.placeOrder(uName,order,0);
				placeOrder.setVisible(false);
				totalPrice = 0;
				//total.setText(String.valueOf(dtm.getValueAt(0, 2)));
				
			}
		});
		placeOrder.setFont(new Font("Times New Roman", Font.BOLD, 17));
		placeOrder.setBackground(new Color(221, 160, 221));
		placeOrder.setBounds(752, 335, 148, 23);
		contentPane.add(placeOrder);

		orderStatusLabel = new JLabel("");
		orderStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		orderStatusLabel.setBounds(299, 518, 148, 25);
		contentPane.add(orderStatusLabel);

		JLabel lblItems = new JLabel("");
		lblItems.setBounds(305, 378, 93, 30);
		contentPane.add(lblItems);
		orderStatusLabel.setVisible(false);

		dtm.addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent arg0) {
				int row = arg0.getFirstRow();
				int column = arg0.getColumn();
				if (orderTable != null && orderTable.getRowCount() > 1 && orderTable.getColumnCount() > 1) {
					
					Object data = orderTable.getValueAt(0, 2);
				
					items.get(row).setQuantity(Integer.parseInt((String.valueOf(data))));
				//	System.out.println("I am in insdie"+items.get(row).getQuantity());
				}
			}
		});

		/*
		 * 
		 * Place Order
		 */

	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
