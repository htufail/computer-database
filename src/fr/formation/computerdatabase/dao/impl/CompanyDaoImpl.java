package fr.formation.computerdatabase.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.formation.computerdatabase.dao.CompanyDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;
import fr.formation.computerdatabase.domain.Company;

public class CompanyDaoImpl implements CompanyDao{

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @author Hina
	 * Méthode permettant de récupérer les companies dans une liste
	 */
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

		System.out.println("Returning result...");
		return companies;
		
	}

	
	@Override
	/**
	 * @author Hina
	 * Méthode (utilisée dans l'ajout d'ordi) qui renvoie la company après qu'on ait récupéré l'id de la combobox
	 */
	public Company getCompany(long company_id) {
		//On initialise
				EntityManager em = null;
				Company myCompany = new Company();

				try {
					//On get un entity manager
					em = GeneralDaoManager.INSTANCE.getEntityManager();
					 //
					String myQuery = "Select c from Company c WHERE c.id = " + company_id;
					Query query = em.createQuery(myQuery);
					myCompany = (Company) query.getSingleResult();
					
					System.out.println("FIND COMPANY BY ID : " + myCompany.toString());
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
