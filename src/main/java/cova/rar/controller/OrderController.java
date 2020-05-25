package cova.rar.controller;

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
import cova.rar.entities.OrderHistory;
import cova.rar.service.CookieMonster;
import cova.rar.service.OrderService;

@Controller
@SessionAttributes("cart")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CookieMonster cookieMonster;
	
	@ModelAttribute("cart")
	public Cart cart() {
		return new Cart();
	}
	
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(@ModelAttribute("cart") Cart cart, WebRequest webReq,
			SessionStatus status, HttpServletRequest request) {


		// add items from cart into orders database
		
		
		String userID = cookieMonster.getCookie("username", request).getValue();
		
		orderService.addCart(cart, userID);
		
		status.setComplete();
		webReq.removeAttribute("cart", WebRequest.SCOPE_SESSION);
		
		// update products inventory
		// if product inventory is less than one -> do not update and mark product
		// get orders from database

		// send to orders view with orders from db and products that cant be displayed
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setOrders(orderService.getOrderHistory(userID));
		
		return new ModelAndView("orderhistory", "orderhistory", orderHistory);
	}
	

}
