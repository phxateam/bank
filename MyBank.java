package bank;

import bank.account.Account;
import bank.account.CheckingAccount;
import bank.account.SavingAccount;
import bank.customer.Address;
import bank.customer.Customer;
import bank.exception.*;
import bank.transaction.TransactionServices;

import java.util.*;

public class MyBank {
	
	private Map<Integer, Customer> customers;
	private Scanner scanner = new Scanner(System.in);
	
	private MyBank(){
		customers = new HashMap<Integer, Customer>();
		
		while(true) 
		{		
			try 
			{
				System.out.println("Enter Customer ID, Name, Phone, and Email....");
				int custId = 0;
				try {
					custId = scanner.nextInt();
					if(custId < 0)
						throw new InvalidCustIDException();
					
					if(customers.containsKey(custId)) {
						throw new DuplicateCustomerException();
					}
				}
				catch(InvalidCustIDException e) {
					System.out.println(e.getMessage());
					continue;
				}
				catch (DuplicateCustomerException e) {
					System.out.println(e.getMessage());
					continue;
				}
				String custName = scanner.next();
				String custPhone = scanner.next();
				String custEmail = scanner.next();
				
				System.out.println("Enter customer street, city, state and zip....");
				String street = scanner.next();
				String city = scanner.next();
				String state = scanner.next();
				String pincode = scanner.next();
				
				Account account = createAccount();
				Address objAddress = new Address();
				objAddress.createAddress(street, state, city, pincode);
				
				Customer cust = new Customer();
				cust.createCustomer(custId, custName, custPhone, custEmail, account, objAddress);
				customers.put(cust.getCustID(), cust);
				
				while(true) {
					System.out.println("Enter additional accounts? {Y/N)");
					String yn = scanner.next();
					if(yn.equalsIgnoreCase("N"))
						break;
					
					account = createAccount();
					if(account != null)
						cust.addCustAccount(account);
				}
				
				cust.printCustomerDetails();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input");
				scanner.next();
			}
			catch(Exception e) {
			}
			finally {
				System.out.println("Continue making customers? (Y/N)");
				String yn = scanner.next();
				if(yn.equalsIgnoreCase("N"))
					break;
			}
		}
	}
	
	public Map<Integer, Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(Map<Integer, Customer> customers) {
		this.customers = customers;
	}
	
	private Account createAccount() {
		System.out.println("Enter type of account (C/S)");
		char type = scanner.next().toUpperCase().charAt(0);	
		
		System.out.println("Enter account id and balance");
		int accId = scanner.nextInt();

		Set<Integer> custIds = customers.keySet();

		for(Integer id: custIds) {
			ArrayList<Account> accounts = customers.get(id).getCustAccounts();
			for(Account acc : accounts) {
				if(acc.getAccId() == accId) {
					System.out.println("Duplicate account id");
					return null;
				}			
			}
		}
		
		double accBalance = scanner.nextDouble();
		
		Account objAccount = new SavingAccount();
		
		if(type=='S')
			objAccount = new SavingAccount();
		else
			objAccount = new CheckingAccount();
		
		objAccount.createAccount(accId, accBalance);
		
		return objAccount;
	}
	
	private Customer getCustomer(int custId) {
		if(customers.containsKey(custId))
			return customers.get(custId);

		return null;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyBank myBank = new MyBank();
		
		/*if(myBank.getCustomers().isEmpty()) {
			System.out.println("TEST RUN");
			myBank.setCustomers(myBank.getTestCusts());
		}*/
		
		Customer customer = null;
		
		while(customer == null) {
			System.out.println("Enter Customer ID");
			int custId = scanner.nextInt();
			
			customer = myBank.getCustomer(custId);
			
			if(customer == null)
				System.out.println("Invalid Customer ID");
		}
		
		Account account = null;
		ArrayList<Account> accounts = customer.getCustAccounts();
		while(account == null) {
		
			for(Account acc : accounts)
				acc.listAccount();
			
			System.out.println("Enter Account ID");
			int accId = scanner.nextInt();
			account = customer.getCustAccount(accId);
			
			if(account == null)
				System.out.println("Invalid Account ID");
		}
		
		myBank.performTransactions(customer, account);
		scanner.close();
		System.out.println("Thank you for banking with us.");
	}
		
	private void performTransactions(Customer customer, Account account) {
		TransactionServices objTransactionServices = new TransactionServices();
		while(true) {
			System.out.println("----------------------------------My Bank----------------------------------");
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("----------------------------------1. CW----------------------------------");
			System.out.println("----------------------------------2. CD----------------------------------");
			System.out.println("---------------------------------------------------------------------------");
		
			int choice = 0;
			
			System.out.println("Enter your choice of transaction...");
			try {
				choice = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Must choose one of the listed integers");
				scanner.next();
			}

			switch(choice) {
				case 1:
					System.out.println("Enter amount to withdraw (20-800):");
					int amountToWithdraw = 0;
					try {
						amountToWithdraw = scanner.nextInt();
						if(amountToWithdraw <= 0 || amountToWithdraw > 800 || amountToWithdraw%20!=0)
							throw new InvalidCWAmountException();
						if(account.getAccBalance() - amountToWithdraw < 500)
							throw new MinBalanceException();
					}
					catch(InputMismatchException e) {
						System.out.println("Invalid input.");
						scanner.next();
						continue;
					}
					catch(InvalidCWAmountException e) {
						System.out.println(e.getMessage());
						continue;
					}
					catch(MinBalanceException e) {
						System.out.println(e.getMessage());
						continue;
					}

					objTransactionServices.cashWithdrawal(account, amountToWithdraw);
					customer.printCustomerDetails();
					break;
				case 2:
					System.out.println("Enter amount to deposit ($0.01-$5000.00):");
					int amountToDeposit = 0;
					try{
						amountToDeposit = scanner.nextInt();
						if(amountToDeposit <= 0 || amountToDeposit > 5000)
							throw new CDAmountException();
					}
					catch(CDAmountException e) {
						System.out.println(e.getMessage());
						continue;
					}
					catch(InputMismatchException e) {
						System.out.println("Invalid input.");
						scanner.next();
						continue;
					}
					objTransactionServices.cashDeposit(account, amountToDeposit);
					customer.printCustomerDetails();
					break;
				default:
					System.out.println("No service for this choice");
					break;
			}
			
			System.out.println("Do you want to continue....(Y/N)");
			String yn = scanner.next();
			if(yn.equalsIgnoreCase("N"))
				return;
		}
	}
	
	private HashMap<Integer, Customer> getTestCusts() {
		HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
		Address add1 = new Address();
		add1.createAddress("123 Fake St", "IL", "Chicago", "60551");
		CheckingAccount acc1 = new CheckingAccount();
		acc1.createAccount(1, 2000.0);
		Customer cust1 = new Customer();
		cust1.createCustomer(1, "Joe Johnson", "555-555-5555", "joe@johnson.com", acc1, add1);
		customers.put(cust1.getCustID(), cust1);
		return customers;
	}
	
}
