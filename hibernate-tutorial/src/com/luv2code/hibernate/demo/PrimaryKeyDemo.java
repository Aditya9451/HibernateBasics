package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student Object");
			Student student= new Student("Aditya", "Raj", "aditya5194@gmail.com");
			Student student2= new Student("Neha", "Kataria", "neha@gmail.com");
			Student student3= new Student("Khushboo", "Sharma", "khushboo@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			factory.close();
		}

	}

}
