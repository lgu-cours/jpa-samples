package org.demo;

import javax.persistence.EntityManager;

import org.demo.entities.Badge;

public class DiferredUpdate {

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
		 
		 Badge badge301 = getBadge(301);
		 Badge badge302 = getBadge(302);
		 
		 em.getTransaction().begin();
		 
		 System.out.println("persist...");
		 em.persist(badge301);
		 System.out.println("contains : " + em.contains(badge301) );
		 
		 System.out.println("remove...");
		 em.remove(badge301);
		 System.out.println("contains : " + em.contains(badge301) );
		 
		 System.out.println("persist...");
		 em.persist(badge302);
		 System.out.println("contains : " + em.contains(badge302) );

		 em.getTransaction().commit();
		 
		 Helper.finished(em);
	 }
	 
}
