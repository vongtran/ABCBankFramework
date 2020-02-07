package asd.abcbankframework.model.account;

import java.util.ArrayList;
import java.util.List;

public  class Account implements IAccount {
	String accountNumber, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
	private List<IEntry> entries = new ArrayList<IEntry>();
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber,String clientName,String street,String city,String zip, String state,String accountType,String clientType,String amountDeposit){
		this.accountNumber = accountNumber;
		this.clientName = clientName;
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.accountType = accountType;
		this.clientType = clientType;
		this.amountDeposit = amountDeposit;
	}
	public Account(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
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
	
	public List<IEntry> getEntries() {
		return entries;
	}
}
