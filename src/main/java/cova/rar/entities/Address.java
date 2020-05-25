package cova.rar.entities;

public class Address {
	
	private String line1;
	private String line2;
	private String state;
	private String zip;
	
	
	public String getLine1() {
		return line1;
	}


	public void setLine1(String line1) {
		this.line1 = line1;
	}


	public String getLine2() {
		return line2;
	}


	public void setLine2(String line2) {
		this.line2 = line2;
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
		return line1 + " " + line2 + " " + state + " " + zip;
	}
	
	

}
