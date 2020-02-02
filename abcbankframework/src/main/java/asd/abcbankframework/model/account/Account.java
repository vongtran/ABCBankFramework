package asd.abcbankframework.model.account;

import java.util.ArrayList;
import java.util.List;

public class Account implements IAccount {
	private String accountNumber;
	private List<IEntry> entries = new ArrayList<IEntry>();
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return entries.stream().mapToDouble(e -> e.getAmmount()).sum();
	}
	public void addEntry(IEntry entry) {
		entries.add(entry);
	}
	
}
