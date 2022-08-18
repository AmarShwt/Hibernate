package com.amar.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		
		System.out.println("Embeddable Annotation Demo....");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Student st1 = new Student();
		st1.setStudentId(3);
		st1.setName("Taman");
		st1.setEmail("taman@test.com");
		st1.setCity("Solapur");
		
		Certificate certi = new Certificate();
		certi.setCourse("Demo");
		certi.setDuration("3 Months");
		
		st1.setCerti(certi);
		
		session.save(st1);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done..");

	}

}
