package org.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.demo.entities.Author;

public class AuthorDAO {

	EntityManager entityManager;
	
//	public final void setClazz( Class< T > clazzToSet ){
//	this.clazz = clazzToSet;
//	}
	public Author findOne( long entityId ){
		return entityManager.find( Author.class, entityId );
	}
	public List<Author> findAll(){
		return entityManager.createQuery( "from " + Author.class.getName() ).getResultList();
	}
	public void create( Author entity ){
		entityManager.persist( entity );
	}
	public Author update( Author entity ){
		return entityManager .merge( entity );
	}
	public void delete( Author entity ){
		entityManager.remove( entity );
	}
	public void deleteById( long entityId ){
		Author entity = findOne( entityId );
		delete( entity );
	}
}
