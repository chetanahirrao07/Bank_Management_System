package com.bank;


public class Report {
	int accountNumber;
	String accountName;
	double transicationAmount;
	String activity;

	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(int accountNumber, String accountName, double transicationAmount, String activity) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.transicationAmount = transicationAmount;
		this.activity = activity;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getTransicationAmount() {
		return transicationAmount;
	}

	public void setTransicationAmount(double transicationAmount) {
		this.transicationAmount = transicationAmount;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}

