package asd.abcbankframework.View;

import asd.bank.view.JDialog_AddPAcc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopPanelComponent extends JPanel {
    javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    javax.swing.JButton JButton_CompAC = new javax.swing.JButton();

    public TopPanelComponent(){
        JButton_PerAC.setText("Default");
        JButton_CompAC.setText("Default");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(JButton_CompAC);
        add(JButton_PerAC);
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