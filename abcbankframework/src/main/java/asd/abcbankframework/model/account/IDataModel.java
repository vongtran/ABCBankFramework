package asd.abcbankframework.model.account;

import java.util.List;
import java.util.Vector;
import java.util.function.Function;

import asd.abcbankframework.model.customer.ICustomer;

public interface IDataModel {
	public Vector<String> getColumnIdentifiers();
	public void setColumnIdentifiers(Vector<String> columnIdentifiers);
	public Vector<Vector<String>> getDataVector(List<ICustomer> customers, Function<List<ICustomer>, Vector<Vector<String>>> f);
	public void setDataVector(Vector<Vector<String>> dataVector);
	public Function<List<ICustomer>, Vector<Vector<String>>> defaultAccountFuntion();
}
