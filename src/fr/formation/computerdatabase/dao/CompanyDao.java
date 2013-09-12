package fr.formation.computerdatabase.dao;

import java.util.List;

import fr.formation.computerdatabase.domain.Company;

public interface CompanyDao {

	List<Company> getCompanies();
	Company getCompany(long company_id);
	
}
