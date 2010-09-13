package model;


public class Order implements Printable{
	private int id;
	private Client client;
	private Pizza pizza;
	private int qty;
	private static int idCount = 1;
	
	public Order(Client client, Pizza pizza, int qty) {
		super();
		this.id = idCount++;
		this.client = client;
		this.pizza = pizza;
		this.qty = qty;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public double getValue(){
		return pizza.getPrice() * qty;
	}
	
	public String toXml(){
		StringBuffer xml = new StringBuffer("<pedido id='"+ id +"'>");
		xml.append("<cliente>"+client.getId()+"</cliente>");
		xml.append("<pizza>"+pizza.getId()+"</pizza>");
		xml.append("<cantidad>"+ qty +"</cantidad>");
		xml.append("<valor>"+ getValue() +"</valor>");
		xml.append("</pedido>");
		return xml.toString();
	}

	@Override
	public String toJson() {
		StringBuffer json = new StringBuffer("{ id:" + id);
		json.append(",cliente:" + client.getId());
		json.append(",pizza:" + pizza.getId());
		json.append(",cantidad:" + qty);
		json.append(",valor:" + getValue() + "}");
		return json.toString();
	}
}
