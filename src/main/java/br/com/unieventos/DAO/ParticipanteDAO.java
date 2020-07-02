package br.com.unieventos.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.unieventos.modelo.Participante;
import br.com.unieventos.util.HibernateUtil;

public class ParticipanteDAO {

	public void cadastra(Participante pessoa) {
		Transaction trans = null;
		Session session = HibernateUtil.getSession().openSession();

		try {

			trans = session.beginTransaction();
			session.saveOrUpdate(pessoa);
			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public List<Participante> recuperaTodosParticipantes() {
		Transaction trans = null;
		Session session = HibernateUtil.getSession().openSession();

		try {

			trans = session.beginTransaction();
			List<Participante> participante = session.createQuery("from Participante", Participante.class).list();
			trans.commit();
			return participante;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return null;

	}
}
