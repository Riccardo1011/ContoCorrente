package it.accenture.contocorrente.model;

public abstract class CurrentAccount implements Comparable<CurrentAccount> {
	
	protected static int IDGenerator;
	protected int ID;
	protected double balance;
	protected String dateOpen;
	protected String dateClose;
	protected boolean gold;
	
	public CurrentAccount() {
		IDGenerator++;
		ID= IDGenerator;
	}
	
	public CurrentAccount(double balance, String dateOpen, String dateClose, boolean gold) {
		this();
		this.balance= balance;
		this.dateOpen= dateOpen;
		this.dateClose= dateClose;
		this.gold= gold;
	}
	
	public void setID(int ID) {
		this.ID= ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public abstract double Deposit(double amount);
	
	public double Collect(double amount) {
		if(balance- amount >= 0) {
			this.balance-= amount;
			System.out.println("Prelievo effettuato");
		} else {
			System.out.println("Saldo insufficente per il prelievo");
		}
		return balance;
	}
	
	public double transfer(CurrentAccount ca, double b) {
		if(ca.balance> 0) {
			balance+= b;
			ca.balance-= b;
			return balance;
		}
		System.out.println("Saldo insufficiente per effettuare il trasferimento");
		return balance;
	}
	
	@Override
	public int compareTo(CurrentAccount other) {
		System.out.printf("Stiamo comparando il conto con ID %d con il conto con ID %d%n", this.ID, other.ID);
		double difference= this.balance-other.balance;
		return (int) Math.signum(difference);	
	}
	
}
