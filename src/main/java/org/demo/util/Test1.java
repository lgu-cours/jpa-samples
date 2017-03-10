package org.demo.util;

import java.io.IOException;

import javax.persistence.EntityManager;

public class Test1 {

	public static void main(String[] args) {

		EntityManager em = TransactionManager.createEntityManagerFactory() ;
		
		System.out.println("Set EM in ThreadLocal...");
		EntityManagerThreadLocal.set(em);

		//TransactionManager.beginTransaction(); // Expected Error
		
		System.out.println("EntityManagerThreadLocal.get() : " + EntityManagerThreadLocal.get());
		
		System.out.println("Remove EM from ThreadLocal...");
		EntityManagerThreadLocal.remove();
		
		System.out.println("EntityManagerThreadLocal.get() : " + EntityManagerThreadLocal.get());
		
		Transaction tx = TransactionManager.beginTransaction();
		System.out.println("Transaction started");
		
			tx.close();
			System.out.println("Transaction closed");
	}

}
