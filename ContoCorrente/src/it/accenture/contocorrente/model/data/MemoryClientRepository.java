package it.accenture.contocorrente.model.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import it.accenture.contocorrente.model.Client;
import it.accenture.contocorrente.model.Gender;

public class MemoryClientRepository implements AbstractClientRepository {
	
	private static int IDGenerator= 1;
	protected HashMap<Integer, Client> data= new HashMap<>();
	
	public MemoryClientRepository() {
		Client c= new Client("Riccardo", "Piccininno", "Via Galliano", LocalDate.now(), Gender.MALE);
		data.put(1, c);
	}
	
	@Override
	public Optional<Client> findByID(int ID) {
		Client x= data.get(ID);
		/*if(x!= null) {
			return Optional.of(x);
		}
		return Optional.empty();*/
		return x!= null? Optional.of(x): Optional.empty();
		
	}

	@Override
	public ArrayList<Client> getAll() {
		Collection<Client> cc= data.values();
		ArrayList<Client> clients= new ArrayList<>();
		for(Client c: cc) {
			clients.add(c);
		}
		return clients;
	}

	@Override
	public boolean deleteById(int ID) {
		Client mayBe= data.remove(ID);
		/*if(mayBe== null) {
			return false;
		}
		return true;*/
		return mayBe!= null;
	}

	@Override
	public boolean update(int ID, Client c) {
		Client mayBe= data.put(ID, c);
		return mayBe!= null;
	}

	@Override
	public int create(Client c) {
		int newID= ++IDGenerator;
		c.setID(newID);
		data.put(newID, c);
		return newID;
	}

}
