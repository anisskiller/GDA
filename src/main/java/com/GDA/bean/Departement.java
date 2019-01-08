package main.java.com.GDA.bean;

public class Departement {

	private int id;
	private String name;
	
	public Departement(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", name=" + name + "]";
	}
	
	
}
