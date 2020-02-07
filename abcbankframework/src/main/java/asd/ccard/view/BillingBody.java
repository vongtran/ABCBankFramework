package asd.ccard.view;

import asd.abcbankframework.DialogFactory.Body.IDialogBody;
import asd.ccard.controller.CCController;

import java.awt.event.ActionListener;


public class BillingBody extends IDialogBody {
    javax.swing.JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
    javax.swing.JTextArea JTextField1 = new javax.swing.JTextArea();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    CCController ccController;
    public BillingBody(){
    	ccController=new CCController();
        setLayout(null);
        add(JScrollPane1);
        JScrollPane1.setBounds(24,24,358,240);
        JScrollPane1.getViewport().add(JTextField1);
        JTextField1.setBounds(0,0,355,237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        add(JButton_OK);
        JButton_OK.setBounds(156,276,96,24);
        JTextField1.setText(ccController.generateMonthlyBilling().toString());
        
    }

    public void setBodyOKAction(ActionListener action){this.JButton_OK.addActionListener(action);}

}
