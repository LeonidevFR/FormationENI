package fr.formation.module4.tp.dal;

public class DAOFactory {
	
	public static RepasDAO createRepasDAO() {
		return new RepasDAOImpl();
	}

}
