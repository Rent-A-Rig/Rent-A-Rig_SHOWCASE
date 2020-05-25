package cova.rar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.CartRedirectEntity;
import cova.rar.entities.Product;
import cova.rar.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView productPage(HttpServletRequest request, HttpServletResponse response) {

		List<Product> products = null;
		String filter = "all"; // default value for filter
		
		if (null != request.getParameter("filter")) {
			filter = (String) request.getParameter("filter");
		}
		
		System.out.println(filter);
		products = productService.getProducts(filter);
		CartRedirectEntity cre = new CartRedirectEntity(products, filter);
		

		return new ModelAndView("products", "cartRedirectEntity", cre);
		
	}

}
