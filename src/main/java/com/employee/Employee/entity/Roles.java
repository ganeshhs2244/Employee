package com.employee.Employee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	@Column (name = "id")
	private long id;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "title")
	private String title;
	
	@Column (name = "description")
	private String description;

	@OneToMany(targetEntity = Permission.class, cascade = CascadeType.ALL)
	private List<Permission> permission;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Roles() 
	{
		
	}
	
	
	public Roles(long id, String name, String title, String description,List<Permission> permission) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.permission = permission;
	}

	public List<Permission> getPermission() {
		return permission;
	}

	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + "]";
	}
	

}
