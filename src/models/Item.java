package models;

public class Item {

	Integer product_id;
	String product_name;
	Integer product_type_id;
	String product_type;
	Integer brand_id;
	String brand;
	Integer size_id;
	String size;
	Integer price;
	Integer quantity;
	String unit;
	Integer store_id;
	String store_add;
	
	public String getStore_add() {
		return store_add;
	}

	public void setStore_add(String store_add) {
		this.store_add = store_add;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Item(){
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Item(Integer product_id, String product_name, Integer product_type_id, String product_type, Integer brand_id,
			String brand, Integer size_id, String size) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_type_id = product_type_id;
		this.product_type = product_type;
		this.brand_id = brand_id;
		this.brand = brand;
		this.size_id = size_id;
		this.size = size;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getSize_id() {
		return size_id;
	}

	public void setSize_id(Integer size_id) {
		this.size_id = size_id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
