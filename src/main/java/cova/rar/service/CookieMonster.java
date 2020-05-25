package cova.rar.service;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cova.rar.entities.Login;
import cova.rar.entities.User;

public class CookieMonster {
	
	
	public void setUserCookie(User user, HttpServletResponse response) {

		// username cookie ** will be used to get data from DB for user
		Cookie usernamecookie = new Cookie("username", user.getUsername());
		usernamecookie.setPath("/");
		usernamecookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(usernamecookie);

	}
	public void setUserCookie2(Login login, HttpServletResponse response) {

		// username cookie ** will be used to get data from DB for user
		Cookie usernamecookie = new Cookie("username", login.getUsername());
		usernamecookie.setPath("/");
		usernamecookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(usernamecookie);

	}
	
	public void setLoginCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					loginCookie = cookie;
				}
			}
		}
		
		if (null == loginCookie) {
			loginCookie = new Cookie("login", "true");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(loginCookie);
			
		}
		else if (loginCookie.getValue().equals("false")) {
			loginCookie = new Cookie("login", "true");
			loginCookie.setPath("/");
			loginCookie.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(loginCookie);
		}
		
	}
	
	public void setLogoutCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		
	}
	
	
	
	public boolean isLoggedIn(HttpServletRequest request) {

		Cookie loginCookie = getCookie("login", request);
		
		
		if (null == loginCookie || loginCookie.getValue().equals("false")) {
			return false;
		}
		else {
			return true;
		}
		
	}

	public void initLogin(HttpServletRequest request, HttpServletResponse response) {
		// init the login and session cookies
		
		Cookie loginCookie = getCookie("login", request);
		Cookie sessionCookie = getCookie("session", request);
		String sessionID = request.getSession().getId();
		if (null == loginCookie) {
			setCookie("login", "false", response);
		}
		if (null == sessionCookie || !sessionID.equals(sessionCookie.getValue())) {
			setCookie("session", request.getSession().getId(), response);		
		}
		

	}
	
	public void setCookie(String name, String value, HttpServletResponse response) {
		
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(cookie);
		
	}
	
	public Cookie getCookie(String cookieName, HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					return c;
				}
			}
		}
		
		
		return null;
		

	}

}
