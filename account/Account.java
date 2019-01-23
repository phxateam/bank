package bank.account;

public abstract class Account {
	private int accId;
//	private String accType;
	private double accBalance;
	
	public void createAccount(int accId,double accBalance)
	{
		this.accId=accId;
	//	this.accType=accType;
		this.accBalance=accBalance;
	}
	public void printAccountDetails()
	{
		System.out.println(accId +  "   " + accBalance);
	}
	public void updataAccountDetails()
	{
		
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	
	
	

}
