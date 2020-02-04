package asd.abcbankframework.View;

import asd.abcbankframework.DialogFactory.ActionDialog;
import asd.abcbankframework.DialogFactory.DialogFactory;
import asd.abcbankframework.DialogFactory.SimpleFactory;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankDataModel;
import asd.bank.view.BankFrm;
import asd.bank.view.JDialog_AddPAcc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private CenterPanelComponent centerPanelComponent;
    private  RightPanelComponent rightPanelComponent;
    public   TopPanelComponent topPanelComponent;
    private JScrollPane JScrollPane1;
    private JTable JTable1;
    private DefaultTableModel model;


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
        Deposit deposit = new Deposit();
        Withdraw withdraw = new Withdraw();
        this.topPanelComponent.setJButton_CompACAction(lSymAction);
        this.topPanelComponent.setJButton_PerACAction(lSymAction);
        add(this.topPanelComponent,BorderLayout.NORTH);
        this.topPanelComponent.setBounds(24,20,350,33);
        this.topPanelComponent.setLayout(new GridLayout(1, 2));

        add(this.rightPanelComponent,BorderLayout.EAST);
        this.rightPanelComponent.setBounds(468,104,96,100);
        this.rightPanelComponent.setLayout(new GridLayout(3, 1));
        this.rightPanelComponent.setJButton_DepositAction(deposit);
        this.rightPanelComponent.setJButton_WithdrawAction(withdraw);
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

        DialogFactory actionDialog = SimpleFactory.createDialog(this,"form");
        actionDialog.show();
    }

    class Deposit implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            deposit(event);

        }
    }

    void deposit(java.awt.event.ActionEvent event)
    {
        DialogFactory actionDialog = SimpleFactory.createDialog(this,"action");
        actionDialog.show();
    }

    class Withdraw implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            deposit(event);

        }
    }

    void Withdraw(java.awt.event.ActionEvent event)
    {
        DialogFactory actionDialog = SimpleFactory.createDialog(this,"action");
        actionDialog.show();
    }

}
