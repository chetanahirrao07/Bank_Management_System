package com.bank;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends SavingAccount {
	LocalDate lastTransicationDate;

	public SalaryAccount() {
		// TODO Auto-generated constructor stub
	}

	public SalaryAccount(int accountNumber, String accountHolderName, double acccountBalance,String password) {
		super(accountNumber, accountHolderName, acccountBalance,password);
		this.lastTransicationDate = LocalDate.now();

	}

	public LocalDate getLastTransicationDate() {
		
		return lastTransicationDate;
	}

	public void setLastTransicationDate(LocalDate lastTransicationDate) {
		this.lastTransicationDate = lastTransicationDate;
	}

	public boolean isFrozen() {
		if (ChronoUnit.DAYS.between(lastTransicationDate, LocalDate.now()) > 60) {
			return true;
		} else {
			return false;
		}
	}

	public boolean withdraw(double amount) {
		if (this.isFrozen()) {
			System.out.println("This Account Has Been Blocked");
			return false;
		} else {
			if (amount <= this.accountBalance - minimumBalance) {
				this.accountBalance -= amount;
				this.lastTransicationDate = LocalDate.now();
				return true;
			} else {
				return false;
			}
		}
	}

	public double rateofintreset() {
		return this.accountBalance * (roi / 100);

	}
	public boolean deposite(double amount) {
		this.accountBalance += amount;
		this.lastTransicationDate = LocalDate.now();
		return true;
	}

}
