package asd.abcbankframework.View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopPanelComponent extends JPanel {
    protected javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
    protected javax.swing.JButton JButton_CompAC = new javax.swing.JButton();

    public TopPanelComponent(){
        JButton_PerAC.setText("Add Account");
        JButton_CompAC.setText("Add Company Account");
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
