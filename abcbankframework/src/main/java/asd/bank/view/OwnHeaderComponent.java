package asd.bank.view;

import asd.abcbankframework.View.TopPanelComponent;

public class OwnHeaderComponent extends TopPanelComponent {
    javax.swing.JButton JButton_PerAC1 = new javax.swing.JButton();
    public OwnHeaderComponent() {
        super();
        super.addNewButton(JButton_PerAC1);
        JButton_PerAC1.setText("Add interest");
        //super.setJButton_CompACTittle("asasas");
    }
}
