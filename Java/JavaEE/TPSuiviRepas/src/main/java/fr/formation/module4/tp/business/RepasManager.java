package fr.formation.module4.tp.business;

import java.util.ArrayList;
import java.util.List;

import fr.formation.module4.tp.dal.DAOFactory;
import fr.formation.module4.tp.dal.RepasDAO;
import fr.formation.module4.tp.model.Repas;

public class RepasManager {
	
	public static void createMeal(String date, String hour, String ingredients) {
		//Verif sur les données
		//Business rules
		//Contraintes métiers
		//Regles de gestion
		//Date remplie (!= null) + date & heure dans le passé
		
		//Créer instance de repas
		
		try {
			Repas repas = new Repas(date, hour, ingredients);
			RepasDAO repasDAO = DAOFactory.createRepasDAO();
			repasDAO.insertRepas(repas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Manager réussi");
	}
	
	public static List<Repas> selectAll() {
		
		List<Repas> allMeal = new ArrayList<Repas>();
		
		try {
			RepasDAO repasDAO = DAOFactory.createRepasDAO();
			allMeal = repasDAO.getRepas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(allMeal);
		return allMeal;
	}

}
