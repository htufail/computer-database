package fr.formation.computerdatabase.service;

import java.util.List;

import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;

public interface GeneralService {

	abstract List<Company> getCompanies();
	abstract List<Computer> getComputers();
	abstract void addComputer(Computer computer);
}
