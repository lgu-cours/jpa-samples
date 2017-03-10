package org.demo.util;

import java.io.Closeable;

public class Foo implements Closeable {

	private boolean open = false ;
	
	protected Foo() {
		super();
		System.out.println("new instance created");
		open = true ;
	}

	public void printStatus() {
		System.out.println("open = " + open);
	}
	
	@Override
	public void close()  {
		System.out.println("instance closing");
		open = false ;
	}

}
