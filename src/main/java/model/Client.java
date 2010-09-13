package model;

public class Client implements Printable{
	private int id;
	private String name;
	private String address;
	private static int idCount = 1;
	
	public Client(String name, String address) {
		super();
		this.id = idCount++;
		this.name = name;
		this.address = address;
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toXml(){
		StringBuffer xml = new StringBuffer("<cliente id='"+ id +"'>");
		xml.append("<nombre>"+ name +"</nombre>");
		xml.append("<direccion>"+ address +"</direccion>");
		xml.append("</cliente>");
		return xml.toString();
	}

	@Override
	public String toJson() {
		StringBuffer json = new StringBuffer("{ id:" + id);
		json.append(",nombre:" + name);
		json.append(",direccion:" + address + "}");
		return json.toString();
	}
}
