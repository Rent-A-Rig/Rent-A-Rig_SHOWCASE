package cova.rar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.CartRedirectEntity;
import cova.rar.entities.Login;
import cova.rar.entities.Product;
import cova.rar.entities.ProductRequest;
import cova.rar.entities.RequestedInventory;
import cova.rar.rest.service.RequestService;
import cova.rar.service.CookieMonster;
import cova.rar.service.ProductService;
import cova.rar.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CookieMonster cookieMonster;
	
	@Autowired
	RequestService requestService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView showAdminLogin(HttpServletRequest request, HttpServletResponse response) {
	
		ModelAndView mv = new ModelAndView("admin_login");
		mv.addObject("login", new Login());

		return mv;
	}
	
	@PostMapping("/adminloginprocess")
	public ModelAndView adminLoginProcess(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		//get loginUser 
		Login loginUser = userService.validateUser(login);
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin_login");
		}
		
		//if loginUser do not exist, return login;
		ModelAndView m = null;
		if(loginUser == null) {
			bindingResult.rejectValue("username", "username","Username or password not found!");
			
			m = new ModelAndView("admin_login");
			return m;	
		}
		
		//if loginUser is not admin, return login;
		if(!loginUser.getUsername().equals("admin") ) {
			bindingResult.rejectValue("username", "username", "Sorry, you are not an admin!");
			return new ModelAndView("admin_login");
		}
		
		cookieMonster.setLoginCookie(request, response);
		cookieMonster.setUserCookie2(login, response);
		return new ModelAndView("redirect:/adminhome");
	}
	
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public ModelAndView showAdmin(HttpServletRequest request, HttpServletResponse response) {
		
		List<ProductRequest> productRequests = new ArrayList<ProductRequest>();
		List<Product> products = productService.getProducts("all");
		List<RequestedInventory> pendingRequests = requestService.getPendingRequests();
		
		if (null == pendingRequests) {
			for (Product product : products) {
				productRequests.add(new ProductRequest(product));
			}
			return new ModelAndView("adminhome", "productRequests", productRequests);
		}
		else {
			for (Product product : products) {
				boolean found = false;
				for (RequestedInventory pendingReq : pendingRequests) {
					if (product.getId().equals(pendingReq.getProduct_id())) {
						found = true;
						productRequests.add(new ProductRequest(product, pendingReq));
					}
				}
				if (!found) {
					productRequests.add(new ProductRequest(product));
				}
			}

			ModelAndView mv = new ModelAndView("adminhome", "productRequests", productRequests);
			return mv;
		}
		
	}
	
	@RequestMapping(value = "/requestInventory")
	public ModelAndView sendRequest(@RequestParam("id") String id, @RequestParam("requestQty") int requestQty) {
		
		Product product = productService.getProduct(id);
		RequestedInventory invRequest = new RequestedInventory(product, requestQty);
		requestService.sendInventoryRequest(invRequest);
		
		return new ModelAndView("redirect:/adminhome");
	}
	
}
