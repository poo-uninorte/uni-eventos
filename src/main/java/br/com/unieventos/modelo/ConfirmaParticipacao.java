package br.com.unieventos.modelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import br.com.unieventos.DAO.ParticipanteDAO;
import br.com.unieventos.application.Keypad;
import br.com.unieventos.application.Screen;

public class ConfirmaParticipacao {
	
	private static final Screen SCREEN = new Screen();
	private static final Keypad KEYPAD = new Keypad();
	
	public void confirma() {

		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		
		ArrayList<Participante> participantes =  (ArrayList<Participante>) participanteDAO.recuperaTodosParticipantes();
		
		SCREEN.displayMessageLine("Confirma��o\n");
		SCREEN.displayMessageLine("Participantes inscritos:\n ");
		
		for (int i = 0; i < participantes.size(); i++) {
			SCREEN.displayMessageLine(participantes.get(i).toString() + ", c�digo: " + i);
		}
		
		SCREEN.displayMessage("\nEscolha o c�digo do interessado para confirmar a participa��o: ");
		
		Integer escolhaParticipante = 0;
		boolean continuaLoop = true;
		do {
			try {
				escolhaParticipante = KEYPAD.getInputInteiro();
				
				Participante participante = (Participante) participantes.get(escolhaParticipante);
				participante.setParticipou(true);
				participanteDAO.cadastra(participante);
				
				continuaLoop = false;
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inv�lida! Tente um n�mero:");
				KEYPAD.getInputString();
			}  catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Participante n�o encontrado! tente novamente:");
				KEYPAD.getInputString();
			}
		} while (continuaLoop);
		
		SCREEN.displayMessageLine("\nConfirmado com sucesso! Pressione Enter\n");
		KEYPAD.getInputString();
		KEYPAD.getInputString();
	}
	
}
