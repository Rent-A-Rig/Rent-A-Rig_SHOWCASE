package cova.rar.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cova.rar.dao.OrderDao;
import cova.rar.dao.ProductDao;
import cova.rar.entities.Cart;
import cova.rar.entities.Item;
import cova.rar.entities.Order;
import cova.rar.entities.Product;

public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;

	public Cart addCart(Cart cart, String userID) {
		// call dao method to add items to item table and reference that to a single
		// order id
		boolean cartUpdated = false;
		
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		int orderID = orderDao.insertOrder(userID, date);
		
		// check to see if inventory is greater or equal to cart qty
		for (Item item : cart.getItems()) {
			Product prodInDB = productDao.getProduct(item.getProduct().getId());
			if (prodInDB.getInventory() < item.getQty()) {
				cart.updateItemQty(item, prodInDB.getInventory());
				cartUpdated = true;
			}
		}
		
		if (cartUpdated) {
			return cart;
		}
		
		orderDao.addItems(orderID, cart.getItems());
		productDao.removeInventory(cart.getItems());
		
		return null;
	}
	
	public List<Order> getOrderHistory(String userID) {
		
		List<Order> orders = orderDao.getOrders(userID);
		
		return orders;
	}
	
	public Order getLastOrder(Cart cart, String userID) {	
		Order lastOrder = orderDao.getLastOrder(userID);
		lastOrder.setItems(cart.getItems());
		return lastOrder;
	}

}
