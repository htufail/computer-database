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
		
		/**
		 * @author Hina
		 * Constructeur
		 */
		private GeneralDaoManager() {
			emf = Persistence.createEntityManagerFactory("JuliaHina");
			companyDao = new CompanyDaoImpl();
			computerDao = new ComputerDaoImpl();
			
		}

		/**
		 * @author Hina
		 * Différents getters et setters
		 */
		
		public CompanyDao getCompanyDao() {
			return companyDao;
		}
		
		
		public ComputerDao getComputerDao() {
			return computerDao;
		}

		
		public EntityManager getEntityManager() {
			return emf.createEntityManager();
		}
}
