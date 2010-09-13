package model;

import java.util.LinkedList;
import java.util.List;

public class PizzaManager {
	private List<Pizza> pizzas = new LinkedList<Pizza>();
	private static PizzaManager instance = null;
	
	public static PizzaManager getInstance(){
		if (instance == null){
			return instance = new PizzaManager();
		}
		return instance;
	}

	
	public Pizza getPizza(int id){
		 for (Pizza each : pizzas){
			 if (each.getId() == id){
				 return each;
			 }
		 }
		 return null;
	}
	
	public void addPizza(Pizza pizza){
		pizzas.add(pizza);
	}
	
	public boolean deletePizza(Pizza pizza){
		if (!pizzas.contains(pizza)){
			return false;
		}
		pizzas.remove(pizza);
		return true;
	}
	
	public Iterable<Pizza> getAll(){
		return pizzas;
	}
}
