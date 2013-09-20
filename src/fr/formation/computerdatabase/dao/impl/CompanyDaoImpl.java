package fr.formation.computerdatabase.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.formation.computerdatabase.dao.CompanyDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;
import fr.formation.computerdatabase.domain.Company;

public class CompanyDaoImpl implements CompanyDao{

	
	/**
	 * @author Hina
	 * Méthode permettant de récupérer les companies dans une liste
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getCompanies() {
		
		//On initialise
		EntityManager em = null;
		List<Company> companies = null;

		try {
			//On get un entity manager
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			 //namedQuery appelée, déclarée en annotation dans la classe domain.Company
			String myQuery = "Select c from Company c";
			companies = em.createQuery(myQuery).getResultList();
		}
			catch(Exception e) {
			  e.printStackTrace();
	    	}
			finally {
				if(em != null)
				        em.close();
			}

		return companies;
		
	}

	
	
	/**
	 * @author Hina
	 * Méthode (utilisée dans l'ajout d'ordi) qui renvoie la company après qu'on ait récupéré l'id de la combobox
	 */
	@Override
	public Company getCompany(long company_id) {
		//On initialise
		EntityManager em = null;
		Company myCompany = new Company();

		try {
					//On get un entity manager
					em = GeneralDaoManager.INSTANCE.getEntityManager();
					 //récupérer la companie à partie de son id
					String myQuery = "Select c from Company c WHERE c.id = " + company_id;
					Query query = em.createQuery(myQuery);
					//Recuperer le résultat
					myCompany = (Company) query.getSingleResult();
		}
		 catch(Exception e) {
			  e.printStackTrace();
		 }
		 finally {
			if(em != null)
			em.close();
		 }

		return myCompany;
	}

}
