package cova.rar.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cova.rar.dao.OrderDao;
import cova.rar.dao.ProductDao;
import cova.rar.entities.Cart;
import cova.rar.entities.Order;

public class OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;

	public void addCart(Cart cart, String userID) {

		// call dao method to add items to item table and reference that to a single
		// order id
		
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		int orderID = orderDao.insertOrder(userID, date);
		
		orderDao.addItems(orderID, cart.getItems());
		
		productDao.removeInventory(cart.getItems());
		
	}
	
	public List<Order> getOrderHistory(String userID) {
		
		List<Order> orders = orderDao.getOrders(userID);
		
		return orders;
	}

}
