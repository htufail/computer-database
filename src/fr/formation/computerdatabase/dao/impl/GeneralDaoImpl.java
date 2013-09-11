package fr.formation.computerdatabase.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import fr.formation.computerdatabase.dao.GeneralDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;
import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;

public class GeneralDaoImpl implements GeneralDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getCompanies() {
		// TODO Auto-generated method stub
		
		//On initialise
		EntityManager em = null;
		List<Company> companies = null;

		try {
			//On get un entity manager
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			 //namedQuery appelée, déclarée en annotation dans la classe domain.Company
			companies = em.createNamedQuery("findAllCompanies").getResultList();
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputers() {
		// TODO Auto-generated method stub
		//On initialise
				EntityManager em = null;
				List<Computer> computers = null;

				try {
					//On get un entity manager
					em = GeneralDaoManager.INSTANCE.getEntityManager();
					 //namedQuery appelée, déclarée en annotation dans la classe domain.Computer
					computers = em.createNamedQuery("findAllComputers").getResultList();
				}
					catch(Exception e) {
					  e.printStackTrace();
			    	}
					finally {
						if(em != null)
						        em.close();
					}

				System.out.println("Returning result...");
				return computers;
		
	}

	@Override
	public void addComputer(Computer computer) {

		
		EntityManager em = null;
		
		try {
			//Recuperation de l'entityManager qui gere la connexion a la BD
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			//Debut de transaction (obligatoire pour des operations d'ecriture sur la BDD)
			em.getTransaction().begin();
			
			//Sauvegarde de l'utilisateur
			em.persist(computer);
			
			//Commit de la transaction = on applique toutes les operations ci dessus
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(em != null)
				em.close();
		}
	
		
	}

}
