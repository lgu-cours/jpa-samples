package org.demo.util.tx;

import javax.persistence.EntityManager;

import org.demo.entities.Author;

public class AuthorDALUpdate {

	public void update( Author entity ){
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			em.merge( entity );
			
			AuthorDALDelete authorDALDelete = new AuthorDALDelete();
			authorDALDelete.deleteById(987654);
		}
	}
}
