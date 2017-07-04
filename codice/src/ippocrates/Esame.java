package ippocrates;

public class Esame implements Elemento {
	
	private String nome;
	private String descr;
	
	public Esame(String nome, String descr) {
		super();
		this.nome = nome;
		this.descr = descr;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
	public String toString() {
		return "Esame [nome=" + nome + ", descr=" + descr + "]";
	}
	
	
}
