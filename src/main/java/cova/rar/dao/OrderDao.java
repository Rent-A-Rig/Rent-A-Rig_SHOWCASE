package cova.rar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import cova.rar.entities.Item;
import cova.rar.entities.Order;

public class OrderDao {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ProductDao productDao;
	
	
	public void addItems(int orderID, List<Item> items) {
		String orderStmt = "INSERT INTO items (ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(?,?,?)";
		
		// for each item in the cart. Add the product ID and Order ID and the num of items.
		for (Item item : items) {
			jdbcTemplate.update(orderStmt, orderID, item.getProduct().getId(), item.getQty());
		}
	}
	
	// update order table with username and date and get back unique order ID. 
	public int insertOrder(String userID, Date date) {
		final String INSERT_SQL = "insert into orders (USER_ID, ORDER_DATE) values(?, ?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, userID);
				ps.setDate(2, date);
				return ps;
			}
		}, holder);

		int orderID = holder.getKey().intValue();
		return orderID;
	}
	
	public List<Order> getOrders(String userID) {
		
		// get a list of order IDs and dates
		String sql = "SELECT ORDER_ID, ORDER_DATE FROM orders WHERE USER_ID = " + "'" + userID + "'"; 
		
		List<Order> orders = jdbcTemplate.query(sql, new OrderMapper());
		
		for (Order order : orders) {
			
			//get list of items
			String itemStmt = "SELECT * FROM items WHERE ORDER_ID = " + order.getId();
			List<Item> items = jdbcTemplate.query(itemStmt, new ItemMapper());
			
			order.setItems(items);
		}
		
		
		
		return orders;
	}
	
	class OrderMapper implements RowMapper<Order> {

		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Order order = new Order();
			
			order.setId(rs.getInt("ORDER_ID"));
			order.setDate(rs.getDate("ORDER_Date"));
			
			return order;
		}
		
	}
	
	
	class ItemMapper implements RowMapper<Item> {

		@Override
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {

			Item item = new Item();
			
			item.setQty(rs.getInt("QUANTITY"));
			String prodID = rs.getString("PRODUCT_ID");
			item.setProduct(productDao.getProduct(prodID));


			return item;
		}

	}

}
