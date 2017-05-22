package ippocrates;

import java.util.*;

import ippocrates.exceptions.IppocratesException;

public class test {

	public static void main(String[] args) throws IppocratesException {
		
		System.out.println("Benvenuto in Ippopocrates!");
		
		Ippocrates ippocrates = new Ippocrates();
		Scanner s = new Scanner(System.in);
		
		String nome;
		String cognome;
		String cf;
		
		System.out.println("Nome: ");
		nome = s.nextLine();
		System.out.println("Cognome: ");
		cognome = s.nextLine();
		System.out.println("CF: ");
		cf = s.nextLine();
		
		ippocrates.aggiungiPaziente(nome, cognome, cf);
		Paziente p = ippocrates.ricercaPaziente(cf);
		
		System.out.println(p.toString());

	}

}