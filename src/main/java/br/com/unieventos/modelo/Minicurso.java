package br.com.unieventos.modelo;


import javax.persistence.Entity;

@Entity
public class Minicurso extends Atividade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer limiteParticipante;
	
	
	public Integer getLimiteParticipante() {
		return limiteParticipante;
	}

	public void setLimiteParticipante(Integer limiteParticipante) {
		this.limiteParticipante = limiteParticipante;
	}

	public Minicurso() {
		
	}
	
	public Minicurso(String nome, String responsavel, Integer limite) {
		super(nome, responsavel);
		this.limiteParticipante = limite;
	}
	
	public Minicurso(String nome, String responsavel) {
		super(nome, responsavel);
	}
}
