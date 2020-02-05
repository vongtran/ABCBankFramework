package asd.abcbankframework.DialogFactory.Body;

import asd.abcbankframework.DialogFactory.FormDialog;

import java.awt.event.ActionListener;

public class FormBody extends IDialogBody {
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
    javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
    FormDialog formDialog;

    public FormBody(FormDialog formDialog){
        this.formDialog = formDialog;
        setLayout(null);
        JLabel1.setText("Name");

        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,96,48,24);
        JLabel2.setText("Street");
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,120,48,24);
        JLabel3.setText("City");

        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12,144,48,24);
        JLabel4.setText("State");

        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12,168,48,24);
        JLabel5.setText("Zip");

        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12,192,48,24);
        JLabel6.setText("No of employees");

        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,216,96,24);
        JLabel7.setText("Email");

        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12,240,48,24);

        JTextField_NAME.setBounds(120,96,156,20);

        JTextField_CT.setBounds(120,144,156,20);

        JTextField_ST.setBounds(120,168,156,20);

        JTextField_STR.setBounds(120,120,156,20);

        JTextField_ZIP.setBounds(120,192,156,20);

        JTextField_NoOfEmp.setBounds(120,216,156,20);

        JTextField_EM.setBounds(120,240,156,20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");

        JButton_OK.setBounds(48,276,84,24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");

        JButton_Cancel.setBounds(156,276,84,24);
        JLabel8.setText("Acc Nr");

        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12,72,48,24);

        JTextField_ACNR.setBounds(120,72,156,20);
        add(JLabel1);
        add(JLabel2);
        add(JLabel3);
        add(JLabel4);
        add(JLabel5);
        add(JLabel6);
        add(JLabel7);
        add(JTextField_NAME);
        add(JTextField_CT);
        add(JTextField_ST);
        add(JTextField_STR);
        add(JTextField_ZIP);
        add(JTextField_NoOfEmp);
        add(JTextField_EM);
        add(JButton_OK);
        add(JButton_Cancel);
        add(JLabel8);
        add(JTextField_ACNR);
    }

    public void setJButton_OKAction(ActionListener action) {
        this.JButton_OK.addActionListener(action);
    }
    public void setJButton_Cancel(ActionListener action) {
        this.JButton_Cancel.addActionListener(action);
    }

    public void setText(){
        this.formDialog.setName(JTextField_NAME.getText());
        this.formDialog.setCity(JTextField_CT.getText());
        this.formDialog.setState(JTextField_ST.getText());
        this.formDialog.setAccountnr(JTextField_ACNR.getText());
        this.formDialog.setZip(JTextField_ZIP.getText());
        this.formDialog.setStreet(JTextField_STR.getText());
    }
}
