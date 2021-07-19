package fr.formation.module4.tp.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ajout = request.getParameter("ajouter");
		String affichage = request.getParameter("afficher");
		
		if(ajout != null) {
			response.sendRedirect("ServletAjouterRepas");
			 //this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajoutRepas.jsp").forward(request, response);
		} else if (affichage != null) {
			response.sendRedirect("ServletAfficherRepas");
		} else {
			response.sendRedirect("ServletAccueil");
		}
		
	}

	
	/*
	  <servlet>
	<servlet-name>ServletAjouterRepas</servlet-name>
	<servlet-class>fr.formation.module4.tp.ihm.ServletAjouterRepas</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>ServletAjouterRepas</servlet-name>
	<url-pattern>/ServletAjouterRepas</url-pattern>
</servlet-mapping>
	 */

}
