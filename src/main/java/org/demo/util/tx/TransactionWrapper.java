package org.demo.util.tx;

import java.io.Closeable;
import java.io.IOException;

import javax.persistence.EntityManager;

public class TransactionWrapper implements Closeable {
	
	private final EntityManager em ;
	
	private final boolean isNewEntityManager ; // créé pour la durée de vie du Wrapper

	private final boolean isNewTransaction; // créé pour la durée de vie du Wrapper

	
	public TransactionWrapper(EntityManager em, boolean isNewEntityManager, boolean isNewTransaction) {
		super();
		this.em = em ;
		this.isNewEntityManager = isNewEntityManager ;
		this.isNewTransaction = isNewTransaction ;
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void commit() {
		if ( isNewTransaction ) {
			em.getTransaction().commit();
		}
	}

	@Override
	public void close() {
		if ( isNewTransaction ) {
			if ( em.getTransaction().isActive() ) { // no commit
				em.getTransaction().rollback(); // because 
			}
		}
		
		if ( isNewEntityManager ) {
			em.close();
			EntityManagerThreadLocal.remove();
		}
	}

}
