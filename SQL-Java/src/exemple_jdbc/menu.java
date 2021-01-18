package exemple_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class menu {

	static Connection conn = null; //Crear conexio com static per poder compartirse amb tots els metodes.
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
				
		boolean s = false;
		
	   while (s==false) {

		    System.out.println("Que vols fer:");
			System.out.println("1- Mostrar");
			System.out.println("2- Insertar");
			System.out.println("3- Actualitzar");
			System.out.println("4- Borrar");
			System.out.println("5- Sortir");
			System.out.print("Triar opcio: ");
			
			int a = scan.nextInt();
			System.out.println();
		
		   if(a==1) {
			   connectar();
			   mostrar();
		   }
		   
           if(a==2) {
        	   connectar();
			   insertar();
		   }
		   
 
          if(a==3) {
        	  connectar();
	          actualitzar();
          }
 
          if(a==4) {
        	  connectar();
	          borrar();
         }
 
         if(a==5) {
         	s=true;   
         }
  
	   }
		
	}
	
	private static void connectar() {
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			   String URL = "jdbc:mysql://localhost/empresa";
			   String USER = "root";
			   String PASS = "";
			   conn = DriverManager.getConnection(URL, USER, PASS);
			   //System.out.println("S'ha onnectat correctament.");
		} catch (Exception e){
			
		}
	}
	

	public static void mostrar() {
		try {

			System.out.println("Quina taula vols mostrar:");
			System.out.println("1- Client");
			System.out.println("2- Empleat");
			System.out.println("3- Producte");
			System.out.print("Triar opcio: ");
			int a= scan.nextInt();
			System.out.println();
			
			if(a==1) {
			
				   String sql= "SELECT* FROM client";
				   Statement stmnt = conn.createStatement();
				   ResultSet result = stmnt.executeQuery(sql);
				   
				   while(result.next()) {
					   System.out.print("CLIENT_COD: " + result.getInt(1) + " ");
					   System.out.print("NOM: " + result.getString(2) + " ");
					   System.out.print("ADREÇA: " + result.getString(3) + " ");
					   System.out.print("CIUTAT: " + result.getString(4) + " ");
					   System.out.print("ESTAT: " + result.getString(5) + " ");		
					   System.out.print("CODI POSTAL: " + result.getString(6) + " ");
					   System.out.print("AREA: " + result.getInt(7) + " ");
					   System.out.print("TELEFON: " + result.getString(8) + " ");
					   System.out.print("REPR COD: " + result.getInt(9) + " ");
					   System.out.print("LIMIT CREDIT: " + result.getDouble(10) + " ");
					   System.out.println("OBSERVACIONS: " + result.getString(11) + " ");
				   }
				
			}
			
			if(a==2) {
				
				   String sql= "SELECT* FROM emp";
				   Statement stmnt = conn.createStatement();
				   ResultSet result = stmnt.executeQuery(sql);
				   
				   while(result.next()) {
					   System.out.print("NOM EMPLEAT: " + result.getInt(1) + " ");
					   System.out.print("COGNOM: " + result.getString(2) + " ");
					   System.out.print("OFICI: " + result.getString(3) + " ");
					   System.out.print("CAP: " + result.getInt(4) + " ");
					   System.out.print("DATA ALTA: " + result.getString(5) + " ");		
					   System.out.print("SALARI: " + result.getInt(6) + " ");
					   System.out.print("COMISSIO: " + result.getInt(7) + " ");
					   System.out.println("N DEPARTAMENT: " + result.getInt(8) + " ");

				   }
				
			}
			
			if(a==3) {
				
				   String sql= "SELECT* FROM producte";
				   Statement stmnt = conn.createStatement();
				   ResultSet result = stmnt.executeQuery(sql);
				   
				   while(result.next()) {
					   System.out.print("NUMERO PRODUCTE: " + result.getInt(1) + " ");
					   System.out.println("DESCRIPCIO: " + result.getString(2) + " ");  
				   }
				
			}
			
			
			
			System.out.println();		
				
		conn.close();
		}catch (Exception e){
			
		}
	}
	
	
	
    public static void insertar() {
		try {
			
			System.out.println("Quina taula vols insertar:");
			System.out.println("1- Client");
			System.out.println("2- Empleat");
			System.out.println("3- Producte");
			System.out.print("Triar opcio: ");
			int a= scan.nextInt();
			System.out.println();
			
			if(a==1) {  //INSERTAR CLIENT
			
				System.out.print("Entrar codi: ");
				int codi = scan.nextInt();
				System.out.print("Entrar nom: ");
				String nom= scan.next();
				System.out.print("Entrar adreça: ");
				String adreça= scan.next();
				System.out.print("Entrar ciutat: ");
				String ciutat= scan.next();
				System.out.print("Entrar estat: ");
				String estat= scan.next();
				System.out.print("Entrar codi postal: ");
				String codi_p= scan.next();
				System.out.print("Entrar area: ");
				int area= scan.nextInt();
				System.out.print("Entrar telefon: ");
				String telefon= scan.next();
				System.out.print("Entrar repr cod: ");
				int repr= scan.nextInt();
				System.out.print("Entrar limit credit: ");
				Double limit = scan.nextDouble();
				System.out.print("Entrar Observacions: ");
				String observacions= scan.next();
				
				   
				String sql = ("INSERT INTO client VALUES (?,?,?,?,?,?,?,?,?,?,?)");
				
				PreparedStatement psInsertar = (PreparedStatement) conn.prepareStatement(sql);
						
				   
				   psInsertar.setInt(1,codi);
				   psInsertar.setString(2,nom);
				   psInsertar.setString(3,adreça);
				   psInsertar.setString(4,ciutat);
				   psInsertar.setString(5,estat);
				   psInsertar.setString(6,codi_p);
				   psInsertar.setInt(7,area);
				   psInsertar.setString(8,telefon);
				   psInsertar.setInt(9,repr);
				   psInsertar.setDouble(10,limit);
				   psInsertar.setString(11,observacions);
				   
				   psInsertar.executeUpdate();				  	
					
				  
			}
			
			if(a==2) { //INSERTAR EMPLEAT
				
				System.out.print("Entrar numero empleat: ");
				int codi = scan.nextInt();
				System.out.print("Entrar Cognom: ");
				String cognom= scan.next();
				System.out.print("Entrar ofici: ");
				String ofici= scan.next();
				System.out.print("Entrar cap: ");
				int cap= scan.nextInt();
				System.out.print("Entrar data alta: ");
				String data= scan.next();
				System.out.print("Entrar salari: ");
				int salari= scan.nextInt();
				System.out.print("Entrar comissio: ");
				int comissio= scan.nextInt();
				System.out.print("Entrar numero departament: ");
				int dept= scan.nextInt();
				   
				String sql = ("INSERT INTO emp VALUES (?,?,?,?,?,?,?,?)");
				
				PreparedStatement psInsertar = (PreparedStatement) conn.prepareStatement(sql);
						
				   
				   psInsertar.setInt(1,codi);
				   psInsertar.setString(2,cognom);
				   psInsertar.setString(3,ofici);
				   psInsertar.setInt(4,cap);
				   psInsertar.setString(5,data);
				   psInsertar.setInt(6,salari);
				   psInsertar.setInt(7,comissio);
				   psInsertar.setInt(8,dept);
				   
				   psInsertar.executeUpdate();		
					
			
			}
			
			if(a==3) { //INSERTAR PRODUCTE
				
				System.out.print("Entrar numero producte: ");
				int num = scan.nextInt();
				System.out.print("Entrar descripcio: ");
				String descrip= scan.next();
				
				String sql1 = ("INSERT INTO producte VALUES (?,?)");
				
				PreparedStatement psInsertar = (PreparedStatement) conn.prepareStatement(sql1);
						
				   
				   psInsertar.setInt(1,num);
				   psInsertar.setString(2,descrip);
				   				   
				   psInsertar.executeUpdate();
				   	
			}
				
			
			System.out.println();
			
		conn.close();
		}catch (Exception e){
			
		}
	}
    
    
    public static void actualitzar() {
		try {
			
			System.out.println("Quina taula vols actualitzar:");
			System.out.println("1- Client");
			System.out.println("2- Empleat");
			System.out.println("3- Producte");
			System.out.print("Triar opcio: ");
			int a= scan.nextInt();
			System.out.println();
			
			
			if (a==1) { //CLIENT
				
				System.out.print("Entrar codi de client a actualitzar: ");
				int cod = scan.nextInt();
				System.out.print("Quin camp vols actualizar: ");
				String camp = scan.next();
				System.out.print("Entrar valor nou: ");
				String valor = scan.next();
				
				Statement stmt = conn.createStatement();
			      String sql3 = "UPDATE client SET " + camp + " = " + valor + " WHERE CLIENT_COD = " + cod;


			    stmt.executeUpdate(sql3);
					
			}
			

			if (a==2) { //EMPLEAT
				
				System.out.print("Entrar numero de empleat a actualitzar: ");
				int num = scan.nextInt();
				System.out.print("Quin camp vols actualizar: ");
				String camp = scan.next();
				System.out.print("Entrar valor nou: ");
				String valor = scan.next();
				
				Statement stmt = conn.createStatement();
			      String sql3 = "UPDATE emp SET " + camp + " = " + valor + " WHERE EMP_NO = " + num;

			    stmt.executeUpdate(sql3);

				
			}
			
			

			if (a==3) {  //PRODUCTE
				
				System.out.print("Entrar numero de producte a actualitzar: ");
				int num = scan.nextInt();
				System.out.print("Quin camp vols actualizar: ");
				String camp = scan.next();
				System.out.print("Entrar valor nou: ");
				String valor = scan.next();
				
				Statement stmt = conn.createStatement();
			      String sql3 = "UPDATE producte SET " + camp + " = " + valor + " WHERE PROD_NUM = " + num;

			    stmt.executeUpdate(sql3);

				
			}
			
			
			
			System.out.println();
			
			
		conn.close();
		}catch (Exception e){
			
		}
    }
    
    public static void borrar() {
		try {
			
			System.out.println("De quina taula vols borrar:");
			System.out.println("1- Client");
			System.out.println("2- Empleat");
			System.out.println("3- Producte");
			System.out.print("Triar opcio: ");
			int a= scan.nextInt();
			System.out.println();
			
			
			if (a==1) { //CLIENT
				
				System.out.print("Entrar codi de client a borrar: ");
				int cod = scan.nextInt();
				
				Statement stmt = conn.createStatement();
			    String sql = "DELETE FROM client WHERE CLIENT_COD = " + cod;
			    stmt.executeUpdate(sql);
					
			}
			

			if (a==2) { //EMPLEAT
				
				System.out.print("Entrar codi de empleat a borrar: ");
				int num = scan.nextInt();
				
				Statement stmt = conn.createStatement();
			    String sql = "DELETE FROM emp WHERE EMP_NO = " + num;
			    stmt.executeUpdate(sql);
				
			}
			
			

			if (a==3) {  //PRODUCTE
				
				System.out.print("Entrar numero de producte a borrar: ");
				int num = scan.nextInt();
				
				Statement stmt = conn.createStatement();
			    String sql = "DELETE FROM producte WHERE PROD_NUM = " + num;
			    stmt.executeUpdate(sql);
				
			}
				
			System.out.println();
			
		conn.close();
		}catch (Exception e){
			
		}
    }

	

}
