package asd.ccard.view;

import asd.abcbankframework.DialogFactory.Body.FormBody;
import asd.abcbankframework.DialogFactory.Body.IDialogBody;
import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.DialogFactory.Header.IDialogHeader;

import java.awt.event.ActionListener;

public class CreditCardBody extends FormBody {

    FormDialog createCreditDialog;
    public CreditCardBody(FormDialog createCreditDialog) {

        super(createCreditDialog,"CC");
        this.createCreditDialog = createCreditDialog;
        JLabel6.setText("CC number");
        add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,50,96,24);
        JLabel8.setText("Exp. Date");
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12,260,72,24);
        add(JTextField_Number);
        JTextField_Number.setBounds(120,50,156,20);
        add(JTextField_other);
        JTextField_other.setBounds(120,260,156,20);
        add(JLabel8);
    }


}
