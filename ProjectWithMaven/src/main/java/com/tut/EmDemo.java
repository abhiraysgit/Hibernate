package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(1255);
		student1.setName("Ankit Tiwari");
		student1.setCity("indore");

		certificate certificate = new certificate();
		certificate.setCourse("Andoide");
		certificate.setDuration("2 month");
		student1.setCerti(certificate);

		Student student2 = new Student();
		student2.setId(1256);
		student2.setName("samir khan");
		student2.setCity("Dehli");

		certificate certificate1 = new certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1.5 month");

		student2.setCerti(certificate1);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		// object save

		s.save(student1);
		s.save(student2);
		tx.commit();
		s.close();

		factory.close();
	}

}
