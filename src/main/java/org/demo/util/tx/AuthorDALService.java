package org.demo.util.tx;

import java.util.List;

import javax.persistence.EntityManager;

import org.demo.entities.Author;

public class AuthorDALService {

//	EntityManager entityManager;
	
//	public final void setClazz( Class< T > clazzToSet ){
//	this.clazz = clazzToSet;
//	}
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
	public void create( Author entity ){
		System.out.println("Author create...");
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			em.persist( entity );
		}
	}
	public Author update( Author entity ){
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			return em .merge( entity );
		}
	}
	public void delete( Author entity ){
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			em.remove( entity );
		}
	}
	public void deleteById( long entityId ){
		Author entity = findOne( entityId );
		if ( entity != null ) {
			delete( entity );
		}
	}
}
