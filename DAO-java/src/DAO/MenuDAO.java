package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuDAO {
	
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
              mostrar();
			}
			
			if(a==2) {
				insertar();
			}
			
			if(a==3) {
				actualitzar();
			}
			
			if(a==4) {
				borrar();
			}
			
			if(a==5) {
				s=true;
			}

	  }

    }

	public static void mostrar() {
		try {

			System.out.println("Quina taula vols mostrar:");
			System.out.println("1- Producte");
			System.out.println("2- Detall");
			System.out.println("3- Comanda");
			System.out.print("Triar taula: ");
			int a= scan.nextInt();
			System.out.println();
			
			if(a==1) {

				producte prod = new producte(); 
				producteDAO productDAO = new producteDAO();
				
				productDAO.findAll();
			}
			
			if(a==2) {
				detall det = new detall();
			    detallDAO detDAO = new detallDAO();
				detDAO.findAll();
				
			}
			
			if(a==3) {

				comanda com = new comanda();
				comandaDAO comDAO = new comandaDAO();
				comDAO.findAll();

			}
			
		}catch (Exception e){
			
		}
	}
	
	public static void insertar() {
		try {

			System.out.println("A quina taula vols insertar:");
			System.out.println("1- Producte");
			System.out.println("2- Comanda");
			System.out.println("3- Detall");
			System.out.print("Triar taula: ");
			int a= scan.nextInt();
			System.out.println();
			
			if(a==1) {
				System.out.print("Entrar numero de producte: ");
				int num = scan.nextInt();
				System.out.print("Entrar descripcio: ");
				String descripcio = scan.next();
				
				producte prod = new producte(num, descripcio); 
				producteDAO productDAO = new producteDAO();
				
				productDAO.add(prod);
				
			}
			
			if(a==2) {
				System.out.print("Entrar numero de comanda: ");
				int num_com = scan.nextInt();
				System.out.print("Entrar data de comanda: ");
				String data_com = scan.next();
				System.out.print("Entrar tipus de comanda: ");
				String tipus = scan.next();
				System.out.print("Entrar codi de client: ");
				int codi_client = scan.nextInt();
				System.out.print("Entrar data de tramesa: ");
				String data_tramesa = scan.next();
				System.out.print("Entrar total: ");
				double total = scan.nextDouble();
				
				comanda com = new comanda(num_com,data_com,tipus,codi_client,data_tramesa,total);
				comandaDAO comDAO = new comandaDAO();
				comDAO.add(com);
				
			}
			
			if(a==3) {
				System.out.print("Entrar numero de comanda: ");
				int num_com = scan.nextInt();
				System.out.print("Entrar numero de detall: ");
				int det_num = scan.nextInt();
				System.out.print("Entrar numero de producte: ");
				int prod_num = scan.nextInt();
				System.out.print("Entrar preu de venda: ");
				double preu_venda = scan.nextDouble();
				System.out.print("Entrar quantitat: ");
				int quantitat = scan.nextInt();
				System.out.print("Entrar import: ");
				double immport = scan.nextDouble();
				
				detall det = new detall(num_com,det_num,prod_num,preu_venda,quantitat,immport);
			    detallDAO detDAO = new detallDAO();
				detDAO.add(det);

			}
			
		}catch (Exception e){
			
		}
	}
	
	public static void actualitzar() {
		try {

			System.out.println("Quina taula vols actualizar:");
			System.out.println("1- Producte");
			System.out.println("2- Comanda");
			System.out.println("3- Detall");
			System.out.print("Triar taula: ");
			int a= scan.nextInt();
			System.out.println();
			
			if(a==1) {
				System.out.print("Entrar numero de producte a actualitzar: ");
				int num = scan.nextInt();
				System.out.print("Entrar nova descripcio: ");
				String descripcio = scan.next();
				
				producteDAO productDAO = new producteDAO();
				
				productDAO.update(num, descripcio);

			}
			
			if(a==2) {
				System.out.print("Entrar numero de comanda a actualitzar: ");
				int num = scan.nextInt();
				System.out.print("Entrar nou total: ");
				double total = scan.nextDouble();
				
				
				comandaDAO comDAO = new comandaDAO();
				comDAO.update(num, total);
						
			}
			
			if(a==3) {
				System.out.print("Entrar numero de comanda a actualitzar: ");
				int num = scan.nextInt();
				System.out.print("Entrar detall de comanda a actualitzar: ");
				int det = scan.nextInt();
				System.out.print("Entrar nova quantitat: ");
				int quant = scan.nextInt();
				System.out.print("Entrar nou import: ");
				double imp = scan.nextDouble();
				
				
				detallDAO detDAO = new detallDAO();
				detDAO.update(quant, imp, num, det);
				
			}
			
		}catch (Exception e){
			
		}
	}
	
	
	public static void borrar() {
		try {

			System.out.println("De quina taula vols borrar:");
			System.out.println("1- Producte");
			System.out.println("2- Comanda");
			System.out.println("3- Detall");
			System.out.print("Triar taula: ");
			int a= scan.nextInt();
			System.out.println();
			
			if(a==1) {
				System.out.print("Entrar numero de producte a borrar: ");
				int num= scan.nextInt();
				
				producteDAO product = new producteDAO();
				product.delete(num);

			}
			
			if(a==2) {
				System.out.print("Entrar numero de comanda a borrar: ");
				int num= scan.nextInt();
				
				comandaDAO comanda = new comandaDAO();
				comanda.delete(num);
				
			}
			
			if(a==3) {
				System.out.print("Entrar numero de comanda a borrar: ");
				int num= scan.nextInt();
				
				detallDAO detall = new detallDAO();
				detall.delete(num);

			}
			
		}catch (Exception e){
			
		}
	}
	
}
