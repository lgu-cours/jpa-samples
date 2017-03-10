package org.demo.util.tx;

import java.sql.Date;
import java.util.List;

import org.demo.entities.Author;
import org.demo.util.ServiceForBadges;


public class UseCase3 {
	
	public static void main(String[] args) {
		
//		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
//			EntityManager em = emw.getEm();
//			System.out.println("TX active ? " + em.getTransaction().isActive() );
//			
//			
//			Author entity = new Author();
//			entity.setFirstName("aaa bb 4444");
//			entity.setId(44444);
//
//			em.merge(entity);
//
//			em.getTransaction().begin();
//
//			//em.merge(entity);
//			
//			//em.getTransaction().commit();
//			em.getTransaction().rollback();
//
//			em.getTransaction().begin();
//			em.getTransaction().commit();
//		}

		
//		EntityManager em = EntityManagerThreadLocal.get();
//		System.out.println(" EM is null ? " + em == null );
//		
		ServiceForBadges svc = new ServiceForBadges();
		svc.getBadges();

		
		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
			ServiceForBadges svc2 = new ServiceForBadges();
			svc2.getBadges();
			
			AuthorDALService authorDAL = new AuthorDALService();

			authorDAL.deleteById(777L);
			
//			EntityManager em = EntityManagerThreadLocal.get();
//			Author author = em.find( Author.class, 777 );
			
			Author author = new Author();
			java.util.Date now = new java.util.Date();
			author.setFirstName("new author 777 " + now.getTime());
			author.setId(777);
			AuthorDALCreate authorDALCreate = new AuthorDALCreate();
			authorDALCreate.create(author);
			
			AuthorDALSelect authorDALSelect = new AuthorDALSelect();
			Author aut2 = authorDALSelect.findOne(777);
			System.out.println("Author found : " + aut2 );

			//if ( true ) throw new RuntimeException("My ERROR");
			
			AuthorDALUpdate authorDALUpdate = new AuthorDALUpdate();
			aut2.setLastName("Update lastName" + now.getTime());
			authorDALUpdate.update(aut2);
			
			tx.commit();
			
			AuthorDALSelect authorSelect = new AuthorDALSelect() ;
			List<Author> authors = authorSelect.findAll();
			System.out.println("List size = " + authors.size());
		} 

//		
//		try ( TransactionWrapper tx = TransactionAccessor.openTransaction() ) {
//			ServiceForBadges svc2 = new ServiceForBadges();
//			svc2.getBadges();			
//		} 
	}
	
}
