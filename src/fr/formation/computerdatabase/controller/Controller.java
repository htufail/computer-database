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
		System.out.println("L'utilisateur recherche : " + search);
		
		//On récupère les companies et les ordinateurs
		if(search !=null && !search.trim().isEmpty()){
			request.setAttribute("computers", monService.getComputersBySearch(search));
			System.out.println("Recherche en cours");
		}
		else{
			//Si pas de recherche
			request.setAttribute("computers", monService.getComputers());
			System.out.println("on get tous les ordis");
			
		}

		
		//Affichage
		//A CHANGER :
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/dashboard.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    
	}

}
