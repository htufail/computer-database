package fr.formation.computerdatabase.dao.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.computerdatabase.dao.CompanyDao;
import fr.formation.computerdatabase.dao.ComputerDao;
import fr.formation.computerdatabase.dao.impl.CompanyDaoImpl;
import fr.formation.computerdatabase.dao.impl.ComputerDaoImpl;


public enum GeneralDaoManager {
		INSTANCE;
		
		private CompanyDao companyDao;
		private ComputerDao computerDao;
		private EntityManagerFactory emf;
		
		private GeneralDaoManager() {
			emf = Persistence.createEntityManagerFactory("JuliaHina");
			companyDao = new CompanyDaoImpl();
			computerDao = new ComputerDaoImpl();
			
		}

		//M�thode qui get le Dao de la classe Company
		public CompanyDao getCompanyDao() {
			return companyDao;
		}
		
		//M�thode qui get le Dao de la classe Computer
		public ComputerDao getComputerDao() {
			return computerDao;
		}

		//M�thode qui cr�e un entity manager
		public EntityManager getEntityManager() {
			return emf.createEntityManager();
		}
}
