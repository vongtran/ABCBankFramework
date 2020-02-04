package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.Body.FormBody;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.DialogFactory.Header.FormHeader;
import asd.abcbankframework.View.MainView;

import javax.swing.*;
import java.awt.*;

public class FormDialog extends DialogFactory {
    MainView mainView;
    public FormDialog(MainView mainView) {
        super(mainView);
        this.mainView = mainView;
        setTitle("Add compamy account");
        setSize(298,339);
        setVisible(true);
        JPanel header = createHeader();
        JPanel body = createBody();
        getContentPane().add(header);
        header.setBounds(0,10,298,30);
        getContentPane().add(body);
    }

    @Override
    public JPanel createHeader() {
        return new FormHeader();
    }

    @Override
    public JPanel createBody() {
        return new FormBody();
    }




}
