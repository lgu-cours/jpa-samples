package org.demo;

import javax.persistence.EntityManager;

import org.demo.entities.Badge;

public class PersistSameInstance {

	 public static Badge getBadge(int badgeNumber ) 
	 {
			Badge badge = new Badge();
			badge.setBadgeNumber(badgeNumber);
			badge.setAuthorizationLevel((short)(1000 + badgeNumber) );
			return badge ;
	 }

	 public static void main(String[] args) 
	 {
		 EntityManager em = Helper.init();
		 System.out.println("Ready...");
		 
		 
		 em.getTransaction().begin();
		 
		 Badge badge = new Badge();
		 badge.setBadgeNumber(305);
		 badge.setAuthorizationLevel((short) 1305 );
		 
		 System.out.println("persist...");
		 em.persist(badge);

		 badge.setAuthorizationLevel((short) 2000 );
		 
		 System.out.println("commit..." );

		 em.getTransaction().commit();
		 
		 Helper.finished(em);
	 }
	 
}
