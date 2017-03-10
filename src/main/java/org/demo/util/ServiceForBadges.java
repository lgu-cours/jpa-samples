package org.demo.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.demo.entities.Author;
import org.demo.util.tx.AuthorDALService;
import org.demo.util.tx.EntityManagerAccessor;
import org.demo.util.tx.EntityManagerWrapper;

public class ServiceForBadges {

	public void getBadges() 
	{
		//EntityManager em = EntityManagerThreadLocal.get();
		try ( EntityManagerWrapper emw = EntityManagerAccessor.getEntityManagerWrapper() ) {
			EntityManager em = emw.getEm();
			
			final String QUERY = "SELECT b.badgeNumber FROM Badge b " ;
			
			System.out.println("create query ...");
			//Query query = em.createQuery( QUERY ) ;
			TypedQuery<Integer> query = em.createQuery( QUERY,Integer.class ) ;
			
			//--- Execute query
			System.out.println("execute query ...");
			List<Integer> list = query.getResultList();
			
			System.out.println("Number of badges : " + list.size() );
			for ( Integer i : list ) {
				System.out.println(" . badge number : " + i );
			}
			
//			AuthorDALService svc = new AuthorDALService();
//			Author entity = new Author();
//			entity.setFirstName("aaa bb  cc");
//			entity.setId(1001);
//			svc.create(entity);
			
		} // close
	 }
	 

}
