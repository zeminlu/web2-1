package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Client;
import model.ClientManager;
import model.Order;
import model.OrderManager;
import model.Pizza;
import model.PizzaManager;
import model.Printable;

public class Api extends HttpServlet{
	private ClientManager clientMan = ClientManager.getInstance();
	private PizzaManager pizzaMan = PizzaManager.getInstance();
	private OrderManager orderMan = OrderManager.getInstance();
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);

		String requestFormat = req.getHeader("Accept");
		String format;
		if( !requestFormat.contains("application/json") &&
				!requestFormat.contains("application/xml")){
			// retorno un error.
			return;
		} else {
			format = requestFormat.contains("application/json")? "json":"xml";
		}
		
		String baseUrl = req.getContextPath()+"/Api";
		String reqUrl = req.getRequestURI();
		PrintWriter out = resp.getWriter();
		if( reqUrl.equals(baseUrl + "/pedidos") ){
			Iterable<Order> orders = orderMan.getAll();
			if(format.equals("xml")){
				responseXml(orders, "pedidos", out);
			} else {
				responseJson(orders, out);
			}
		} else if( reqUrl.equals(baseUrl + "/clients") ){
			Iterable<Client> clients = clientMan.getAll();
			if(format.equals("xml")){
				responseXml(clients, "clientes", out);
			} else {
				responseJson(clients, out);
			}
		} else if( reqUrl.equals(baseUrl + "/pizzas") ){
			Iterable<Pizza> pizzas = pizzaMan.getAll();
			if(format.equals("xml")){
				responseXml(pizzas, "pizzas", out);
			} else {
				responseJson(pizzas, out);
			}
		} else {
			// retornamos un error.
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
	
	private void responseXml(Iterable<? extends Printable> iterator, String root, PrintWriter out){
		out.print("<"+root+">");
		for(Printable each: iterator){
			out.print(each.toXml());
		}
		out.print("</"+root+">");
	}
	
	private void responseJson(Iterable<? extends Printable> iterator, PrintWriter out){
		out.print("[");
		Iterator<? extends Printable> it = iterator.iterator();
		if(it.hasNext()){
			out.print(it.next().toJson());
		}
		while(it.hasNext()){
			out.print(","+it.next().toJson());
		}
		out.print("]");
	}
	
}
