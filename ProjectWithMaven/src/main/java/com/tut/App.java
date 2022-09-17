package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started......");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Student
		Student st = new Student();
		st.setId(110);
		st.setName("Rakesh Varma");
		st.setCity("pune");
		System.out.println(st);

		// Creating Address
		Address ad = new Address();
		ad.setStreet("Street3");
		ad.setCity("pune");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(123.4325);

		// Reading image
		// FileInputStream fis = new FileInputStream("src/main/java/pic.png");
		FileInputStream fis = new FileInputStream("src/main/java/pic.png.jpg");
		byte[] data = new byte[fis.available()];
		ad.setImage(data);

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();

		System.out.println("Done");

	}
}
