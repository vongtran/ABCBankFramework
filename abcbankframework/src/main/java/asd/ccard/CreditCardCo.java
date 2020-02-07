package asd.ccard;

import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankController;
import asd.bank.view.BankFrm;
import asd.ccard.controller.CCController;
import asd.ccard.model.account.CCViewAccountModel;
import asd.ccard.model.account.CardDataModel;
import asd.ccard.view.CardFrm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.TextField;

/**
 * Hello world!
 *
 */
public class CreditCardCo {
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
			CenterPanelComponent centerPanelComponent = new CenterPanelComponent( new CardDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));

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
