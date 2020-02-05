package asd.bank.view;

import java.util.List;

import asd.abcbankframework.controller.MainController;
import asd.abcbankframework.model.account.Checkings;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.Savings;

public class BankController extends MainController  {

	
	public void addInterest(double amount) {
		List<IAccount> accounts = bank.getAllAccounts();
		for (IAccount account : accounts) {
			
			  if (account instanceof Checkings){
				  ((Checkings)account).addInterest(amount);
					System.out.println(((Checkings)account).getInterest_rate());
			  }
			  if (account instanceof Savings){
				  ((Savings)account).addInterest(amount);
			  		System.out.println(((Savings)account).getInterest_rate());
			  }
		}
	
	}
}
