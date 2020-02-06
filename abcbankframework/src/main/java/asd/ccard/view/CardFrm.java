package asd.ccard.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Vector;

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
import asd.ccard.model.account.CCViewAccountModel;
import asd.ccard.model.account.CardDataModel;

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
    
    private static CenterPanelComponent centerPanelComponent;

    CCController ccController;
    
    public void setTableModel(DefaultTableModel model) {
    	this.model = model;
    }
    
	public CardFrm(TopPanelComponent topPanelComponent,CenterPanelComponent centerPanelComponent,RightPanelComponent rightPanelComponent, MainController controller)
	{
		 
		super(centerPanelComponent,rightPanelComponent,topPanelComponent,controller);
		setTitle("Credit Card");		
		ccController = new CCController();
		topPanelComponent.removeButton_CompACAction();
		topPanelComponent.removeButton_PersonAction();
		topPanelComponent.setJButton_CompACAction(new CreateCreditAccount());
		topPanelComponent.setJButton_PerACAction(new GenerateBill());
		centerPanelComponent.setTableModel(new CardDataModel(ccController.getDataVector(), ccController.getColumnIdentifiers()));
		centerPanelComponent=centerPanelComponent;
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
			
			ccController.addAccount(formDialog.getClientName(), formDialog.getStreet(), formDialog.getCity()
            		, formDialog.getState(), formDialog.getZip(),formDialog.getEmail() , formDialog.getAccountType()
            		, "CC", null
            		, formDialog.getNumber(),formDialog.getOther());
			System.out.println(formDialog.getAccountType());
			 Vector<Vector<String>> data = ccController.getDataVector();                       
	            model = new CardDataModel(data, ccController.getColumnIdentifiers());
	            setModel(model);
	            refreshTable(model);
			
			
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
			controller.setDataModel(new CCViewAccountModel());			
			centerPanelComponent = new CenterPanelComponent( new CardDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
		
			
			CardFrm car =new CardFrm(headerButtonComponent,centerPanelComponent,rightPanelComponent, controller);
			car.setModel(new CardDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
			car.setVisible(true);
			centerPanelComponent.setView(car);
		} 
		
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
}
