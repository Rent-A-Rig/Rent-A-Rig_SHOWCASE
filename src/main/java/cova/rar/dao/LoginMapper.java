package cova.rar.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cova.rar.entities.Login;
import cova.rar.entities.User;

	public class LoginMapper implements RowMapper<Login>{
	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login login = new Login();
		User user = new User();
		
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setFirstname(rs.getString("first_name"));
		user.setLastname(rs.getString("last_name"));
		user.setPhone(rs.getString("phone_number"));
		
		return login;
	}
	
}