package bank.account;

public class CheckingAccount extends Account {
	private final float ir=2;
	private final float creditlimit=2000;
	
	public void printAccountDetails()
	{
		super.printAccountDetails();
		System.out.println("Interest Rate : " + ir);
		System.out.println("Credit limit : " + creditlimit);
	}
}