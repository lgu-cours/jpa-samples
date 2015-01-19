package org.demo;

import javax.persistence.EntityManager;

import org.demo.entities.Badge;
import org.demo.entities.Department;
import org.demo.primarykey.DepartmentPK;

public class Find {

	 public static void main(String[] args) 
	 {
		 EntityManager em = Helper.init();
		 System.out.println("Ready...");
		 System.out.println("-----");

		 System.out.println("EntityManager class : " + em.getClass().getCanonicalName() );
		 // For Hibernate : org.hibernate.ejb.EntityManagerImpl

		 find(em, 1 );
		 find(em, 305 );
		 find(em, 900 );
		 
		 Helper.finished(em);
	 }
	 
	 public static void find(EntityManager em, int id ) 
	 {
		 System.out.println("find ( id = " + id + " ) ...");
		 Badge badge = em.find(Badge.class, id);
		 
		 if ( badge != null ) {
			 System.out.println("Found : " + badge );
		 }
		 else {
			 System.out.println("Not found");
		 }
		 
		 System.out.println("em.contains ? " + em.contains(badge) );
	 }
	 
	 public static void findWithPK(EntityManager em) 
	 {
		 DepartmentPK pk = new DepartmentPK(2, "ABC");
		 System.out.println("find...");
		 Department dep = em.find(Department.class, pk);
		 /*
		 if ( badge != null ) {
			 System.out.println("Found : " + badge );
		 }
		 else {
			 System.out.println("Not found");
		 }
		 */
	 }
	 
}
