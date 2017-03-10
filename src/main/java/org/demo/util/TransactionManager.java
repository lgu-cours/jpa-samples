package org.demo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TransactionManager {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tests"); 
	
	public final static Transaction beginTransaction() {
//		EntityManager em = emf.createEntityManager(); 
//		em.getTransaction().begin();
		return new Transaction(emf);
	}
	
	protected final static EntityManager createEntityManagerFactory() {
		return emf.createEntityManager(); 
	}
}
