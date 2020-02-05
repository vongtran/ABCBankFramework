package asd.abcbankframework.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import asd.abcbankframework.View.JDialog_AddAccount;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.db.BankDB;
import asd.abcbankframework.model.account.Checkings;
import asd.abcbankframework.model.account.DefaultViewAccountModel;
import asd.abcbankframework.model.account.Entry;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IDataModel;
import asd.abcbankframework.model.account.IEntry;
import asd.abcbankframework.model.account.Savings;
import asd.abcbankframework.model.bank.Bank;
import asd.abcbankframework.model.bank.IBank;
import asd.abcbankframework.model.customer.Customer;
import asd.abcbankframework.model.customer.ICustomer;
import asd.abcbankframework.model.customer.Organization;
import asd.abcbankframework.model.customer.Person;
import asd.abcbankframework.observer.ConcreteSubject;
import asd.abcbankframework.observer.IObserver;


public class MainController {
	private IDataModel dataModel = new DefaultViewAccountModel();
	private BankDB bdb = BankDB.getInstance();
	MainView mainView;


	protected IBank bank = BankDB.getInstance().getBank();
	

	
	public void addAccount(String name, String street, String city
			, String state, String zip, String email, String typeAccount
			, String typeCustomer, String noOfemployee
			, String accountNumber
			) {
		
		//Validation
		
		List<IAccount> accounts = bank.getAllAccounts().stream().filter(x->x.getAccountNumber().equals(accountNumber)).collect(Collectors.toList());
		if(accounts.size()>0)
		{
			System.out.println("This account exist");
			return;
		}
		
		// check accountNumber
		if(accountNumber.isEmpty()) {
			System.out.println("Please enter account number");
			return;
		}
		
		// check name
		if(name.isEmpty()) {
			System.out.println("Please enter name");
			return;
		}
		
		
	   
		ICustomer cus;
	
		//Create customer
		if(typeCustomer=="P") {
			cus=new Person();		
		}
		else //company
		{
			cus=new Organization();
			
		}
		cus.setName(name);
		cus.setStreet(street);
		cus.setCity(city);
		cus.setState(state);
		
		
		//Create acccount
		IAccount account;		
		if(typeAccount=="Ch")
		   account=new Checkings();
		else //"saving"
		   account=new Savings();
		account.setAccountNumber(accountNumber);
		
		cus.addAccount(account);
		bank.addCustomer(cus);
				
		//notifies		
		 notifies(cus," Add account ");

	}
	
	public void deposit(String accoutnNumber, double amount) {
		
		
		IAccount account =  bank.searchAccount(accoutnNumber);
		
		if(account==null)
			throw new Error("Can't find this account ");		
	    
		IEntry entry=new Entry();
		entry.setAmmount(amount);
		entry.setDate("2020-02-23");
		entry.setName(" deposit ");
				
		account.addEntry(entry);
		
		
	
	    ICustomer cus= bank.getCustomerByAccount(accoutnNumber);
		notifies(cus," deposit "+ amount);
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
		
		
		 ICustomer cus= bank.getCustomerByAccount(accoutnNumber);
		 notifies(cus," Withdraw "+ amount);
	}
	
	public void updateUI() {
		
	}
	
	public void notifies(IObserver cus, String message) {
		ConcreteSubject con=new ConcreteSubject();
		con.Attach(cus);
		con.notifies(message);
	}
	
	public Vector<String> getColumnIdentifiers() {
		return dataModel.getColumnIdentifiers();
	}
	
	public Vector<Vector<String>> getDataVector() {
		List<ICustomer> customers = bdb.getBank().getAllCustomers();
		return dataModel.getDataVector(customers, dataModel.defaultAccountFuntion());
	}

	public IDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(IDataModel dataModel) {
		this.dataModel = dataModel;
	}

	


	
}
