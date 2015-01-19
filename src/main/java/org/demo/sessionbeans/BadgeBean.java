package org.demo.sessionbeans;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// EJB not supported without Java EE
// @Stateless
// @Statefull
public class BadgeBean {

	@PersistenceContext(unitName="")
	EntityManager em ;
}
