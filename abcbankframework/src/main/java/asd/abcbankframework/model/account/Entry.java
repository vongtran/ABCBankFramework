package asd.abcbankframework.model.account;

public class Entry implements IEntry {
	private double ammount;
	private String date;
	private String name;
	
	public Entry() {
		super();
	}
	
	public Entry(double ammount, String date, String name) {
		super();
		this.ammount = ammount;
		this.date = date;
		this.name = name;
	}

	public double getAmmount() {
		return ammount;
	}
	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
