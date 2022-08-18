package com.amar.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		e1.setEmpId(1);
		e1.setEmpName("Ram");

		e2.setEmpId(2);
		e2.setEmpName("Shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setProjId(11);
		p1.setProject("Test");
		
		p2.setProjId(12);
		p2.setProject("Demo");
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		
		List<Project> proList = new ArrayList<Project>();
		proList.add(p1);
		proList.add(p2);
		
		e1.setProjects(proList);
		p2.setEmployees(empList);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Done");
		
	}

}
