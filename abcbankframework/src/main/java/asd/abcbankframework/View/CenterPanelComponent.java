package asd.abcbankframework.View;

import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankDataModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class CenterPanelComponent extends JPanel {
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object[] rowData;
    MainView view;

    public CenterPanelComponent(DefaultTableModel model){
        JScrollPane1 = new JScrollPane();
        this.model =model; // new BankDataModel(data, column);
        JTable1 = new JTable(model);
        add(JScrollPane1);
        JScrollPane1.getViewport().add(JTable1);
      
    }
    
    public void setView(MainView view ) {
    	this.view = view;
    }

    public void setTableModel(DefaultTableModel model) {
        this.model = model;
    }

    public int getSelection(){
    
        return JTable1.getSelectionModel().getMinSelectionIndex();
    }

    public String getAccnr(){
    	 if(this.getSelection()==-1)
    	  return "NaN";
         else
         return (String)this.view.getModel().getValueAt(this.getSelection(), 0);
    }

    public void setRowData(Object[] rowData) {
        this.rowData = rowData;
    }

    public JScrollPane getJScrollPane() {
    	return JScrollPane1;
    }
    
    public void refreshTable(JTable JTable1) {
    	 this.JTable1=JTable1;
    	 JScrollPane1.getViewport().removeAll();
    	 JScrollPane1.getViewport().add(JTable1);
    }

}
