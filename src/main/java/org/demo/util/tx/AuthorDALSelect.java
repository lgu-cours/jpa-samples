package org.demo.util.tx;

import java.util.List;

import javax.persistence.EntityManager;

import org.demo.entities.Author;

public class AuthorDALSelect {

	public Author findOne( long entityId ){
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			return em.find( Author.class, entityId );
		}
	}
	public List<Author> findAll(){
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			return em.createQuery( "from " + Author.class.getName() ).getResultList();
		}
	}
}
