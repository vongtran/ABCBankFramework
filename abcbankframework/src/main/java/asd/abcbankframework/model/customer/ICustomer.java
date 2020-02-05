package asd.abcbankframework.model.customer;

import java.util.List;

import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.observer.IObserver;

public interface ICustomer extends IObserver {
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void sendEmail(String message);
	
	public String getName();
	public void setName(String name);
	public String getStreet();
	public void setStreet(String street);
	public String getCity();
	public void setCity(String city);
	public String getState();
	public void setState(String state);
	public String getZip();
	public void setZip(String zip);
	public List<IAccount> getAccounts();
}
