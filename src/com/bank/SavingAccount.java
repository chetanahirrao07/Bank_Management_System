package com.bank;


class SavingAccount extends Account {
	static double minimumBalance = 1000, roi = 12;

	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(int accountNumber, String accountHolderName, double acccountBalance,String password) {
		super(accountNumber, accountHolderName, acccountBalance,password);
	}

	public static double getMinimumBalance() {
		return minimumBalance;
	}

	public static void setMinimumBalance(double minimumBalance) {
		SavingAccount.minimumBalance = minimumBalance;
	}

	public static double getRoi() {
		return roi; 
	}

	public static void setRoi(double roi) {
		SavingAccount.roi = roi;
	}

	public double rateofintreset() {
		return this.accountBalance * (roi / 100);

	}

		
	
	
	public boolean withdraw(double amount) {
		if (amount <= this.accountBalance - minimumBalance) {
			this.accountBalance -= amount;
			return true;
		} else {
			return false;
		}
	}

}
