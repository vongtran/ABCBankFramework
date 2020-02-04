package asd.abcbankframework.controller;

import java.util.List;
import java.util.Vector;

import asd.abcbankframework.db.BankDB;
import asd.abcbankframework.model.account.DefaultViewAccountModel;
import asd.abcbankframework.model.account.Entry;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IDataModel;
import asd.abcbankframework.model.account.IEntry;
import asd.abcbankframework.model.bank.Bank;
import asd.abcbankframework.model.bank.IBank;
import asd.abcbankframework.model.customer.ICustomer;

public class MainController {
	private IDataModel dataModel = new DefaultViewAccountModel();
	private BankDB bdb = BankDB.getInstance();
	private IBank bank = BankDB.getInstance().getBank();
	
	
	public void addAccount(ICustomer customer) {
	   bank.addCustomer(customer);
	}
	
	public void deposit(String accoutnNumber, double amount) {
		
		
		IAccount account =  bank.searchAccount(accoutnNumber);
		
		if(account==null)
			throw new Error("Can't find this account ");		
	    
		IEntry entry=new Entry();
		entry.setAmmount(amount);
		entry.setDate("2020-02-23");
		entry.setName("");
				
		account.addEntry(entry);
		
	
		
	}
	
	public void withdraw(String accoutnNumber, double amount) {
		
        IAccount account =  bank.searchAccount(accoutnNumber);
		
		if(account==null)
			throw new Error("Can't find this account ");		
	    
		IEntry entry=new Entry();
		entry.setAmmount(-1 * amount);
		entry.setDate("2020-02-23");
		entry.setName("");
				
		account.addEntry(entry);
	}
	
	public void updateUI() {
		
	}
	
	public Vector<String> getColumnIdentifiers() {
		return dataModel.getColumnIdentifiers();
	}
	
	public Vector<Vector<String>> getDataVector() {
		List<ICustomer> customers = bdb.getBank().getAllCustomers();
		System.out.println("bank name: " + bdb.getBank().getName());
		System.out.println("customers total: " + bdb.getBank().getAllCustomers().size());
		return dataModel.getDataVector(customers, dataModel.defaultAccountFuntion());
	}

	public IDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(IDataModel dataModel) {
		this.dataModel = dataModel;
	}
	
	
	
}
