package org.demo;

import javax.persistence.EntityManager;

import org.demo.entities.Badge;

public class MergeTwoInstances {

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
		 
		 //mergeTest1(em);
		 //merge(em, getBadge(311) );
		 System.out.println("-----");
		 merge2(em, getBadge(311) );
		 System.out.println("-----");
		 merge3(em, getBadge(311) );
		 System.out.println("-----");
		 
		 Helper.finished(em);
	 }
	 
	 public static void mergeTest1(EntityManager em) 
	 {
		 em.getTransaction().begin();
		 
		 Badge badge = new Badge();
		 badge.setBadgeNumber(305);
		 badge.setAuthorizationLevel((short) 3000 );
		 
		 System.out.println("merge...");
		 em.merge(badge);

		 badge.setAuthorizationLevel((short) 2000 );
		 
		 System.out.println("commit..." );

		 em.getTransaction().commit();
	 }
	 
	 public static void merge(EntityManager em, Badge badge) 
	 {
		 em.getTransaction().begin();

		 System.out.println("merge...");
		 Badge managedBadge = em.merge(badge); // FALSE
		 
		 System.out.println("contains(badge) : " + em.contains(badge));
		 System.out.println("contains(managedBadge) : " + em.contains(managedBadge));
		 
		 em.getTransaction().commit();
	 }
	 
	 public static void merge2(EntityManager em, Badge badge) 
	 {
		 em.getTransaction().begin();

		 System.out.println("merge...");
		 
		 em.merge(badge);
		 
		 boolean b = em.contains(badge); // FALSE
		 
		 System.out.println("contains(badge) : " + b );
		 
		 em.getTransaction().commit();
	 }
	 
	 public static void merge3(EntityManager em, Badge badge) 
	 {
		 em.getTransaction().begin();

		 System.out.println("merge...");
		 
		 Badge managedBadge = em.merge(badge);
		 
		 boolean b1 = em.contains(badge); // FALSE
		 boolean b2 = em.contains(managedBadge); // TRUE 
		 
		 managedBadge.setAuthorizationLevel((short)888);
		 
		 System.out.println("contains(badge) : " + b1 );
		 System.out.println("contains(managedBadge) : " + b2 );
		 
		 em.getTransaction().commit();
	 }
}
