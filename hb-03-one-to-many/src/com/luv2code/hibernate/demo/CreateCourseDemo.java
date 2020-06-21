package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Instructor Object");
			
			session.beginTransaction();
			
			Instructor tempins=new Instructor("Aditya","Raj","adra0501@outlook.com");
			
			InstructorDetail tempinsdetail = new InstructorDetail("https://youtube.com/techmania", "Reading");
			
			tempins.setInstructordetail(tempinsdetail);
			
			session.save(tempins);
			
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
