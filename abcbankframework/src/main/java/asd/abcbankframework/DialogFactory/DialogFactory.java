package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.View.MainView;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class DialogFactory extends JDialog {
    public DialogFactory(MainView mainView){
        super(mainView);
    }
    protected abstract JPanel createHeader();
    protected abstract JPanel createBody();
}
