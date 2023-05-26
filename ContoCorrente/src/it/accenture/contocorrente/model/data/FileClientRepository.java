package it.accenture.contocorrente.model.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.accenture.contocorrente.model.Client;
import it.accenture.contocorrente.model.Gender;
import it.accenture.contocorrente.model.exceptions.DataException;
import it.accenture.contocorrente.model.utils.CSVUtils;

public class FileClientRepository implements AbstractClientRepository {

	private Path filePath = new File("Clienti.csv").toPath();

	@Override
	public Optional<Client> findByID(int ID) throws DataException {
		try {
			List<String> lines = Files.readAllLines(filePath);
			for (String s : lines) {
				String[] result = s.split(",");
				if (Integer.parseInt(result[0]) == ID) {
					Client c = CSVUtils.clientFromCSV(result);
					return Optional.of(c);
				}
			}
			return Optional.empty();
		} catch (IOException e) {
			DataException d = new DataException("Errore nella ricerca per ID del cliente", e);
			throw d;
		}
	}

	@Override
	public ArrayList<Client> getAll() throws DataException {
		try {
		List<String> lines = Files.readAllLines(filePath);
		ArrayList<Client> clients = new ArrayList<>();
		for (String s : lines) {
			String[] result = s.split(",");
			Client c = CSVUtils.clientFromCSV(result);
			clients.add(c);
		}
		return clients;
		} catch (IOException e) {
			throw new DataException("Errore nella lettura di tutti i clienti dal file CSV", e);
		}
	}

	@Override
	public boolean deleteById(int ID) throws DataException {
		boolean delete= false;
		try(FileWriter fw= new FileWriter("Clienti.csv", false)) {
			List<String> lines = Files.readAllLines(filePath);
			for (String s : lines) {
				String[] result = s.split(",");
				if (Integer.parseInt(result[0]) != ID) {
					fw.write(s + System.lineSeparator());
				} else {
					delete= true;
				}
			}
			return delete;
		}  catch (IOException e) {
			DataException d = new DataException("Errore nella ricerca per ID del cliente", e);
			throw d;
		}	
		/*finally {
			if(fw!= null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
	}

	@Override
	public boolean update(int ID, Client c) throws DataException{
		boolean update= false;
		try(FileWriter fw= new FileWriter("Clienti.csv", false)) {
			List<String> lines = Files.readAllLines(filePath);
			for(String s : lines) {
				String[] result = s.split(",");
				if (Integer.parseInt(result[0]) == ID) {
					fw.write(CSVUtils.stringFromClient(c) + System.lineSeparator());
					update= true;
				} 
			}
			return update;
		}	catch (IOException e) {
			DataException d = new DataException("Errore nell'aggiornamento dei dati del cliente", e);
			throw d;
		}
	}

	@Override
	public int create(Client c) {
		// TODO Auto-generated method stub
		return 0;
	}

}
