package asd.abcbankframework.DialogFactory.Body;

import asd.abcbankframework.DialogFactory.FormDialog;

public class PersonalForm extends FormBody {
    public PersonalForm(FormDialog formDialog, String clientType) {
        super(formDialog, clientType);
        JLabel6.setText("Birthdate");
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12,260,96,24);
        JTextField_other.setBounds(120,260,156,20);
        JLabel8.setText("Acc Nr");

        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12,50,48,24);

        JTextField_Number.setBounds(120,50,156,20);
        add(JTextField_other);
        add(JLabel8);
        add(JTextField_Number);
        add(JLabel6);
    }
}
