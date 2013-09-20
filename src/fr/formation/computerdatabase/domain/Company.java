package fr.formation.computerdatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "company")
public class Company {
	
	@Id 
	@GeneratedValue
	private long id;
	
	@Column(name="name")
	private String name;
	
	/**
	 * @author Hina
	 * Différents setters et getters
	 * 
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}
	

}
