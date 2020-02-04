package asd.abcbankframework.View;

import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankFrm;
import asd.bank.view.JDialog_AddPAcc;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private CenterPanelComponent centerPanelComponent;
    private  RightPanelComponent rightPanelComponent;
    private  TopPanelComponent topPanelComponent;

    private JScrollPane JScrollPane1;


    public MainView(CenterPanelComponent centerComponent, RightPanelComponent rightComponent, TopPanelComponent topComponent){
        this.topPanelComponent = topComponent;
        this.rightPanelComponent = rightComponent;
        this.centerPanelComponent = centerComponent;
        setTitle("Bank Application.");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(575,310);
        setVisible(false);
        SymAction lSymAction = new SymAction();
        SymAction1 lSymAction1 = new SymAction1();
        this.topPanelComponent.setJButton_CompACAction(lSymAction);

        add(this.topPanelComponent,BorderLayout.NORTH);
        //this.topPanelComponent.setLocation(10,20);

        add(this.rightPanelComponent,BorderLayout.EAST);
        this.rightPanelComponent.setJButton_DepositAction(lSymAction1);
        //this.topPanelComponent.setLocation(400,20);

        add(this.centerPanelComponent,BorderLayout.WEST);

    }
    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            JButtonPerAC_actionPerformed(event);

        }
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
    {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

        JDialog_AddAccount pac = new JDialog_AddAccount(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();
    }

    class SymAction1 implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            JButtonPerAC_actionPerformed1(event);

        }
    }

    void JButtonPerAC_actionPerformed1(java.awt.event.ActionEvent event)
    {
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

        JDialog_Action pac = new JDialog_Action(this);
        pac.show();




    }

}
