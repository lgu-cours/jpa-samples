package org.demo;

import javax.persistence.EntityManager;

import org.demo.entities.Badge;

public class Refresh {

	 public static void main(String[] args) 
	 {
		 EntityManager em = Helper.init();
		 System.out.println("Ready...");
		 
		 //mergeTest1(em);
		 //merge(em, getBadge(311) );
		 System.out.println("-----");
		 refresh1(em );
		 Helper.finished(em);
	 }
	 
	 public static void refresh1(EntityManager em) 
	 {
		 System.out.println("find...");
		 Badge badge = em.find(Badge.class, 305);
		 
		 System.out.println("Badge after find : " + badge );

		 badge.setAuthorizationLevel((short) 2 ) ;
		 System.out.println("Badge after change : " + badge );

		 System.out.println("refresh...");
		 em.refresh(badge);

		 System.out.println("Badge after refresh : " + badge );
	 }
	 
}
