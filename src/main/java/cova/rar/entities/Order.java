package cova.rar.entities;

import java.sql.Date;
import java.util.List;


public class Order {
	
	private Date date;
	private int id;
	private List<Item> items;
	
	private double getTotal() {
		double total = 0;
		for (Item item : items) {
			total += item.getQty() * item.getProduct().getPrice();
		}
		return total;
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
	}

	
	

}
