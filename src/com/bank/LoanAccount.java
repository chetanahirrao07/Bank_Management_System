package com.bank;

public class LoanAccount extends Account {

	static double roi = 10;

	public static double getRoi() {
		return roi;
	}

	public static void setRoi(double roi) {
		LoanAccount.roi = roi;
	}

	public double rateofintreset() {
		return this.accountBalance * (roi / 100);
	}

	public LoanAccount() {
		// TODO Auto-generated constructor stub
	}

	public LoanAccount(int accountNumber, String accountHolderName, double acccountBalance,String password) {
		super(accountNumber, accountHolderName, -acccountBalance,password);
	}

	@Override
	public boolean withdraw(double amount) {
		System.out.println("Can't Withdraw From This Account Becoz its Loan Account");
		return false;
	}
	
	public boolean deposite(double amount) {
		if(this.accountBalance+amount<=0)
		{
			this.accountBalance+=amount;
			if(this.accountBalance==0)
			{
				System.out.println("This Account Loan Has Been Cleard");
			}
			return true;
		}
		else
		{

			System.out.println("Enter valid amount");
			System.out.println("Remaining Payemnt:"+this.accountBalance);
			return false;
		}
		
		
	
	}
}
