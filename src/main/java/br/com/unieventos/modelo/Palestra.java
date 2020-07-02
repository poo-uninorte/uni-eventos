package br.com.unieventos.modelo;


import javax.persistence.Entity;

@Entity
public class Palestra extends Atividade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Palestra() {
		
	}
	
	public Palestra(String nome, String responsavel) {
		super(nome, responsavel);
	}
}
