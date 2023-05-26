package it.accenture.contocorrente.main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import it.accenture.contocorrente.model.Client;
import it.accenture.contocorrente.model.Gender;
import it.accenture.contocorrente.model.data.AbstractClientRepository;
import it.accenture.contocorrente.model.data.FileClientRepository;
import it.accenture.contocorrente.model.data.MemoryClientRepository;
import it.accenture.contocorrente.model.exceptions.DataException;

public class UserInterface {
	private Scanner console= new Scanner(System.in);
	private AbstractClientRepository repo;
	
	public UserInterface(AbstractClientRepository repo) {
		this.repo= repo;
	}
			
	public void start() {
		boolean goOn= true;
		try {
			do {
				System.out.println("Inserisci c per creare un nuovo cliente");
				System.out.println("Inserisci r per vedere tutti i clienti");
				System.out.println("Inserisci d per eliminare un cliente");
				System.out.println("Inserisci u per aggiornare un cliente");
				System.out.println("Inserisci s per cercare un cliente tramite ID");
				System.out.println("Inserisci q per uscire");
				String s= console.nextLine();
				switch(s) {
					case "c": 
					case "C": 
						createClient();
						break;
					case "r":
					case "R":
						showClients();
						break;
					case "d":
					case "D":
						deleteClient();
						break;
					case "u":
					case "U":
						updateClient();
						break;
					case "s": 
					case "S": 
						findByID();
						break;
					case "q":
					case "Q":
						System.out.println("Arrivederci");
						goOn= false;
						break;
				}
			} while (goOn);
		}	catch (DataException d) {
				System.out.println("Terminando il programma con errore");
				System.out.println(d.getMessage());
				Throwable cause= d.getCause();
				System.out.println(cause.getClass().getName());
				System.out.println(cause.getMessage());
		}
	}

	private void findByID() throws DataException {
		System.out.println("Inserire l'ID del cliente");
		int ID= console.nextInt();
		console.nextLine();
		Optional<Client> found= repo.findByID(ID);
		if(found.isPresent()) {
			System.out.println("Cliente trovato");
			System.out.println(found);
		} else {
			System.out.printf("Il cliente con ID %d non esiste%n", ID);
		}
		
		
	}

	private void updateClient() throws DataException {
		System.out.println("Inserisci l'ID del cliente da aggiornare");
		int ID= console.nextInt();
		console.nextLine();
		Client c= readClientData();
		c.setID(ID);
		boolean result= repo.update(ID, c);
		if(result) {
			System.out.println("Cliente modificato con successo");
		} else {
			System.out.printf("Il cliente con ID %d non esiste%n", ID);
		}
	}

	private void deleteClient() throws DataException {
		System.out.println("Inserisci l'ID del cliente da eliminare");
		int ID= console.nextInt();
		console.nextLine();
		boolean result= repo.deleteById(ID);
		if(result) {
			System.out.println("Cliente eliminato");
		} else {
			System.out.printf("Il cliente con ID %d non esiste%n", ID);
		}
	}

	private void showClients() throws DataException {
		ArrayList<Client> clients= repo.getAll();
		for(Client c: clients) {
			System.out.println(c.toString());
		}
		
	}

	private void createClient() throws DataException {
		Client c= readClientData();
		repo.create(c);
	}
	
	public static void main(String[] args) {
		AbstractClientRepository repo= new FileClientRepository();
		UserInterface UI= new UserInterface(repo);
		UI.start();
	}
	
	public Client readClientData() {
		System.out.println("Inserisci il nome del cliente: ");
		String name= console.nextLine();
		System.out.println("Inserisci il cognome del cliente: ");
		String lastname= console.nextLine();
		System.out.println("Inserisci l'indirizzo del cliente: ");
		String homeAddress= console.nextLine();
		System.out.println("Inserisci la data di nascita del cliente: ");
		String dateOfBirthString= console.nextLine();
		LocalDate dateOfBirth= LocalDate.parse(dateOfBirthString);
		System.out.println("Inserisci il genere del cliente: m/f/o");
		String genderString= console.nextLine();
		Gender gender= Gender.parse(genderString);
		Client c= new Client(name, lastname, homeAddress, dateOfBirth, gender);
		return c;
	}
}
