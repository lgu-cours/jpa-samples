package org.demo.util.tx;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerAccessor {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tests"); 

	public static EntityManagerWrapper getEntityManagerWrapper() {
		boolean created = false ;
		EntityManager em = EntityManagerThreadLocal.get();
		if ( em == null ) {
			em = emf.createEntityManager(); 
			// Set EntityManager in ThreadLocal
			EntityManagerThreadLocal.set(em);
			created = true ;
		}
		return new EntityManagerWrapper(em, created) ;
	}
}
