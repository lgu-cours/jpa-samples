package org.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

import org.demo.entities.Badge;

public class GettingStarted {

	 public static void main(String[] args) 
	 { 
		System.out.println("--- Persistence.createEntityManagerFactory(xx)...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tests"); 
		
		System.out.println("--- emf.createEntityManager()...");		
		EntityManager em = emf.createEntityManager(); 
		
		System.out.println("----------");

		
		 // close the EM and EMF when done 
		
		System.out.println("--- closing ...");		
		
        em.close(); 
        emf.close();		
	 }
	 
	 public static boolean contains(EntityManager em , Badge badge ) 
	 {
		 if ( badge != null ) {
			 boolean inPersistenceContext = em.contains(badge);
			 System.out.println("contains("+badge+") : " + inPersistenceContext );
			 return inPersistenceContext ;
		 }
		 else {
			 System.out.println("contains(null) ! " );
			 return false ;
		 }
	 }
	 
	 public static void insertWithTransaction(EntityManager em , Badge badge ) 
	 {
		 System.out.println("insertWithTransaction()...");
		 em.getTransaction().begin();
		 
//		 try {
//			 em.getTransaction().begin();
//			 // Multiple "begin" => error 
//			 // java.lang.IllegalStateException
//		 }
//		 catch ( Throwable t) {
//			 System.out.println("ERROR / begin : " + t );
//		 }
		 
		 try {
			 em.persist(badge);
			 
		 }
		 catch ( Throwable t) {
			 System.out.println("ERROR / persist : " + t );
		 }
		 
		 try {
			 em.getTransaction().commit();
		 }
		 catch ( Throwable t) {
			 System.out.println("ERROR / commit : " + t );
		 }
		 
		 
	 }
	 
	 public static void insertWithFlush(EntityManager em , Badge badge ) 
	 {
		 System.out.println("insertWithFlush(" + badge + ")...");
		 if ( em.getTransaction().isActive() == false ) {
			 em.getTransaction().begin();
		 }

		 em.persist(badge);
		 em.flush();
	 }
	 
	 public static void testPersist(EntityManager em , Badge badge ) 
	 {
		 System.out.println("persist("+badge+")");
		 em.persist(badge);
		 boolean b = em.contains(badge);
		 System.out.println("contains("+badge+") : " + b );
	 }

	 public static void testRemove(EntityManager em , Badge badge ) 
	 {
		 System.out.println("----- testRemove("+badge+") ");
		 boolean b = em.contains(badge);
		 System.out.println("contains("+badge+") : " + b );
		 System.out.println("remove("+badge+")");
		 em.remove(badge);
		 b = em.contains(badge);
		 System.out.println("contains("+badge+") : " + b );
	 }

	 public static Badge find(EntityManager em , int id ) 
	 {
		Badge badge = em.find(Badge.class, id);
		System.out.println( badge != null ? "Found" : "Not found");
		return badge ;
	 }

	 public static Badge getReference(EntityManager em , int id ) 
	 {
		Badge badge = null ;
		try {
			//--- NB : une entité est créée et retournée, même si non trouvée en base
			badge = em.getReference(Badge.class, id);
			System.out.println( "getReference("+id+") : Found");
			//--- Si NOT FOUND : badge != null (instance non valorisée )
			return badge ;
		} catch (EntityNotFoundException e) {
			System.out.println( "getReference("+id+") : Not found (EntityNotFoundException)");
			return null ;
		}
	 }

	 public static void delete(EntityManager em , Badge badge ) 
	 {
		 System.out.println("Try to delete " + badge );
		 if ( badge != null ) {
			 if ( em.contains(badge) ) {
				 System.out.println("Badge is in context" );
				 em.getTransaction().begin();
				 em.remove(badge);
				 em.getTransaction().commit();
			 }
			 else {
				 System.out.println("Badge is NOT in context" );
			 }
		 }
		 else {
			 System.out.println("Badge is null" );
		 }
	 }
	 public static void delete(EntityManager em , int id ) 
	 {
		 // Removal of an entity from the database is not a basic operation 
		 // In order to remove an entity, the entity itself must be "managed"
		 // It must be present in the Persistence Context
		 
		 // 1) find the entity : returns a "managed instance"
		 
		 
		 Badge badge = em.find(Badge.class, id);
		
		 if ( badge != null ) {
			 System.out.println("Found");
			 
			 em.getTransaction().begin();
			 
			 em.remove(badge);
			 
			 em.getTransaction().commit();
			 
			 System.out.println("Removed");
		 }
		 else {
			 System.out.println("Not found");
		 }
	 }
	 
	 public static void update(EntityManager em , int id, short authorizationLevel ) 
	 {
		 System.out.println("update("+id+"," + authorizationLevel + ")" );
		 
		 // 1) find the entity : returns a "managed instance"
		 Badge badge = em.find(Badge.class, id);
		
		 if ( badge != null ) {
			 System.out.println("Found");

			 em.getTransaction().begin();

			 badge.setAuthorizationLevel(authorizationLevel);
			 System.out.println("Updated in memory");
//			 em.flush();
			 
			 em.getTransaction().commit();
			 
			 System.out.println("Commited");
		 }
		 else {
			 System.out.println("Not found");
		 }
	 }
	 
	 public static void transactionTest(EntityManager em ) 
	 {
		 EntityTransaction transaction = em.getTransaction();
		 showStatus(transaction);
		 
		 transaction.begin();
		 showStatus(transaction);
		 showFlushMode(em ); 
		 
		 transaction.commit();
		 //transaction.rollback();
		 showStatus(transaction);
		 showFlushMode(em ); 
		 
	 }

	 public static void showFlushMode(EntityManager em ) 
	 {
		 FlushModeType mode = em.getFlushMode();
		 System.out.println("FlushMode : " + mode );
	 }
	 
	 public static void showStatus(EntityTransaction transaction) 
	 {
		 System.out.println(" TRANSACTION is active ? : " + transaction.isActive() );
	 }
}
