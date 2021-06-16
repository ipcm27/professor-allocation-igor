package com.project.professor.allocation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Departament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column (name = "name", nullable =false, unique = true)
	String name;
	
	
	@OnDelete (action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy= "departament")
	// Não se esquecer de fazer o get, set e adicionar no construtor
	private List<Professor> professors;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Departament(){
		
	}
	
	public Departament(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
