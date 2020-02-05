package asd.ccard.model.account;

import java.util.List;

import asd.abcbankframework.model.account.Account;

public abstract class CCAccount extends Account{
	private String expireDate, lastMonthBalance;
	public CCAccount() {
		super();
	}

	public CCAccount(String accountNumber) {
		super(accountNumber);
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getLastMonthBalance() {
		return lastMonthBalance;
	}

	public void setLastMonthBalance(String lastMonthBalance) {
		this.lastMonthBalance = lastMonthBalance;
	}
	
	public double getTotalMonthlyCredits() {
		return 0.0;
	}
	
	public double getTotalMonthlyCharges() {
		return 0.0;
	}
	
	public void notifyCardHolder() {
		
	}
	
	public abstract double getNewMonthlyBalance();
	
	public abstract double getMonthlyAmountDue();
	
}
