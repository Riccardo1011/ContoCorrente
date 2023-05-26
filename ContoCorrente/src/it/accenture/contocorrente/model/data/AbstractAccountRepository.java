package it.accenture.contocorrente.model.data;

import java.util.List;

import it.accenture.contocorrente.model.AccountType;
import it.accenture.contocorrente.model.CurrentAccount;
import it.accenture.contocorrente.model.exceptions.DataException;

public interface AbstractAccountRepository {
	
	int createAccount(CurrentAccount c, int clientID) throws DataException;
	
	List<CurrentAccount> getByClientID(int clientID) throws DataException;
	
}
