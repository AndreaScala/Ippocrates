package ippocrates;

import java.time.*;

public class Visita {
	
	private String descrizione;
	private LocalDate data;
	//LocalDate date = LocalDate.of(2014, Month.SEPTEMBER, 9);
	//int year = date.getYear(); // 2014
	//Month month = date.getMonth(); // SEPTEMBER
	//int dom = date.getDayOfMonth(); // 9
	//DayOfWeek dow = date.getDayOfWeek(); // Tuesday
	//int len = date.lengthOfMonth(); // 30 (Numero di gg di settembre)
	//boolean leap = date.isLeapYear(); //false (2014 non è bisestile)
	
	//il costruttore di default imposta la data di oggi
	public Visita() {
		this.data = LocalDate.now();
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
