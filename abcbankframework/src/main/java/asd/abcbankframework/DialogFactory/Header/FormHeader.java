package asd.abcbankframework.DialogFactory.Header;

public class FormHeader extends IDialogHeader {
    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
    public FormHeader(){
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36,12,84,24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36,36,84,24);
    }
    @Override
    void display() {

    }
}
