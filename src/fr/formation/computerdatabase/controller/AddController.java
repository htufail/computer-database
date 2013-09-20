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
import javax.swing.JOptionPane;

import fr.formation.computerdatabase.domain.Company;
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
	//booléen permettant de dire qu'une erreur est déjà apparue (éviter la surcharge de pop ups)
	boolean error;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
        super();
        monService = ServiceManager.INSTANCE.getGeneralService();
        error=false;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On récupère les ordinateurs
		request.setAttribute("companies", monService.getCompanies());
		
		//Affichage
		RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/addComputer.jsp"));
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On récupère les entrées de l'utilisateur
		String name = request.getParameter("computerName");
		
		//Dates
		String introducedDate = request.getParameter("introducedDate");
		String discontinuedDate = request.getParameter("discontinuedDate");
		
		//Contrôle des dates
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date newDateInit = null;
		Date newDateDisc = null;
		try {
			newDateInit = df.parse(introducedDate);
			newDateDisc = df.parse(discontinuedDate);
			
		} catch (ParseException e) {
			//traitement des dates en cas de format incorrect
			if(name == null || name.trim().isEmpty()){
				JOptionPane.showMessageDialog(null,"Please specify a name and a correct date format for your computer", "Name and date required", JOptionPane.WARNING_MESSAGE);
				error=true;
			}else{
				JOptionPane.showMessageDialog(null, "incorrect date format. You should use 'YYYY-MM-DD'", "Incorrect Date", JOptionPane.WARNING_MESSAGE);
				
			}
		}
		
		//On récupère l'id company renvoyé par le paramètre
		Long company_id = Long.parseLong(request.getParameter("company"));
		
		//On souhaite récupérer l'objet "Company"
		Company newCompany = monService.getCompany(company_id);
		
		RequestDispatcher rd;
		//Test de validite des champs nom de l'ordi, dates, et entreprise
		if(name != null && !name.trim().isEmpty()
			&& introducedDate !=null && !introducedDate.trim().isEmpty()
			&& discontinuedDate != null && !discontinuedDate.trim().isEmpty()
			){
			    	monService.addComputer(new Computer.Builder().name(name)
			    							.introduced(newDateInit)
			    							.discontinued(newDateDisc)
			    							.companie(newCompany)
			    							.build());
			    	
					   //Redirection vers la page principale
			rd = getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp"));
			rd.forward(request, response);
		  }
		else{
			if(!error)
				JOptionPane.showMessageDialog(null,"Please specify a name for your computer", "Name required", JOptionPane.WARNING_MESSAGE);
			//On reste sur la même page
			doGet(request, response);
		}
			    

			
		
	}

}
