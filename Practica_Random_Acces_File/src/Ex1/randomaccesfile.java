package Ex1;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class randomaccesfile {
	
	static Scanner sc = new Scanner(System.in);
	static RandomAccessFile fichero = null;

	public static void main(String[] args) {
	int numero=0;

		    try {
		    	fichero = new RandomAccessFile("numerros.txt", "rw");
		    	
		    	for(int i=1; i<11; i++) {
		         System.out.print("Introduce número " + i +":");                    
		         numero = sc.nextInt(); //se lee el entero a añadir en el fichero
		         fichero.seek(fichero.length()); //nos situamos al final del fichero
		         fichero.writeInt(numero);       //se escribe el entero		    	
		    	}		    
	
		    		mostrarFichero();//muestra el contenido del fichero después de añadir los números
	    	fichero.close();
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
}    
			private static void mostrarFichero() {
				// TODO Auto-generated method stub
				    try {
				        fichero.seek(0); //nos situamos al principio
				        
				        for(int i=0; i<11; i=i+2) {
				        	fichero.seek(i); 
				        	int a= fichero.readInt();
				            System.out.println(a);  //se muestra en pantalla
				        }
				        
				    } catch (EOFException e) {
				        System.out.println("Fin de fichero");
				    } catch (IOException ex) {
				        System.out.println(ex.getMessage());
				    }
             }
	}
