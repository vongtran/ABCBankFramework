package asd.abcbankframework.View;

import asd.abcbankframework.DialogFactory.ActionDialog;
import asd.abcbankframework.DialogFactory.DialogFactory;
import asd.abcbankframework.DialogFactory.FormDialog;
import asd.abcbankframework.DialogFactory.SimpleFactory;
import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankDataModel;
import asd.bank.view.BankFrm;

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
    
    private ActionDialog actionDialog;

    MainController controller;

    public MainView(CenterPanelComponent centerComponent, RightPanelComponent rightComponent, TopPanelComponent topComponent){
        this.topPanelComponent = topComponent;
        this.rightPanelComponent = rightComponent;
        this.centerPanelComponent = centerComponent;
        setTitle("Framework");
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(575,310);
        setVisible(false);
        PersonalAccount personalAccount = new PersonalAccount();
        CompanyAccount companyAccount = new CompanyAccount();
        Deposit deposit = new Deposit();
        Withdraw withdraw = new Withdraw();

        this.topPanelComponent.setJButton_CompACAction(companyAccount);
        this.topPanelComponent.setJButton_PerACAction(personalAccount);
        add(this.topPanelComponent,BorderLayout.NORTH);
        this.topPanelComponent.setBounds(24,20,350,33);
        this.topPanelComponent.setLayout(new GridLayout(1, 2));

        add(this.rightPanelComponent,BorderLayout.EAST);
        this.rightPanelComponent.setBounds(468,104,96,100);
        this.rightPanelComponent.setLayout(new GridLayout(3, 1));
        this.rightPanelComponent.setJButton_DepositAction(deposit);
        this.rightPanelComponent.setJButton_WithdrawAction(withdraw);
        this.rightPanelComponent.setJButton_ExitAction(new Exit());
        add(this.centerPanelComponent,BorderLayout.WEST);
        
        
        controller=new MainController();
        SymWindow aSymWindow = new SymWindow();
        addWindowListener(aSymWindow);

    }

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == MainView.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(java.awt.event.WindowEvent event)
    {
        // to do: code goes here.

        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }


    class PersonalAccount implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            JButtonPerAC_actionPerformed(event);

        }
    }

    class CompanyAccount implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            JButtonComAC_actionPerformed(event);

        }
    }

    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
    {

        FormDialog formDialog  = new FormDialog(this,"P");
        formDialog.setCancelAction(new CancelCreateAccountPer(formDialog));
        formDialog.setOKAction(new OKCreateAccountPer(formDialog));
        formDialog.show();
    }

    void JButtonComAC_actionPerformed(java.awt.event.ActionEvent event)
    {

        FormDialog formDialog  = new FormDialog(this,"C");
        formDialog.setCancelAction(new CancelCreateAccountPer(formDialog));
        formDialog.setOKAction(new OKCreateAccountPer(formDialog));
        formDialog.show();
    }

    class OKCreateAccountPer implements java.awt.event.ActionListener
    {
        FormDialog formDialog;
        String accountType;
        public OKCreateAccountPer(FormDialog formDialog){
          this.formDialog = formDialog;
        }
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            formDialog.actionOk();
          
            
            controller.addAccount(formDialog.getClientName(), formDialog.getStreet(), formDialog.getCity()
            		, formDialog.getState(), formDialog.getZip(), formDialog.getName(), formDialog.getAccountType()
            		, formDialog.getClientType(), "20"
            		, formDialog.getAccountnr());
            
            centerPanelComponent.setTableModel(new BankDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
        
            refreshTable();
            formDialog.dispose();
        
        }
    } 
    class Exit implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            dispose();

        }
    }
    
    
    class CancelCreateAccountPer implements java.awt.event.ActionListener
    {
        FormDialog formDialog;
        public CancelCreateAccountPer(FormDialog formDialog){
            this.formDialog = formDialog;
        }
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            formDialog.dispose();
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
        actionDialog = new ActionDialog(this);
        actionDialog.setBodyCancelAction(new Cancel());
        String selection = this.centerPanelComponent.getAccnr();
        if(selection=="NaN")
        {
          System.out.println("Please select one account");
          return;
        }
        
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
        actionDialog = new ActionDialog(this);
        String selection = this.centerPanelComponent.getAccnr();
        if(selection=="NaN")
        {
          System.out.println("Please select one account");
          return;
        }
        actionDialog.setText(selection);
        actionDialog.setBodyOKAction(new OKWithdraw(actionDialog,selection));
        actionDialog.setBodyCancelAction(new Cancel());
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
            actionDialog.dispose();
            centerPanelComponent.setTableModel(new BankDataModel(controller.getDataVector(), controller.getColumnIdentifiers()));
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

             controller.withdraw(this.Id,Double.parseDouble(this.value.getAmount()));

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
            actionDialog.dispose();
            refreshTable();
          
        }
    }

    class Cancel implements java.awt.event.ActionListener
    {

        public void actionPerformed(java.awt.event.ActionEvent event)
        {
        
            actionDialog.dispose();

        }
    }
    
    public void refreshTable() {
    	 //refresh table
        Vector<Vector<String>> data = controller.getDataVector();                       
        model = new BankDataModel(data, controller.getColumnIdentifiers());
        JTable1 = new JTable(model);
        centerPanelComponent.refreshTable(JTable1);
    }


}
