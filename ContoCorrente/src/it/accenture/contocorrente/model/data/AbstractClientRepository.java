package it.accenture.contocorrente.model.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import it.accenture.contocorrente.model.Client;
import it.accenture.contocorrente.model.exceptions.DataException;

public interface AbstractClientRepository {
	
	/*public abstract*/ Optional<Client> findByID(int ID) throws DataException;
		
	ArrayList<Client> getAll() throws DataException;
	
	boolean deleteById(int ID) throws DataException;
	
	boolean update(int ID, Client c) throws DataException;
	
	int create(Client c) throws DataException;
	
	static void newMethod() {
		System.out.println("Sono un metodo statico");
	}
	
	default void myDefaultMethod() {
		System.out.println("Sono un metodo di default");
	}
	
	/*final static*/ int x= 3;
}
