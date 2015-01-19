package org.demo.queries;

import java.util.List;

import javax.persistence.EntityManager;

import org.demo.Helper;
import org.demo.entities.Badge;

public class BadgeQueriesRunner {

	 public static void main(String[] args) 
	 {
		EntityManager em = Helper.init();
		System.out.println("Ready...");
		System.out.println("-----");

		BadgeQueries badgeQueries = new BadgeQueries();
		List<Integer> list = badgeQueries.getBadgeNumbers(em);
		System.out.println("Number of badges : " + list.size() );
		for ( Integer i : list ) {
			System.out.println(" . badge number : " + i );
		}
		 
		Helper.finished(em);
	 }
	 
	 public static void update(EntityManager em) 
	 {
		 System.out.println("find...");
		 Badge badge = em.find(Badge.class, 305);
		 if ( badge != null ) {
			 System.out.println("Found : " + badge );

			 em.getTransaction().begin();

			 badge.setAuthorizationLevel((short) 555 );
			 System.out.println("Updated in memory : " + badge );
			 
			 em.getTransaction().commit();
			 
			 System.out.println("Commited");
		 }
		 else {
			 System.out.println("Not found");
		 }
		 
	 }
	 
}
