package com.p4.demo;

import com.p4.demoentity.Courses;
import com.p4.demoentity.Instructor;
import com.p4.demoentity.InstructorDetail;
import com.p4.demoentity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CreateCourses {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			Courses c=new Courses("Python");
			c.add(new Review("too good course"));
			c.add(new Review("average to lengthy"));
			c.add(new Review("good"));
			System.out.println("saving...");
			entityManager.persist(c);
			System.out.println("done...");
			entityTransaction.commit();
		}
		catch(Exception e )
		{
			System.out.println(e);
		}
		finally {
			entityManager.close();
		}

	}

}
