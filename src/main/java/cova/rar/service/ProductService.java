package cova.rar.service;

import java.util.ArrayList;
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

	public List<Product> getTabProducts(String filter, int i) {
		
		List<Product> tabProducts = new ArrayList<Product>();
		List<Product> allProducts = productDao.getCategory(filter);
		
		if (i==1) {
			for (Product product : allProducts) {
				if (product.getCategory().contains("desktop") || product.getCategory().contains("thinandlight")) {
					tabProducts.add(product);
				}
			}
		}
		else if (i==2) {
			for (Product product : allProducts) {
				if (product.getCategory().contains("monitor") || product.getCategory().contains("gaminglaptop")) {
					tabProducts.add(product);
				}
			}
		}
		else if (i==3) {
			for (Product product : allProducts) {
				if (product.getCategory().contains("accessories") || product.getCategory().contains("tablet")) {
					tabProducts.add(product);
				}
			}
		}
		
		return tabProducts;
	}

}
