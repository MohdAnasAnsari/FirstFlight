package transferobjectaccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Configuration.HibernateConfig;
import models.Flight;
import models.Passenger;

public class FlightDAO {
	
	public void insertFlightInDB(Flight f)	{
		
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			dbSession.save(f);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public  List<Flight> getAllDetails()	{
		
		Session dbSession = null;
		List<Flight> list= null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			list = dbSession.createQuery("from Flight").list();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		return list;
		
	}
	
	public Flight getFlightById(int flightId) {
		
		Transaction transaction = null;
		Session dbSession = null;
		Flight f = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			f = dbSession.get(Flight.class, flightId);
			
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		return f;
		
	}
	
	public Flight updateFlight(Flight f) {
		
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			dbSession.update(f);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		return f;
	
	}

	public Flight deleteFlight(Flight f) {
		
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			dbSession.delete(f);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		return f;
		
	}
	
	public void relation(Flight f, List<Passenger> list) {
		
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			f.setPassenger(list);
			dbSession.save(f);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
	
	}
	
}
