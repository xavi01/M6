package random;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class randomaccesfile {
	
	static Scanner sc = new Scanner(System.in);
	static RandomAccessFile fichero = null;

	public static void main(String[] args) {

	    try {
	    	fichero = new RandomAccessFile("nomms.txt", "rw");  //ficher sobre el que treballem
	    	
	    	for(int i=0; i<10; i++) {  //bucle per introduir noms
	         System.out.print("Entrar nom " + i + ": ");                    
	         String nom = sc.next();
	         fichero.seek(fichero.length()); //situar al final del fitxer
	         fichero.writeChars(nom);	  //escriure   	
	    	}		    	
	    	System.out.println();
	    	
	    	System.out.print("Quin nom vols esborrar: ");
	    	String nom1 = sc.next(); //entrar nom a borrar
	    	
	        fichero.seek(0); //situarnos al principi
	        
	        for(int i=0; i<10; i++) {
	        	fichero.seek(i); 
	        	if(nom1.equals(fichero.readUTF())) { //si llegeix el mateix que el nom introduit 
	        		fichero.writeChars("");  //"esborrar" no he trobat cap metode de la classe random per borrar
	        	}
	        }
	    		
    	  fichero.close();
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        } 
   }    
	
}


