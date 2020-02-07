package asd.abcbankframework.model.customer;

public class Person extends Customer implements IPerson {
	private String birthDate;
	
	public Person() {
		super();
	}

	public Person(String name, String street, String city, String state, String zip, String birthDate) {
		super(name, street, city, state, zip);
		this.birthDate = birthDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
