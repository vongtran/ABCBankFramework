package asd.ccard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
			String typeAccount, String typeCustomer, String noOfemployee, String accountNumber,String other) {
	
		
		super.addAccount(name, street, city, state, zip, email, typeAccount, typeCustomer, noOfemployee, accountNumber,other);
	
	
	}
	
	public StringBuilder generateMonthlyBilling() {
		StringBuilder sb = new StringBuilder();
		List<String> billingInfo = new ArrayList<String>();
		for (ICustomer c : bank.getAllCustomers()) {
			for (IAccount a : c.getAccounts()) {
			
				sb.append("Name = " + c.getName() + "\n");
			    sb.append("Address = " + c.getStreet() + "\n");
			    sb.append("CC number= " + a.getAccountNumber() + "\n");
//			    sb.append("CC type= " + a.getAccountType() + "\n");
			    if(a instanceof CCAccount)
			    {
			    sb.append("Previous balance = " + ((CCAccount)a).getLastMonthBalance() + "\n");
			    sb.append("Total Credits= " + ((CCAccount)a).getTotalMonthlyCredits() + "\n");
			    sb.append("Total Charges= " + ((CCAccount)a).getTotalMonthlyCharges() + "\n");
			    sb.append("New balance = " + a.getBalance() + "\n");
			    sb.append("Total amount due= " + ((CCAccount)a).getMonthlyAmountDue() + "\n");
			    billingInfo.add(sb.toString());
			    }
			    
			}
			
			sb.append("=============================================\n");
		}
		
		return sb;
	}
	@Override
	public Vector<String> getColumnIdentifiers() {
		return dataModel.getColumnIdentifiers();
	}
	@Override
	public Vector<Vector<String>> getDataVector() {
		List<ICustomer> customers = bdb.getBank().getAllCustomers();
		return dataModel.getDataVector(customers, dataModel.defaultAccountFuntion());
	}
}
