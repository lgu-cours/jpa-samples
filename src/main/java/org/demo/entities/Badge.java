package org.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BADGE database table.
 * 
 */
@Entity 
public class Badge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BADGE_NUMBER")
	private int badgeNumber;

	@Column(name="AUTHORIZATION_LEVEL")
	private short authorizationLevel;

    @Temporal( TemporalType.TIMESTAMP )
	@Column(name="END_OF_VALIDITY")
	private Date endOfValidity;

    public Badge() {
    }

	public int getBadgeNumber() {
		return this.badgeNumber;
	}

	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}

	public short getAuthorizationLevel() {
		return this.authorizationLevel;
	}

	public void setAuthorizationLevel(short authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	public Date getEndOfValidity() {
		return this.endOfValidity;
	}

	public void setEndOfValidity(Date endOfValidity) {
		this.endOfValidity = endOfValidity;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "#" + badgeNumber + " : " + authorizationLevel + "|"+ endOfValidity ;
	}

	
}