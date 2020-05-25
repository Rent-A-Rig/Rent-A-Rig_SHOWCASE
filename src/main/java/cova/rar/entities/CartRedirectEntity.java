package cova.rar.entities;

import java.util.List;

public class CartRedirectEntity {
	
	private List<Product> products;
	private String filter;
	private String prodID;
	private int quantity;
	
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public CartRedirectEntity() {};
	
	public CartRedirectEntity(String filter) {
		this.products = null;
		this.filter = filter;
	}
	
	public CartRedirectEntity(List<Product> products, String filter) {
		this.products = products;
		this.filter = filter;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getProdID() {
		return prodID;
	}
	public void setProdID(String product) {
		this.prodID = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
