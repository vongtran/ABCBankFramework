package asd.ccard.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.DialogFactory.SimpleFactory;
import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.*;
import asd.ccard.controller.CCController;

import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class CardFrm  extends MainView 
{
	 /****
     * init variables in the object
     ****/
    String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    BankFrm myframe;
    private Object rowdata[];

    BankController bankController;
    
    public void setTableModel(DefaultTableModel model) {
    	this.model = model;
    }
    
	public CardFrm(TopPanelComponent topPanelComponent,CenterPanelComponent centerPanelComponent,RightPanelComponent rightPanelComponent)
	{
		 
		super(centerPanelComponent,rightPanelComponent,topPanelComponent);
		setTitle("Credit Card");		
		bankController = new BankController();
		topPanelComponent.removeButton_CompACAction();
		topPanelComponent.removeButton_PersonAction();
		topPanelComponent.setJButton_CompACAction(new CreateCreditAccount());
		topPanelComponent.setJButton_PerACAction(new GenerateBill());

	}

	class CreateCreditAccount implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			JButton_actionPerformed(event);

		}
	}

	void JButton_actionPerformed(java.awt.event.ActionEvent event)
	{

		CreateCreditDialog formDialog  = new CreateCreditDialog(this,"CC");
		formDialog.setTitle("Add Credit Card Account");
		formDialog.setCancelAction(new CancelCreateCreditAccount(formDialog));
		formDialog.setOKAction(new OKCreateCreditAccount(formDialog));
		formDialog.show();
	}

	class OKCreateCreditAccount implements java.awt.event.ActionListener
	{
		CreateCreditDialog formDialog;
		public OKCreateCreditAccount(CreateCreditDialog formDialog){
			this.formDialog = formDialog;
		}
		public void actionPerformed(java.awt.event.ActionEvent event)
		{

			formDialog.actionOk();
			System.out.println(formDialog.getNumber());
			System.out.println(formDialog.getAccountType());
			System.out.println(formDialog.getCity());
			formDialog.dispose();

		}
	}

	class CancelCreateCreditAccount implements java.awt.event.ActionListener
	{
		FormDialog formDialog;
		public CancelCreateCreditAccount(FormDialog formDialog){
			this.formDialog = formDialog;
		}
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			formDialog.dispose();
		}

	}

	class GenerateBill implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			JButtonGenerateBill_actionPerformed(event);

		}
	}

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{

		BillingDialog billingDialog  = new BillingDialog(this);
		billingDialog.setTitle("Generate Billing");
		billingDialog.setBodyOKAction(new OKGenerateBill(billingDialog));
		billingDialog.show();
	}

	class OKGenerateBill implements java.awt.event.ActionListener
	{
		BillingDialog billingDialog;
		public OKGenerateBill(BillingDialog billingDialog){
			this.billingDialog = billingDialog;
		}
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			billingDialog.dispose();

		}
	}



	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }

		    //Top
		    TopPanelComponent headerButtonComponent = new TopPanelComponent();
			headerButtonComponent.setJButton_CompACTittle("Add Credit-card account");
			headerButtonComponent.setJButton_PerACTittle("Generate Monthly bills");

			headerButtonComponent.setBounds(24,20,350,33);
			headerButtonComponent.setLayout(new GridLayout(1, 2));
			

			//Right
			RightPanelComponent rightPanelComponent = new RightPanelComponent();
			rightPanelComponent.setJButton_WithdrawTittle("Charge");
			rightPanelComponent.setBounds(468,104,96,100);
			rightPanelComponent.setLayout(new GridLayout(3, 1));
			
			//Center
			CCController  controller = new CCController();
			CenterPanelComponent centerPanelComponent = new CenterPanelComponent(controller.getDataVector(), controller.getColumnIdentifiers());
			
			
			(new CardFrm(headerButtonComponent,centerPanelComponent,rightPanelComponent)).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
}
