package org.demo.queries;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Query;


/**
 * NamedQuery 
 * . doit être dans une classe définie dans persistence.xml
 * . la classe doit être mappée sur une entité
 * 
 */

@NamedQuery (name="query1", query="SELECT b.badgeNumber FROM Badge b " )
@Entity // Fake ENTITY
public class BadgeQueries implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id // Fake ID
	private int fakeId ;
	
	public List<Integer> getBadgeNumbers(EntityManager em) {
		Query query = em.createNamedQuery("query1");
		List<Integer> list = query.getResultList();
		return list ;
	}

}