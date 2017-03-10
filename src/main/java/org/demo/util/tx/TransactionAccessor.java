package org.demo.util.tx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransactionAccessor {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tests"); 

	public static TransactionWrapper openTransaction() {
		boolean created = false ;
		EntityManager em = EntityManagerThreadLocal.get();
		if ( em == null ) {
			em = emf.createEntityManager(); 
			// Set EntityManager in ThreadLocal
			EntityManagerThreadLocal.set(em);
			created = true ;
		}
		
		boolean transactionCreated = false ;
		if ( ! em.getTransaction().isActive() ) {
			em.getTransaction().begin();
			transactionCreated = true ;
		}
		
		return new TransactionWrapper(em, created,transactionCreated) ;
	}
}
