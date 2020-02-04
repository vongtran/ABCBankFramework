package asd.abcbankframework.DialogFactory.Body;

import javax.swing.*;
import java.awt.*;

public class ActionBody extends IDialogBody {
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();

    public ActionBody(){
        setLayout(null);
        JLabel1.setText("Acc Nr");
        JLabel2.setText("Amount");
        JTextField_NAME.setEditable(false);
        JLabel1.setBounds(12,12,48,24);
        JLabel2.setBounds(12,48,48,24);
        JTextField_NAME.setBounds(84,12,144,24);
        JTextField_Deposit.setBounds(84,48,144,24);
        JButton_OK.setBounds(36,84,84,24);
        JButton_Cancel.setBounds(156,84,84,24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");

        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        add(JTextField_NAME);
        add(JLabel1);
        add(JLabel2);
        add(JTextField_Deposit);
        add(JButton_Cancel);
        add(JButton_OK);
    }
}
