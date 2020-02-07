package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.CompanyForm;
import asd.abcbankframework.DialogFactory.Body.FormBody;
import asd.abcbankframework.DialogFactory.Body.PersonalForm;
import asd.abcbankframework.View.MainView;

import java.awt.event.ActionListener;

public class SimpleFactory {
    public static FormBody createDialog(FormDialog formDialog, String s){
        if(s.equals("P")){
            return new PersonalForm(formDialog,s);
        }
        return new CompanyForm(formDialog,s);
    }
}
