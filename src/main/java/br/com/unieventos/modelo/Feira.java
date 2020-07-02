package br.com.unieventos.modelo;


import javax.persistence.Entity;

@Entity
public class Feira extends Atividade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Feira() {
	}
	
	public Feira(String nome, String responsavel) {
		super(nome, responsavel);
	}
}
