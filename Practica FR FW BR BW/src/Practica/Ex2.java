package Practica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		try {
		
		FileReader fr = new FileReader("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\Practica FR FW BW BR\\Dades.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String[] text= new String[15]; //Cada casella de l'array sera una linea.
		int i = 0; //contador per augmentar l'array
		
		String line = br.readLine(); //Buffered line et llegeix tota una linea
		System.out.println(line);
		text[0]=line; //Guardem la primera linea
		
		while(line != null) { //Anira mostrant linea linea mentre br no sigui null que es quan acava de llegir
		  i++;
	      line = br.readLine(); //Llegir la linea
		  System.out.println(line);  //Printar linea
		  text[i]=line; //Guardar la linea llegida a un array
		}
		
		br.close();
		fr.close();
		
		System.out.println();
		System.out.print("Introdueix un ID: ");
		String id = scan.nextLine();
		
		for(int c=0;c<text.length-1;c++) { //Recorrer cada linea del text
			
			if(text[c].contains(id)) {	//Si la linea te l'ID entrara		
				String[] email = text[c].split("//");  //Separar la linea guardant cada part a un Array
				System.out.print("El correu de l'ID " + id + " és: " + email[3] ); 
			}
			
		}
		
		}catch (Exception e){
			
		}	
	}
}


