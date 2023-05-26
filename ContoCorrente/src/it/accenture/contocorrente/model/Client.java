package it.accenture.contocorrente.model;

import java.time.LocalDate;
import java.util.ArrayList;

import it.accenture.contocorrente.model.CurrentAccount;

public class Client {
	
	public ArrayList<CurrentAccount> accounts= new ArrayList<>();
	
	protected static int IDGenerator;
	protected int ID;
	protected String name;
	protected String lastname;
	protected String homeAddress;
	protected LocalDate dateOfBirth;
	protected Gender gender;
	
	public Client() {
		IDGenerator++;
		ID= IDGenerator;
	}
	
	public Client(String name, String lastname, String homeAddress, LocalDate dateOfBirth, Gender gender) {
		this();
		this.name= name;
		this.lastname= lastname;
		this.homeAddress= homeAddress;
		this.dateOfBirth= dateOfBirth;
		this.gender= gender;
	}
	
	public Client(int ID, String name, String lastname, String homeAddress, LocalDate dateOfBirth, Gender gender) {
		this(name, lastname, homeAddress, dateOfBirth, gender);
		this.ID= ID;
	}
	
	/*public void setGender(String gender) {
		if(this.gender.equalsIgnoreCase("m") || this.gender.equalsIgnoreCase("f")) {
			this.gender= gender;
		}
	}*/
	
	public void show() {
		System.out.printf("ID: %d; Nome: %s; Cognome: %s; Indirizzo di casa: %s; Data di nascita: %s%n", ID, name, lastname, homeAddress, dateOfBirth);
	}
	
	public double TotalBalance() {
		double tb= 0;
		
		for(CurrentAccount ca: accounts) {
		tb+= ca.balance;
		}
		return tb;
	}
	
	public int addCurrentAccount(CurrentAccount ca) {
		if(accounts.size()< 3) {
			accounts.add(ca);
		} else {
			System.out.printf("Il cliente %s %s possiede già il numero massimo di conti", this.name, this.lastname);
		}
		
		return accounts.size();
	}

	public void setID(int ID) {
		this.ID= ID;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public String getHomeAddress() {
		return homeAddress;
	}
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	/*public CurrentAccount getAccounts(Client c) {
		for(CurrentAccount ca: accounts) {
			return ca;
		}
		return ca;
	}*/
	
	@Override
	public String toString() {
		return String.format("Nome: %s, Cognome: %s, Indirizzo di casa: %s, Data di nascita: %s, Genere: %s%n", name, lastname, homeAddress, dateOfBirth, gender);
	}
	
}
