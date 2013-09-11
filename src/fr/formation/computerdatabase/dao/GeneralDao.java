package fr.formation.computerdatabase.dao;

import java.util.List;

import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;

public interface GeneralDao {

	List<Company> getCompanies();
	List<Computer> getComputers();
	void addComputer(Computer computer);
}
