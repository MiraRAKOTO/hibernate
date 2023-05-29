package gestionSalle.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gestionSalle.model.Prof;
import gestionSalle.model.Salle;
import gestionSalle.util.HibernateUtil;

public class SalleDao {
	
	public void saveSalle(Salle salle) {
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			session.save(salle);
			
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	public void updateSalle(Salle salle) {
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			session.saveOrUpdate(salle);
			
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public Salle getSalleById(long id) {
		Salle salle= null;
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			salle= session.get(Salle.class,id);
			//prof= session.load(Prof.class, id);
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return salle;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Salle> getAllSalles() {
		List<Salle> salles= null;
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			salles= session.createQuery("from Salle s ORDER BY s.codeSalle ASC").getResultList();
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return salles ;
	}
	
	@SuppressWarnings("unchecked")
	public List<Salle> findcontainsByDes(String keyword) {
		List<Salle> salles = null;
		Transaction transaction = null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			salles= session.createQuery("select s from Salle s where s.designationSalle like :keyword ").setParameter("keyword", "%" + keyword + "%").getResultList();
			transaction.commit();
			
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return salles ;
		
	}
	

	public void deleteSalle(long id) {
		Salle salle= null;
		Transaction transaction= null;
		try(Session session= HibernateUtil.getSessionFactory().openSession()){
			transaction= session.beginTransaction();
			
			salle= session.get(Salle.class, id);
			session.delete(salle);
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	
	
	
}
