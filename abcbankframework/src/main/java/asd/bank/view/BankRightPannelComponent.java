package asd.bank.view;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import asd.abcbankframework.View.RightPanelComponent;

public class BankRightPannelComponent extends RightPanelComponent {

	 
	    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	   

	    public BankRightPannelComponent(){
	       
	    	super();
	        JButton_Withdraw.setText("Withdraw");
	      
	        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	       
	        removeAll(); // remove component all in pannel
	        add(JButton_Deposit);
	        add(JButton_Withdraw);
	        add(JButton_Exit);
	      
	    }
	   

	    public void setJButton_WithdrawTittle(String tittle) {
	        this.JButton_Withdraw.setText(tittle);
	    }

	 
	    public void setJButton_WithdrawAction(ActionListener action) {
	        this.JButton_Withdraw.addActionListener(action);
	    }
	    

	    public void addNewButton(JButton button){
	        add(button);
	    }
}
