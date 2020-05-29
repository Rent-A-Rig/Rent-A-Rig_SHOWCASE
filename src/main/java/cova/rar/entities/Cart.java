package cova.rar.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Item> items;
	private int numItems;
	private double total;
	
	public Cart() {
		this.items = new ArrayList<Item>(1);
		this.total = 0;
		this.numItems = 0;
	}
	
	public void add(Item item) {
		
		int index = getItemIndex(item);
		if (index != -1) {
			int quantity = item.getQty();
			Item cartItem = items.get(index);
			cartItem.setQty(cartItem.getQty() + quantity);
		}
		else {
			items.add(item);
		}
		
		updateTotal();
		
	}
	
	public void updateItem(Item item) {

		int qty = item.getQty();
		int i = getItemIndex(item);

		if (i == -1) {
			return;
		}
		else if (qty == 0 && i != -1) {
			items.remove(i);
		} else {
			items.get(i).setQty(qty);
		}

		updateTotal();
	}
	
	private void updateTotal() {
		total = 0;
		numItems = 0;
		for (Item item : items) {
			total += item.getQty() * item.getProduct().getPrice();
			numItems += item.getQty();
		}
	}
	
	private int getItemIndex(Item item) {
		int index = 0;
		for (Item existingItem : this.items) {
			if (existingItem.equals(item)) {
				return index;
			} else {
				index++;
			}
		}
		index = -1;
		return index;
	}
	
	public void updateItemQty(Item item, int num) {
		
		int index = getItemIndex(item);
		if (index != -1) {
			items.get(index).setQty(num);
			updateTotal();
		}
		
	}
	
	
	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
