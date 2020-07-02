package br.com.unieventos.modelo;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Evento implements Serializable{
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	private static final long serialVersionUID = 1L;
	private String sigla;
	private String nome;
	private String titulo;
	private String equipeOgranizadora;
		
	public Evento() {
		
	}
			
	public Evento(String sigla, String nome, String titulo, String equipeOgranizadora) {
		this.sigla = sigla;
		this.nome = nome;
		this.titulo = titulo;
		this.equipeOgranizadora = equipeOgranizadora;
	}

	public String getEquipeOgranizadora() {
		return equipeOgranizadora;
	}

	public void setEquipeOgranizadora(String equipeOgranizadora) {
		this.equipeOgranizadora = equipeOgranizadora;
	}

	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return "@ Nome: " + this.getNome();
	}
}