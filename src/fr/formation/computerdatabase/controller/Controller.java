package fr.formation.computerdatabase.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.computerdatabase.service.GeneralService;
import fr.formation.computerdatabase.service.manager.ServiceManager;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Declare un nouveau service
	GeneralService monService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        monService = ServiceManager.INSTANCE.getGeneralService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//Récupération pour la recherche
		String search = null;
		search = request.getParameter("search");
		int page = 1; //On commence l'affichage du tableau par la première page
		int nbAffichage = 30; //On souhait afficher 30 lignes par page
		long nbTotalComputers = monService.getNbComputers(search);
		//totalComputer se rafraichira à chauqe fois qu'on fera une recherche
		request.setAttribute("totalComputer", monService.getNbComputers(search));
		
		//On récupère les companies et les ordinateurs
		if(search !=null && !search.trim().isEmpty()){
			request.setAttribute("computers", monService.getComputersBySearch(search));
			
			
			//Afin de gérer la pagination, il n'apparait qu'un bouton "previous" lorsqu'on effectue une recherche, qui permet de revenir vers le tableau entier
			request.setAttribute("currentPage", 2);// Ainsi lorsqu'on clique sur ce bouton previous, on revient à la premiere page du tableau entier
			
		}
		else{
			
			if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
			
			//Si pas de recherche
			//request.setAttribute("computers", monService.getComputers());
			request.setAttribute("computers", monService.getComputersByPage((page-1)*nbAffichage, nbAffichage));
			
			int noOfPages = (int) Math.ceil(nbTotalComputers / nbAffichage);
	        request.setAttribute("nbPages", noOfPages);
	        request.setAttribute("currentPage", page);
		}

		
		//Affichage
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/dashboard.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    
	}

}
