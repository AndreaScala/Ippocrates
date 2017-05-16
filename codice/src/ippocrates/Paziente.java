package ippocrates;

public class Paziente {
	
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private CartellaClinica cartellaClinica;
	
	public Paziente(String nome, String cognome, String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.cartellaClinica = new CartellaClinica();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public CartellaClinica getCartellaClinica() {
		return cartellaClinica;
	}
	public void setCartellaClinica(CartellaClinica cartellaClinica) {
		this.cartellaClinica = cartellaClinica;
	}

	@Override
	public String toString() {
		return "Paziente [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + "]";
	}
	
}