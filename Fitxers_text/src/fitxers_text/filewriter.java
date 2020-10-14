package fitxers_text;

import java.io.FileWriter;
import java.util.Scanner;

public class filewriter {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		try {
			FileWriter fw = new FileWriter("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\HOLA.txt",true);
			String frase = scan.nextLine();
			String[] lletres =  frase.split("");
			for (String a:lletres) {
				
			}
			
		}catch (Exception e) {
			
		}

	}

}
