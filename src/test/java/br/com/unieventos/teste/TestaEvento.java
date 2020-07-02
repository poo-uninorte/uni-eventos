package br.com.unieventos.teste;

import java.util.ArrayList;

import org.junit.Test;

import br.com.unieventos.DAO.AtividadeDAO;
import br.com.unieventos.modelo.Atividade;

public class TestaEvento {

	@Test
	public void testsEvento() {
		
//		AtividadeDAO atividadeDao = new AtividadeDAO();
//		ArrayList<Integer> limiteAtividade = (ArrayList<Integer>) atividadeDao.quantidadeLimiteDaAtividade(4);
//		Integer limite = limiteAtividade.get(0);
//		System.out.println(limite);
		
		AtividadeDAO atividadeDao = new AtividadeDAO();
		ArrayList<Atividade> atvds = new ArrayList<>();
		
		atvds = (ArrayList<Atividade>) atividadeDao.recuperaTodasAtividades(1);
		
		System.out.println(atvds.size());
	}
}
