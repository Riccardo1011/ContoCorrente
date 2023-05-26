package it.accenture.contocorrente.model;

public enum Gender {
	MALE, FEMALE, OTHER;
	
	public static Gender parse(String s) {
		switch(s.toLowerCase()) {
			case "m":
				return MALE;
			case "f": 
				return FEMALE;
			default:
				return OTHER;
		}
	}
}
