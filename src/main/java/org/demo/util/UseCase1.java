package org.demo.util;


public class UseCase1 {
	
	public static void main(String[] args) throws InterruptedException {
		testOK();

		testWithError();

	}
	
	public static void testOK() {
		System.out.println("\n--- Test OK");
		try ( Foo foo = new Foo() ) {
			foo.printStatus();
		} 
	}	

	public static void testWithError() throws InterruptedException {
		System.out.println("\n--- Test with Error");
		try ( Foo foo = new Foo() ) {
			foo.printStatus();
			//Thread.sleep(1000);
			throw new RuntimeException("My Error");
		} 
	}	
}
