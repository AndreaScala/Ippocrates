package ippocrates;

import java.util.*;

import ippocrates.exceptions.IppocratesException;

public class ProvaInterfaccia {

	public static void main(String[] args) throws IppocratesException {
		
		System.out.println("Benvenuto in Ippopocrates!");
		
		Ippocrates ippocrates = new Ippocrates();
		PrescriptionFactory prfac;
		
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		String desc;
		String choice;
		String nomeEl;
		String dato2El;
		
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
		
		System.out.println("Fai la tua prima prescrizione!");
		System.out.println("Ricetta o impegnativa?");
		choice = s.nextLine();
		if (choice.equals("Ricetta"))
			prfac = new RicettaFactory();
		else
			prfac = new ImpegnativaFactory();
		
		Prescrizione prescrizione = prfac.creaPrescrizione();
		System.out.println("Nome Farmaco/Esame: ");
		nomeEl = s.nextLine();
		System.out.println("Altra Info: ");
		dato2El = s.nextLine();
		ippocrates.inserisciElemento(prescrizione, nomeEl, dato2El);
		ippocrates.inserisciPrescrizione(cf, prescrizione);
		
		System.out.println("Hai inserito con successo:");
		System.out.println(ippocrates.ricercaPaziente(cf).getCartellaClinica().getListaPrescrizioni().get(0).getLista().get(0).toString());
		
		s.close();

	}

}