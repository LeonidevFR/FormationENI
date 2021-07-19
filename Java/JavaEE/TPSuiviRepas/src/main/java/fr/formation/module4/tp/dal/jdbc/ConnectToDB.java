package fr.formation.module4.tp.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
	
	private static Connection con;

	
	public static Connection getConnection() throws SQLException {
		
		// Initialiser les variables de connexion = url, login, password
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:8889/...";
		String login = "...";
		String password = "...";
		
		/*		try {
		     Class.forName(driver); //loading the driver
		    } catch (ClassNotFoundException e) {
		    System.out.println("Where is your MySQL JDBC Driver?");
		    e.printStackTrace();
		    } */
		

        try {
		     Class.forName(driver); //loading the driver
		     System.out.println("MySQL JDBC Driver Registered!");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        
        if(con == null) {
			con = DriverManager.getConnection(url, login, password);
		}
		return con;
	}
	
	public static Connection closeConnection() throws SQLException {
		if(con != null) {
			con.close();
			con = null;
		}
		return con;
	}

}
