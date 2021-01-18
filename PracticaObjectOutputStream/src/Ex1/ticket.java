package Ex1;

import java.io.Serializable;

public class ticket implements Serializable{

	private int codi_ticket;
	private String nom_empleat;
	private String data_ticket;
	private Producte p;
	
	public ticket(int codi_ticket, String nom_empleat, String data_ticket, Producte p) {
		super();
		this.codi_ticket = codi_ticket;
		this.nom_empleat = nom_empleat;
		this.data_ticket = data_ticket;
		this.p = p;
	}

	public int getCodi_ticket() {
		return codi_ticket;
	}

	public void setCodi_ticket(int codi_ticket) {
		this.codi_ticket = codi_ticket;
	}

	public String getNom_empleat() {
		return nom_empleat;
	}

	public void setNom_empleat(String nom_empleat) {
		this.nom_empleat = nom_empleat;
	}

	public String getData_ticket() {
		return data_ticket;
	}

	public void setData_ticket(String data_ticket) {
		this.data_ticket = data_ticket;
	}

	public Producte getP() {
		return p;
	}

	public void setP(Producte p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "ticket [codi_ticket=" + codi_ticket + ", nom_empleat=" + nom_empleat + ", data_ticket=" + data_ticket
				+ ", p=" + p + "]";
	}
	
	
	
	
	
}
