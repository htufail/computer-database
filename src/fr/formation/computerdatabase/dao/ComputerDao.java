package fr.formation.computerdatabase.dao;

import java.util.List;

import fr.formation.computerdatabase.domain.Computer;

public interface ComputerDao {

	List<Computer> getComputersBySearch(String search);
	List<Computer> getComputers();
	List<Computer> getComputersByPage(int offset,int noOfRecords);
	Computer getComputerById(long computer_id);
	void addComputer(Computer computer);
	void updateComputer(Computer computer);
	void deleteComputer(Computer computer);
	long getNbComputers(String search);

}
