package ippocrates;
import java.util.*;

public class CartellaClinica {
	
	public static int incrementalID = 0;
	private int ID;
	private List<Visita> listaVisite;
	private List<Prescrizione> listaPrescrizioni;
	
	public CartellaClinica() {
		this.ID = incrementalID;
		incrementalID++;
		this.listaVisite = new ArrayList<Visita>();
		this.listaPrescrizioni = new ArrayList<Prescrizione>();
	}
	
	public int getID() {
		return ID;
	}
	public List<Visita> getListaVisite() {
		return listaVisite;
	}
	public List<Prescrizione> getListaPrescrizioni() {
		return listaPrescrizioni;
	}
	
}
