package asd.abcbankframework.model.account;

public class Savings extends Account{
	double interest_rate = 0.0325;

	public Savings() {
		super();
	}

	public Savings(String accountNumber) {
		super(accountNumber);
	}
	
}
