package br.com.unieventos.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.unieventos.modelo.Atividade;
import br.com.unieventos.modelo.Evento;
import br.com.unieventos.modelo.Feira;
import br.com.unieventos.modelo.MesaRedonda;
import br.com.unieventos.modelo.Minicurso;
import br.com.unieventos.modelo.Palestra;
import br.com.unieventos.modelo.Participante;

public class HibernateUtil {
	private static SessionFactory session;

	public static SessionFactory getSession() {
		if(session == null) {
			try {
				Configuration conf = new Configuration();
				Properties prop = new Properties();
				
				conf.setProperties(prop);
				prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				//Escreva o nome do seu banco de dados depois de 3306/
				prop.put(Environment.URL, "jdbc:mysql://localhost:3306/eventosuninorte");
				prop.put(Environment.USER, "root");
				//Mude para a senha do banco de dados
				prop.put(Environment.PASS, "xxxx");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				prop.put(Environment.HBM2DDL_AUTO, "update");
				conf.setProperties(prop);
				
				conf.addAnnotatedClass(Evento.class);
				conf.addAnnotatedClass(Participante.class);
				conf.addAnnotatedClass(Feira.class);
				conf.addAnnotatedClass(MesaRedonda.class);
				conf.addAnnotatedClass(Minicurso.class);
				conf.addAnnotatedClass(Palestra.class);
				conf.addAnnotatedClass(Atividade.class);

				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
						applySettings(conf.getProperties()).build();
				session = conf.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return session;
	}
	
}


