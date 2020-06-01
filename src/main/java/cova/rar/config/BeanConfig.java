package cova.rar.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import cova.rar.dao.OrderDao;
import cova.rar.dao.ProductDao;
import cova.rar.dao.UserDao;
import cova.rar.rest.service.RequestService;
import cova.rar.service.CookieMonster;
import cova.rar.service.OrderService;
import cova.rar.service.ProductService;
import cova.rar.service.UserService;
import cova.rar.validator.LoginValidator;
import cova.rar.validator.UserValidator;

@Configuration
@ComponentScan(basePackages = {"cova.rar.service", "cova.rar.dao", "cova.rar.controller", "cova.rar.rest",
		"org.springframework.jdbc.datasource.DriverManagerDataSource",
		"org.springframework.jdbc.core.JdbcTemplate"})
public class BeanConfig {
	
	@Bean
	public UserValidator getUserValidator() {
		return new UserValidator();
	}
	
	@Bean
	public LoginValidator getLoginValidator() {
		return new LoginValidator();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	
	@Bean 
	public UserDao getUserDao() {
		return new UserDao();
	}
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost/rentarig?useSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		dmds.setSchema("rentarig");
		return dmds;
	}
	
	@Bean 
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public ProductService getProductService() {
		return new ProductService();
	}
	
	@Bean
	public ProductDao getProductDao() {
		return new ProductDao();
	}
	
	@Bean
	public CookieMonster getCookieMonster() {
		return new CookieMonster();
	}
	
	@Bean
	public OrderService getOrderService() {
		return new OrderService();
	}
	
	@Bean
	public OrderDao getOrderDao() {
		return new OrderDao();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public RequestService requestService() {
		return new RequestService();
	}

}
