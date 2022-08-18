package com.amar.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question q1 = new Question();
		q1.setQuestion("What is Java?");
		q1.setQuestionId(1);
		
		//creating answer
		Answer answer = new Answer();
		answer.setAnswerId(11);
		answer.setAnswer("Java is programming language");
		answer.setQuestion(q1);
		
		Answer answer1 = new Answer();
		answer1.setAnswerId(12);
		answer1.setAnswer("Java is used to develope softwares");
		answer1.setQuestion(q1);
		
		Answer answer2 = new Answer();
		answer2.setAnswerId(13);
		answer2.setAnswer("Java platform independent language.");
		answer2.setQuestion(q1);
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		q1.setAnswers(list);
		
		//open session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(answer);
		session.save(answer1);
		session.save(answer2);
		 
		
		//fetching data
		
		/*
		 * Question q = (Question) session.get(Question.class, 1);
		 * System.out.println("Question :" + q.getQuestionId());
		 * System.out.println("Question :" + q.getQuestion());
		 * System.out.println("Answer: "+q.getAnswers().size());
		 */
		
		/*
		 * for (Answer a : q.getAnswers()) { System.out.println(a.getAnswer()); }
		 */
		
		tx.commit();
		
		session.close();
		factory.close();
		System.out.println("Done");
	}

}
