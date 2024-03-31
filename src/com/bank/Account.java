package com.bank;


public abstract class Account {
	int accountNumber;
	String accountHolderName;
	double accountBalance;
	String password;
	
	

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accountNumber, String accountHolderName, double accountBalance,String password) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.password=password;

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public boolean deposite(double amount) {
		this.accountBalance += amount;
		return true;
	}

	public abstract boolean withdraw(double amount);

	
	public abstract double rateofintreset();

	

	
	public boolean transfer1(Account destination,double amount)
	{
		if(this.withdraw(amount))
		{
			destination.deposite(amount);
			
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public void display() {
		System.out.println("\t====================================================================================================");
        System.out.printf("\t| %-8s | %-23s | %-18s | %-33s |\n", "AccountNumber", "AccountHolderName", "Balance", "Password");
        System.out.println("\t====================================================================================================");
		System.out.printf("\t| %-13d | %-23s | %-18s | %-33s |\n",this.getAccountNumber(),this.getAccountHolderName(),this.getAccountBalance(),this.getPassword());
		System.out.println("\t----------------------------------------------------------------------------------------------------");

	}
	public void displayAll() {
		
		System.out.printf("\t| %-13d | %-23s | %-18s |\n",this.getAccountNumber(),this.getAccountHolderName(),this.getAccountBalance());
		System.out.println("\t---------------------------------------------------------------");

	}

}
