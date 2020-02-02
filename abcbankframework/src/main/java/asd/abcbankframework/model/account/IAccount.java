package asd.abcbankframework.model.account;

public interface IAccount {
	public double getBalance();
	public void addEntry(IEntry entry);
}
