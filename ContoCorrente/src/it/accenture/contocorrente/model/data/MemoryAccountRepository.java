package it.accenture.contocorrente.model.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.accenture.contocorrente.model.AccountType;
import it.accenture.contocorrente.model.CurrentAccount;

public class MemoryAccountRepository implements AbstractAccountRepository {
	
	private Map<Integer, List<CurrentAccount>> data= new HashMap<>();
	private static int IDGenerator;
	
	@Override
	public int createAccount(CurrentAccount c, int clientID) {
		c.setID(++IDGenerator);
		List<CurrentAccount> ca= data.get(clientID);
		if(ca== null) {
			ca= new ArrayList<CurrentAccount>();
			data.put(clientID, ca);
		}
		ca.add(c);
		return c.getID();
	}

	@Override
	public List<CurrentAccount> getByClientID(int clientID) {
		var cc= data.get(clientID);
		if(cc== null) {
			return new ArrayList<>();
		} 
		return cc;
		
	}
	
	
}
