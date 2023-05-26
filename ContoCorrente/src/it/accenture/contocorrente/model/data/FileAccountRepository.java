package it.accenture.contocorrente.model.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import it.accenture.contocorrente.model.CurrentAccount;
import it.accenture.contocorrente.model.exceptions.DataException;

public class FileAccountRepository implements AbstractAccountRepository{
	
	private static int IDGenerator;
	@Override
	public int createAccount(CurrentAccount c, int clientID) throws DataException {
		c.setID(++IDGenerator);
		try (FileWriter fw= new FileWriter("Clienti.csv", true)) {
			
		}	catch (IOException e) {
			DataException d= new DataException("Errore nel salvataggio dell'account sul file di testo", e);
			throw d;
		}
		
		return 0;
	}

	@Override
	public List<CurrentAccount> getByClientID(int clientID) throws DataException {
		
		return null;
	}

}
