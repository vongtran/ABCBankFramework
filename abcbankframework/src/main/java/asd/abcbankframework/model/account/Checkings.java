package asd.abcbankframework.model.account;

public class Checkings extends Account{
	double interest_rate = 0.01;

	public Checkings() {
		super();
	}

	public Checkings(String accountNumber) {
		super(accountNumber);
	}
	
	public void addInterest(double amount) {
		this.interest_rate=amount;
	}

	public double getInterest_rate() {
		return interest_rate;
	}
}
