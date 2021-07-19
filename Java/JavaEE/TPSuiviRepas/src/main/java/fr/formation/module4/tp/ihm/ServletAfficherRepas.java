package fr.formation.module4.tp.ihm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.module4.tp.business.RepasManager;
import fr.formation.module4.tp.model.Repas;

/**
 * Servlet implementation class ServletAfficherRepas
 */
@WebServlet("/ServletAfficherRepas")
public class ServletAfficherRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Repas> liste = new ArrayList();
		liste = RepasManager.selectAll();
        request.setAttribute("result", liste);

        PrintWriter out = response.getWriter();
        out.print(liste);
        
//        if(liste != null) {
//    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/listeRepas.jsp");
//    	    rd.forward(request, response);
//        }
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
