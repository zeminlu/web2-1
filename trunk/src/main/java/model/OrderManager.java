package model;

import java.util.LinkedList;
import java.util.List;

public class OrderManager {
	private List<Order> orders = new LinkedList<Order>();
	private static OrderManager instance = null;
	
	public static OrderManager getInstance(){
		if (instance == null){
			return instance = new OrderManager();
		}
		return instance;
	}

	public Order getOrder(int id){
		for (Order each : orders){
			if (each.getId() == id){
				return each;
			}
		}
		return null;
	}
	
	public void addOrder(Order order){
		orders.add(order);
	}
	
	public boolean deleteOrder(Order order){
		if (!orders.contains(order)){
			return false;
		}
		orders.remove(order);
		return true;
	}
}
