package models;

public class Product_Type {
	
	Integer product_type_id;
	String product_type;
	String product_category;
	public Product_Type(){}
	public Product_Type(Integer product_type_id, String product_type, String product_category) {
		super();
		this.product_type_id = product_type_id;
		this.product_type = product_type;
		this.product_category = product_category;
	}
		
	public Integer getProduct_type_id() {
		return product_type_id;
	}
	public void setProduct_type_id(Integer product_type_id) {
		this.product_type_id = product_type_id;
	}
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

}
