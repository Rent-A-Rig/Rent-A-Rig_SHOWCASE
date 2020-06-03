package cova.rar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import cova.rar.entities.Address;
import cova.rar.entities.Login;
import cova.rar.entities.User;
import cova.rar.service.CookieMonster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	CookieMonster cookieMonster;

	public int register(User user) {

		// username, password, first name, last name, email, phone
		String sql = "insert into user values(?,?,?,?,?,?)";

		return jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
				user.getLastname(), user.getEmail(), user.getPhone() });
	}

	public Login validateUser(Login login) {
		String sql = "select * from user where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";

		List<Login> users = jdbcTemplate.query(sql, new LoginMapper());
		System.out.println("size: " + users.size());

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public Login validateAdmin(Login login) {
		String sql = "select * from user where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";

		List<Login> users = jdbcTemplate.query(sql, new LoginMapper());
		System.out.println("size: " + users.size());

		if (users.size() > 0) { // and isAdmin == true (after you update the database)
			return users.get(0);
		} else {
			return null;
		}
	}

	public void updateAddress(Address address) {

		// update address where type and username match
		// update other user fields

		String aSql = "UPDATE address set place = '" + address.getPlace() + "', street = '" + address.getStreet()
				+ "', city = '" + address.getCity() + "', state = '" + address.getState() + "', zip = '"
				+ address.getZip() + "' where username = '" + address.getUsername() + "'";

		int aRows = jdbcTemplate.update(aSql);
		System.out.println(aRows);
	}

	public int setAddress(Address address, HttpServletRequest request) throws SQLException {
		String sql = "insert into address values(?,?,?,?,?,?)";
		User user = new User();
		CookieMonster cm = new CookieMonster();

		String place = address.getPlace();
		String street = address.getStreet();
		String city = address.getCity();
		String state = address.getState();
		String zip = address.getZip();
		String username = cm.getCookie("username", request).getValue();

		System.out.println("setAddress, userdao" + place + street + city + state + zip + "  username: " + username);

		return jdbcTemplate.update(sql, new Object[] { place, street, city, state, zip, username });
	}

	public Address getAddress(String username) throws SQLException, ClassNotFoundException {

		final String sql = "Select * from address where username = '" + username + "';";

		List<Address> addresses = jdbcTemplate.query(sql, new AddressMapper());
		System.out.println("get address userdao");
		
		if (addresses.size() > 0) {
			return addresses.get(0);
		} else {
			return null;
		}
	}

	public User getUser(String username) throws SQLException {

		String sql = "Select * from user where username = '" + username + "'";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();

			// no address atm
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setFirstname(rs.getString("first_name"));
			user.setLastname(rs.getString("last_name"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone_number"));

			return user;
		}

	}

	class AddressMapper implements RowMapper<Address> {

		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {

			Address address = new Address();

			address.setStreet(rs.getString("street"));
			address.setCity(rs.getString("city"));
			address.setState(rs.getString("state"));
			address.setZip(rs.getString("zip"));
			address.setPlace(rs.getString("place"));
			System.out.println("addressmapper" + address.getPlace() + address.getStreet() + address.getState() + address.getZip() + address.getCity());
			
			return address;
		}

	}
}
