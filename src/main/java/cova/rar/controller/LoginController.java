package cova.rar.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cova.rar.dao.UserDao;
import cova.rar.entities.Address;
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

	@Autowired
	UserDao userDao;

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

	@PostMapping("/loginProcess")

	public ModelAndView loginProcess(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

		Login loginUser = userService.validateUser(login);
		if (bindingResult.hasErrors()) {
			System.out.println("has error!");
			return new ModelAndView("login");
		}

		ModelAndView m = null;
		if (loginUser == null) {
			bindingResult.rejectValue("username", "username", "Username or password not found!");

			m = new ModelAndView("login");
			return m;

		}
		// if logUser is admin, login as admin and then go adminHome;
		if (loginUser.getUsername().equals("admin")) {
			return new ModelAndView("redirect:/adminhome");
		}

		cookieMonster.setLoginCookie(request, response);
		cookieMonster.setUserCookie2(login, response);

		Address address = userDao.getAddress(login.getUsername());
		System.out.println("using userdao in loginprocess" + address);
		User user = userDao.getUser(login.getUsername());

		HttpSession session = request.getSession();
		
			session.setAttribute("streetatt", address.getStreet());
			session.setAttribute("cityatt", address.getCity());
			session.setAttribute("stateatt", address.getState());
			session.setAttribute("zipatt", address.getZip());
			session.setAttribute("placeatt", address.getPlace());
			session.setAttribute("username", user.getUsername());
			session.setAttribute("firstname", user.getFirstname());
			session.setAttribute("lastname", user.getLastname());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("phone", user.getPhone());
////		
		userDao.getAddress(login.getUsername());
		System.out.println("loginprocess" + login.getUsername());

		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/logoutProcess")
	public String logoutProcess(HttpServletRequest request, HttpServletResponse response) {
		cookieMonster.setLogoutCookie(request, response);

		HttpSession session = request.getSession();
		session.removeAttribute("streetatt");
		session.removeAttribute("cityatt");
		session.removeAttribute("stateatt");
		session.removeAttribute("zipatt");
		session.removeAttribute("placeatt");
		session.removeAttribute("username");
		session.removeAttribute("firstname");
		session.removeAttribute("lastname");
		session.removeAttribute("email");
		session.removeAttribute("phone");
		
		return "redirect:home";

	}
}
