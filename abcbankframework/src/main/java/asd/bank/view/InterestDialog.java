package asd.bank.view;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.DialogFactory;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.View.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InterestDialog extends DialogFactory {
    MainView mainView;
    DialogBody body ;
    public InterestDialog(MainView mainView) {
        super(mainView);
        this.mainView = mainView;
        setTitle("Interest");
        setSize(268,150);
        setVisible(true);
        body = createBody();
        getContentPane().add(body, BorderLayout.CENTER);
    }

    @Override
    protected JPanel createHeader() {
        return null;
    }

    @Override
    protected DialogBody createBody() {
        return new DialogBody();
    }

    public void setBodyOKAction(ActionListener action){
        body.setJButton_OKAction(action);
    }

    public String getInterest(){
        return body.getJTextField_Interest();
    }

    public void setBodyCancelAction(ActionListener action){
        body.setJButton_Cancel(action);
    }
}
