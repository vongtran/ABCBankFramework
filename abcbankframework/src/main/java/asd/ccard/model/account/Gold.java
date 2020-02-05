package asd.ccard.model.account;

public class Gold extends CCAccount {
	private double X = 0.05, Y = 0.1;

	@Override
	public double getNewMonthlyBalance() {
		return 0;
	}

	@Override
	public double getMonthlyAmountDue() {
		return 0;
	}

}
