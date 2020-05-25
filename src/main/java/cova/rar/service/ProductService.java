package cova.rar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cova.rar.dao.ProductDao;
import cova.rar.entities.Product;

public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getProducts(String filter) {
		
		switch(filter) {
			case "all": return productDao.getAll();
			case "gamingrigs": return productDao.getCategory("gamingrigs");
			case "portable": return productDao.getCategory("portable");
			case "accessories": return productDao.getCategory("accessories");
			default: return productDao.getSearch(filter);
		}

	}

	public Product getProduct(String prodID) {
		return productDao.getProduct(prodID);
	}

}
