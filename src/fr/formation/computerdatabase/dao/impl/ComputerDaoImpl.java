package fr.formation.computerdatabase.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.formation.computerdatabase.dao.ComputerDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;

import fr.formation.computerdatabase.domain.Computer;

public class ComputerDaoImpl implements ComputerDao{

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @author Hina
	 * Méthode renvoyant une liste d'ordinateurs suite à une recherche par l'utilisateur
	 */
	public List<Computer> getComputersBySearch(String search) {
		//On initialise
				EntityManager em = null;
				List<Computer> myList = null;

				try {
					//On get un entity manager
					em = GeneralDaoManager.INSTANCE.getEntityManager();
					
					//On effectue la requête
					String query = "Select c from Computer c where c.name like '%"+ search +"%'";
					Query queryToDo = em.createQuery(query);
					
					//On récupère la liste des résultats
					myList = queryToDo.getResultList();
					
				}
					catch(Exception e) {
					  e.printStackTrace();
			    	}
					finally {
						if(em != null)
						        em.close();
					}

				return myList;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * @author Hina
	 * Accesseur pour liste d'ordinateurs
	 */
	public List<Computer> getComputers() {
		//On initialise
		EntityManager em = null;
		List<Computer> computers = null;

		try {
			//On get un entity manager
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			 //on effectue la query et on récupère la liste de résultats
			String query = "Select c from Computer c";
			computers = em.createQuery(query).getResultList();
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
	/**
	 * @author Hina
	 * Méthode permettant l'ajout d'un ordinateur à la liste d'ordinateurs
	 */
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

	@Override
	public Computer getComputerById(long computer_id) {
		
		//On initialise
		EntityManager em = null;
		Computer myComputer = new Computer();

		try {
			//On get un entity manager
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			 //
			String myQuery = "Select c from Computer c WHERE c.id = " + computer_id;
			Query query = em.createQuery(myQuery);
			myComputer = (Computer) query.getSingleResult();
			
		}
			catch(Exception e) {
			  e.printStackTrace();
	    	}
			finally {
				if(em != null)
				        em.close();
			}
		
		return myComputer;
	}

	@Override
	public void updateComputer(Computer computer) {
		
EntityManager em = null;
		
		try {
			//Recuperation de l'entityManager qui gere la connexion a la BD
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			//Debut de transaction (obligatoire pour des operations d'ecriture sur la BDD)
			em.getTransaction().begin();

			//Sauvegarde de l'utilisateur
			em.merge(computer);
			
			//Commit de la transaction = on applique toutes les operations ci dessus
			em.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(em != null)
				em.close();
		}
	}

	@Override
	public void deleteComputer(Computer computer) {
		
		//On initialise
				EntityManager em = null;

				try {
					//On get un entity manager
					em = GeneralDaoManager.INSTANCE.getEntityManager();
					 
					//Debut de transaction (obligatoire pour des operations d'ecriture sur la BDD)
					em.getTransaction().begin();

					String myQuery = "delete from Computer c WHERE c.id = " + computer.getId();
					Query query = em.createQuery(myQuery);
					query.executeUpdate();
					
					
					//Commit de la transaction = on applique toutes les operations ci dessus
					em.getTransaction().commit();
					
				}
					catch(Exception e) {
					  e.printStackTrace();
			    	}
					finally {
						if(em != null)
						        em.close();
					}
	}

}
