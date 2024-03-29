package model;

public class Pizza implements Printable{
	private int id;
	private String name;
	private double price;
	private static int idCount = 1;
	
	public Pizza(String name, double price) {
		super();
		this.id = idCount++;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
		Pizza other = (Pizza) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toJson() {
		StringBuffer json = new StringBuffer("{ id:" + id);
		json.append(",nombre:" + name);
		json.append(",precio:" + price + "}");
		return json.toString();
	}
	@Override
	public String toXml() {
		StringBuffer xml = new StringBuffer("<pizza id='"+ id +"'>");
		xml.append("<nombre>"+ name +"</cliente>");
		xml.append("<precio>"+ price +"</pizza>");
		xml.append("</pizza>");
		return xml.toString();
	}
	
}
