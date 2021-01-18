package DAO;

import java.io.Serializable;

public class comanda implements Serializable {
	
	int COM_NUM;
    String COM_DATA;
    String COM_TIPUS;
    int CLIENT_COD;
    String DATA_TRAMESA;
    double TOTAL;
     
	public comanda() {
		
	}
	
	
	
	public comanda(int cOM_NUM, String cOM_DATA, String cOM_TIPUS, int cLIENT_COD, String dATA_TRAMESA, double tOTAL) {
		COM_NUM = cOM_NUM;
		COM_DATA = cOM_DATA;
		COM_TIPUS = cOM_TIPUS;
		CLIENT_COD = cLIENT_COD;
		DATA_TRAMESA = dATA_TRAMESA;
		TOTAL = tOTAL;
	}


	public int getCOM_NUM() {
		return COM_NUM;
	}
	public void setCOM_NUM(int cOM_NUM) {
		COM_NUM = cOM_NUM;
	}
	public String getCOM_DATA() {
		return COM_DATA;
	}
	public void setCOM_DATA(String cOM_DATA) {
		COM_DATA = cOM_DATA;
	}
	public String getCOM_TIPUS() {
		return COM_TIPUS;
	}
	public void setCOM_TIPUS(String cOM_TIPUS) {
		COM_TIPUS = cOM_TIPUS;
	}
	public int getCLIENT_COD() {
		return CLIENT_COD;
	}
	public void setCLIENT_COD(int cLIENT_COD) {
		CLIENT_COD = cLIENT_COD;
	}
	public String getDATA_TRAMESA() {
		return DATA_TRAMESA;
	}
	public void setDATA_TRAMESA(String dATA_TRAMESA) {
		DATA_TRAMESA = dATA_TRAMESA;
	}
	public double getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(double tOTAL) {
		TOTAL = tOTAL;
	}
    
    


}
