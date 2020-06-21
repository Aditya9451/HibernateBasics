package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student Object");
			Student student= new Student("Preeti", "Kumari", "preeti@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			
			// Retrive student
			
			 session= factory.getCurrentSession();
			 session.beginTransaction();
			Student myStudent=session.get(Student.class,student.getId());
			
			System.out.println("Generated id"+student.getId());
			System.out.println(myStudent);
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		
	}

}
