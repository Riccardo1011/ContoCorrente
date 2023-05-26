package it.accenture.contocorrente.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import it.accenture.contocorrente.model.*;

public class Bank {

	public static void main(String[] args) {
		
		Client c1= new Client("Riccardo", "Piccininno", "Via Galliano", LocalDate.parse("2003-11-11"), Gender.MALE);
		c1.show();
		Client c2= new Client("Vincenzo", "Piccininno", "Via Galliano", LocalDate.parse("2007-02-02"), Gender.MALE);
		c2.show();
		
		CurrentAccount ca1= new GoldAccount(100.32, "25/01/2023", "25/01/2024", true);
		c1.addCurrentAccount(ca1);
		System.out.println("Saldo di c1 iniziale: " + ca1.getBalance());
		
		CurrentAccount ca2= new ProletarianAccount(1000.42, "25/01/2023", "25/01/2024", false);
		CurrentAccount ca3= new GoldAccount(550.00, "25/01/2023", "25/01/2024", true);
		ArrayList<CurrentAccount> conti= new ArrayList<>();
		conti.add(ca1);
		conti.add(ca2);
		conti.add(ca3);
		Collections.sort(conti);
		c1.addCurrentAccount(ca2);
		c1.addCurrentAccount(ca3);
		System.out.println("Saldo totale di c1: " + c1.TotalBalance());
		
		ca1.Deposit(10);
		System.out.println("Saldo totale di c1 dopo il deposito: " + c1.TotalBalance());
		
		ca2.transfer(ca3, 400);
		System.out.println("Saldo ca2 dopo il transfer: " + ca2.getBalance());
		System.out.println("Saldo ca3 dopo il transfer: " + ca3.getBalance());
		
		ca3.Collect(50);
		System.out.println("Saldo ca3 dopo il ritiro: " + ca3.getBalance());
		
		ca2.Collect(2000);
		System.out.println("Saldo ca2 dopo il ritiro: " + ca2.getBalance());
		
		ca2.Collect(100);
		System.out.println("Saldo ca2 dopo il ritiro: " + ca2.getBalance());
		
		CurrentAccount ca4= new ProletarianAccount(1000.42, "25/01/2023", "25/01/2024", false);
		c1.addCurrentAccount(ca4);
	}
	
	public static void handleAccount(CurrentAccount x) {
		if(x.getBalance()> 1000000) {
			x.Deposit(100);
		}
	}
}
