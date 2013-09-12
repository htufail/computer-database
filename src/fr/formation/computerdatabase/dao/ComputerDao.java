package fr.formation.computerdatabase.dao;

import java.util.List;

import fr.formation.computerdatabase.domain.Computer;

public interface ComputerDao {

	List<Computer> getComputersBySearch(String search);
	List<Computer> getComputers();
	void addComputer(Computer computer);
}
