package fr.formation.computerdatabase.domain;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "computer")
@NamedQuery (name="findAllComputers", query="Select c from Computer c")
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

	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}

	public Date getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}
	
	//Classe Builder
		public static class Builder {
			private Computer computer;

			public Builder() {
				computer = new Computer();
			}

			public Builder id(int id) {
				computer.setId(id);
				return this;
			}

			public Builder name(String nom) {
				System.out.println("Building name");
				computer.setName(nom);
				return this;
			}
			
			
			public Builder introduced(String dateInit) {
				
				DateFormat df = DateFormat.getDateInstance();
				Date newDateInit = null;
				System.out.println("Building dateInit");
				try {
					newDateInit = df.parse(dateInit);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("problem date init");
				}
				
				computer.setIntroduced(newDateInit);
				return this;
			}
			
			
			public Builder discontinued(String dateDisc) {
				
				DateFormat df =  DateFormat.getDateInstance();
				Date newDateDisc = null;
				System.out.println("Building dateDisc");
				try {
					newDateDisc = df.parse(dateDisc);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("problem date disc");
				}
				
				computer.setDiscontinued(newDateDisc);
				return this;
			}

			public Builder company(String company){
				Company myCompany = new Company();
				myCompany.setName(company);
				System.out.println("Building company..");
				
				computer.setCompanie(myCompany);
				return this;
			}
			public Computer build() {
				return computer;
			}
		}

}
