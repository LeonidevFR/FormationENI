package fr.eni.tpchifoumi.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletChifoumi
 */
@WebServlet("/ServletChifoumi")
public class ServletChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSPTentative.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	 
		Random rand = new Random();
		int randomComputerValue = rand.nextInt(3 - 1 + 1) + 1;
	    int userChoice = 0;
	    
	    int status = 0;
	    //1 = égalité, 2 = victoire, 3 = défaite
	    
	    if(request.getParameter("subchi")!= null) {
	    	userChoice = 1;
	    } else if (request.getParameter("subfou")!= null) {
	    	userChoice = 2;
	    } else if (request.getParameter("submi")!= null) {
	    	userChoice = 3;
	    } else {
	    	erreur(request, response);
	    }
	   
	    if(userChoice==randomComputerValue) {
	    	status = 1;
	    } else if(userChoice==1) {
	    	if (randomComputerValue == 2) {
	    		status = 3;
	    	} else if(randomComputerValue == 3) {
	    		status = 2;
	    	}
	    } else if(userChoice==2) {
	    	if (randomComputerValue == 1) {
	    		status = 3;
	    	} else if(randomComputerValue == 3) {
	    		status = 2;
	    	}
	    } else if(userChoice==3) {
	    	if (randomComputerValue == 2) {
	    		status = 3;
	    	} else if(randomComputerValue == 1) {
	    		status = 2;
	    	}
	    }
	    
		 request.setAttribute("status", status);
		 request.setAttribute("computer", randomComputerValue);
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Resultat.jsp").forward(request, response);
	    	}
	
	protected void erreur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/WEB-INF/Erreur.jsp");
	}

}
