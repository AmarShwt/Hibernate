package com.amar.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	private int projId;
	private String project;
	@ManyToMany(mappedBy = "projects")
	List<Employee>	employees;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projId, String project, List<Employee> employees) {
		super();
		this.projId = projId;
		this.project = project;
		this.employees = employees;
	}

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
