package br.com.unieventos.modelo;

import javax.persistence.Entity;

@Entity
public class MesaRedonda extends Atividade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MesaRedonda() {
	}
	
	public MesaRedonda(String nome, String responsavel) {
		super(nome, responsavel);
	}
	
}
