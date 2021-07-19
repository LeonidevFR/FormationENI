package fr.formation.module4.tp.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Repas {
	private String date;
	private String hour;
	private String ingredients;
	
	public Repas() {
	}
	
	public Repas(String date, String hour, String ingredients) {
		super();
		this.date = date;
		this.hour = hour;
		this.ingredients = ingredients;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getHour() {
		return hour;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	
	@Override
	public String toString() {
		String str = String.format("Repas : [le %s à %sh : %s]%n", this.date, this.hour, this.ingredients);
		return str;
	}
	

}
