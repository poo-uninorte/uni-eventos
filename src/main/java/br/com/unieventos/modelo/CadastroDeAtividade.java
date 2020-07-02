package br.com.unieventos.modelo;


import java.util.ArrayList;
import java.util.InputMismatchException;

import br.com.unieventos.DAO.AtividadeDAO;
import br.com.unieventos.DAO.EventoDAO;
import br.com.unieventos.application.Keypad;
import br.com.unieventos.application.Screen;

public class CadastroDeAtividade {
	
	private static final Screen SCREEN = new Screen();
	private static final Keypad KEYPAD = new Keypad();
	
	public void cadastra(Atividade atividade) {

		SCREEN.displayMessage("\nNome da atividade:");
		String nomeAtividade = KEYPAD.getInputString();
		if("".equals(nomeAtividade)) {
			SCREEN.displayMessage("\nNome da atividade:");
			nomeAtividade = KEYPAD.getInputString();
		}
		SCREEN.displayMessage("\nNome do responsável ou dos responsáveis separados por vírgula:");
		String nomeDoResponsavel = KEYPAD.getInputString();
		
		atividade.setNome(nomeAtividade);
		atividade.setResponsavel(nomeDoResponsavel);
		
		if(atividade instanceof Minicurso) {
			SCREEN.displayMessage("\nLimite de participantes:");
			Integer limite = 0;
			boolean continuaLoop = true;
			
			do {
				try {
					
					limite = KEYPAD.getInputInteiro();
					continuaLoop = false;
					
				} catch (InputMismatchException e) {
					SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
					KEYPAD.getInputString();
				}
			} while (continuaLoop);
			
			((Minicurso) atividade).setLimiteParticipante(limite);
		}
		
		EventoDAO eventoDao = new EventoDAO();
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		eventos = (ArrayList<Evento>) eventoDao.recuperaTodosEventos();
		
		SCREEN.displayMessageLine("\nEventos disponíveis: \n" );

		for (int i = 0; i < eventos.size(); i++) {
			SCREEN.displayMessageLine(eventos.get(i).toString() + ", código: " + i);
		}
		
		
		SCREEN.displayMessage("\nEscolha o evento pelo código para a atividade criada:");
		
		//Trata a entrada de um inteiro
		Integer escolhaEvento = 0;
		boolean continuaLoop = true;
		
		do {
			try {
				
				escolhaEvento = KEYPAD.getInputInteiro();
				atividade.setEvento(eventos.get(escolhaEvento));
				continuaLoop = false;
				
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Atividade não encontrada! tente novamente:");
				KEYPAD.getInputString();
			}
		} while (continuaLoop);
		
		AtividadeDAO atividadeDao = new AtividadeDAO();

		atividadeDao.cadastra(atividade);
	}
}
