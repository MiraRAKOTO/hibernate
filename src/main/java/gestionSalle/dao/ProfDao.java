package gestionSalle.dao;

import java.util.List;

import org.hibernate.*;

import gestionSalle.model.Prof;
import gestionSalle.util.HibernateUtil;

public class ProfDao {
	
	
	public void saveProf(Prof prof) {
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			session.save(prof);
			
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	public void updateProf(Prof prof) {
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			session.saveOrUpdate(prof);
			
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}

	public Prof getProfById(long id) {
		Prof prof= null;
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			prof= session.get(Prof.class,id);
			//prof= session.load(Prof.class, id);
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return prof;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prof> getAllProfs() {
		List<Prof> profs= null;
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			profs= session.createQuery("from Prof p ORDER BY p.codeProf ASC").getResultList();
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return profs ;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prof> findcontains(String keyword) {
		List<Prof> profs = null;
		Transaction transaction = null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			profs= session.createQuery("select p from Prof p where p.nomProf like :keyword ").setParameter("keyword", "%" + keyword + "%").getResultList();
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return profs ;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Prof> findcontainsById(long keyword) {
		List<Prof> profs = null;
		Transaction transaction = null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			profs= session.createQuery("select p from Prof p where p.codeProf like :keyword ").setParameter("keyword", "%" + keyword + "%").getResultList();
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return profs ;
		
	}
	
	
	
	
	public void deletProf(long id) {
		Prof prof= null;
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			prof= session.get(Prof.class, id);
			session.delete(prof);
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	
}

