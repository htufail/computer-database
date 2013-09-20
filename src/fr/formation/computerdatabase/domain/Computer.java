package fr.formation.computerdatabase.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "computer")

public class Computer {
	
	@Id 
	@GeneratedValue
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="introduced")
	@Temporal(TemporalType.TIMESTAMP)
	private Date introduced;
	
	@Column(name="discontinued")
	@Temporal(TemporalType.TIMESTAMP)
	private Date discontinued;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="company_id")
	private Company companie;
	
	/**
	 * @author Hina
	 * Différents getters et setters
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

	public Company getCompanie() {
		return companie;
	}

	public void setCompanie(Company companie) {
		this.companie = companie;
	}

	public Date getIntroduced() {
		return introduced;
	}
	
	public String getIntroducedAsString(){
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		return introduced == null ? null : formatDate.format(introduced);
	}
	
	public String getDiscontinuedAsString(){
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		return discontinued == null ? null : formatDate.format(discontinued);
	}

	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}

	public Date getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}
	
	
	/**
	 * 
	 * @author Hina
	 * Builder permettant de construire les ordinateurs
	 */
	public static class Builder {
			private Computer computer;

			public Builder() {
				computer = new Computer();
			}

			public Builder id(long id) {
				computer.setId(id);
				return this;
			}

			public Builder name(String nom) {
				System.out.println("Building name");
				computer.setName(nom);
				return this;
			}
			
			
			public Builder introduced(Date dateInit) {
				
				computer.setIntroduced(dateInit);
				return this;
			}
			
			
			public Builder discontinued(Date dateDisc) {
				
				computer.setDiscontinued(dateDisc);
				return this;
			}

			public Builder companie(Company myCompany){

				computer.setCompanie(myCompany);
				System.out.println("Building company..");
				return this;
			}
			public Computer build() {
				return computer;
			}
	}

}
