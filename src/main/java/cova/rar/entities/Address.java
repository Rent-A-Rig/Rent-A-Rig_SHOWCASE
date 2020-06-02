package cova.rar.entities;

public class Address {
	
	User user = new User();
	
	private String username = "";
	private String street = "";
	private String city = "";
	private String state = "";
	private String zip = "";
	private String place = "";
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = user.getUsername();
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	@Override
	public String toString() {
		return place + " " + street + " " + city + " " + state + " " + zip;
	}
	
	

}
