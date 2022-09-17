package com.map;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// SessionFactory factory = cfg.buildSessionFactory();
		SessionFactory factory = cfg.buildSessionFactory();
		// creatig question
		Question q1 = new Question();
		q1.setQuestionID(1212);
		q1.setQuestion("What is Java ?");

		// creating Answer

		Answer ans = new Answer();
		ans.setAnswerID(343);
		ans.setAnswer("java is a programing language");
		ans.setQuestion(q1);
		q1.setAnswer(ans);

		// creatig question
		Question q2 = new Question();
		q2.setQuestionID(242);
		q2.setQuestion("What is collection framwork ?");

		// creating Answer

		Answer ans1 = new Answer();
		ans1.setAnswerID(344);
		ans1.setAnswer("API to work with group of objects");
		ans1.setQuestion(q2);
		q2.setAnswer(ans1);

		// session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		// save
		s.save(q1);
		s.save(q2);
		s.save(ans);
		s.save(ans1);

		tx.commit();

		// Fetching Data.......

		Question newQ = (Question) s.get(Question.class, 1212);
		Question newQ1 = (Question) s.load(Question.class, 242);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());

		System.out.println(newQ1.getQuestion());
		System.out.println(newQ1.getAnswer().getAnswer());
		s.close();

		factory.close();

	}

}
