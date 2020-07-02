package br.com.unieventos.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Participante implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	private String nome;
	private String email;
	private Atividade atividade;
	private boolean participou;

	public Participante(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.participou = false;
	}

	public Participante() {
	}

	public boolean isParticipou() {
		return participou;
	}

	public void setParticipou(boolean participou) {
		this.participou = participou;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public void setAtividade(Atividade atividade, Participante participante) {
		atividade.getParticipante().add(participante);
		this.atividade = atividade;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "@ Nome: " + this.getNome() + ", Participou: " + this.isParticipou();
	}
}
