package fr.formation.computerdatabase.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.formation.computerdatabase.dao.ComputerDao;
import fr.formation.computerdatabase.dao.manager.GeneralDaoManager;
import fr.formation.computerdatabase.domain.Computer;

public class ComputerDaoImpl implements ComputerDao{

	
	/**
	 * @author Hina
	 * Méthode renvoyant une liste d'ordinateurs suite à une recherche par l'utilisateur
	 */
	@SuppressWarnings("unchecked")
	@Override
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

	
	/**
	 * @author Hina
	 * Accesseur pour liste d'ordinateurs
	 */
	@SuppressWarnings("unchecked")
	@Override
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
		
		return computers;
	}

  @Override
  public long getNbComputers(String search) {
		
	  EntityManager em = null;
		TypedQuery<Computer> query = null;
			try {
				em = GeneralDaoManager.INSTANCE.getEntityManager();
				em.getTransaction().begin();
				System.out.println("search : "+ search);
				if(search == null || search.trim().isEmpty())
				{
					String string = "Select u From Computer u";
					long result = em.createQuery(string).getResultList().size();
					System.out.println("result  : " + result);
					return result;
				}
				else{
					
					String string = "Select u From Computer u Where u.name Like :search";
					query = em.createQuery(string, Computer.class);
					query.setParameter("search", "%"+search+"%"); 
					return query.getResultList().size();
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				if(em != null)
					em.close();
			}
	}
	
	/**
	 * @author Hina
	 * Méthode permettant l'ajout d'un ordinateur à la liste d'ordinateurs
	 */
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

	@Override
	public Computer getComputerById(long computer_id) {
		
		//On initialise
		EntityManager em = null;
		Computer myComputer = new Computer();

		try {
			//On get un entity manager
			em = GeneralDaoManager.INSTANCE.getEntityManager();
			
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
	
	/**
	 * @author Hina
	 * @param : l'ordinateur dont les infos doivent etre mises à jour
	 * Methode permettant de mettre à jour dans la BDD des données de l'ordinateur
	 */
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

	/**
	 * @author Hina
	 * méthode permettant de supprimer un ordinateur dans la BDD
	 * @param : l'ordinateur à supprimer
	 */
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
			query.executeUpdate(); //execute la requete
					
					
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


	@SuppressWarnings("unchecked")
	@Override
	public List<Computer> getComputersByPage(int offset, int noOfRecords) {
		
		//On initialise
				EntityManager em = null;
				List<Computer> computers = null;

				try {
					//On get un entity manager
					em = GeneralDaoManager.INSTANCE.getEntityManager();
					 //on effectue la query et on récupère la liste de résultats
					String query = "Select c from Computer c";
					
					Query myQuery = em.createQuery(query);
					
					myQuery.setFirstResult(offset);
					myQuery.setMaxResults(noOfRecords);
					computers = myQuery.getResultList();
					
					
				}
					catch(Exception e) {
					  e.printStackTrace();
			    	}
					finally {
						if(em != null)
						        em.close();
					}
		return computers;
	}

}
