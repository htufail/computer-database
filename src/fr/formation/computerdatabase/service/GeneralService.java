package fr.formation.computerdatabase.service;

import java.util.List;

import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;

public interface GeneralService {

	abstract List<Company> getCompanies();
	abstract List<Computer> getComputers();
	abstract List<Computer> getComputersByPage(int offset, int noOfRecords);
	abstract void addComputer(Computer computer);
	abstract void updateComputer(Computer computer);
	abstract Company getCompany(long company_id);
	abstract Computer getComputerById(long computer_id);
	abstract List<Computer> getComputersBySearch(String search);
	abstract void deleteComputer(Computer computer);
	abstract long getNbComputers(String search);
}
