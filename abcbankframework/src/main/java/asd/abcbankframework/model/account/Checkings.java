package asd.abcbankframework.model.account;

public class Checkings extends Account{
	double interest_rate = 0.01;

	public Checkings() {
		super();
	}

	public Checkings(String accountNumber) {
		super(accountNumber);
	}
	
}
