package asd.abcbankframework.observer;

import java.util.ArrayList;
import java.util.List;

import asd.abcbankframework.model.customer.ICustomer;

public abstract class Subject {

	List<IObserver> observer=new ArrayList<IObserver>();
	public void Attach(IObserver ob) {
		observer.add(ob);
	}
	
	public void notifies(String message) {
		for (IObserver iObserver : observer) {
			iObserver.update(message);
		}
	}
}



