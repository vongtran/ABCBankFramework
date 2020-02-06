package asd.ccard.view;

import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.DialogFactory.Header.FormHeader;
import asd.abcbankframework.DialogFactory.Header.IDialogHeader;

import javax.swing.*;

public class CreditCardHeader extends FormHeader {

    FormDialog createCreditDialog;
    javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Bronze= new javax.swing.JRadioButton();
    public CreditCardHeader(FormDialog createCreditDialog){
        super(createCreditDialog);
        removeAll();
        this.createCreditDialog = createCreditDialog;
        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Gold");

        JRadioButton_Gold.setBounds(36,12,84,24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Silver");
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Bronze");

        JRadioButton_Bronze.setBounds(36,60,84,24);
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(JRadioButton_Gold);
        bgroup.add(JRadioButton_Silver);
        bgroup.add(JRadioButton_Bronze);
        JRadioButton_Gold.setSelected(true);
        add(JRadioButton_Gold);
        add(JRadioButton_Silver);
        add(JRadioButton_Bronze);
        JRadioButton_Silver.setBounds(36,36,84,24);
    }

    public void setAccountType(){
        if (JRadioButton_Gold.isSelected())
            createCreditDialog.setAccountType("Gold");
        else{
            if (JRadioButton_Silver.isSelected())
                createCreditDialog.setAccountType("Silver");
            else
                createCreditDialog.setAccountType("Bronze");
        }
    }
    @Override
    public void display() {

    }
}
