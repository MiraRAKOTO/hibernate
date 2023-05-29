package gestionSalle.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import gestionSalle.model.Occuper;
import gestionSalle.model.Prof;
import gestionSalle.model.Salle;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
			Configuration configuration= new Configuration();
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "org.postgresql.Driver");
			settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/gestionSalle");
			settings.put(Environment.USER,"postgres");
			settings.put(Environment.PASS, "1234");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
			settings.put(Environment.SHOW_SQL,"true");
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Prof.class);
			configuration.addAnnotatedClass(Salle.class);
			configuration.addAnnotatedClass(Occuper.class);
			
			ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory= configuration.buildSessionFactory(serviceRegistry);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
