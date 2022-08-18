package com.amar.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.amar.tut.Student;

public class HQLDemo {

	public static void main(String[] args) {
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s = f.openSession();
		//Transaction tx = s.beginTransaction();
		
		/*
		 * String query = "from Student as s where s.city= :x"; Query q =
		 * s.createQuery(query); q.setParameter("x", "Pune"); List<Student> list =
		 * q.list(); for(Student s1:list) { System.out.println(s1.getName()+
		 * ": "+s1.getCerti().getCourse()); }
		 */
		
		Transaction tx = s.beginTransaction();
		/*
		 * String query = "delete from Student as s where s.city=:c"; Query q2 =
		 * s.createQuery(query); q2.setParameter("c", "Solapur");
		 * 
		 * int result = q2.executeUpdate(); System.out.println("Deleted : "+result);
		 */
		
		/*
		 * String query = "update Student as s set s.city=:c where s.name=:n"; Query
		 * q3=s.createQuery(query); q3.setParameter("c", "Solapur");
		 * q3.setParameter("n", "Raman"); int res = q3.executeUpdate();
		 * System.out.println(res+" updated.");
		 */
		
		String query = "select q.questionId, q.question, a.answer from Question as q INNER JOIN q.answers as a";
		Query q4 = s.createQuery(query);
		List<Object[]> list4= q4.getResultList();
		for(Object[] obj:list4) {
			System.out.println(Arrays.toString(obj));
		}
		tx.commit();
		s.close();
		f.close();
	}

}
