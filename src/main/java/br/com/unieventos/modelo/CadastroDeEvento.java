package br.com.unieventos.modelo;

import br.com.unieventos.DAO.EventoDAO;
import br.com.unieventos.application.Keypad;
import br.com.unieventos.application.Screen;

public class CadastroDeEvento {

	private static final Screen SCREEN = new Screen();
	private static final Keypad KEYPAD = new Keypad();
	
	
	public void cadastra() {
		
	    SCREEN.displayMessage("\nNome do evento:");
	    String nomeEvento = KEYPAD.getInputString();
		SCREEN.displayMessage("\nTítulo: ");
		String tituloEvento = KEYPAD.getInputString();
		SCREEN.displayMessage("\nSigla:");
		String siglaEvento = KEYPAD.getInputString();
		SCREEN.displayMessage("\nNome da equipe organizadora:");
		String nomeEquipeOrganizadora = KEYPAD.getInputString();
		Evento evento = new Evento(siglaEvento, nomeEvento, tituloEvento, nomeEquipeOrganizadora);
		
		EventoDAO eventoDAO = new EventoDAO();
		eventoDAO.cadastra(evento);
		SCREEN.displayMessage("\nCadastrado com sucesso! Pressione enter\n");
		KEYPAD.getInputString();
		KEYPAD.getInputString();
	}
	
}
