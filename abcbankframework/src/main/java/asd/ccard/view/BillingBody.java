package asd.ccard.view;

import asd.abcbankframework.DialogFactory.Body.IDialogBody;

import java.awt.event.ActionListener;

public class BillingBody extends IDialogBody {
    String billstring;
    javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
    javax.swing.JTextField JTextField1 = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    public BillingBody(){
        setLayout(null);
        add(JScrollPane1);
        JScrollPane1.setBounds(24,24,358,240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0,0,355,237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        add(JButton_OK);
        JButton_OK.setBounds(156,276,96,24);

        // generate the string for the monthly bill
        billstring = "Name= John White\r\n";
        billstring += "Address= 1000 Main, Fairfield, IA, 52556\r\n";
        billstring += "CC number= 2341 3421 4444 5689\r\n";
        billstring += "CC type= GOLD\r\n";
        billstring += "Previous balance = $ 100.00\r\n";
        billstring += "Total Credits = $ 25.00\r\n";
        billstring += "Total Charges = $ 560.00\r\n";
        billstring += "New balance = $ 638.75\r\n";
        billstring += "Total amount due = $ 63.88\r\n";
        billstring += "\r\n";
        billstring += "\r\n";
        billstring += "Name= Frank Summer\r\n";
        billstring += "Address= 1000 N, 4th St, Fairfield, IA, 52556\r\n";
        billstring += "CC number= 0099 3421 4321 6577\r\n";
        billstring += "CC type= BRONZE\r\n";
        billstring += "Previous balance = $ 200.00\r\n";
        billstring += "Total Credits = $ 45.00\r\n";
        billstring += "Total Charges = $ 150.00\r\n";
        billstring += "New balance = $ 313.53\r\n";
        billstring += "Total amount due = $ 34.49\r\n";
        JTextField1.setText(billstring);
    }

    public void setBodyOKAction(ActionListener action){this.JButton_OK.addActionListener(action);}

}
