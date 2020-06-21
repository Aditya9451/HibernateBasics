package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student Object");
			Student student= new Student("Aditya", "Raj", "aditya5194@gmail.com");
			session.beginTransaction();
			session.save(student);
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
