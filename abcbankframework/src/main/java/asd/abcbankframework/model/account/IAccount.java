package asd.abcbankframework.model.account;

import java.util.Vector;

public interface IAccount {
	public double getBalance();
	public void addEntry(IEntry entry);
	public String getAccountNumber();
	public void setAccountNumber(String accountNumber);
}
