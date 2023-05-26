package it.accenture.contocorrente.model.utils;

import java.time.LocalDate;

import it.accenture.contocorrente.model.Client;
import it.accenture.contocorrente.model.Gender;

public class CSVUtils {
	
	public static Client clientFromCSV(String[] result) {
		Client c= new Client(Integer.parseInt(result[0]), result[1], result[2],
				result[3], LocalDate.parse(result[4]), Gender.valueOf(result[5]));
		return c;
	}
	
	public static String stringFromClient(Client c) {
		return String.format("%d,%s,%s,%s,%s,%s", c.getID(), c.getName(), c.getLastName(), c.getHomeAddress(), c.getDateOfBirth(), c.getGender()); 
	}
	
}
