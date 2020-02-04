package asd.abcbankframework.View;

import javax.swing.*;

public class JDialog_Action extends JDialog {
    private MainView parentFrame;
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();

    public JDialog_Action(MainView parentFrame){
        super(parentFrame);
        this.parentFrame = parentFrame;

        setTitle("Deposit");
        setModal(true);
        getContentPane().setLayout(null);
        setSize(268,126);
        setVisible(false);
        JLabel1.setText("Acc Nr");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,12,48,24);
        JLabel2.setText("Amount");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,48,48,24);
        JTextField_NAME.setEditable(false);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84,12,144,24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(36,84,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156,84,84,24);
        getContentPane().add(JTextField_Deposit);
        JTextField_Deposit.setBounds(84,48,144,24);
    }
}
