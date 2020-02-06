package asd.bank;

import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankController;
import asd.bank.view.BankDataModel;
import asd.bank.view.BankFrm;
import asd.bank.view.OwnHeaderComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.TextField;

/**
 * Hello world!
 *
 */
public class BankCo {
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

			RightPanelComponent rightPanelComponent = new RightPanelComponent(); //new RightPanelComponent();
			rightPanelComponent.setBounds(468,104,96,100);
			rightPanelComponent.setLayout(new GridLayout(3, 1));
			MainController  controller = new MainController();
			CenterPanelComponent centerPanelComponent = new CenterPanelComponent( new BankDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
			(new BankFrm(headerButtonComponent,centerPanelComponent,rightPanelComponent, new BankController())).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}

}
