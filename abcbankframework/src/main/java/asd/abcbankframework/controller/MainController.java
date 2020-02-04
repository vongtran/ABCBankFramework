package asd.abcbankframework.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import asd.abcbankframework.View.JDialog_AddAccount;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.db.BankDB;
import asd.abcbankframework.model.account.DefaultViewAccountModel;
import asd.abcbankframework.model.account.IDataModel;
import asd.abcbankframework.model.customer.ICustomer;

public class MainController {
	private IDataModel dataModel = new DefaultViewAccountModel();
	private BankDB bdb = BankDB.getInstance();
	MainView mainView;

	public void addAccount() {

	}
	
	public void deposit() {
		
	}
	
	public void withdraw() {
		
	}
	
	public void updateUI() {
		
	}
	
	public Vector<String> getColumnIdentifiers() {
		return dataModel.getColumnIdentifiers();
	}
	
	public Vector<Vector<String>> getDataVector() {
		List<ICustomer> customers = bdb.getBank().getCustomers();
		System.out.println("bank name: " + bdb.getBank().getName());
		System.out.println("customers total: " + bdb.getBank().getCustomers().size());
		return dataModel.getDataVector(customers, dataModel.defaultAccountFuntion());
	}

	public IDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(IDataModel dataModel) {
		this.dataModel = dataModel;
	}


	
}
