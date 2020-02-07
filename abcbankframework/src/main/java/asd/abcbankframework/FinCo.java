package asd.abcbankframework;

import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankController;
import asd.bank.view.BankDataModel;
import asd.bank.view.BankFrm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.TextField;

/**
 * Hello world!
 *
 */
public class FinCo {
    public static void main(String[] args) {
        {
            try {
                // Add the following code if you want the Look and Feel
                // to be set to the Look and Feel of the native system.

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                }

                //Create a new instance of our application's frame, and make it visible.
                TopPanelComponent topPanelComponent = new TopPanelComponent();
                RightPanelComponent rightPanelComponent = new RightPanelComponent();
                MainController  controller = new MainController();
                
              //  controller.getDataVector(), controller.getColumnIdentifiers(),
                
                CenterPanelComponent centerPanelComponent = new CenterPanelComponent( new DefaultTableModel(controller.getDataVector(),controller.getColumnIdentifiers()));
                centerPanelComponent.setTableModel(new BankDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
               MainView view= (new MainView(centerPanelComponent, rightPanelComponent, topPanelComponent,new BankController()));
               view.setVisible(true);
               view.setModel( new DefaultTableModel(controller.getDataVector(),controller.getColumnIdentifiers()));
               centerPanelComponent.setView(view);
               
               
               
            } catch (Throwable t) {
                t.printStackTrace();
                //Ensure the application exits with an error condition.
                System.exit(1);
            }

        }
    }

}
