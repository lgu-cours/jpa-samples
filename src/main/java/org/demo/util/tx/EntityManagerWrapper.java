package org.demo.util.tx;

import java.io.Closeable;
import java.io.IOException;

import javax.persistence.EntityManager;

public class EntityManagerWrapper implements Closeable {
	
	private final EntityManager em ;
	
	private final boolean isNewEntityManager ; // créé pour la durée de vie du Wrapper

	
	public EntityManagerWrapper(EntityManager em, boolean isNewEntityManager) {
		super();
		this.em = em ;
		this.isNewEntityManager = isNewEntityManager ;
	}


	public EntityManager getEm() {
		return em;
	}


	@Override
	public void close() {
		if ( isNewEntityManager ) {
			em.close();
			EntityManagerThreadLocal.remove();
		}
	}

}
