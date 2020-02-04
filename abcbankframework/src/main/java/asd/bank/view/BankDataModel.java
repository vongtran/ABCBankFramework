package asd.bank.view;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class BankDataModel extends DefaultTableModel {

	public BankDataModel() {
		super();
	}

	public BankDataModel(Vector<? extends Vector> data, Vector<?> columnNames) {
		super(data, columnNames);
	}
	
}
