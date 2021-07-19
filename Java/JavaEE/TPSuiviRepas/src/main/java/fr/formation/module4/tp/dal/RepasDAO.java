package fr.formation.module4.tp.dal;

import java.util.List;

import fr.formation.module4.tp.model.Repas;

public interface RepasDAO {
	
	public void insertRepas(Repas repas);
	
	public List<Repas> getRepas();

}
