package Ex2;

import java.io.RandomAccessFile;
import java.util.Scanner;


public class randomaccesfile {

	static Scanner sc = new Scanner(System.in);
	static RandomAccessFile fichero = null;

	public static void main(String[] args) {
	String frase="";
	char lletra_canviar;
	char lletra_nova;

		    try {
		    	
		    	 fichero = new RandomAccessFile("frase.dat", "rw");
		    	  System.out.println("Entra la frase:");                    
			      frase = sc.nextLine(); //se lee la frase a añadida en el fichero
			      
			      fichero.writeBytes(frase); //Escriure frase
			      
			      System.out.println("Quina lletra vols canviar:");                    
			      lletra_canviar = sc.nextLine().charAt(0); 
			         
			      System.out.println("Quina lletra vols ficar:");                    
			      lletra_nova = sc.nextLine().charAt(0);

		         
		         System.out.println("" + fichero.readLine());
		         
		         for(int i=0; i==fichero.length(); i++) {
		        	 fichero.seek(i);
		        	 if(fichero.readChar()==lletra_canviar) {
		        		 fichero.writeChar(lletra_nova);
		        	 }
		         }

		         fichero.seek(0);
		         System.out.println("" + fichero.readLine());

		         
		         fichero.close();
		    	
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
    }
}
