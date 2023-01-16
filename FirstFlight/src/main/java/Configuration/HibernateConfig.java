package Configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import models.Flight;
import models.Passenger;

public class HibernateConfig {

	private static SessionFactory sFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sFactory == null) {
			try {
				Configuration cfg = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "samad");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				//settings.put(Environment.HBM2DDL_AUTO, "update");
				settings.put(Environment.HBM2DDL_AUTO, "create");
				
				cfg.setProperties(settings);
				cfg.addAnnotatedClass(Flight.class);
				cfg.addAnnotatedClass(Passenger.class);
				ServiceRegistry servReg = new StandardServiceRegistryBuilder()
						.applySettings(cfg.getProperties()).build();
				sFactory = cfg.buildSessionFactory(servReg);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sFactory;
	}
}