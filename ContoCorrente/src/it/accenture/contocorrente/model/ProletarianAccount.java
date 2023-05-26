package it.accenture.contocorrente.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ProletarianAccount extends CurrentAccount{
	
	public ProletarianAccount(double balance, String dateOpen, String dateClose, boolean gold) {
		super(balance, dateOpen, dateClose, gold);
	}

	@Override
	public double Deposit(double amount) {
		if(LocalDate.now().getDayOfWeek()!= DayOfWeek.SUNDAY) {
			amount= amount-(1*100/amount);
		}
		this.balance+= amount;
		return balance;
	}
}
