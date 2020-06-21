package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;


public class CreateCourseandReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session= factory.getCurrentSession();
		
		try {
			System.out.println("Creating new Course Object");
			
			session.beginTransaction();
			
			Course tempcourse=new Course(" Learn Amazon Web Services");
			
			tempcourse.addReview(new Review("A very good course"));
			tempcourse.addReview(new Review("Learning was fun"));
			tempcourse.addReview(new Review("Skills developed"));
			System.out.println("Saving the course");
			session.save(tempcourse);
			
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
