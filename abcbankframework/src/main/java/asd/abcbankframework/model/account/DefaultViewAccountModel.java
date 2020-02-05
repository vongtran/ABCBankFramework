package asd.abcbankframework.model.account;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.function.BiFunction;
import java.util.function.Function;

import asd.abcbankframework.model.bank.IBank;
import asd.abcbankframework.model.customer.Customer;
import asd.abcbankframework.model.customer.ICustomer;
import asd.abcbankframework.model.customer.Person;

public class DefaultViewAccountModel implements IDataModel{
	private Vector<String> columnIdentifiers;
	private Vector<Vector<String>> dataVector;
	public DefaultViewAccountModel() {
		columnIdentifiers = new Vector<String>();
		columnIdentifiers.add("AccountNr");
		columnIdentifiers.add("Name");
		columnIdentifiers.add("City");
		columnIdentifiers.add("P/C");
		columnIdentifiers.add("Ch/S");
		columnIdentifiers.add("Ammount");
		
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
					data.add(c.getCity());
					data.add(c instanceof Person ? "P" : "C");
					data.add(a instanceof Checkings ? "Ch" : "S");
					data.add(String.valueOf(a.getBalance()));
					result.add(data);
				}
			}
			
			return result;
		};
		return accountTableFuction;
	}
	
}
