package com.amar.casacade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.amar.map.Answer;
import com.amar.map.Question;

public class CascadeDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Question q = new Question();
		q.setQuestionId(11);
		q.setQuestion("What is cascadeing?");
		
		Answer a= new Answer();
		a.setAnswerId(22);
		a.setAnswer("It is testing");
		Answer a1= new Answer();
		a1.setAnswerId(33);
		a1.setAnswer("It is demo");
		Answer a2= new Answer();
		a2.setAnswerId(44);
		a2.setAnswer("It is another functionality given by hibernate");
		List<Answer> list = new ArrayList<Answer>();
		list.add(a);
		list.add(a1);
		list.add(a2);
		q.setAnswers(list);
		s.save(q);
		tx.commit();
		s.close();
		factory.close();
	}

}
