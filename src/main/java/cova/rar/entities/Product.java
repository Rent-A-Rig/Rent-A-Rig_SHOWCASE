package cova.rar.entities;

public class Product {
	
	private String id;
	private String name;
	private double price;
	private String shortDesc;
	private String longDesc;
	private int inventory;
	private String category;
	
	public boolean equals(Product product) {
		if (product.getId().equals(this.id)) {
			return true;
		}
		else {
			return false;
		}


	}
	
	public String getId() {
		return id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public String getShortDesc() {
		return shortDesc;
	}
	
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public void setCategory(String category) {
		this.category = category;
		
	}
	
	public String getCategory() {
		return category;	
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", shortDesc=" + shortDesc + ", longDesc="
				+ longDesc + ", inventory=" + inventory + ", category=" + category + "]";
	}
	
}
