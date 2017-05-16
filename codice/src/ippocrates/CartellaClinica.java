package ippocrates;
import java.util.*;

public class CartellaClinica {
	
	private String ID;
	private List<Visita> listaVisite;
	private List<Prescrizione> listaPrescrizioni;
	
	public CartellaClinica(String iD) {
		super();
		ID = iD;
		this.listaVisite = new ArrayList<Visita>();
		this.listaPrescrizioni = new ArrayList<Prescrizione>();
	}
	
	public String getID() {
		return ID;
	}
	public List<Visita> getListaVisite() {
		return listaVisite;
	}
	public List<Prescrizione> getListaPrescrizioni() {
		return listaPrescrizioni;
	}
	
	
	
	
}
