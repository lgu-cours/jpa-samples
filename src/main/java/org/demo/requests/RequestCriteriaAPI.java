package org.demo.requests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.demo.Helper;
import org.demo.entities.Badge;

public class RequestCriteriaAPI {

	
	public static void main(String[] args) 
	{
		EntityManager em = Helper.init();
		System.out.println("Ready...");
		System.out.println("-----");
		
		System.out.println("----------");
		request1JPQL(em);
		System.out.println("----------");
		request1(em);
		System.out.println("----------");
		 
		Helper.finished(em);
	}
	 
	public static void request1JPQL(EntityManager em) 
	{
		final String QUERY = "SELECT b FROM Badge b where badgeNumber = 305" ;
		
		System.out.println("create query ...");
		Query query = em.createQuery( QUERY ) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge i : list ) {
			System.out.println(" . badge number : " + i );
		}
		
	 }
	public static void request1(EntityManager em) 
	{
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
		CriteriaQuery<Badge> c = cb.createQuery(Badge.class); 
		
		//--- Criteria definition
		Root<Badge> badge = c.from(Badge.class); 
		c.select(badge) 
		 .where(cb.equal(badge.get("badgeNumber"), 305 )); 
		
		
		System.out.println("create query ...");
		Query query = em.createQuery( c ) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge i : list ) {
			System.out.println(" . badge number : " + i );
		}
		
	 }
	 
	 
}
