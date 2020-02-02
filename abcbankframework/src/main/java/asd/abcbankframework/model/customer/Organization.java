package asd.abcbankframework.model.customer;

public class Organization extends Customer implements IOrganization {
	private Long numberOfEmployee;

	public Long getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Long numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	
}
