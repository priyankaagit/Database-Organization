package models;

import java.util.*;

public class Order {
	String status;
	Integer order_id;
	HashMap<Integer, Item> items;
	Integer total = 0;
	
	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Order(){
		items = new HashMap<>();
	}
	
	public HashMap<Integer, Item> getItems() {
		return items;
	}

	public void setItems(HashMap<Integer, Item> items) {
		this.items = items;
	}

	
	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	public void addItem(Item it){
		if(items == null)
			items = new HashMap<Integer, Item>();
		items.put(it.getProduct_id(),it);
	}
	
	public void addItems(HashMap<Integer, Item> items){
		if(this.items == null)
			this.items = new HashMap<Integer, Item>();
		for(Map.Entry<Integer, Item> entry : items.entrySet()){
			this.items.put(entry.getKey(), entry.getValue());
		}
	}
}
