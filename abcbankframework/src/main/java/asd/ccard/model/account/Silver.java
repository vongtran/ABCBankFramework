package asd.ccard.model.account;

public class Silver extends CCAccount {
	private double X = 0.06, Y = 0.14;

	@Override
	public double getNewMonthlyBalance() {
		return 0;
	}

	@Override
	public double getMonthlyAmountDue() {
		return 0;
	}

}
