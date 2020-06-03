package cova.rar.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.dao.UserDao;
import cova.rar.entities.Address;
import cova.rar.entities.User;
import cova.rar.service.CookieMonster;
import cova.rar.service.UserService;

@Controller
public class MyAccountController {

	@Autowired
	UserDao userDao;

	@Autowired
	CookieMonster cookieMonster;

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/myAccount" })
	public ModelAndView myAccount(@CookieValue("username") String username, HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException, SQLException {
		// assume user is logged in since link to myaccount is hidden

		User user = userDao.getUser(username);
		Address address = userDao.getAddress(username);
		System.out.println("using myaccount mapping...");

		HttpSession session = request.getSession();
		session.setAttribute("streetatt", user.getBlank());
		session.setAttribute("cityatt", user.getBlank());
		session.setAttribute("stateatt", user.getBlank());
		session.setAttribute("zipatt", user.getBlank());
		session.setAttribute("placeatt", user.getBlank());
		session.setAttribute("username", user.getUsername());
		session.setAttribute("firstname", user.getFirstname());
		session.setAttribute("lastname", user.getLastname());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("phone", user.getPhone());
		System.out.println(session.getAttribute("phone"));

		if (null == cookieMonster.getCookie("firstname", request)) {
			userService.setUserCookies(request, response);
			return new ModelAndView("myAccount");
		} else {
			return new ModelAndView("myAccount");
		}
	}

	@RequestMapping(value = { "/addAddress" })
	public ModelAndView myAccount(@ModelAttribute("address") Address address, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		// get info from view

		User user = userDao.getUser(address.getUsername());
		userService.setAddress(address, request);
		HttpSession session = request.getSession();
		
		session.setAttribute("streetatt", address.getStreet());
		session.setAttribute("cityatt", address.getCity());
		session.setAttribute("stateatt", address.getState());
		session.setAttribute("zipatt", address.getZip());
		session.setAttribute("placeatt", address.getPlace());
		System.out.println("addaddress called");
		return new ModelAndView("myAccount", "address", address);
	}
	
	@RequestMapping(value= {"/updateMyAccountInfo"})
	public ModelAndView updateAddress(@ModelAttribute("address") Address address, HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		User user = userDao.getUser(address.getUsername());
		userDao.updateAddress(address);
		
		HttpSession session = request.getSession();
		session.setAttribute("streetatt", address.getStreet());
		session.setAttribute("cityatt", address.getCity());
		session.setAttribute("stateatt", address.getState());
		session.setAttribute("zipatt", address.getZip());
		session.setAttribute("placeatt", address.getPlace());
		System.out.println("updatemyaccount called");
		return new ModelAndView("myAccount", "address", address);
		
	}

}