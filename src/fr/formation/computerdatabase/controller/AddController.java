package fr.formation.computerdatabase.controller;

import java.io.IOException;
import java.text.DateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.computerdatabase.domain.Computer;
import fr.formation.computerdatabase.service.GeneralService;
import fr.formation.computerdatabase.service.manager.ServiceManager;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Declare un nouveau service
	GeneralService monService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        monService = ServiceManager.INSTANCE.getGeneralService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Affichage
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/addComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On récupère les entrées de l'utilisateur
		System.out.println("Récup des entrées utilisateur");
				String name = request.getParameter("computerName");
			    String introducedDate = request.getParameter("introducedDate");
			    String discontinuedDate = request.getParameter("discontinuedDate");
			    String company = request.getParameter("company");

			  //Test de validite des champs nom de l'ordi, dates, et entreprise
			    if(name != null && !name.isEmpty() 
			    	&& introducedDate != null 
			    	&& !introducedDate.isEmpty()
			    	&& discontinuedDate != null 
			    	&& !discontinuedDate.isEmpty()){
			    	monService.addComputer(new Computer.Builder().name(name)
			    							.introduced(introducedDate)
			    							.discontinued(discontinuedDate)
			    							.company(company)
			    							.build());
			    System.out.println("Builder utilisé");	
			    }
			    
			    //Redirection vers la page
			    doGet(request, response);
			    System.out.println("Redirection page...");
	}

}
