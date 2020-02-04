package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.View.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionDialog  extends DialogFactory {
    MainView mainView;
    JPanel header ;
    JPanel body ;
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    public ActionDialog(MainView parentFrame,ActionListener OKAction,ActionListener CancelAction){
        super(parentFrame);
        this.mainView = parentFrame;
        setTitle("Deposit");
        setSize(268,150);
        setVisible(true);
        header = createHeader();
        body = createBody(OKAction, CancelAction);
        getContentPane().add(header,BorderLayout.PAGE_START);
        getContentPane().add(body,BorderLayout.CENTER);
    }

    @Override
    public JPanel createHeader() {
        return new ActionHeader();
    }

    @Override
    public JPanel createBody(ActionListener OKAction,ActionListener CancelAction) {
        return new ActionBody(OKAction, CancelAction);
    }



}
