package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.CartRedirectEntity;
import cova.rar.entities.Item;
import cova.rar.entities.Product;
import cova.rar.service.CookieMonster;
import cova.rar.service.ProductService;
import cova.rar.entities.Cart;

@Controller
@SessionAttributes("cart")
public class CartController {

	@Autowired
	ProductService productService;

	@Autowired
	CookieMonster cookieMonster;
	
	@ModelAttribute("cart")
	public Cart cart() {
		return new Cart();
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(Model model, @ModelAttribute Cart cart,
			@ModelAttribute("cartRedirectEntity") CartRedirectEntity cre) {

		// Get ProductID
		// Get ProductQTY
		// Get list of products

		String filter = cre.getFilter();
		String prodID = cre.getProdID();
		int prodQty = cre.getQuantity();

		// if no cart in session then make one
		// add products to cart object
		// add cart to session
		Item item = new Item();
		item.setProduct(productService.getProduct(prodID));
		item.setQty(prodQty);

		if (null != cart) {
			cart.add(item);
		} else {
			cart = new Cart();
			cart.add(item);
		}

		// redirect back to /products view with products obj
		return "redirect:/products?filter=" + filter;
	}
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView showCartPOST(@ModelAttribute("cart") Cart cart,
			HttpServletRequest request, HttpServletResponse response) {

		// if not logged in redirect to log in page
		// if no items in cart (or null) send to empty cart view

		if (!cookieMonster.isLoggedIn(request)) {
			return new ModelAndView("redirect:/login");
		}
		if (null == cart || cart.getItems().size() < 1) {
			return new ModelAndView("emptyCart");
		} else {
			// get cart from session and send to checkout view
			return new ModelAndView("cart", "cart", cart);
		}

	}
	
	@RequestMapping(value = "/updateCart", method = RequestMethod.POST)
	public ModelAndView updateCart(@ModelAttribute("cart") Cart cart,
			HttpServletRequest request, HttpServletResponse response) {

		String[] prodIDs = request.getParameterValues("prodID");
		String[] quantities = request.getParameterValues("quantity");

		for(int i = 0; i < prodIDs.length; i++) {
			
			Product product = productService.getProduct(prodIDs[i]);
			int qty = Integer.parseInt(quantities[i]);
			Item item = new Item(product, qty);	
			cart.updateItem(item);
			
		}
		
		return new ModelAndView("redirect:/cart", "cart", cart);

	}

	
}
