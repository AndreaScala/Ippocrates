package ippocrates;

import java.util.ArrayList;

public class Impegnativa implements Prescrizione {

	private ArrayList<Esame> listaEsami;
	
	public Impegnativa() {
		this.listaEsami = new ArrayList<Esame>();
	}

	@Override
	public void inserisciElemento(Elemento e) {
		Esame ex = (Esame) e;
		this.listaEsami.add(ex);
	}
	
	@Override
	public ArrayList<Elemento> getLista() {
		ArrayList<Elemento> l = new ArrayList<Elemento>(this.listaEsami);
		return l;
	}

}
