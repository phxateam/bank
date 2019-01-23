package bank.customer;

public class Address {
	private String street;
	private String state;
	private String city;
	private String pincode;
	
	public void createAddress(String street,String state,String city,String pincode)
	{
		this.street=street;
		this.state=state;
		this.city=city;
		this.pincode=pincode;
	}
	public void updateAddress()
	{
		
	}
	public void printAddress()
	{
		System.out.println(street + "   " + state + "   " + city + "   " + pincode);
	}
}
