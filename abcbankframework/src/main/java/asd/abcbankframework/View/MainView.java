package asd.abcbankframework.View;

import asd.abcbankframework.DialogFactory.ActionDialog;
import asd.abcbankframework.DialogFactory.DialogFactory;
import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.DialogFactory.SimpleFactory;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankDataModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainView extends JFrame {

    protected CenterPanelComponent centerPanelComponent;
    private  RightPanelComponent rightPanelComponent;
    public   TopPanelComponent topPanelComponent;
    private JScrollPane JScrollPane1;
    private JTable JTable1;
    private DefaultTableModel model;

    MainController controller;

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
        
        
        controller=new MainController();

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

        FormDialog formDialog  = new FormDialog(this);
        formDialog.setCancelAction(new CancelCreateAccountPer());
        formDialog.setOKAction(new OKCreateAccountPer(formDialog));
        formDialog.show();
    }

    class OKCreateAccountPer implements java.awt.event.ActionListener
    {
        FormDialog formDialog;
        public OKCreateAccountPer(FormDialog formDialog){
          this.formDialog = formDialog;
        }
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            formDialog.actionOk();
            System.out.println(formDialog.getAccountType());
            System.out.println(formDialog.getClientName());
        }
    }

    class CancelCreateAccountPer implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            deposit(event);

        }
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
        ActionDialog actionDialog = new ActionDialog(this);
        actionDialog.setBodyCancelAction(new Cancel());
        String selection = this.centerPanelComponent.getAccnr();
        actionDialog.setText(selection);
        actionDialog.setBodyOKAction(new OKDeposit(actionDialog,selection));

        actionDialog.show();
    }

    class Withdraw implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            withdraw(event);

        }
    }

    void withdraw(java.awt.event.ActionEvent event)
    {
        ActionDialog actionDialog = new ActionDialog(this);
        String selection = this.centerPanelComponent.getAccnr();
        actionDialog.setText(selection);
        actionDialog.setBodyOKAction(new OKWithdraw(actionDialog,selection));
        actionDialog.show();
    }

    class OKWithdraw implements java.awt.event.ActionListener
    {
    	 ActionDialog value;
         String Id;
         public OKWithdraw(ActionDialog value,String id){
             this.value = value;
             this.Id = id;
         }
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
      
            controller.withdraw(this.Id, Double.parseDouble(this.value.getAmount()));
          // centerPanelComponent.setTableModel(new BankDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
            refreshTable();
        }
    }
    
    class OK implements java.awt.event.ActionListener
    {
        ActionDialog value;
        String Id;
        public OK(ActionDialog value,String id){
            this.value = value;
            this.Id = id;
        }
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
<<<<<<< HEAD
          
            controller.withdraw(this.Id, Double.parseDouble(this.value.getAmount()));
           
=======
            System.out.println(this.value.getAmount());

            controller.withdraw(this.Id,Double.parseDouble(this.value.getAmount()));

>>>>>>> 06af3e212cfe0e8bdac5cc206bb1aefd7f15b550
        }
    }
    
    
    class OKDeposit implements java.awt.event.ActionListener
    {
    	ActionDialog value;
        String Id;
        public OKDeposit(ActionDialog value,String id){
            this.value = value;
            this.Id = id;
        }
        
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
      
            controller.deposit(this.Id, Double.parseDouble(this.value.getAmount()));
       
            refreshTable();
          
        }
    }

    class Cancel implements java.awt.event.ActionListener
    {

        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            System.out.println("Cancel");
            

        }
    }
    
    private void refreshTable() {
    	 //refresh table
        Vector<Vector<String>> data = controller.getDataVector();                       
        model = new BankDataModel(data, controller.getColumnIdentifiers());
        JTable1 = new JTable(model);
        centerPanelComponent.refreshTable(JTable1);
    }


}
