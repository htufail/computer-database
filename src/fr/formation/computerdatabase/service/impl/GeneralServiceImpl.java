package fr.formation.computerdatabase.service.impl;

import java.util.List;

import fr.formation.computerdatabase.dao.GeneralDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;
import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;
import fr.formation.computerdatabase.service.GeneralService;

public class GeneralServiceImpl implements GeneralService{

	
	GeneralDao generalDao;
	
	public GeneralServiceImpl(){
		generalDao = GeneralDaoManager.INSTANCE.getGeneralDao();
	}
	
	@Override
	public List<Company> getCompanies() {
		
		return generalDao.getCompanies();
	}

	@Override
	public List<Computer> getComputers() {
		
		return generalDao.getComputers();
	}

	@Override
	public void addComputer(Computer computer) {
		generalDao.addComputer(computer);
		
	}

}
