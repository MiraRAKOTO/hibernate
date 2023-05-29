package gestionSalle.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gestionSalle.model.Occuper;
import gestionSalle.model.Prof;
import gestionSalle.util.HibernateUtil;

public class OccuperDao {

	public void saveOccupe(Occuper occupe) {
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			session.save(occupe);
			
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
}
}
