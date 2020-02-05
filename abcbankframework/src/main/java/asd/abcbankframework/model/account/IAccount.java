package asd.abcbankframework.model.account;

import java.util.List;
import java.util.Vector;

public interface IAccount {
	public double getBalance();
	public void addEntry(IEntry entry);
	public String getAccountNumber();
	public void setAccountNumber(String accountNumber);
	public List<IEntry> getEntries();
}
