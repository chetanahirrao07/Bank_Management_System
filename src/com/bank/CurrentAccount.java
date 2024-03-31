package com.bank;

public class CurrentAccount extends Account

{
	double overdraftlimit;

	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(int accountNumber, String accountHolderName, double acccountBalance,String password, double overdraftlimit) {
		super(accountNumber, accountHolderName, acccountBalance,password);
		this.overdraftlimit = -overdraftlimit;
	}

	public double getOverdraftlimit() {
		return overdraftlimit;
	}

	public void setOverdraftlimit(double overdraftlimit) {
		this.overdraftlimit = -overdraftlimit;
	}

	public double rateofintreset() {
		return 0;
	}

	@Override
	public boolean withdraw(double amount) {
		if (this.overdraftlimit <= this.accountBalance - amount) {
			this.accountBalance -= amount;
			return true;
		} else {
			return false;
		}

	}

	
	

}

