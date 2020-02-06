package asd.ccard.model.account;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class CardDataModel extends DefaultTableModel {
	public CardDataModel() {
		super();
	}

	public CardDataModel(Vector<? extends Vector> data, Vector<?> columnNames) {
		super(data, columnNames);
	}
	
}
