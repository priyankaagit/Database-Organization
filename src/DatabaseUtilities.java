import java.sql.*;
import models.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import models.Product_Type;
public class DatabaseUtilities {
	
	 Connection conn = null;
	
	public static void insertCustomer(Customer cust){
		String firstName = cust.getFirstName();
		String lastName = cust.getLastName();
		String emailId = cust.getEmailId();
		String password = cust.getPassword();
		String phoneNumber =  cust.getPhoneNumber();
		String programId = cust.getProgramId();
	    
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "INSERT INTO DBO_IIT_CUSTOMER (FIRSTNAME,LASTNAME,PHONE,EMAIL,PASSWORD,PROGRAM_ID) " + "VALUES (?,?,?,?,?,?)";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,firstName); 
			pst.setString(2,lastName); 
			pst.setString(3,phoneNumber);
			pst.setString(4,emailId);
			pst.setString(5,password);	
			pst.setString(6,programId);
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}			
	}
	
	public static boolean selectUser(String userName, String password){
		
		boolean status = false;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String checkCustomerQuery = "SELECT EMAIL, PASSWORD from DBO_IIT_CUSTOMER where EMAIL =?  ";   	   
			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			pst.setString(1,userName);
			//pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				String userid = (rs.getString("EMAIL"));
				String pass = (rs.getString("PASSWORD"));
				if (userName.equals(userid) && password.equals(pass) ){
					  status = true;			
				}
				else {
					status = false;				
				}						 
			}
	    }
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	public static void insertAddress(Address ad, String userName){
		
		String street = ad.getStreet();	
		String apartment = ad.getApartment();
		String city = ad.getCity();
		String state = ad.getState();
		String country = ad.getCountry();
		String zipcode = ad.getZipcode();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "INSERT INTO DBO_IIT_ADDRESS (EMAIL,STREET,APARTMENT,CITY,STATES,COUNTRY,ZIPCODE) " + "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,userName); 
			pst.setString(2,street); 
			pst.setString(3,apartment);
			pst.setString(4,city);
			pst.setString(5,state);	
			pst.setString(6,country);	
			pst.setString(7,zipcode);	
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}			
				
	}
	
	public static void deleteAddress(Address ad, String userName){
		String street = ad.getStreet();	
		String apartment = ad.getApartment();
		String city = ad.getCity();
		String state = ad.getState();
		String country = ad.getCountry();
		String zipcode = ad.getZipcode();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "DELETE FROM DBO_IIT_ADDRESS WHERE EMAIL= ?";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,userName); 
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
	}
	public static void updateAddress(Address ad, String userName){
		
		String street = ad.getStreet();	
		String apartment = ad.getApartment();
		String city = ad.getCity();
		String state = ad.getState();
		String country = ad.getCountry();
		String zipcode = ad.getZipcode();
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "UPDATE DBO_IIT_ADDRESS SET STREET=?,APARTMENT=?,CITY=?,STATES=?,COUNTRY=?,ZIPCODE=? WHERE EMAIL=?";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,street); 
			pst.setString(2,apartment); 
			pst.setString(3,city);
			pst.setString(4,state);
			pst.setString(5,country);	
			pst.setString(6,zipcode);	
			pst.setString(7,userName);	
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void insertCard( String cardNumber,String expiryDt,String cv,String userName){
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "INSERT INTO DBO_IIT_CARD (EMAIL,CARD_NO,CVV,EXPIRY) " + "VALUES (?,?,?,?)";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,userName); 
			pst.setString(2,cardNumber); 
			pst.setString(3,cv);
			pst.setString(4,expiryDt);	
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}			
				
	}
	
	public static void deleteCard(String userName){
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "DELETE FROM DBO_IIT_CARD WHERE EMAIL =?";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,userName); 
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
	}
	public static void updateCard(String cardNumber,String expiryDt,String cv, String userName){
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "UPDATE DBO_IIT_CARD SET CARD_NO=?,CVV=?,EXPIRY=? WHERE EMAIL=?";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setString(1,cardNumber); 
			pst.setString(2,cv); 
			pst.setString(3,expiryDt);
			pst.setString(4,userName);
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static ArrayList<String> getProductCategory(){
		ArrayList<String> catgs = new ArrayList<String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String checkCustomerQuery = "select distinct product_category from dbo_iit_product_hierarchy";   	   
			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				catgs.add(rs.getString(1));	
			}
	    }
		catch(Exception e){
			e.printStackTrace();
		}
		return catgs;
	}
	
	
	public static ArrayList<Product_Type> getProductType(final String product_category) {
		ArrayList<Product_Type> productTypes = new ArrayList<Product_Type>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String checkCustomerQuery = "select * from dbo_iit_product_type where product_category = ?";
			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			pst.setString(1, product_category);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Product_Type p = new Product_Type();
				p.setProduct_type_id(rs.getInt(1));
				p.setProduct_type(rs.getString(2));
				p.setProduct_category(rs.getString(3));
				productTypes.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productTypes;
	}
	public static ArrayList<Item> getProductType(int product_type_id) {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String checkCustomerQuery = "SELECT P.PRODUCT_ID,P.PRODUCT_NAME,P.PRODUCT_TYPE_ID,B.BRAND_ID,B.BRAND_NAME,S.SIZE_ID,S.UNIT,P.PRICE,I.QUANTITY"
					+ " FROM DBO_IIT_PRODUCT P" + " LEFT JOIN DBO_IIT_BRAND B ON" + " P.BRAND_ID = B.BRAND_ID"
					+ " LEFT JOIN DBO_IIT_SIZE S ON" + " P.SIZE_ID = S.SIZE_ID" + " LEFT JOIN DBO_IIT_PRODUCT_TYPE T ON"					
					+ " P.PRODUCT_TYPE_ID =  T.PRODUCT_TYPE_ID" 
					+ " LEFT JOIN DBO_IIT_INVENTORY I ON"+" P.PRODUCT_ID = I.PRODUCT_ID"
					+ " WHERE P.PRODUCT_TYPE_ID = ?";

			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			pst.setInt(1, product_type_id);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Item it = new Item();
				it.setProduct_id(rs.getInt(1));
				it.setProduct_name(rs.getString(2));
				it.setProduct_type_id(rs.getInt(3));
				it.setBrand_id(rs.getInt(4));
				it.setBrand(rs.getString(5));
				it.setSize_id(rs.getInt(6));
				it.setSize(rs.getString(7));
				it.setPrice(rs.getInt(8));
				it.setQuantity(rs.getInt(9));
				items.add(it);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		for (Item i : items)
			System.out.println(i.getBrand());
		return items;
	}
	
	public static ArrayList<Item> getProduct(int prodId,int storeId) {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String checkCustomerQuery = "SELECT P.PRODUCT_ID,P.PRODUCT_NAME,B.BRAND_NAME,S.UNIT,P.PRICE,I.CURRENT_STOCK,PRODUCT_TYPE,S.PACKAGE_SIZE,I.STORE_ADDRESS"
					+ " FROM DBO_IIT_PRODUCT P" + " LEFT JOIN DBO_IIT_BRAND B ON" + " P.BRAND_ID = B.BRAND_ID"
					+ " LEFT JOIN DBO_IIT_SIZE S ON" + " P.SIZE_ID = S.SIZE_ID" + " LEFT JOIN DBO_IIT_PRODUCT_TYPE T ON"					
					+ " P.PRODUCT_TYPE_ID =  T.PRODUCT_TYPE_ID" 
					+ " LEFT JOIN DBO_IIT_STORE I ON"+" P.PRODUCT_ID = I.PRODUCT_ID"
					+ " WHERE P.PRODUCT_ID=? AND I.STORE_ID=?";

			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			pst.setInt(1, prodId);
			pst.setInt(2, storeId);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Item it = new Item();
				it.setProduct_id(rs.getInt(1));
				it.setProduct_name(rs.getString(2));
				it.setBrand(rs.getString(3));
				it.setUnit(rs.getString(4));
				it.setPrice(rs.getInt(5));
				it.setQuantity(rs.getInt(6));
				it.setProduct_type(rs.getString(7));
				it.setSize(rs.getString(8));
				it.setStore_add(rs.getString(9));
				it.setStore_id(storeId);
				items.add(it);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return items;
	}
	public static void updateProduct(int prodId,int prices, int quan){
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String updatePriceQuery = "UPDATE DBO_IIT_PRODUCT SET PRICE=? WHERE PRODUCT_ID=?";
			PreparedStatement pst = conn.prepareStatement(updatePriceQuery);
			pst.setInt(1, prices);
			pst.setInt(2,prodId);
			pst.executeUpdate();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		
	}
	
	
	public static ArrayList<Integer> getQuantity(int prodId, int storeId){
		
		ArrayList<Integer> stock = new ArrayList<Integer>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String updatePriceQuery = "SELECT CAPACTY,CURRENT_STOCK FROM DBO_IIT_STORE WHERE STORE_ID = ? AND PRODUCT_ID= ?";
			PreparedStatement pst = conn.prepareStatement(updatePriceQuery);
			pst.setInt(1, storeId);
			pst.setInt(2,prodId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				stock.add(rs.getInt(1));
				stock.add(rs.getInt(2));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		return stock;
		
	}
	
	public static void insertProduct(Product prod){
		
		Integer product_id = prod.getProduct_id();
		Integer product_type_id = prod.getProduct_type_id();
		Integer brand_id= prod.getBrand_id();
		Integer size_id= prod.getSize_id();
		float price=prod.getPrice();
		Integer package_id=prod.getPackage_id();
		String product_name=prod.getProduct_name();
		try{                                         
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
			String insertIntoCustomerQuery = "INSERT DBO_IIT_PRODUCT (PRODUCT_ID,PRODUCT_TYPE_ID,BRAND_ID,SIZE_ID,PRICE,PACKAGE_ID,PRODUCT_NAME) " + "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
			pst.setInt(1,product_id); 
			pst.setInt(2,product_type_id);
			pst.setInt(3,brand_id);
			pst.setInt(4,size_id);
			pst.setFloat(5,price);
			pst.setInt(6,package_id);
			pst.setString(7,product_name);	
			pst.execute();
			conn.commit();
			conn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		
		
	}
	
	public static void updateStore(int storeId, int prodId, int quantity){
		
				try{                                         
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priyanka", "priyanka");
					String insertIntoCustomerQuery = "UPDATE DBO_IIT_STORE SET CURRENT_STOCK =? WHERE STORE_ID=? AND PRODUCT_ID =?";
					PreparedStatement pst= conn.prepareStatement(insertIntoCustomerQuery);
					pst.setInt(1,quantity); 
					pst.setInt(2,storeId);
					pst.setInt(3,prodId);
					pst.execute();
					conn.commit();
					conn.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}				
		
	}
	
	
	public static int selectOrderNumber() {

		int rows=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String checkCustomerQuery = "select max(order_id) from dbo_iit_order";
			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			//pst.setString(1, table);
			// pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				rows = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows+1;
	}
	
	public static Order getOrderDetail(int order_id){
		HashMap<Integer,Item> items = new HashMap<Integer,Item>();
		Order order = new Order();
		order.setOrder_id(order_id);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String checkCustomerQuery = "select o.order_id,p.product_name,o.price,o.unit,o.status from"
					+ " dbo_iit_order o left join dbo_iit_product p on"
					+ " o.product_id = p.product_id where o.order_id = ?";
			PreparedStatement pst = conn.prepareStatement(checkCustomerQuery);
			pst.setInt(1, order_id);			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setProduct_id(order_id);
				item.setProduct_name(rs.getString(2));
				item.setPrice(rs.getInt(3));
				item.setQuantity(rs.getInt(4));
				items.put(item.getProduct_id(), item);
				order.setStatus(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		order.setItems(items);
		
		return order;
		
	}
	
	public static int placeOrder(String userName, Order order,int storeId){
		
		int orderNum = order.getOrder_id();
		System.out.println("Inside placeorder"+orderNum);
		HashMap<Integer,Item> items = order.getItems();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "priyanka", "priyanka");
			String insertIntoCustomerQuery = "INSERT INTO dbo_iit_order (order_id,product_id,price,unit,store_id,customer_name,status) "
					+ "VALUES (?,?,?,?,?,?,?)";
			
			
			for(Map.Entry<Integer, Item> entry: items.entrySet()){
				Item it = entry.getValue();
				PreparedStatement pst = conn.prepareStatement(insertIntoCustomerQuery);
			pst.setInt(1, orderNum);
			pst.setInt(2,it.getProduct_id());
			pst.setInt(3, it.getPrice());
			pst.setInt(4, it.getQuantity());
			pst.setInt(5, storeId);
			pst.setString(6, userName);
			pst.setString(7, "placed");
			pst.executeQuery();
		}
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orderNum+1;
	}
	
	
}
