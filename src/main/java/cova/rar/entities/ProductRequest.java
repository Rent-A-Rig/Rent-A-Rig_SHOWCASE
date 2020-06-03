package cova.rar.entities;

import java.sql.Date;

public class ProductRequest {

	private String id;
	private String name;
	private int inventory;
	private int requestQty;
	private Date requestDate;
	private String fulfilled;

	public ProductRequest(Product product, RequestedInventory ri) {
		this.id = product.getId();
		this.name = product.getName();
		this.inventory = product.getInventory();
		this.requestQty = ri.getRequest_qty();
		this.requestDate = ri.getRequest_date();
		this.fulfilled = ri.getFulfilled();

	}

	public ProductRequest(Product product) {

		this.id = product.getId();
		this.name = product.getName();
		this.inventory = product.getInventory();
		this.requestDate = null;
		this.requestQty = 0;
		this.fulfilled = null;
	}

	public ProductRequest() {
	};

	public int getRequestQty() {
		return requestQty;
	}

	public void setRequestQty(int request_qty) {
		this.requestQty = request_qty;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date request_date) {
		this.requestDate = request_date;
	}

	public String getFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(String fulfilled) {
		this.fulfilled = fulfilled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

}
