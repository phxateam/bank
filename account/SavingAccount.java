package bank.account;

public class SavingAccount extends Account {
	private final float ir=5;
	
	public void printAccountDetails()
	{
		super.printAccountDetails();
		System.out.println("Interest Rate : " + ir);
	}
	public void printAccountDetails(String fancy)
	{
		System.out.println("=================================");
		super.printAccountDetails();
		System.out.println("Interest Rate : " + ir);
		System.out.println("=================================");
	}
	
}
