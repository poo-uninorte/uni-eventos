package br.com.unieventos.DAO;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.unieventos.modelo.Atividade;
import br.com.unieventos.modelo.Participante;
import br.com.unieventos.util.HibernateUtil;

public class AtividadeDAO {
	
	public List<Atividade> recuperaTodasAtividades() {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			List<Atividade> atividades = session.createQuery("from Atividade", Atividade.class).list();
			trans.commit();
			return atividades;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
		
	}
	
	public List<Atividade> recuperaTodasAtividades(Integer eventoSelecionado) {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			//List<Atividade> atividades = session.createQuery("from atividade a join evento e where a.codigo = e.codigo and e.codigo = " + eventoSelecionado).list();
			List<Atividade> atividades = session.createQuery("from Atividade where evento_codigo =" + eventoSelecionado, Atividade.class).list();
			trans.commit();
			return atividades;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
		
	}
	

	public Atividade findById(long codigo) {
		
		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			Atividade atividade = session.find(Atividade.class, codigo);
			trans.commit();
			return atividade;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
		
	}
	
	public void cadastra(Atividade atividade) {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			session.saveOrUpdate(atividade);
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public List<BigInteger> quantidadeInscritos(long atividade) {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<BigInteger> query = (List<BigInteger>) session.createSQLQuery("Select count(*) from Participante p, Atividade a where p.atividade_codigo = a.codigo and a.codigo = " + atividade).list();
			trans.commit();
			return query;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	
	
	public List<Integer> quantidadeLimiteDaAtividade(long atividade) {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Integer> query = (List<Integer>) session.createSQLQuery("Select limiteParticipante from Atividade a where a.codigo = " + atividade).list();
			trans.commit();
			return query;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public List<Participante> listaDeInscritosPorAtividade(Integer atividade) {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			List<Participante> query = session.createQuery("from Participante where atividade_codigo =" + atividade, Participante.class).list();
			trans.commit();
			return query;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	

}
