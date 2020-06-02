package cova.rar.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.entities.User;
import cova.rar.service.CookieMonster;
import cova.rar.service.UserService;

@Controller

public class StaticPageController {
	
	@Autowired
	CookieMonster cookieMonster;
	
	@Autowired
	UserService userService;
	
	// map requestmappings to static pages
	@RequestMapping(value= {"/home"})
	public ModelAndView home() {	
		return new ModelAndView("home");
	}
	
	@RequestMapping(value= {"/", ""})
	public ModelAndView firstVisit(HttpServletRequest request, HttpServletResponse response) {
		// check user cookie. If there is no user cookie then make new one with empty string
		if (!cookieMonster.isLoggedIn(request)) {
			cookieMonster.initLogin(request, response);
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = {"/updateinfo"})
	public ModelAndView updateInfo() {
		return new ModelAndView("updateinfo");
	}
	
	@RequestMapping(value = {"/faq"})
	public ModelAndView FAQ() {
		return new ModelAndView("FAQ");
	}
	
	@RequestMapping(value = {"/feedback"})
	public ModelAndView feedback() {
		return new ModelAndView("feedback");
	}
	
	@RequestMapping(value = {"/thankYou"})
	public ModelAndView thankyou() {
		return new ModelAndView("thankYou");
	}
	
}
