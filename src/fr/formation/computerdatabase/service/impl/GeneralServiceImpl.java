package fr.formation.computerdatabase.service.impl;

import java.util.List;

import fr.formation.computerdatabase.dao.CompanyDao;
import fr.formation.computerdatabase.dao.ComputerDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;
import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;
import fr.formation.computerdatabase.service.GeneralService;

public class GeneralServiceImpl implements GeneralService{

	
	CompanyDao companyDao;
	ComputerDao computerDao;
	
	/**
	 * @author Hina
	 * Constructeur 
	 */
	public GeneralServiceImpl(){
		companyDao = GeneralDaoManager.INSTANCE.getCompanyDao();
		computerDao = GeneralDaoManager.INSTANCE.getComputerDao();
	}
	
	
	/**
	 * @author Hina
	 * Différents getters et setters
	 */
	@Override
	public List<Company> getCompanies() {
		
		return companyDao.getCompanies();
	}

	@Override
	public List<Computer> getComputers() {
		
		return computerDao.getComputers();
	}

	@Override
	public void addComputer(Computer computer) {
		computerDao.addComputer(computer);
		
	}

	@Override
	public Company getCompany(long company_id) {
		return companyDao.getCompany(company_id);
	}

	@Override
	public List<Computer> getComputersBySearch(String search) {
		return computerDao.getComputersBySearch(search);
	}

	@Override
	public Computer getComputerById(long computer_id) {
		return computerDao.getComputerById(computer_id);
	}

	/**
	 * @author Hina
	 * fonction de mise à jour et de suppression d'un ordinateur
	 */
	
	@Override
	public void updateComputer(Computer computer) {
		computerDao.updateComputer(computer);
		
	}

	@Override
	public void deleteComputer(Computer computer) {
		computerDao.deleteComputer(computer);		
	}


	@Override
	public List<Computer> getComputersByPage(int offset, int noOfRecords) {
		// TODO Auto-generated method stub
		return computerDao.getComputersByPage(offset, noOfRecords);
	}


	public long getNbComputers(String search) {
		// TODO Auto-generated method stub
		return computerDao.getNbComputers(search);
	}

}
