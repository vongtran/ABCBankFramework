package asd.abcbankframework.model.customer;

import java.util.List;

import asd.abcbankframework.model.account.IAccount;

public class Organization extends Customer implements IOrganization {
	private Long numberOfEmployee;
	
	public Organization() {
		super();
	}

	public Organization(String name, String street, String city, String state, String zip, Long numberOfEmployee) {
		super(name, street, city, state, zip);
		this.numberOfEmployee = numberOfEmployee;
	}

	public Long getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Long numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	
}
