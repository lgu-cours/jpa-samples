package org.demo.primarykey;

import java.io.Serializable;

/**
 * Composite Primary Key 
 * Mandatory :
 * . default constructor
 * . equals and hashCode method
 *
 */
public class DepartmentPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int companyId;

    private String internalCode;

	public DepartmentPK() {
	}
	
	public DepartmentPK(int companyId, String internalCode) {
		super();
		this.companyId = companyId;
		this.internalCode = internalCode;
	}

	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyId;
		result = prime * result
				+ ((internalCode == null) ? 0 : internalCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass())
			return false;
		DepartmentPK other = (DepartmentPK) obj;
		if (companyId != other.companyId)
			return false;
		if (internalCode == null) {
			if (other.internalCode != null)
				return false;
		} else if (!internalCode.equals(other.internalCode))
			return false;
		return true;
	}

}
