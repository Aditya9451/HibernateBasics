package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Student Object");
			
			session.beginTransaction();
			int theId=1;
			InstructorDetail tempinsdet=session.get(InstructorDetail.class,theId );
			
			System.out.println("tempinsdet"+tempinsdet);
			System.out.println("asssociated instructor"+tempinsdet.getInstructor());
			session.getTransaction().commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
