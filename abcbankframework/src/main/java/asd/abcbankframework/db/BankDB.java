package asd.abcbankframework.db;

import asd.abcbankframework.model.account.Account;
import asd.abcbankframework.model.account.Checkings;
import asd.abcbankframework.model.account.Entry;
import asd.abcbankframework.model.account.IAccount;
import asd.abcbankframework.model.account.IEntry;
import asd.abcbankframework.model.account.Savings;
import asd.abcbankframework.model.bank.Finco;
import asd.abcbankframework.model.bank.IFinco;
import asd.abcbankframework.model.customer.ICustomer;
import asd.abcbankframework.model.customer.Organization;
import asd.abcbankframework.model.customer.Person;

public class BankDB {
	private static BankDB instance = new BankDB();
	private IFinco bank;
	private BankDB() {
		bank = new Finco();
		bank.setName("MIU Bank");
		
		
		ICustomer c1 = new Person("Van Vong Tran", "1000N 4th Street", "FairField", "IOWA", "52557", "10/10/1990");
		IAccount ac1 = new Checkings("111");
		
		IEntry entry1 = new Entry(10.0, "01/01/2020", "First");
		ac1.addEntry(entry1);
		c1.addAccount(ac1);
		bank.addCustomer(c1);
		
		ICustomer c2 = new Person("Thanh Luan Tran", "1000N 4th Street", "FairField", "IOWA", "52557", "10/10/1990");
		IAccount ac2 = new Savings("112");
		
		IEntry entry2 = new Entry(10.0, "01/01/2020", "First");
		ac2.addEntry(entry2);
		c2.addAccount(ac2);
		bank.addCustomer(c2);
		
		ICustomer c3 = new Person("Thanh Dat Nguyen", "1000N 4th Street", "FairField", "IOWA", "52557", "10/10/1990");
		IAccount ac3 = new Savings("113");
		
		IEntry entry3 = new Entry(10.0, "01/01/2020", "First");
		ac3.addEntry(entry3);
		c3.addAccount(ac3);
		bank.addCustomer(c3);
		
		ICustomer c4 = new Organization("ABC Inc", "1000N 4th Street", "FairField", "IOWA", "52557", 100L);

		IAccount ac4 = new Checkings("222");

		IEntry entry4 = new Entry(10.0, "01/01/2020", "First");
		ac4.addEntry(entry4);
		c4.addAccount(ac4);
		bank.addCustomer(c4);

		ICustomer c5 = new Organization("ABC Inc", "1000N 4th Street", "FairField", "IOWA", "52557", 100L);
		IAccount ac5 = new Account("223");

		IEntry entry5 = new Entry(10.0, "01/01/2020", "First");
		ac5.addEntry(entry5);
		c5.addAccount(ac5);
		bank.addCustomer(c5);
	}
	public static BankDB getInstance() {
		return instance;
	}
	public IFinco getBank() {
		return this.bank;
	}
	public void setBank(IFinco bank) {
		this.bank = bank;
	} 
	
}
