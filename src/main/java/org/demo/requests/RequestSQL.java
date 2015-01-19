package org.demo.requests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.demo.Helper;
import org.demo.entities.Badge;

public class RequestSQL {

	
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
		requestDelete(em); 
		System.out.println("----------");
		requestInsert(em); 
		System.out.println("----------");
		 
		Helper.finished(em);
	}
	 
	public static void request1(EntityManager em) 
	{
		final String QUERY = "SELECT * FROM BADGE" ;
		
		Query query = em.createNativeQuery( QUERY, Badge.class) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge o : list ) {
			System.out.println(" . badge  : " + o );
		}
		
	 }
	 
	public static void request2(EntityManager em) 
	{
		final String QUERY = "SELECT BADGE_NUMBER FROM BADGE" ;
		
		Query query = em.createNativeQuery( QUERY ) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Object> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Object o : list ) {
			System.out.println(" . badge  : " + o  + "   class " + o.getClass().getCanonicalName() );
		}
		
	 }
	 
	public static void request3(EntityManager em) 
	{
		//final String QUERY = "SELECT BADGE_NUMBER, AUTHORIZATION_LEVEL FROM BADGE WHERE BADGE_NUMBER >= 300 " ;
		final String QUERY = "SELECT BADGE_NUMBER FROM BADGE WHERE BADGE_NUMBER >= 300 " ;
		
		System.out.println("create a NATIVE query ...");
		Query query = em.createNativeQuery( QUERY, Badge.class) ;
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge o : list ) {
			System.out.println(" . badge  : " + o );
		}
		
	 }

	public static void request4(EntityManager em) 
	{
		final String QUERY = "SELECT * FROM BADGE WHERE BADGE_NUMBER >= ? AND BADGE_NUMBER <= ?" ;
		
		Query query = em.createNativeQuery( QUERY, Badge.class) ;
		
		query.setParameter(1, 300);
		query.setParameter(2, 310);
		
		//--- Execute query
		System.out.println("execute query ...");
		List<Badge> list = query.getResultList();
		
		System.out.println("Number of badges : " + list.size() );
		for ( Badge o : list ) {
			System.out.println(" . badge  : " + o );
		}
		
	 }
	 
	public static void requestDelete(EntityManager em) 
	{
		final String QUERY = "DELETE FROM BADGE WHERE BADGE_NUMBER > 600" ;
		
		System.out.println("create query : " + QUERY );
		Query query = em.createNativeQuery( QUERY ) ;
		
		em.getTransaction().begin();
		
		//--- Execute query
		System.out.println("execute query ...");
		int r = query.executeUpdate();

		em.getTransaction().commit();
		
		System.out.println("Return : " + r );
	 }
	 
	public static void requestInsert(EntityManager em) 
	{
		final String QUERY = "INSERT INTO BADGE ( BADGE_NUMBER , AUTHORIZATION_LEVEL ) VALUES ( 801, 3 ) " ;
		
		System.out.println("create query : " + QUERY );
		Query query = em.createNativeQuery( QUERY ) ;
		
		em.getTransaction().begin();
		
		//--- Execute query
		System.out.println("execute query ...");
		int r = query.executeUpdate();

		em.getTransaction().commit();
		
		System.out.println("Return : " + r );
	 }
	 
}
