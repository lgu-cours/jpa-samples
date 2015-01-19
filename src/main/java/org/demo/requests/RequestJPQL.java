package org.demo.requests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.demo.Helper;
import org.demo.entities.Badge;

public class RequestJPQL {

	
	public static void main(String[] args) 
	{
		EntityManager em = Helper.init();
		System.out.println("Ready...");
		System.out.println("-----");
		
		System.out.println("----------");
		request1(em);
		System.out.println("----------");
		request2(em);
		System.out.println("----------");
		request3(em);
		System.out.println("----------");
		request4(em);
		System.out.println("----------");
		requestUpdate(em); 
		System.out.println("----------");
		requestDelete(em); 
		System.out.println("----------");
		 
		Helper.finished(em);
	}
	 
	public static void request1(EntityManager em) 
	{
		final String QUERY = "SELECT b.badgeNumber FROM Badge b " ;
		
		System.out.println("create query ...");
		Query query = em.createQuery( QUERY ) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Integer> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Integer i : list ) {
			System.out.println(" . badge number : " + i );
		}
		
	 }
	 
	public static void request2(EntityManager em) 
	{
		final String QUERY = "SELECT b FROM Badge b " ;
		
		System.out.println("create query ...");
		Query query = em.createQuery( QUERY ) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge b : list ) {
			System.out.println(" . badge : " + b.getBadgeNumber() + " " + b.getAuthorizationLevel() );
		}
		
	 }
	 
	public static void request3(EntityManager em) 
	{
		final String QUERY = "SELECT b FROM Badge b WHERE b.badgeNumber >= :min AND b.badgeNumber <= :max  " ;
		
		System.out.println("create query ...");
		Query query = em.createQuery( QUERY ) ;
		
		System.out.println("set parameters ...");
		query.setParameter("min", 100);
		query.setParameter("max", 310);
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge b : list ) {
			System.out.println(" . badge : " + b.getBadgeNumber() + " " + b.getAuthorizationLevel() );
		}
		
	 }
	 
	public static void request4(EntityManager em) 
	{
		final String QUERY = "SELECT b FROM Badge b WHERE b.badgeNumber >= ?11 AND b.badgeNumber <= ?12  " ;
		
		System.out.println("create query ...");
		Query query = em.createQuery( QUERY ) ;
		
		System.out.println("set parameters ...");
		query.setParameter(11, 302);
		query.setParameter(12, 310);
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge b : list ) {
			System.out.println(" . badge : " + b.getBadgeNumber() + " " + b.getAuthorizationLevel() );
		}
		
	 }
	 
	public static void requestUpdate(EntityManager em) 
	{
		final String QUERY = "UPDATE Badge b SET b.authorizationLevel = 123  WHERE b.badgeNumber > 300 " ;
		
		System.out.println("create query : " + QUERY );
		Query query = em.createQuery( QUERY ) ;
		
		em.getTransaction().begin();
		
		//--- Execute query
		System.out.println("execute query ...");
		int r = query.executeUpdate();

		em.getTransaction().commit();
		
		System.out.println("Return : " + r );
		
	 }

	public static void requestDelete(EntityManager em) 
	{
		final String QUERY = "DELETE Badge b WHERE b.badgeNumber > 400" ;
		
		System.out.println("create query : " + QUERY );
		Query query = em.createQuery( QUERY ) ;
		
		em.getTransaction().begin();
		
		//--- Execute query
		System.out.println("execute query ...");
		int r = query.executeUpdate();

		em.getTransaction().commit();
		
		System.out.println("Return : " + r );
		
	 }
	 
}
