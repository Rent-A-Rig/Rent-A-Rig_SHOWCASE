package cova.rar.controller;

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
import cova.rar.entities.RequestedInventory;
import cova.rar.rest.service.RequestService;
import cova.rar.service.CookieMonster;
import cova.rar.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CookieMonster cookieMonster;
	
	@Autowired
	RequestService requestService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView showAdminLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin_login");
		mv.addObject("login", new Login());

		return mv;
	}
	
	@PostMapping("/adminloginprocess")
	public String adminLoginProcess(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
		//Login loginUser = userService.
		if (bindingResult.hasErrors()) {
			return "login";
		}
		
		//if not admin, return back to login
		cookieMonster.setLoginCookie(request, response);
		cookieMonster.setUserCookie2(login, response);
		return "redirect:adminhome";
	}
	
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public ModelAndView showAdmin(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = null;
			
		products = productService.getProducts("all");

		ModelAndView mv = new ModelAndView("adminhome", "products", products);
		//mv.addObject("login", new Login());

		return mv;
	}
	
	@RequestMapping(value = "requestInventory")
	public ModelAndView sendRequest(@RequestParam("id") String id, @RequestParam("requestQty") int requestQty) {
		
		Product product = productService.getProduct(id);
		RequestedInventory invRequest = new RequestedInventory(product, requestQty);
		requestService.sendInventoryRequest(invRequest);
		
		return new ModelAndView("redirect:/adminhome");
	}
	
}
