package cova.rar.service;

import cova.rar.dao.UserDao;
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

  public void setUserCookies(HttpServletRequest request, HttpServletResponse response) {

	  String username = cookieMonster.getCookie("username", request).getValue();
	  User user = null;
	try {
		user = userDao.getUser(username, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  cookieMonster.setCookie("firstname", user.getFirstname(), response);
	  cookieMonster.setCookie("lastname", user.getLastname(), response);
	  cookieMonster.setCookie("phone", user.getPhone(), response);
	  cookieMonster.setCookie("username", user.getUsername(), response);
	  cookieMonster.setCookie("password", user.getPassword(), response);
	  cookieMonster.setCookie("email", user.getEmail(), response);

  }

}
