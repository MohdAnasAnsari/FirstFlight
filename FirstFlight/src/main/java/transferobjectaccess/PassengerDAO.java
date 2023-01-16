package transferobjectaccess;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Configuration.HibernateConfig;
import models.Flight;
import models.Passenger;

public class PassengerDAO {

	@SuppressWarnings("unchecked")
	public List<Flight> getAllDetailsByOriginDate(String origin, String date, String target) {

		Transaction transaction = null;
		Session dbSession = null;
		List<Flight> list = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query query = dbSession
					.createQuery("from Flight f where f.origin = :origin and f.target = :target and f.dob = :date");
			query.setParameter("origin", origin);
			query.setParameter("target", target);
			query.setParameter("date", date);
			list = query.list();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			dbSession.close();
		}
		return list;

	}

	public void insertPassengerInDB(Passenger p) {

		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			dbSession.save(p);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			dbSession.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Passenger> getAllDetails() {

		Session dbSession = null;
		List<Passenger> list = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			list = dbSession.createQuery("from Passenger").list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbSession.close();
		}
		return list;

	}

	public Passenger getPassengerById(int id) {
		
		Transaction transaction = null;
		Session dbSession = null;
		Passenger p = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			p = dbSession.get(Passenger.class, id);
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		return p;
		
	}

	public Passenger deletePassenger(Passenger p) {
		
		Transaction transaction = null;
		Session dbSession = null;
		try {
			dbSession = HibernateConfig.getSessionFactory().openSession();
			transaction = dbSession.beginTransaction();
			dbSession.delete(p);
			transaction.commit();
		}catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			dbSession.close();
		}
		return p;
		
	}

}
