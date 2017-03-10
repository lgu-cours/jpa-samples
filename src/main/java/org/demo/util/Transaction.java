package org.demo.util;

import java.io.Closeable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Transaction implements Closeable {

	private final   EntityManager em ;
	
	private final void log(String message) {
		System.out.println("LOG Transaction : " + message);
	}
	
	protected Transaction(EntityManagerFactory emf) {
		super();
		log("start");
		
		EntityManager currentEntityManager = EntityManagerThreadLocal.get();
		if ( currentEntityManager != null ) {
			// Is it an error ?
//			em = currentEntityManager; 
			throw new IllegalStateException("A transaction is already in progress");
		}
		else {
			em = emf.createEntityManager(); 
			// Set EntityManager in ThreadLocal
			EntityManagerThreadLocal.set(em);
		}

		// BEGIN TRANSACTION
		em.getTransaction().begin() ;
		// If the transaction is already active -> IllegalStateException
	}

	public void commit() {
		log("commit");
		
		// COMMIT TRANSACTION
		em.getTransaction().commit();
		// If the transaction is not active -> IllegalStateException

	}
	
	@Override
	public void close()  {
		
		EntityTransaction entityTransaction = em.getTransaction();
		
		// The transaction is still active : the "commit" has not been done due to an Exception
		if ( entityTransaction.isActive() ) {
			// ROLLBACK TRANSACTION
			log("rollback");
			entityTransaction.rollback();
		}
		// else : the COMMIT has been done successfully before the close
		
		// Close the entity manager
		log("close");
		em.close();
		
		// Remove EM from ThreadLocal
		log("ThreadLocal.remove()");
		EntityManagerThreadLocal.remove();
	}

}
