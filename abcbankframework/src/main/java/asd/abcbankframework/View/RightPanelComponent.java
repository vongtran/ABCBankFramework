package asd.abcbankframework.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RightPanelComponent extends JPanel {
   protected javax.swing.JButton JButton_Deposit = new javax.swing.JButton();

   protected javax.swing.JButton JButton_Exit = new javax.swing.JButton();

    public RightPanelComponent(){
        JButton_Deposit.setText("Deposit");
      
        JButton_Exit.setText("Exit");
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(JButton_Deposit);
      
        add(JButton_Exit);
    }

    public void setJButton_DepositTittle(String tittle) {
        this.JButton_Deposit.setText(tittle);
    }


  

    public void setJButton_ExitTittle(String tittle) {
        this.JButton_Exit.setText(tittle);
    }

    public void setJButton_DepositAction(ActionListener action) {
        this.JButton_Deposit.addActionListener(action);
        
      
    }



    public void setJButton_ExitAction(ActionListener action) {
        this.JButton_Exit.addActionListener(action);
       
    }

    public void addNewButton(JButton button){
        add(button);
    }
}
