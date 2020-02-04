package asd.abcbankframework;

import asd.abcbankframework.View.CenterPanelComponent;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.RightPanelComponent;
import asd.abcbankframework.View.TopPanelComponent;
import asd.bank.view.BankFrm;

import javax.swing.*;
import java.awt.TextField;

/**
 * Hello world!
 *
 */
public class App {
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
                CenterPanelComponent centerPanelComponent = new CenterPanelComponent();
                (new MainView(centerPanelComponent, rightPanelComponent, topPanelComponent)).setVisible(true);
            } catch (Throwable t) {
                t.printStackTrace();
                //Ensure the application exits with an error condition.
                System.exit(1);
            }

        }
    }
}
