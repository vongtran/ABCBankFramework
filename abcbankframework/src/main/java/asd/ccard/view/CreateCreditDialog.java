package asd.ccard.view;

import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.View.MainView;

public class CreateCreditDialog extends FormDialog {
    String accountType;
    MainView mainView;
    CreditCardHeader header;
    public CreditCardBody body;
    String CCnumber,expDate;
    public CreateCreditDialog(MainView mainView,String s) {
        super(mainView,s);
        this.mainView = mainView;
        setTitle("Add Credit Card");
        setSize(298,339);
        setVisible(true);
        header = createHeader();
        body = createBody();
        getContentPane().add(header);
        header.setBounds(0,10,298,30);
        getContentPane().add(body);
    }

    @Override
    public CreditCardHeader createHeader() {
        return new CreditCardHeader(this);
    }

    @Override
    public CreditCardBody createBody() {
        return new CreditCardBody(this);
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getAccountType(){
        return this.accountType;
    }



}
