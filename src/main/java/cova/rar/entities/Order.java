package cova.rar.entities;

import java.sql.Date;
import java.util.List;


public class Order {
	
	private Date date;
	private int id;
	private List<Item> items;
	private double total;
	
	public double getTotal() {
		return this.total;
	}
	
	public void setTotal() {
		this.total = 0;
		for (Item item : this.items) {
			total += item.getQty() * item.getProduct().getPrice();
		}
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
		setTotal();
	}

	
	

}
