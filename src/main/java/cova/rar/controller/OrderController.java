package cova.rar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.Cart;
import cova.rar.entities.Item;
import cova.rar.entities.Order;
import cova.rar.entities.OrderHistory;
import cova.rar.service.CookieMonster;
import cova.rar.service.OrderService;
import cova.rar.service.UserService;

@Controller
@SessionAttributes("cart")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	UserService userService;

	@Autowired
	CookieMonster cookieMonster;

	@ModelAttribute("cart")
	public Cart cart() {
		return new Cart();
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(ModelAndView mv, @ModelAttribute("cart") Cart cart, 
			WebRequest webReq, SessionStatus status, HttpServletRequest request) {

		// add items from cart into orders database

		String userID = cookieMonster.getCookie("username", request).getValue();

		// update products inventory
		// if product inventory is less than cart item qty then return updated cart (else return null)
		// return back to cart with message before checkout
		Cart updatedCart = orderService.addCart(cart, userID);
		if (null != updatedCart) {
			
			cart = updatedCart;
			mv.setViewName("redirect:/cartUpdated");
			mv.addObject("cart", cart);
			return mv;
		}
		
		// reset cart in session
		status.setComplete();
		webReq.removeAttribute("cart", WebRequest.SCOPE_SESSION);

		// send to orders summary view with orders from db and products that cant be displayed
		mv.setViewName("orderSummary");
		mv.addObject("user", userService.getUser(userID));
		mv.addObject("order", orderService.getLastOrder(cart, userID));

		return mv;
	}
	
	@RequestMapping(value="/orderhistory", method = RequestMethod.GET)
	public ModelAndView orderhistory(ModelAndView mv, HttpServletRequest request) {
		
		String userID = cookieMonster.getCookie("username", request).getValue();
		
		List<Order> orderhistory = orderService.getOrderHistory(userID);
		
		mv.setViewName("orderhistory");
		mv.addObject("user", userService.getUser(userID));
		mv.addObject("orderhistory", orderhistory);
		
		return mv;
	}

}
