package org.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.demo.primarykey.DepartmentPK;

@Entity
@IdClass(value = DepartmentPK.class)
public class Department implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "company_id", insertable = false, updatable = false)
    private Integer companyId;

    @Id
    @Column(name = "internal_code")
    private String internalCode;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

}