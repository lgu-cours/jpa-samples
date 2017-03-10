package org.demo.util;


public class UseCase2 {
	
	public static void main(String[] args) {
		
		ServiceForBadges svc = new ServiceForBadges();
		svc.getBadges();

		try ( Transaction tx = TransactionManager.beginTransaction() ) {
			ServiceForBadges svc2 = new ServiceForBadges();
			svc2.getBadges();
			
			tx.commit();
		} 

		
		try ( Transaction tx = TransactionManager.beginTransaction() ) {
			ServiceForBadges svc2 = new ServiceForBadges();
			svc2.getBadges();
			
		} 
	}
	
}
