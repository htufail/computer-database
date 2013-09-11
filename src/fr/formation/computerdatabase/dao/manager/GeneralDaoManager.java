package fr.formation.computerdatabase.dao.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.formation.computerdatabase.dao.GeneralDao;
import fr.formation.computerdatabase.dao.impl.GeneralDaoImpl;


public enum GeneralDaoManager {
		INSTANCE;
		
		private GeneralDao generalDao;
		private EntityManagerFactory emf;
		
		private GeneralDaoManager() {
			emf = Persistence.createEntityManagerFactory("JuliaHina");
			generalDao = new GeneralDaoImpl();
			
		}

		//M�thode qui get le Dao
		public GeneralDao getGeneralDao() {
			return generalDao;
		}

		//M�thode qui cr�e un entity manager
		public EntityManager getEntityManager() {
			return emf.createEntityManager();
		}
}
