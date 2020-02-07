package asd.ccard.model.account;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.function.BiFunction;
import java.util.function.Function;

import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IDataModel;
import asd.abcbankframework.model.bank.IFinco;
import asd.abcbankframework.model.customer.Customer;
import asd.abcbankframework.model.customer.ICustomer;
import asd.abcbankframework.model.customer.Person;

public class CCViewAccountModel implements IDataModel{
	private Vector<String> columnIdentifiers;
	private Vector<Vector<String>> dataVector;
	public CCViewAccountModel() {
		columnIdentifiers = new Vector<String>();
		columnIdentifiers.add("CC number");
		columnIdentifiers.add("Name");
		
		columnIdentifiers.add("Exp date");
		columnIdentifiers.add("Type");
		columnIdentifiers.add("Balance");
		
		dataVector = new Vector<Vector<String>>();
		
	}
	public Vector<String> getColumnIdentifiers() {
		return columnIdentifiers;
	}
	public void setColumnIdentifiers(Vector<String> columnIdentifiers) {
		this.columnIdentifiers = columnIdentifiers;
	}
	
	public Vector<Vector<String>> getDataVector(List<ICustomer> customers, Function<List<ICustomer>, Vector<Vector<String>>> f) {
		return f.apply(customers);
	}
	public void setDataVector(Vector<Vector<String>> dataVector) {
		this.dataVector = dataVector;
	}
	public Function<List<ICustomer>, Vector<Vector<String>>> defaultAccountFuntion() {
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		Function<List<ICustomer>, Vector<Vector<String>>> accountTableFuction = (customers) -> {
			for (ICustomer c : customers) {
				for (IAccount a : c.getAccounts()) {
					Vector<String> data = new Vector<String>();
					data.add(a.getAccountNumber());
					data.add(c.getName());
					
					String expDate = "";
					//if (c instanceof CCAccount) {
					//	expDate = ((CCAccount) c).getExpireDate();
					//}
					
	               if (a instanceof Gold) {
						
	            	   expDate = ((CCAccount)a).getExpireDate();
					} else if (a instanceof Silver) {
						expDate = ((CCAccount)a).getExpireDate();
					} else if (a instanceof Bronze ) {
						expDate = ((CCAccount)a).getExpireDate();
					}
					
					
					
					data.add(expDate);
					
					
					
					
					
					
					
					if (a instanceof Gold) {
						
						data.add("Gold");
					} else if (a instanceof Silver) {
						data.add("Silver");
					} else {
						data.add("Bronze");
					}
					
					
				
					data.add(String.valueOf(a.getBalance()));
					result.add(data);
				}
			}
			System.out.println(Arrays.toString(result.toArray()));
			return result;
		};
		return accountTableFuction;
	}
	
}
