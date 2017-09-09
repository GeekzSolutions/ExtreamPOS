package com.geekz.orm.hibernate;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.geekz.orm.GeekzORM;
import com.geekz.pos.model.Client;
import com.geekz.pos.model.ClientOrder;
import com.geekz.pos.model.ItemOrder;
import com.geekz.pos.model.ItemRepo;
import com.geekz.pos.model.Teller;

public class HibernateOperator implements GeekzORM {

	private static HibernateOperator instance = null;

	public static HibernateOperator getInstance() {
		if (instance == null) {
			instance = new HibernateOperator(); 
			instance.config();
		}
		return instance;
	}

	SessionFactory factory = null;

	private void config() {
		Configuration configuration = new Configuration().configure();
		configuration = this.setAnnotationClasses(configuration);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        factory = configuration
                .buildSessionFactory(builder.build());
	}
	
	private Configuration setAnnotationClasses(Configuration configuration) {
		configuration.addAnnotatedClass(Teller.class);
		configuration.addAnnotatedClass(Client.class);
		configuration.addAnnotatedClass(ClientOrder.class);
		configuration.addAnnotatedClass(ItemRepo.class);
		configuration.addAnnotatedClass(ItemOrder.class);
		
		return configuration;
	}

	public Object read(Class<?> clz, Integer id) {
		Session sesn = factory.openSession();
		Transaction tx = null;
		Object results = null;
		try {
			tx = sesn.beginTransaction();
			results = sesn.get(clz, id);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sesn.close();
		}
		return results;
	}

	public Object edit(Class<?> clz, Object saveObj) {

		Transaction tx = null;
		Session session = factory.openSession();
		try {
			tx = session.beginTransaction();
			session.update(saveObj);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return saveObj;
	}

	public Object add(Class<?> clz, Object saveObj) {
		Transaction tx = null;
		Session session = factory.openSession();
		try {
			tx = session.beginTransaction();
			Serializable savedID = session.save(saveObj);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return saveObj;
	}

	public Object[] delete() {
		// TODO Auto-generated method stub
		return null;
	}
}
