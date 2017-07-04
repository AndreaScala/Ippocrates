package ippocrates;

public class Farmaco implements Elemento {
	
	private String nome;
	private int quantita;
	
	public Farmaco(String nome, int quantita) {
		super();
		this.nome = nome;
		this.quantita = quantita;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Farmaco [nome=" + nome + ", quantita=" + quantita + "]";
	}
	
	

}