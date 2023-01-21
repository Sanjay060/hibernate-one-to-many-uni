package com.p4.demo;

import com.p4.demoentity.Instructor;
import com.p4.demoentity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CretaeInstructor {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hibernate-example1");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Instructor i=new Instructor("sanjay","c338068@gmail.com");
			InstructorDetail i1=new InstructorDetail("coding");
			i.setInstructor_detail(i1);
			entityTransaction.begin();
			System.out.println("saving");
			entityManager.persist(i);
			System.out.println("saved");
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
