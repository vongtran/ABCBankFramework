package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.View.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionDialog  extends DialogFactory {
    MainView mainView;
    ActionHeader header ;
    ActionBody body ;
    public ActionDialog(MainView parentFrame){
        super(parentFrame);
        this.mainView = parentFrame;
        setTitle("Deposit");
        setSize(268,150);
        setVisible(true);
        header = createHeader();
        body = new ActionBody();
        getContentPane().add(header,BorderLayout.PAGE_START);
        getContentPane().add(body,BorderLayout.CENTER);
    }

    @Override
    public ActionHeader createHeader() {
        return new ActionHeader();
    }

    @Override
    public ActionBody createBody() {
        return new ActionBody();
    }

    public void setBodyOKAction(ActionListener action){
        body.setJButton_OKAction(action);
    }

    public void setBodyCancelAction(ActionListener action){
        body.setJButton_Cancel(action);
    }

    public String getAmount(){
        return body.getJTextField_Deposit();
    }

    public void setText(String s){
        body.setJTextField_NAME(s);
    }
    public void setDialogTitle(String s){setTitle(s);}


}
