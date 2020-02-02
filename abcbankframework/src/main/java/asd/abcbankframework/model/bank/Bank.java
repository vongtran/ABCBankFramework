package asd.abcbankframework.model.bank;

import java.util.ArrayList;
import java.util.List;

import asd.abcbankframework.model.customer.ICustomer;

public class Bank implements IBank {
	private String name;
	private List<ICustomer> customers = new ArrayList<ICustomer>();
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
	public List<ICustomer> getCustomers() {
		return customers;
	}
	
}
