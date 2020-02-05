package asd.ccard.controller;

import java.util.ArrayList;
import java.util.List;

import asd.abcbankframework.controller.MainController;
import asd.abcbankframework.model.account.DefaultViewAccountModel;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IDataModel;
import asd.abcbankframework.model.customer.ICustomer;
import asd.ccard.model.account.CCAccount;
import asd.ccard.model.account.CCViewAccountModel;

public class CCController extends MainController {

	private IDataModel dataModel = new CCViewAccountModel();
	
	@Override
	public void addAccount(String name, String street, String city, String state, String zip, String email,
			String typeAccount, String typeCustomer, String noOfemployee, String accountNumber) {
		super.addAccount(name, street, city, state, zip, email, typeAccount, typeCustomer, noOfemployee, accountNumber);
	}
	
	public void generateMonthlyBilling() {
		List<String> billingInfo = new ArrayList<String>();
		for (ICustomer c : bank.getAllCustomers()) {
			for (IAccount a : c.getAccounts()) {
				StringBuilder sb = new StringBuilder();
				sb.append("Name = " + c.getName() + "\n");
			    sb.append("Address = " + c.getStreet() + "\n");
			    sb.append("CC number= " + a.getAccountNumber() + "\n");
//			    sb.append("CC type= " + a.getAccountType() + "\n");
			    sb.append("Previous balance = " + ((CCAccount)a).getLastMonthBalance() + "\n");
			    sb.append("Total Credits= " + ((CCAccount)a).getTotalMonthlyCredits() + "\n");
			    sb.append("Total Charges= " + ((CCAccount)a).getTotalMonthlyCharges() + "\n");
			    sb.append("New balance = " + a.getBalance() + "\n");
			    sb.append("Total amount due= " + ((CCAccount)a).getMonthlyAmountDue() + "\n");
			    billingInfo.add(sb.toString());
			}
		}
	}
}
