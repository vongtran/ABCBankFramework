package asd.ccard.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import asd.abcbankframework.View.TopPanelComponent;
import asd.bank.view.OwnHeaderComponent;

public class CardTopPannel extends TopPanelComponent {

	  
	    javax.swing.JButton JButton_bill = new javax.swing.JButton();

	    public CardTopPannel(){
	        JButton_PerAC.setText("Add credit-card");
	        JButton_bill.setText("Generate monthly bills");
	        setLayout(new FlowLayout(FlowLayout.LEFT));
	       // add(JButton_CompAC);
	        removeAll(); // remove component all in pannel
	              
	        add(JButton_PerAC);
	        add(JButton_bill);
	    }



	    public void setJButton_PerACTittle(String tittle) {
	        this.JButton_PerAC.setText(tittle);
	    }


	    public void setJButton_CompACTittle(String tittle) {
	        this.JButton_CompAC.setText(tittle);
	    }

	    public void setJButton_PerACAction(ActionListener action) {
	        this.JButton_PerAC.addActionListener(action);
	    }


	    public void setJButton_CompACAction(ActionListener action) {
	        this.JButton_CompAC.addActionListener(action);
	    }

	    public void addNewButton(JButton button){
	        add(button);
	    }

}
