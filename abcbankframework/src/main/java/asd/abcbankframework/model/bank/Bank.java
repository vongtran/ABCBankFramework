package asd.abcbankframework.model.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import asd.abcbankframework.model.account.Entry;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IEntry;
import asd.abcbankframework.model.customer.ICustomer;

public class Bank implements IBank {
	private String name;
	private List<ICustomer> customers = new ArrayList<ICustomer>();
	private List<IAccount> accounts = new ArrayList<IAccount>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void addCustomer(ICustomer customer) {
		customers.add(customer);
	}
	@Override
	public void removeCustomer(ICustomer customer) {
		customers.remove(customer);
	}
	@Override
	public List<ICustomer> getAllCustomers() {
		return customers;
	}
	@Override
	public List<IAccount> getAllAccounts() {
		// TODO Auto-generated method stub
		for (ICustomer cus : customers) {
			for (IAccount acc : cus.getAccounts()) {
						accounts.add(acc);
	    	}
		}
		return accounts;
	}
	
	@Override
	public List<IAccount> searchAccount(Predicate predicate) {
		// TODO Auto-generated method stub
		List<IAccount> account =  getAllAccounts();
		
	  return (List<IAccount>)account.stream().filter(predicate).collect(Collectors.toList());
	}
	
	@Override
	public IAccount searchAccount(String number) {
		// TODO Auto-generated method stub
		List<IAccount> account =  getAllAccounts();
		
		account = account.stream().filter(x->x.getAccountNumber()==number).collect(Collectors.toList());
		
		if(account.size()==0)
			return null;
		else
			return account.get(0);
	}
	
	@Override
	public ICustomer getCustomerByAccount(String number) {
		// TODO Auto-generated method stub
		for (ICustomer cus : customers) {
			for (IAccount acc : cus.getAccounts()) {
						if(acc.getAccountNumber()==number)
							return cus;
	    	}
		}
		return null;
		
		
	}
	@Override
	public List<IEntry> getAllEntries() {
		// TODO Auto-generated method stub
		
		List<IEntry> list=new ArrayList<IEntry>();
		for (IAccount account : getAllAccounts()) {
			for (IEntry entry : account.getEntries()) {
				list.add(entry);
				
			}
		}
		return list;
	}
	
	
}
