package br.com.unieventos.modelo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import br.com.unieventos.DAO.AtividadeDAO;
import br.com.unieventos.DAO.EventoDAO;
import br.com.unieventos.DAO.ParticipanteDAO;
import br.com.unieventos.application.Keypad;
import br.com.unieventos.application.Screen;

public class CadastroDeParticipante {
	
	private static final Screen SCREEN = new Screen();
	private static final Keypad KEYPAD = new Keypad();
	
	public void cadastra() {
		
		Participante participante = new Participante();
		
		SCREEN.displayMessageLine("Inscrição do interessado\n");
		
		SCREEN.displayMessage("\nNome do interessado:");
		String nomeParticipante = KEYPAD.getInputString();
		SCREEN.displayMessage("\nEmail:");
		String emailDoParticipante = KEYPAD.getInputString();
		
		participante.setNome(nomeParticipante);
		participante.setEmail(emailDoParticipante);
		
		
		EventoDAO eventoD = new EventoDAO();
		ArrayList<Evento> eventos = (ArrayList<Evento>) eventoD.recuperaTodosEventos();
		
		SCREEN.displayMessageLine("\nEventos disponíveis:\n");
		
		for (int i = 0; i < eventos.size(); i++) {
			SCREEN.displayMessageLine(eventos.get(i) + ", codigo: " + i);
		}
		
		SCREEN.displayMessage("\nEscolha o evento pelo código: ");
		
		//Trata a entrada de um inteiro
		Integer escolhaEventoParticipante = 0;
		boolean continuaLoop = true;
		do {
			try {
				escolhaEventoParticipante = KEYPAD.getInputInteiro();
				eventos.get(escolhaEventoParticipante);
				continuaLoop = false;
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Evento não encontrado! tente novamente:");
				KEYPAD.getInputString();
			}
			
		} while (continuaLoop);
		
		
		AtividadeDAO atividadeDao = new AtividadeDAO();
		ArrayList<Atividade> atividades = (ArrayList<Atividade>) atividadeDao.recuperaTodasAtividades(escolhaEventoParticipante + 1);
		
		SCREEN.displayMessageLine("\nAtividades disponíveis para o evento:\n");
		
		for (int i = 0; i < atividades.size(); i++) {
			SCREEN.displayMessageLine(atividades.get(i)+ ", codigo: " + i);
		}
		
		SCREEN.displayMessage("\nEscolha uma atividade pelo código:");
		
		//Trata a entrada de um inteiro
		Integer escolhaAtividadeParticipante = 0;
		boolean continuaLoop1 = true;
		do {
			try {
				
				escolhaAtividadeParticipante = KEYPAD.getInputInteiro();
				
				if(atividades.get(escolhaAtividadeParticipante) instanceof Minicurso) {
					
					ArrayList<BigInteger> qtdIncritos = (ArrayList<BigInteger>) atividadeDao.quantidadeInscritos(atividades.get(escolhaAtividadeParticipante).getCodigo());
					BigInteger qtd = qtdIncritos.get(0);
					ArrayList<Integer> limiteAtividade = (ArrayList<Integer>) atividadeDao.quantidadeLimiteDaAtividade(atividades.get(escolhaAtividadeParticipante).getCodigo());
					Integer limite = limiteAtividade.get(0);
					
					SCREEN.displayMessageLine("\nVocê escolheu um Minicurso. Limite de vagas: " + limite + ", Participantes inscritos: " + qtd);
					if(qtd.intValue() < limite) {
						
						participante.setAtividade(atividades.get(escolhaAtividadeParticipante), participante);
						ParticipanteDAO participanteDAO = new ParticipanteDAO();
						participanteDAO.cadastra(participante);
						
						SCREEN.displayMessage("Cadastrado com sucesso! Pressione enter\n");
						KEYPAD.getInputString();
						KEYPAD.getInputString();
						break;
					} else {
						Integer escolhaAnterior = escolhaAtividadeParticipante;
						
						SCREEN.displayMessage("Não há vagas disponíveis!");
						SCREEN.displayMessage("\nEscolha outra atividade pelo código para inscrever-se:");
						
						do {
							
							escolhaAtividadeParticipante = KEYPAD.getInputInteiro();
						
						}while(escolhaAnterior == escolhaAtividadeParticipante);
						
						KEYPAD.getInputString();
						KEYPAD.getInputString();
					}
				}
				
				participante.setAtividade(atividades.get(escolhaAtividadeParticipante), participante);
				
				ParticipanteDAO participanteDAO = new ParticipanteDAO();
				participanteDAO.cadastra(participante);
				SCREEN.displayMessageLine("\nCadastrado com sucesso! Pressione enter");
				KEYPAD.getInputString();
				KEYPAD.getInputString();
				
				continuaLoop1 = false;
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("\nEntrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("\nAtividade não encontrada! tente novamente:");
				KEYPAD.getInputString();
			}
		} while (continuaLoop1);
	
	}
}
