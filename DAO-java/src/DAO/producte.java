package DAO;

import java.io.Serializable;

public class producte implements Serializable{

  int PROD_NUM;
  String DESCRIPCIO;
  
  
  
public producte() {
	
}

public producte(int pROD_NUM, String dESCRIPCIO) {
	PROD_NUM = pROD_NUM;
	DESCRIPCIO = dESCRIPCIO;
}
public int getPROD_NUM() {
	return PROD_NUM;
}
public void setPROD_NUM(int pROD_NUM) {
	PROD_NUM = pROD_NUM;
}
public String getDESCRIPCIO() {
	return DESCRIPCIO;
}
public void setDESCRIPCIO(String dESCRIPCIO) {
	DESCRIPCIO = dESCRIPCIO;
}
  
  
}
