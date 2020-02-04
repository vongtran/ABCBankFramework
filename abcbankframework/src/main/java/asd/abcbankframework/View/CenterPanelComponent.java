package asd.abcbankframework.View;

import asd.abcbankframework.controller.MainController;
import asd.bank.view.BankDataModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CenterPanelComponent extends JPanel {
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object[] rowData;
    MainController controller = new MainController();

    public CenterPanelComponent(){
        JScrollPane1 = new JScrollPane();
        model = new BankDataModel(controller.getDataVector(), controller.getColumnIdentifiers());
        JTable1 = new JTable(model);
        add(JScrollPane1);
        JScrollPane1.getViewport().add(JTable1);
    }

    public void setTableModel(DefaultTableModel model) {
        this.model = model;
    }

    public void setRowData(Object[] rowData) {
        this.rowData = rowData;
    }

}
