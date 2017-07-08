package ippocrates;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import ippocrates.exceptions.IppocratesException;

public class TestIppocrates {

	@Test
	public void testInserisciERicercaPaziente() throws IppocratesException {
		
		Ippocrates ippocrates = new Ippocrates();
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		
		System.out.println("Inserisci il tuo primo paziente!");
		System.out.println("Nome: ");
		nome = s.nextLine();
		System.out.println("Cognome: ");
		cognome = s.nextLine();
		System.out.println("CF: ");
		cf = s.nextLine();
		
		ippocrates.aggiungiPaziente(nome, cognome, cf);
		Paziente pTest = new Paziente(nome, cognome, cf);
		
		assertEquals(pTest.toString(), ippocrates.ricercaPaziente(cf).toString());
		
		for (char c : ippocrates.ricercaPaziente(cf).toString().toCharArray())
			assertFalse(Character.isDigit(c));
		
		//s.close();
		
	}
	
	@Test
	public void testInserisciVisita () throws IppocratesException {
		
		Ippocrates ippocrates = new Ippocrates();
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		
		System.out.println("Inserisci dati paziente");
		System.out.println("Nome: ");
		nome = s.nextLine();
		System.out.println("Cognome: ");
		cognome = s.nextLine();
		System.out.println("CF: ");
		cf = s.nextLine();
		
		ippocrates.aggiungiPaziente(nome, cognome, cf);
		
		String desc;
		
		System.out.println("Inserisci la sua prima visita!");
		System.out.println("Descrizione: ");
		desc = s.nextLine();
		
		ippocrates.inserisciVisita(cf, desc);
		Visita vTest = new Visita(desc);
		
		assertEquals(vTest.toString(),ippocrates.ricercaPaziente(cf).getCartellaClinica().getListaVisite().get(0).toString());
		
		//s.close();
	}
	
	@Test
	public void TestInserisciPrescrizione () throws IppocratesException {
		Ippocrates ippocrates = new Ippocrates();
		PrescriptionFactory prfac;
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		
		System.out.println("Inserisci dati paziente");
		System.out.println("Nome: ");
		nome = s.nextLine();
		System.out.println("Cognome: ");
		cognome = s.nextLine();
		System.out.println("CF: ");
		cf = s.nextLine();
		
		ippocrates.aggiungiPaziente(nome, cognome, cf);
		
		String choice;
		String nomeEl;
		String dato2El;
		
		System.out.println("Fai la tua prima prescrizione!");
		System.out.println("Ricetta o impegnativa?");
		choice = s.nextLine();
		
		if (choice.equals("Ricetta"))
			prfac = new RicettaFactory();
		else {
			prfac = new ImpegnativaFactory();
			assertEquals("Impegnativa", choice);
		}
		
		Prescrizione prescrizione = prfac.creaPrescrizione();
		System.out.println("Nome Farmaco/Esame: ");
		nomeEl = s.nextLine();
		System.out.println("Altra Info: ");
		dato2El = s.nextLine();
		ippocrates.inserisciElemento(prescrizione, nomeEl, dato2El);
		ippocrates.inserisciPrescrizione(cf, prescrizione);
		
		Elemento eTest;
		
		if (choice.equals("Ricetta")) {
			for (char c : dato2El.toCharArray())
				assertTrue(Character.isDigit(c));
			
			assertTrue(Integer.parseInt(dato2El) > 0);
				eTest = new Farmaco(nomeEl,Integer.parseInt(dato2El));
		}
		else
			eTest = new Esame(nomeEl, dato2El);
		
		assertEquals(eTest.toString(), ippocrates.ricercaPaziente(cf).getCartellaClinica().getListaPrescrizioni().get(0).getLista().get(0).toString());
		
		s.close();
	}

}