package fr.formation.computerdatabase.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.computerdatabase.domain.Company;
import fr.formation.computerdatabase.domain.Computer;
import fr.formation.computerdatabase.service.GeneralService;
import fr.formation.computerdatabase.service.manager.ServiceManager;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditController")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//Declare un nouveau service
	GeneralService monService;
	Long computer_id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
        super();
        monService = ServiceManager.INSTANCE.getGeneralService();
        computer_id=null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On r�cup�re les companies
		request.setAttribute("companies", monService.getCompanies());

		
		//On r�cup�re l'ordinateur via son id
		String myId = request.getParameter("id");
		computer_id = Long.parseLong(myId);
		Computer computer = monService.getComputerById(computer_id);
		request.setAttribute("computer", computer);
		
		//Affichage
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/editComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On r�cup�re l'ordinateur via son id
		Computer computer = monService.getComputerById(computer_id);
		
		
		// On r�cup�re les entr�es de l'utilisateur
		String name = request.getParameter("computerName");
		//Dates
				String introducedDate = request.getParameter("introducedDate");
				String discontinuedDate = request.getParameter("discontinuedDate");
		
				//Contr�le des dates
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date newDateInit = null;
				Date newDateDisc = null;
				try {
					newDateInit = df.parse(introducedDate);
					newDateDisc = df.parse(discontinuedDate);
					
				} catch (ParseException e) {
					//traitement des dates en cas de format incorrect
					//e.printStackTrace();
				}
				
				//On r�cup�re l'id company renvoy� par le param�tre
				Long company_id = Long.parseLong(request.getParameter("company"));
				
				//On souhaite r�cup�rer l'objet "Company"
				Company newCompany = monService.getCompany(company_id);
				
				
				RequestDispatcher rd;
				//Test de validite des champs nom de l'ordi, dates, et entreprise
				if(name != null && !name.trim().isEmpty() 
				   	&& introducedDate != null 
				   	&& !introducedDate.trim().isEmpty()
				   	&& discontinuedDate != null 
				   	&& !discontinuedDate.trim().isEmpty()){
					
						computer.setName(name);
						computer.setIntroduced(newDateInit);
						computer.setDiscontinued(newDateDisc);
						computer.setCompanie(newCompany);
					    monService.updateComputer(computer);
					    	
				   //Redirection vers la page principale
					rd = getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp"));
				  }
				else{
					rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/editComputer.jsp"));
				}
					    

					rd.forward(request, response);
	}


}
