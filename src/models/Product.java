package models;

public class Product {

	Integer product_id;
	Integer product_type_id;
	Integer brand_id;
	Integer size_id;
	float price;
	Integer package_id;
	String product_name;

	public Product(Integer product_id, Integer product_type_id, Integer brand_id, Integer size_id, float price,
			Integer package_id, String product_name) {
		super();
		this.product_id = product_id;
		this.product_type_id = product_type_id;
		this.brand_id = brand_id;
		this.size_id = size_id;
		this.price = price;
		this.package_id = package_id;
		this.product_name = product_name;
	}
	
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getProduct_type_id() {
		return product_type_id;
	}
	public void setProduct_type_id(Integer product_type_id) {
		this.product_type_id = product_type_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	public Integer getSize_id() {
		return size_id;
	}
	public void setSize_id(Integer size_id) {
		this.size_id = size_id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getPackage_id() {
		return package_id;
	}
	public void setPackage_id(Integer package_id) {
		this.package_id = package_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

}
