package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.View.MainView;

import java.awt.event.ActionListener;

public class SimpleFactory {
    public static DialogFactory createDialog(MainView mainView, String s, ActionListener OKAction, ActionListener CancelAction){
        if(s.equals("form")){
            return new FormDialog(mainView,OKAction,CancelAction);
        }
        return new ActionDialog(mainView,OKAction,CancelAction);
    }
}
