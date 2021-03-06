package cova.rar.service;

import cova.rar.dao.UserDao;
import cova.rar.entities.Address;
import cova.rar.entities.Login;
import cova.rar.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

	@Autowired
	public UserDao userDao;

	@Autowired
	CookieMonster cookieMonster;

	public int register(User user) {
		return userDao.register(user);
	}

	public Login validateUser(Login login) {
		return userDao.validateUser(login);
	}

	public Login validateAdmin(Login login) {
		return userDao.validateAdmin(login);
	}

	public void setUserCookies(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {

		String username = cookieMonster.getCookie("username", request).getValue();
		User user = null;
		try {
			user = userDao.getUser(username);

			cookieMonster.setCookie("firstname", user.getFirstname(), response);
			cookieMonster.setCookie("lastname", user.getLastname(), response);
			cookieMonster.setCookie("phone", user.getPhone(), response);
			cookieMonster.setCookie("username", user.getUsername(), response);
			cookieMonster.setCookie("password", user.getPassword(), response);
			cookieMonster.setCookie("email", user.getEmail(), response);
		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUser(String userID) {
		try {
			return userDao.getUser(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public void setAddress(Address address, HttpServletRequest request) throws SQLException {

		userDao.setAddress(address, request);

	}
}
