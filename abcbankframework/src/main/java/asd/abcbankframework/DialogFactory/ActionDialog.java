package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.View.MainView;

import javax.swing.*;
import java.awt.*;

public class ActionDialog  extends DialogFactory {
    MainView mainView;
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    public ActionDialog(MainView parentFrame){
        super(parentFrame);
        this.mainView = parentFrame;
        setTitle("Deposit");
        setSize(268,150);
        setVisible(true);
        JPanel header = createHeader();
        JPanel body = createBody();
        getContentPane().add(header,BorderLayout.PAGE_START);
        getContentPane().add(body,BorderLayout.CENTER);
    }

    @Override
    public JPanel createHeader() {
        return new ActionHeader();
    }

    @Override
    public JPanel createBody() {
        return new ActionBody();
    }


}
