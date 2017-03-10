package org.demo.util.tx;

import javax.persistence.EntityManager;

import org.demo.entities.Author;

public class AuthorDALCreate {

	public void create( Author entity ){
		System.out.println("Author create...");
		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
			EntityManager em = tx.getEm();
			em.persist( entity );
			tx.commit();
		}
	}
}
