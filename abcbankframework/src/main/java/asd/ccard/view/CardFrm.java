package asd.ccard.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.table.DefaultTableModel;

import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankController;
import asd.bank.view.BankFrm;
import asd.bank.view.BankRightPannelComponent;
import asd.bank.view.InterestDialog;
import asd.bank.view.OwnHeaderComponent;
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
    
	public CardFrm(CardTopPannel topPanelComponent,CardCenterPanel centerPanelComponent,BankRightPannelComponent rightPanelComponent)
	{
		 
		super(centerPanelComponent,rightPanelComponent,topPanelComponent);
		setTitle("Credit Card");		
		bankController = new BankController();
	    

	}
	class AddInterest implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			JButtonInterest_actionPerformed(event);

		}
	}

	void JButtonInterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		InterestDialog interestDialog  = new InterestDialog(this);
//		interestDialog.setBodyCancelAction(new MainView.CancelCreateAccountPer(formDialog));
		interestDialog.setBodyOKAction(new OKCreateAccountPer(interestDialog));
		interestDialog.show();
	}
	class OKCreateAccountPer implements java.awt.event.ActionListener
	{
		InterestDialog interestDialog;
		public OKCreateAccountPer(InterestDialog interestDialog){
			this.interestDialog = interestDialog;
		}
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			bankController.addInterest(Double.parseDouble(interestDialog.getInterest()));
			refreshTable();
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
		    CardTopPannel headerButtonComponent = new CardTopPannel();
			//headerButtonComponent.setJButton_CompACTittle("Add Credit-card account");
			//headerButtonComponent.setJButton_PerACTittle("Generate Monthly bills");
			headerButtonComponent.setBounds(24,20,350,33);
			headerButtonComponent.setLayout(new GridLayout(1, 2));
			

			//Right
			BankRightPannelComponent rightPanelComponent = new CardRightPanelComponent();
			rightPanelComponent.setJButton_WithdrawTittle("Charge");
			rightPanelComponent.setBounds(468,104,96,100);
			rightPanelComponent.setLayout(new GridLayout(3, 1));
			
			//Center
			CCController  controller = new CCController();
			CardCenterPanel centerPanelComponent = new CardCenterPanel(controller.getDataVector(), controller.getColumnIdentifiers());
			
			
			(new CardFrm(headerButtonComponent,centerPanelComponent,rightPanelComponent)).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
	
}
