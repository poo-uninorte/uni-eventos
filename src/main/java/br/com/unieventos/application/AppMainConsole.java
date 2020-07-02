package br.com.unieventos.application;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;

import br.com.unieventos.DAO.AtividadeDAO;
import br.com.unieventos.DAO.EventoDAO;
import br.com.unieventos.DAO.ParticipanteDAO;
import br.com.unieventos.modelo.Atividade;
import br.com.unieventos.modelo.CadastroDeAtividade;
import br.com.unieventos.modelo.CadastroDeEvento;
import br.com.unieventos.modelo.CadastroDeParticipante;
import br.com.unieventos.modelo.ConfirmaParticipacao;
import br.com.unieventos.modelo.Evento;
import br.com.unieventos.modelo.Feira;
import br.com.unieventos.modelo.MesaRedonda;
import br.com.unieventos.modelo.Minicurso;
import br.com.unieventos.modelo.Palestra;
import br.com.unieventos.modelo.Participante;

public class AppMainConsole {
	
	/*
	 * 
	 *    Variáveis para a utilização do software:
	 *    
	 * -> SCREEN é classe que cuida das mensagens na tela
	 * -> KEYPAD trata das entradas do usuário
	 * -> {EVENTO, INTERESSADO, RESPONSAVEL_ATIVIDADE,
	 * PARTICIPACAO, ESTATISTICA_ATIVIDADE, ESTATISTICA_EVENTO,SAIR} são variáveis de controle de fluxo do MainConsole
	 * 
	 * 
	 * */

	private static final Screen SCREEN = new Screen();
	private static final Keypad KEYPAD = new Keypad();
	private static final String EVENTO = "E";
	private static final String INTERESSADO = "I";
	private static final String RESPONSAVEL_ATIVIDADE = "CR";
	private static final String PARTICIPACAO = "CP";
	private static final String ESTATISTICA_ATIVIDADE = "EA";
	private static final String ESTATISTICA_EVENTO = "EE";
	private static final String SAIR = "S";

	public static void main(String[] args) {

		/*
		 * Esse método faz o levantamento das informações necessárias para as estatísticas do MainConsole
		 * Descomente para subir as informações no banco de dados
		 * 
		 * */
		
		//inicializaBancoDeDados();

		/*
		 * Controla as escolhas do usuário até ele escolher sair
		 * 
		 * -> servicoCadastroDeEvento() faz o cadastro do evento. Utilizamos uma classe própria para que o princípio de responsabilidade única se mantesse
		 * -> servicoInscricaoDeInteressado() tem a mesma funcionalidade da anterior, todavia faz o cadastro do interessado
		 * -> servicoCadastroDeAtividadeResponsavel() equivalente ao anteiror
		 * -> servicoDeConfirmacaoDeParticipacao() confirma a participação do interessado na atividade
		 * -> servicoEstatisticaAtividade() faz a busca pela quantidade de inscritos por atividade e quem participou
		 * -> servicoEstatisticaEvento() faz a busca pelas atividades criadas no evento e total de inscritos nela
		 * 
 		 * */
		while (true) {

			displayMainMenu();
			String escolha = "";
			escolha = KEYPAD.getInputString().toUpperCase();

			switch (escolha) {
			case EVENTO:
				servicoCadastroDeEvento();
				break;
			case INTERESSADO:
				servicoInscricaoDeInteressado();
				break;
			case RESPONSAVEL_ATIVIDADE:
				servicoCadastroDeAtividadeResponsavel();
				break;
			case PARTICIPACAO:
				servicoDeConfirmacaoDeParticipacao();
				break;
			case ESTATISTICA_ATIVIDADE:
				servicoEstatisticaAtividade();
				break;
			case ESTATISTICA_EVENTO:
				servicoEstatisticaEvento();
				break;
			case SAIR:
				sair();
				break;
			}
		}
	}

	/*Informações iniciais ao carregar o software*/
	public static void displayMainMenu() {

		SCREEN.displayMessageLine("\nMenu principal:");
		SCREEN.displayMessageLine("\nE  - Evento");
		SCREEN.displayMessageLine("I  - Inscreva-se");
		SCREEN.displayMessageLine("CR - Cadastra Atividade e seu Responsável");
		SCREEN.displayMessageLine("CP - Confirmar Participação");
		SCREEN.displayMessageLine("EA - Estatística por Atividade");
		SCREEN.displayMessageLine("EE - Estatística por Evento");
		SCREEN.displayMessageLine("S - Sair");
		SCREEN.displayMessage("\nEscolha uma opção:");
	}

	/*Cria o objeto e chama o método que cadastra eventos */
	public static void servicoCadastroDeEvento() {
		jumpLines();
		SCREEN.displayMessage("Cadastro de Evento\n");
		CadastroDeEvento evento = new CadastroDeEvento();
		evento.cadastra();
	}

	public static void inicializaBancoDeDados() {

		
		Evento eventoU = new Evento("TJ", "Food", "Food", "Joana e Cassandra");
		Evento eventoF= new Evento("KO", "IA", "Tecnologia", "Pedro");
		Evento eventoJ = new Evento("JDK", "Java", "Linguagem", "Junior");
		
		EventoDAO eventoDao = new EventoDAO();
		eventoDao.cadastra(eventoJ);
		eventoDao.cadastra(eventoF);
		eventoDao.cadastra(eventoU);
		
		Feira feira = new Feira("Gastronomia Unieventos", "Juninor, Pedro e Cassandra");
		feira.setEvento(eventoU);
		MesaRedonda mesa = new MesaRedonda("Chuva de ideiais", "Carlos e Sabrina");
		mesa.setEvento(eventoF);
		Minicurso minicurso = new Minicurso("Business Inteligence", "Miguel");
		minicurso.setLimiteParticipante(4);
		minicurso.setEvento(eventoJ);
		
		AtividadeDAO atividade = new AtividadeDAO();
		atividade.cadastra(feira);
		atividade.cadastra(mesa);
		atividade.cadastra(minicurso);

		Participante mylena = new Participante("Mylena", "mila@gmail.com");
		mylena.setParticipou(true);
		mylena.setAtividade(feira, mylena);
		Participante odilon = new Participante("Odilon", "odilon@gmail.com");
		odilon.setAtividade(mesa, odilon);
		Participante valdenilson = new Participante("Valdenilson", "valdenilson@gmail.com");
		valdenilson.setAtividade(minicurso, valdenilson);
		valdenilson.setParticipou(true);
		Participante manasses = new Participante("Manassés", "manasses@gmail.com");
		manasses.setAtividade(minicurso, manasses);

		ParticipanteDAO participanteDao = new ParticipanteDAO();
		participanteDao.cadastra(manasses);
		participanteDao.cadastra(mylena);
		participanteDao.cadastra(odilon);
		participanteDao.cadastra(valdenilson);

		SCREEN.displayMessage("Banco de dados inicializado com sucesso!\n");
	}

	/*Cria o objeto e chama o método que cadastra o participante e o inscreve numa atividade*/
	public static void servicoInscricaoDeInteressado() {

		jumpLines();

		CadastroDeParticipante cadastraParticipante = new CadastroDeParticipante();
		cadastraParticipante.cadastra();

		jumpLines();
	}

	/*Cria os objetos das classes filhas para a seleção de criação. Após isto, chama o método genêrico que cadastra a atividade desejada, aplicando então o OCP*/
	public static void servicoCadastroDeAtividadeResponsavel() {

		// Pula linhas para não poluir a tela
		jumpLines();
		
		// Cria um objeto para cadastrar as atividades
		CadastroDeAtividade cadastraAtividade = new CadastroDeAtividade();

		// Variáveis para facilitar a leitura
		final String feira = "FE";
		final String mesaRedonda = "MR";
		final String minicurso = "MI";
		final String palestra = "PA";

		// Variável para escolha
		String escolha;
		// Variável que continua o loop caso o usuário não digite a atividade desejada
		boolean continuaLoop = true;

		//Menu de seleção da atividade
		do {
			menuAtividadesDisponiveis();

			SCREEN.displayMessage("\nEscolha uma atividade:");
			escolha = KEYPAD.getInputString().toUpperCase();

			switch (escolha) {
			case feira:
				Feira CFeira = new Feira();
				cadastraAtividade.cadastra(CFeira);
				continuaLoop = false;
				break;
			case mesaRedonda:
				MesaRedonda CMesaRedonda = new MesaRedonda();
				cadastraAtividade.cadastra(CMesaRedonda);
				continuaLoop = false;
				break;
			case minicurso:
				Minicurso CMinicurso = new Minicurso();
				cadastraAtividade.cadastra(CMinicurso);
				continuaLoop = false;
				break;
			case palestra:
				Palestra CPalestra = new Palestra();
				cadastraAtividade.cadastra(CPalestra);
				continuaLoop = false;
				break;
			}
		} while (continuaLoop);
		
		//Feedback sobre a operação
		SCREEN.displayMessageLine("\nCadastrado com sucesso! Pressione Enter para continuar\n");
		KEYPAD.getInputString();
		KEYPAD.getInputString();
		jumpLines();
	}

	/*Menu das atividades disponíveis*/
	private static void menuAtividadesDisponiveis() {

		SCREEN.displayMessageLine("\nAtividades disponíveis:");
		SCREEN.displayMessageLine("\nFE - Feira");
		SCREEN.displayMessageLine("MR - Mesa Redonda");
		SCREEN.displayMessageLine("MI - Minicurso");
		SCREEN.displayMessageLine("PA - Palestra");
	}
	/*Cria um objeto para a chamada do método de confirmação*/
	public static void servicoDeConfirmacaoDeParticipacao() {
		jumpLines();
		ConfirmaParticipacao confirmaP = new ConfirmaParticipacao();
		confirmaP.confirma();
	}

	/*Optamos por implementar o serviço de estatística da Atividade aqui*/
	public static void servicoEstatisticaAtividade() {
		
		
		AtividadeDAO atividadeDao = new AtividadeDAO();
		ArrayList<Atividade> atividades = (ArrayList<Atividade>) atividadeDao.recuperaTodasAtividades();
		jumpLines();
		SCREEN.displayMessageLine("Atividades disponíveis para saber a quantidade de participantes:\n");
		
		for (int i = 0; i < atividades.size(); i++) {
			SCREEN.displayMessageLine(atividades.get(i).getNome() + ", código: " + i);
		}
		
		SCREEN.displayMessage("\nEscolha uma atividade pelo código: ");
		
		//Trata a entrada de um inteiro
		Integer escolhaAtividade = 0;
		ArrayList<BigInteger> qtdInscritos = null;
		boolean continuaLoop = true;
		
		do {
			try {
				
				escolhaAtividade = KEYPAD.getInputInteiro();
				atividades.get(escolhaAtividade);
				qtdInscritos = (ArrayList<BigInteger>) atividadeDao.quantidadeInscritos(escolhaAtividade + 1);
				continuaLoop = false;
				
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Atividade não encontrada! tente novamente:");
				KEYPAD.getInputString();
			}
		} while (continuaLoop);
		
		SCREEN.displayMessage("\nTotal de inscritos nesta atividade: " + qtdInscritos.get(0).intValue());
		KEYPAD.getInputString();
		KEYPAD.getInputString();
		
		jumpLines();
		
		SCREEN.displayMessageLine("Atividades disponíveis para a lista de participantes:\n");
		
		for (int i = 0; i < atividades.size(); i++) {
			SCREEN.displayMessageLine(atividades.get(i).getNome() + ", código: " + i);
		}
		

		SCREEN.displayMessage("\nEscolha uma atividade pelo código para a lista de inscritos e se participou: ");
		
		//Trata a entrada de um inteiro
		Integer escolhaAtividade1 = 0;
		boolean continuaLoop1 = true;
		ArrayList<Participante> participantes = new ArrayList<>();
		 
		do {
			try {
				
				escolhaAtividade1 = KEYPAD.getInputInteiro();
				atividades.get(escolhaAtividade1);
				participantes = (ArrayList<Participante>) atividadeDao.listaDeInscritosPorAtividade(escolhaAtividade1+1);
				continuaLoop1 = false;
				
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Atividade não encontrada! tente novamente:");
				KEYPAD.getInputString();
			}
		} while (continuaLoop1);
		
		SCREEN.displayMessageLine("\nParticipantes:\n");
		for (int i = 0; i < participantes.size(); i++) {
			System.out.println(participantes.get(i).toString());
		}
		KEYPAD.getInputString();
		KEYPAD.getInputString();
		
		jumpLines();
	}

	/*Optamos por implementar o serviço de estatística do Evento aqui também*/
	public static void servicoEstatisticaEvento() {
		
		jumpLines();
		
		EventoDAO eventoDao = new EventoDAO();
		
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		eventos = (ArrayList<Evento>) eventoDao.recuperaTodosEventos();
		
		SCREEN.displayMessageLine("Eventos disponíveis: \n" );
		
		for (int i = 0; i < eventos.size(); i++) {
			SCREEN.displayMessageLine(eventos.get(i).toString() + ", código: " + i);
		}
		
		
		AtividadeDAO atividadeDao = new AtividadeDAO();
		ArrayList<Atividade> atividades = new ArrayList<Atividade>();
		
		
		SCREEN.displayMessage("\nEscolha o evento pelo código para saber a quantidade de atividades incluídas nele:");
		
		//Trata a entrada de um inteiro
		Integer escolhaEvento = 0;
		boolean continuaLoop = true;
		
		do {
			try {
				
				escolhaEvento = KEYPAD.getInputInteiro();
				atividades = (ArrayList<Atividade>) atividadeDao.recuperaTodasAtividades(escolhaEvento + 1);
				continuaLoop = false;
				
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Evento não encontrado! tente novamente:");
				
			}
		} while (continuaLoop);
		
		SCREEN.displayMessageLine("\nAtividades do evento escolhido: " + atividades.size() + "\n");
		
		for (Atividade atividade : atividades) {
			SCREEN.displayMessageLine(atividade.toString());
		}
		KEYPAD.getInputString();
		KEYPAD.getInputString();
		
		SCREEN.displayMessageLine("\nEventos disponíveis: \n" );
		for (int i = 0; i < eventos.size(); i++) {
			SCREEN.displayMessageLine(eventos.get(i).toString() + ", código: " + i);
		}
		
		
		
		//Trata a entrada de um inteiro
		Integer escolhaEvento2 = 0;
		boolean continuaLoop2 = true;
		AtividadeDAO atividadeDao1 = new AtividadeDAO();
		ArrayList<Atividade> atividades1;
		ArrayList<BigInteger> qtdIncritos;
		
		do {
			try {
				SCREEN.displayMessage("\nEscolha o evento pelo código para saber o total de envolvidos nas atividades dele:");
				
				escolhaEvento2 = KEYPAD.getInputInteiro();
			
				atividades1 = (ArrayList<Atividade>) atividadeDao1.recuperaTodasAtividades(escolhaEvento2 + 1);
				
				if(atividades1.size() == 0) {
					SCREEN.displayMessage("\nNenhuma atividade encontrada! Escolha outro evento.\n");
					KEYPAD.getInputString();
					continue;
				}
				
				SCREEN.displayMessageLine("\nAtividades encontradas:\n");
				for (int i = 0; i < atividades1.size(); i++) {
					
					qtdIncritos = (ArrayList<BigInteger>) atividadeDao1.quantidadeInscritos(atividades1.get(i).getCodigo());
					SCREEN.displayMessageLine("\n"+atividades1.get(i).toString() + "; com " + qtdIncritos.get(0).toString() +" inscritos.");
				}
				
				KEYPAD.getInputString();
				KEYPAD.getInputString();
				
				continuaLoop2 = false;
				
			} catch (InputMismatchException e) {
				SCREEN.displayMessage("Entrada inválida! Tente novamente com um número:");
				KEYPAD.getInputString();
			} catch (IndexOutOfBoundsException  e) {
				SCREEN.displayMessage("Evento não encontrado! tente novamente:");
				
			}
		} while (continuaLoop2);
		
		jumpLines();
	}

	public static void sair() {
		System.out.println("Tchau tchau!");
		System.exit(0);
	}

	public static void jumpLines() {
		for (int i = 0; i < 50; i++) {
			SCREEN.displayMessageLine("");
		}
	}
}
