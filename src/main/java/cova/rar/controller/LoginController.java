package cova.rar.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.Login;
import cova.rar.entities.User;
import cova.rar.service.CookieMonster;
import cova.rar.service.UserService;
import cova.rar.validator.LoginValidator;
import cova.rar.validator.UserValidator;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private LoginValidator loginValidator;
	
	@Autowired
	CookieMonster cookieMonster;
	
	@InitBinder
	   protected void initBinder(WebDataBinder binder) {
	      binder.addValidators(loginValidator);
	   }
	// go to login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("login", new Login());
		return mv;
	}
	
//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public ModelAndView showAdminLogin(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("admin_login");
//		mv.addObject("login", new Login());
//
//		return mv;
//	}
	
//	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
//	public ModelAndView showAdmin(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("adminhome");
//		//mv.addObject("login", new Login());
//
//		return mv;
//	}
	
//	@PostMapping("/adminloginprocess")
//	public String adminLoginProcess(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
//		//Login loginUser = userService.
//		if (bindingResult.hasErrors()) {
//			System.out.println("has error!");
//			return "login";
//		}
//		
//		//if not admin, return back to login
//		
//		return "redirect:adminhome";
//	}
	
	@PostMapping("/loginProcess")
	public String loginProcess(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
	
		Login loginUser = userService.validateUser(login);
		if (bindingResult.hasErrors()) {
			System.out.println("has error!");
			return "login";
		}
		
		
		if(loginUser == null) { return "login"; }

		
		cookieMonster.setLoginCookie(request, response);
		cookieMonster.setUserCookie2(login, response);
		
		return "redirect:home";
	}
	@RequestMapping("/logoutProcess")
	public String logoutProcess(HttpServletRequest request, HttpServletResponse response) {
		cookieMonster.setLogoutCookie(request, response);
		
		return "redirect:home";
		
	}
}
