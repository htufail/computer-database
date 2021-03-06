package fr.formation.computerdatabase.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import fr.formation.computerdatabase.domain.Computer;
import fr.formation.computerdatabase.service.GeneralService;
import fr.formation.computerdatabase.service.manager.ServiceManager;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GeneralService monService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        monService = ServiceManager.INSTANCE.getGeneralService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String myId = request.getParameter("id");
		long computer_id = Long.parseLong(myId);
		
		int reply = JOptionPane.showConfirmDialog(null, "Do you wish to delete this computer ?", "Delete a computer", JOptionPane.WARNING_MESSAGE);
		if(reply == JOptionPane.CANCEL_OPTION)
		{
			//Affichage
			RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp"));
			rd.forward(request, response);
		}
		else if(reply == JOptionPane.OK_OPTION){
			
			//On r�cup�re l'ordinateur via son id
			Computer computer = monService.getComputerById(computer_id);
					
			monService.deleteComputer(computer);
			System.out.println("le computer a �t� delete");
					
			//Affichage
			RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/index.jsp"));
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
