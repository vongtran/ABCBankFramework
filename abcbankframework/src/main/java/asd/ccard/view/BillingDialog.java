package asd.ccard.view;

import asd.abcbankframework.DialogFactory.DialogFactory;
import asd.abcbankframework.View.MainView;
import asd.bank.view.DialogBody;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BillingDialog extends DialogFactory {
    MainView mainView;
    BillingBody body ;
    public BillingDialog(MainView mainView) {
        super(mainView);
        this.mainView = mainView;
        setTitle("Monthly Billing");
        setSize(405,367);
        setVisible(true);
        body = createBody();
        getContentPane().add(body, BorderLayout.CENTER);
    }

    @Override
    protected JPanel createHeader() {
        return null;
    }

    @Override
    protected BillingBody createBody() {
        return new BillingBody();
    }

    public void setBodyOKAction(ActionListener action){
        body.setBodyOKAction(action);
    }
}
