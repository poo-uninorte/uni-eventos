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
		SCREEN.displayMessage("\nNome do respons�vel ou dos respons�veis separados por v�rgula:");
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
					SCREEN.displayMessage("Entrada inv�lida! Tente novamente com um n�mero:");
					KEYPAD.getInputString();
				}
			} while (continuaLoop);
			
			((Minicurso) atividade).setLimiteParticipante(limite);
		}
		
		EventoDAO eventoDao = new EventoDAO();
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		eventos = (ArrayList<Evento>) eventoDao.recuperaTodosEventos();
		
		SCREEN.displayMessageLine("\nEventos dispon�veis: \n" );

		for (int i = 0; i < eventos.size(); i++) {
			SCREEN.displayMessageLine(eventos.get(i).toString() + ", c�digo: " + i);
		}
		
		
		SCREEN.displayMessage("\nEscolha o evento pelo c�digo para a atividade criada:");
		
		//Trata a entrada de um inteiro
		Integer escolhaEvento = 0;
		boolean continuaLoop = true;
		
		do {
			try {
				
				escolhaEvento = KEYPAD.getInputInteiro();
				atividade.setEvento(eventos.get(escolhaEvento));
				continuaLoop = false;
				
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inv�lida! Tente novamente com um n�mero:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Atividade n�o encontrada! tente novamente:");
				KEYPAD.getInputString();
			}
		} while (continuaLoop);
		
		AtividadeDAO atividadeDao = new AtividadeDAO();

		atividadeDao.cadastra(atividade);
	}
}
