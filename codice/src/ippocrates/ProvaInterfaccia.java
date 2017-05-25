package ippocrates;

import java.util.*;

import ippocrates.exceptions.IppocratesException;

public class ProvaInterfaccia {

	public static void main(String[] args) throws IppocratesException {
		
		System.out.println("Benvenuto in Ippopocrates!");
		
		Ippocrates ippocrates = new Ippocrates();
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		String desc;
		
		System.out.println("Inserisci il tuo primo paziente!");
		System.out.println("Nome: ");
		nome = s.nextLine();
		System.out.println("Cognome: ");
		cognome = s.nextLine();
		System.out.println("CF: ");
		cf = s.nextLine();
		
		ippocrates.aggiungiPaziente(nome, cognome, cf);
		Paziente p = ippocrates.ricercaPaziente(cf);
		
		System.out.println("Hai inserito con successo:");
		System.out.println(p.toString());
		
		System.out.println("Inserisci la sua prima visita!");
		System.out.println("Descrizione: ");
		desc = s.nextLine();
		
		ippocrates.inserisciVisita(p.getCodiceFiscale(), desc);
		Visita v = ippocrates.ricercaPaziente(cf).getCartellaClinica().getListaVisite().get(0);
		System.out.println("Hai inserito con successo:");
		System.out.println(v.toString());
		
		s.close();

	}

}