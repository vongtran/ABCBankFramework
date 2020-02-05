package asd.abcbankframework.model.customer;

import java.util.ArrayList;
import java.util.List;

import asd.abcbankframework.model.account.Account;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.observer.IObserver;
import asd.abcbankframework.observer.Subject;

public class Customer implements ICustomer {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private List<IAccount> accounts = new ArrayList<IAccount>();
	public Customer() {
		
	}
	
	public Customer(String name, String street, String city, String state, String zip) {
		super();
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public List<IAccount> getAccounts() {
		return accounts;
	}
	@Override
	public void addAccount(IAccount account) {
		accounts.add(account);
	}
	@Override
	public void removeAccount(IAccount account) {
		accounts.remove(account);
		
	}
	@Override
	public void sendEmail(String message) {
		System.out.println(" Email sent to: " + getName() + " $$ message: " + message);
	}

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		sendEmail(message);
	}
	

}
