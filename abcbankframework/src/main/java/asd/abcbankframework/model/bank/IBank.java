package asd.abcbankframework.model.bank;

import java.util.List;
import java.util.function.Predicate;

import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IEntry;
import asd.abcbankframework.model.customer.ICustomer;

public interface IBank {
	public void addCustomer(ICustomer customer);
	public void removeCustomer(ICustomer customer);
	public List<ICustomer> getAllCustomers();
	
	public List<IAccount> getAllAccounts();
	
	public List<IAccount> searchAccount(Predicate predicate);
	
	public IAccount searchAccount(String number);
	
	public ICustomer getCustomerByAccount(String account);
	
	public List<IEntry> getAllEntries();

	
	public String getName();
	public void setName(String name);
}
