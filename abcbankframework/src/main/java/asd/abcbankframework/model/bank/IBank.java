package asd.abcbankframework.model.bank;

import java.util.List;

import asd.abcbankframework.model.customer.ICustomer;

public interface IBank {
	public void addCustomer(ICustomer customer);
	public void removeCustomer(ICustomer customer);
	public List<ICustomer> getCustomers();
	
	public String getName();
	public void setName(String name);
}
