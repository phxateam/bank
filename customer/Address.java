package bank.customer;

public class Address {
	private String street;
	private String state;
	private String city;
	private String pincode;
	
	public void createAddress(String street, String state, String city, String pincode) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	
	public void updateAddress() {
		
	}
	
	public void printAddress() {
		System.out.println(street);
		System.out.println(city + ", " + state + " " + pincode);
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
