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
		
		if (filter.equals("gamingrigs") || filter.equals("portable")) {
			return new ModelAndView("redirect:/category", "filter", filter);
		}
		
		products = productService.getProducts(filter);
		CartRedirectEntity cre = new CartRedirectEntity(products, filter);
		

		return new ModelAndView("products", "cartRedirectEntity", cre);
		
	}
	
	@RequestMapping(value = {"/category"}, method = RequestMethod.GET)
	public ModelAndView ProductCategoryPage(HttpServletRequest request, HttpServletResponse response) {
		
		String filter = (String) request.getParameter("filter");
		
		List<Product> tabOne = productService.getTabProducts(filter, 1);
		List<Product> tabTwo = productService.getTabProducts(filter, 2);
		List<Product> tabThree = productService.getTabProducts(filter, 3);
		ModelAndView mv = null;
		if (filter.equals("gamingrigs")) {
			mv = new ModelAndView("gamingrigs");
		}
		else {
			mv = new ModelAndView("portables");
		}
		
		mv.addObject("tabOne", tabOne);
		mv.addObject("tabTwo", tabTwo);
		mv.addObject("tabThree", tabThree);
		mv.addObject("cartRedirectEntity", new CartRedirectEntity(filter));

		return mv;
		
	}

}
