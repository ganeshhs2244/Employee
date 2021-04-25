package com.employee.Employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission 
{
	@Id
	@Column(name="id")
	private long id;
	
	private String action;
	
	private boolean active;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", action=" + action + ", active=" + active + "]";
	}

	public Permission() {
		// TODO Auto-generated constructor stub
	} 
	
	public Permission(long id, String action, boolean active) {
		super();
		this.id = id;
		this.action = action;
		this.active = active;
	}
	
	
}
