package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.View.MainView;

public class SimpleFactory {
    public static DialogFactory createDialog(MainView mainView,String s){
        if(s.equals("form")){
            return new FormDialog(mainView);
        }
        return new ActionDialog(mainView);
    }
}
