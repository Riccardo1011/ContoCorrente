package it.accenture.contocorrente.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class GoldAccount extends CurrentAccount {
	
	
	public GoldAccount(double balance, String dateOpen, String dateClose, boolean gold) {
		super(balance, dateOpen, dateClose, gold);
	}
	
	@Override
	public double Deposit(double amount) {
		if(LocalDate.now().getDayOfWeek()== DayOfWeek.SUNDAY) {
			amount= amount+(1*100/amount);
		}
		this.balance+= amount;
		return balance;
	}
	
	@Override
	public double Collect(double amount) {
		if(balance< 0) {
			System.out.println("Impossibile effettuare prelievo con saldo negativo");
			return balance;
		}
		if(amount<= balance*2) {
			balance-= amount;
		} else {
			System.out.printf("Impossibile effettuare il ritiro.%nIl saldo attuale è di%n");
		}
		return balance;
	}

}
