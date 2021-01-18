package Ex1;

import java.io.Serializable;

public class Producte implements Serializable{
	
	private String nom;
	private double preu;
	private int stock;
	
	public Producte(String nom, double preu, int stock){
		super();
		this.nom = nom;
		this.preu = preu;
		this.stock = stock;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public double getPreu() {
		return preu;
	}


	public void setPreu(double preu) {
		this.preu = preu;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Producte [nom=" + nom + ", preu=" + preu + ", stock=" + stock+"]";
	}
	


 
	
}
