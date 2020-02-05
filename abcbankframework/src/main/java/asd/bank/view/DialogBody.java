package asd.bank.view;

import asd.abcbankframework.DialogFactory.Body.IDialogBody;

import java.awt.event.ActionListener;

public class DialogBody extends IDialogBody {
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();

    javax.swing.JTextField JTextField_Interest = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Cancel = new javax.swing.JButton();

    public DialogBody(){
        setLayout(null);
        JLabel1.setText("Interest");
        JLabel1.setBounds(12,12,48,24);
        JTextField_Interest.setBounds(84,12,144,24);
        JButton_OK.setBounds(36,84,84,24);
        JButton_Cancel.setBounds(156,84,84,24);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");

        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        add(JLabel1);
        add(JTextField_Interest);
        add(JButton_Cancel);
        add(JButton_OK);
    }

    public void setJButton_OKAction(ActionListener action) {
        this.JButton_OK.addActionListener(action);
    }

    public String getJTextField_Interest() {
        return JTextField_Interest.getText();
    }

    public void setJTextField_Interest(String JTextField_NAME) {
        this.JTextField_Interest.setText(JTextField_NAME);
    }

    public void setJButton_Cancel(ActionListener action) {
        this.JButton_Cancel.addActionListener(action);
    }

}
