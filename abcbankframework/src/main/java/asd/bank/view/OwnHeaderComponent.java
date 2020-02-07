package asd.bank.view;

import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.View.TopPanelComponent;

import java.awt.event.ActionListener;

public class OwnHeaderComponent extends TopPanelComponent {
    javax.swing.JButton JButton_PerAC1 = new javax.swing.JButton();
    public OwnHeaderComponent() {
        super();
       // super.addNewButton(JButton_PerAC1);
        JButton_PerAC1.setText("Add interest");
        //super.setJButton_CompACTittle("asasas");
        removeAll(); // remove component all in pannel
        add(JButton_CompAC);
        add(JButton_PerAC);
        add(JButton_PerAC1);
    }

    public void setJButton_AddInterest(ActionListener action) {
        this.JButton_PerAC1.addActionListener(action);

    }


}
