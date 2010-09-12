package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClientManager;
import model.PizzaManager;

public class Api extends HttpServlet{
	private ClientManager clientMan = ClientManager.getInstance();
	private PizzaManager pizzaMan = PizzaManager.getInstance();
	private ClientManager userMan = ClientManager.getInstance();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
		
		String[] args = req.getRequestURI().split("/");

		if (args[2].equals("clients")){
			if (args.length == 3){
				//aca pide todos los clientes
			}else{
				System.out.println("todo mal");
			}
		
		} else if( args[1].equals("products")) {
			if (args.length == 3){
				System.out.println("joya");
			}else{
				System.out.println("todo mal");
			}
			
		} else if( args[1].equals("pizzas")){
			if (args.length == 3){
				System.out.println("joya");
			}else{
				System.out.println("todo mal");
			}
		}
			
		for(String each: args){
			System.out.println(each);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
}
