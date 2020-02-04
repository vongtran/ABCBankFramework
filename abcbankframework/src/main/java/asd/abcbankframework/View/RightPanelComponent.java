package asd.abcbankframework.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RightPanelComponent extends JPanel {
    javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
    javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    public RightPanelComponent(){
        JButton_Deposit.setText("Deposit");
        JButton_Withdraw.setText("Withdraw");
        JButton_Exit.setText("Exit");
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(JButton_Deposit);
        add(JButton_Withdraw);
        add(JButton_Exit);
    }

    public void setJButton_DepositTittle(String tittle) {
        this.JButton_Deposit.setText(tittle);
    }


    public void setJButton_WithdrawTittle(String tittle) {
        this.JButton_Withdraw.setText(tittle);
    }

    public void setJButton_ExitTittle(String tittle) {
        this.JButton_Exit.setText(tittle);
    }

    public void setJButton_DepositAction(ActionListener action) {
        this.JButton_Deposit.addActionListener(action);
    }


    public void setJButton_WithdrawAction(ActionListener action) {
        this.JButton_Withdraw.addActionListener(action);
    }

    public void setJButton_ExitAction(ActionListener action) {
        this.JButton_Exit.addActionListener(action);
    }

    public void addNewButton(JButton button){
        add(button);
    }
}
