package ippocrates;
import java.util.*;

public class Esame implements Elemento {
	
	private String nome;
	private Date data;
	
	public Esame(String nome, Date data) {
		super();
		this.nome = nome;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
