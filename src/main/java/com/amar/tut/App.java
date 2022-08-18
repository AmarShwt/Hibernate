package com.amar.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started!" );
        
        Configuration cfg= new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction tr = session.beginTransaction();
        
        Student st = new  Student();
        st.setStudentId(3);
        st.setName("Amar123");
        st.setEmail("test123@test.com");
        
        Address add = new Address();
        add.setStreet("Sam");
        add.setCity("Singh");
        add.setOpen(true);
        add.setX(123.232);
        add.setAddedDate(new Date());
        
        FileInputStream fis = new FileInputStream("src/main/java/dashboard_logo1.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
        session.save(st);
        session.save(add);
        tr.commit();
        session.close();
        factory.close();
        System.out.println("Done");
    }
}
