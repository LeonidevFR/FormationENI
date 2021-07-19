package fr.formation.module4.tp.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.module4.tp.business.RepasManager;

/**
 * Servlet implementation class ServletAjouterRepas
 */
@WebServlet("/ServletAjouterRepas")
public class ServletAjouterRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutRepas.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperer les données du formulaire : request.getParameter();
		String cancel = request.getParameter("cancel");
		String submit = request.getParameter("submit");
		
		if(submit != null) {
			String date = request.getParameter("date");
			String heure = request.getParameter("time");
			String repas = request.getParameter("meal");
			if(date != null && heure!=null && repas!=null) {
				RepasManager.createMeal(date, heure, repas);
				response.sendRedirect("ServletEnd");
			} else {
				System.out.println("Erreur...");
			}
		} else if(cancel != null) {
			response.sendRedirect("ServletAccueil");
		}
		
		//Appeler le service métier pour déclencher la sauvegarde du repas
		
		//RepasManager new
		//methode create
		
		//Rediriger vers la JSP qui affiche la liste des repas
	}

}
