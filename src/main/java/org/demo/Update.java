package org.demo;

import java.util.Date;

import javax.persistence.EntityManager;

import org.demo.entities.Badge;

public class Update {

	 public static void main(String[] args) 
	 {
		 EntityManager em = Helper.init();
		 System.out.println("Ready...");
		 System.out.println("-----");

		 update(em );
		 
		 Helper.finished(em);
	 }
	 
	 public static void update(EntityManager em) 
	 {
		 System.out.println("find...");
		 Badge badge = em.find(Badge.class, 305);
		 if ( badge != null ) {
			 System.out.println("Found : " + badge );

			 em.getTransaction().begin();

			 badge.setAuthorizationLevel((short) 556 );
			 badge.setEndOfValidity( new Date() );
			 System.out.println("Updated in memory : " + badge );
			 
			 em.getTransaction().commit();
			 
			 System.out.println("Commited");
		 }
		 else {
			 System.out.println("Not found");
		 }
		 
	 }
	 
}
