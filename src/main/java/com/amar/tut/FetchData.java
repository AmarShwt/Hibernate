package com.amar.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		System.out.println("Fetching Data from Database...");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		Student st =  (Student)session.get(Student.class, 10);
		System.out.println(st);
		
		Address add = (Address)session.get(Address.class, 1);
		System.out.println(add.getStreet()+":"+add.getCity());
		
		Student st1 = session.get(Student.class, 1);
		System.out.println(st1.getName() +": "+ st1.getCity());
		
		session.close();
		factory.close();
		
		
	}

}
