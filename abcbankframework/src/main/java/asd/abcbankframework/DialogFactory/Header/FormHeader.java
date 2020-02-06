package asd.abcbankframework.DialogFactory.Header;

import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.model.account.Account;

import javax.swing.*;

public class FormHeader extends IDialogHeader {
    FormDialog formDialog;
    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
    public FormHeader(FormDialog formDialog){
        this.formDialog = formDialog;
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");

        JRadioButton_Chk.setBounds(36,12,84,24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(JRadioButton_Chk);
        bgroup.add(JRadioButton_Sav);
        JRadioButton_Chk.setSelected(true);
        add(JRadioButton_Chk);
        add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36,36,84,24);
    }
    @Override
    public void display() {

    }

    public void  setAccountType(){
        if (JRadioButton_Chk.isSelected())
            formDialog.setAccountType("Ch");
        else
            formDialog.setAccountType("S");

    }
}
