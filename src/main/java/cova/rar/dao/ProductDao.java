package cova.rar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cova.rar.entities.Item;
import cova.rar.entities.Product;

public class ProductDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> getAll() {
		String sql = "select * from products";

		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		if (products.size() > 0) {
			return products;
		} else {
			return null;
		}
		
	}

	public List<Product> getCategory(String category) {

		String sql = "select * from products where category LIKE '%" + category + "%'";
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());

		if (products.size() > 0) {
			return products;
		} else {
			return null;
		}
	}

	public List<Product> getSearch(String search) {
		
		String sql = "select * from products where "
				+ "PRODUCT_NAME LIKE '%" + search + "%'"
						+ "OR SHORT_DESC LIKE '%" + search + "%'"
						+ "OR LONG_DESC LIKE '%" + search + "%'";
		
		
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		System.out.println(products.size());
		if (products.size() > 0) {
			return products;
		} else {
			return null;
		}
	}
	
	public Product getProduct(String prodID) {
		String sql = "select * from products where PRODUCT_ID = " + "\"" + prodID + "\"";
		
		return jdbcTemplate.queryForObject(sql, new ProductMapper());
	}
	
	public List<Item> removeInventory(List<Item> items) {
		List<Item> itemsOutOfStock = new ArrayList<Item>();
		for (Item item : items) {

			String prodID = item.getProduct().getId();
			String qtyStmt = "SELECT STOCK FROM PRODUCTS WHERE PRODUCT_ID = "  + "\"" + prodID + "\"";

			int qty = (int) jdbcTemplate.queryForObject(qtyStmt, new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt("STOCK");
				}

			});
			if (qty >= item.getQty()) {
				qty -= item.getQty();
				String updateStmt = "UPDATE PRODUCTS SET STOCK = " + qty + " WHERE PRODUCT_ID= " + "\"" + prodID + "\"";
				jdbcTemplate.execute(updateStmt);
			}
			else {
				itemsOutOfStock.add(item);
			}

		}

		return itemsOutOfStock;
	}

	class ProductMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

			Product product = new Product();

			product.setId(rs.getString("PRODUCT_ID"));
			product.setName(rs.getString("PRODUCT_NAME"));
			product.setPrice(rs.getDouble("PRODUCT_PRICE"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setShortDesc(rs.getString("SHORT_DESC"));
			product.setLongDesc(rs.getString("LONG_DESC"));
			product.setInventory(rs.getInt("STOCK"));

			return product;
		}

	}

}
