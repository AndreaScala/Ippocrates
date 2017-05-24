package ippocrates;
import java.util.*;
import java.time.*;
import ippocrates.exceptions.*;

public class Ippocrates {
	public List<Paziente> listaPazienti;
	
	public Ippocrates() {
		this.listaPazienti = new ArrayList<Paziente>();
	}
	
	public Paziente ricercaPaziente(String cf) {
		Iterator<Paziente> iterator = listaPazienti.iterator();
		while (iterator.hasNext()) {
			Paziente p = iterator.next();
			if (p.getCodiceFiscale()==cf)
				return p;
		}
		return null;
	}
	
	public Paziente ricercaPaziente(String nome, String cognome) {
		Iterator<Paziente> iterator = listaPazienti.iterator();
		while (iterator.hasNext()) {
			Paziente p = iterator.next();
			if (p.getNome()==nome && p.getCognome()==cognome)
				return p;
		}
		return null;
	}
	
	private boolean contienePaziente(String cf) {
		return (ricercaPaziente(cf)!=null);
	}
	
	public void aggiungiPaziente(String nome, String cognome, String cf) throws IppocratesException {
		if (contienePaziente(cf)) throw new IppocratesException("Codice fiscale del paziente gi� presente\n");
		Paziente p = new Paziente(nome, cognome, cf);
		listaPazienti.add(p);
	}
	
	public void aggiornaCampoPaziente(String cf, String nuovoValore, String campo) throws IppocratesException {
		Paziente p = ricercaPaziente(cf);
		if (p==null) throw new IppocratesException("Codice fiscale del paziente non trovato\n");
		switch(campo) {
		case "nome":
			p.setNome(nuovoValore);
			break;
		case "cognome":
			p.setCognome(nuovoValore);
			break;
		case "cf":
			p.setCodiceFiscale(nuovoValore);
			break;
		default:
			throw new IppocratesException("Campo inserito non valido");	
		}
	}
	
	public void eliminaPaziente(String cf) throws IppocratesException{
		if (contienePaziente(cf)==false) throw new IppocratesException("Paziente non trovato\n");
		Paziente p=ricercaPaziente(cf);
		if (confermaEliminaPaziente())
			listaPazienti.remove(p);
	}
	
	private boolean confermaEliminaPaziente() {
		/*Qui va scritta la procedura di sicurezza
		 * relativa alla conferma di eliminazione
		 * ad esempio: una stringa in cui si chiede
		 * all'utente e si riceve un input
		 */
		return true;
	}
	
	public void inserisciVisita (String cf, String descrizione, LocalDate data) throws IppocratesException{
		Paziente p = ricercaPaziente(cf);
		if (p==null) throw new IppocratesException("Paziente non trovato\n");
		Visita v = new Visita();
		v.setDescrizione(descrizione);
		v.setData(data);
		p.getCartellaClinica().getListaVisite().add(v);
	}
	
	public void inserisciVisita (String cf, String descrizione) throws IppocratesException{
		inserisciVisita(cf, descrizione, LocalDate.now());
	}
	
	public void inserisciPrescrizione (String cf, String IDprescrizione, String descrizione) throws IppocratesException {
		Paziente p = ricercaPaziente(cf);
		if (p==null) throw new IppocratesException("Paziente non trovato\n");
		Prescrizione pr = new Prescrizione(IDprescrizione, descrizione);
		List<Prescrizione> L = p.getCartellaClinica().getListaPrescrizioni();
		if (contienePrescrizione(IDprescrizione, L)) throw new IppocratesException("IDprescrizione esistente con lo stesso valore\n");
		L.add(pr);
	}
	
	private boolean contienePrescrizione(String IDprescrizione, List<Prescrizione> L) {
		Iterator<Prescrizione> iterator = L.iterator();
		while (iterator.hasNext()) {
			Prescrizione pr = iterator.next();
			if (pr.getIDprescrizione()==IDprescrizione)
				return true;
		}
		return false;
	}
	
	public CartellaClinica ricercaCartellaClinica (Paziente p) throws IppocratesException{
		if (ricercaPaziente(p.getNome(), p.getCognome())==null)
			throw new IppocratesException ("Paziente non trovato");
		return p.getCartellaClinica();
	}
	
	public CartellaClinica ricercaCartellaClinica (String nome, String cognome) throws IppocratesException{
		Paziente p = ricercaPaziente(nome, cognome);
		if (p==null) throw new IppocratesException ("Paziente non trovato");
		return ricercaCartellaClinica(p);
	}

}
