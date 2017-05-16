package ippocrates;

public class Prescrizione {
	
	private String IDprescrizione;
	private String descrizione;
	
	public Prescrizione(String id, String desc) {
		this.IDprescrizione = id;
		this.descrizione = desc;
	}

	public String getIDprescrizione() {
		return IDprescrizione;
	}

//	public void setIDprescrizione(String iDprescrizione) {
//		IDprescrizione = iDprescrizione;
//	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
