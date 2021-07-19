package fr.formation.module4.tp.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.module4.tp.dal.jdbc.ConnectToDB;
import fr.formation.module4.tp.model.Repas;

public class RepasDAOImpl implements RepasDAO {

	@Override
	public void insertRepas(Repas repas) {
		
		Connection con = null;
		PreparedStatement prpStmt = null;
		String sqlInsert = "INSERT INTO REPAS (date, heure, ingredients) " + "VALUES(?,?,?)";
		
		try {
			con = ConnectToDB.getConnection();
			prpStmt = con.prepareStatement(sqlInsert);
			//prpStmt = con.prepareStatement(sqlInsert);

			prpStmt.setString(1, repas.getDate());
			prpStmt.setString(2, repas.getHour());
			prpStmt.setString(3, repas.getIngredients());
            
            int row = prpStmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
		System.out.println("Repas inséré dans la Base de données ! ");
	}

	@Override
	public List<Repas> getRepas() {

		List<Repas> repas = new ArrayList<Repas>();
		Connection con = null;
		Statement stmt;
		
		try {
			con = ConnectToDB.getConnection();			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM REPAS ORDER BY date DESC");
			//Eleve e = null; dans mon Test ça renvoyait l'adresse mémoire et pas le nom+prénom+email
			//Du coup j'ai déclaré le new Eleve en dessous dans le while & j'ai crée une méthode toString dans la classe Eleve !
			
			while(rs.next()) {
				Repas re = new Repas(rs.getString(1), rs.getString(2), rs.getString(3));
				repas.add(re);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return repas;
	}

}
