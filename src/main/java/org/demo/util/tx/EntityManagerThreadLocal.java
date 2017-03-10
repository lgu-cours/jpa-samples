package org.demo.util.tx;

import javax.persistence.EntityManager;

public class EntityManagerThreadLocal {
	
    private static final ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<EntityManager>();

    protected static void set(EntityManager em) {
    	emThreadLocal.set(em);
    }

    protected static void remove() {
    	emThreadLocal.remove();
    }

    public static EntityManager get() {
        return emThreadLocal.get();
    }
}
