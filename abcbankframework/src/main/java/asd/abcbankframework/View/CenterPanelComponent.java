package asd.abcbankframework.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CenterPanelComponent extends JPanel {
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    private Object[] rowData;

    public CenterPanelComponent(){
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        model.addColumn("AccountNr");
        model.addColumn("Name");
        model.addColumn("City");
        model.addColumn("P/C");
        model.addColumn("Ch/S");
        model.addColumn("Amount");
        rowData = new Object[8];
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
