package asd.bank.view;

import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.abcbankframework.controller.MainController;

import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * A basic JFC based application.
 **/
public class BankFrm extends MainView
{
    /****
     * init variables in the object
     ****/


    BankController bankController;

    
	public BankFrm(OwnHeaderComponent topPanelComponent,CenterPanelComponent centerPanelComponent,RightPanelComponent rightPanelComponent)
	{
		super(centerPanelComponent,rightPanelComponent,topPanelComponent);
		topPanelComponent.setJButton_AddInterest(new AddInterest());
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
		interestDialog.setBodyCancelAction(new CancelCreateAccountPer(interestDialog));
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
			interestDialog.dispose();
		}
	}

	class CancelCreateAccountPer implements java.awt.event.ActionListener
	{
		InterestDialog interestDialog;
		public CancelCreateAccountPer(InterestDialog interestDialog){
			this.interestDialog = interestDialog;
		}
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			interestDialog.dispose();
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

			OwnHeaderComponent headerButtonComponent = new OwnHeaderComponent();
			headerButtonComponent.setJButton_CompACTittle("Add Company Account");
			headerButtonComponent.setJButton_PerACTittle("Add Personal Account");
			headerButtonComponent.setBounds(24,20,350,33);
			headerButtonComponent.setLayout(new GridLayout(1, 2));

			RightPanelComponent rightPanelComponent = new RightPanelComponent();
			rightPanelComponent.setBounds(468,104,96,100);
			rightPanelComponent.setLayout(new GridLayout(3, 1));
			MainController  controller = new MainController();
			CenterPanelComponent centerPanelComponent = new CenterPanelComponent(controller.getDataVector(), controller.getColumnIdentifiers());
			(new BankFrm(headerButtonComponent,centerPanelComponent,rightPanelComponent)).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}
}


