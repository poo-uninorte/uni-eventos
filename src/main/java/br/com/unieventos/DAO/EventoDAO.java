package br.com.unieventos.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.unieventos.modelo.Evento;
import br.com.unieventos.util.HibernateUtil;

public class EventoDAO {
	
	public void cadastra(Evento evento) {
		Transaction trans = null;
		Session session = HibernateUtil.getSession().openSession();
		
		try{
			
			trans = session.beginTransaction();
			session.saveOrUpdate(evento);
			trans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	} 
	
	public List<Evento> recuperaTodosEventos() {

		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			List<Evento> eventos = session.createQuery("from Evento", Evento.class).list();
			trans.commit();
			
			return eventos;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;
		
	}
	
public Evento findById(long codigo) {
		
		Transaction trans = null;
		
		Session session = HibernateUtil.getSession().openSession();
		
		try {
			
			trans = session.beginTransaction();
			Evento evento = session.find(Evento.class, codigo);
			trans.commit();
			
			return evento;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
		
	}
	
}
