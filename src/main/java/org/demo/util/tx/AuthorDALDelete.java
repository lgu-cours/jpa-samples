package org.demo.util.tx;

import javax.persistence.EntityManager;

import org.demo.entities.Author;

public class AuthorDALDelete {
	
	private Author findOne( long entityId ){
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			return em.find( Author.class, entityId );
		}
	}

	public void delete( Author entity ){
		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
			EntityManager em = tx.getEm();
			em.remove( entity );
			tx.commit();
		}
	}
	public void deleteById( long entityId ){
		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
			Author entity = findOne( entityId );
//			if ( entity != null ) {
//				delete( entity );
//			}
			if ( true ) throw new RuntimeException("My FAKE ERROR on DELETE");
			delete( entity );
			tx.commit();
		}
	}
}
