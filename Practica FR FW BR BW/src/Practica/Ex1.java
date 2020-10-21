package Practica;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex1 {

	public static void main(String[] args) {
		
	try {		

		FileReader fr = new FileReader("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\Practica FR FW BW BR\\Poema.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String[] text= new String[15]; //Cada casella de l'array sera una frase
		int i = 0; //contador per augmentar l'array
		
		System.out.println("Text original: ");
		System. out. println();
		
		String line = br.readLine(); //Buffered line et llegeix tota una linea
		System.out.println(line);
		text[0]=line;

		
		while(line != null) { //Anira mostrant linea linea mentre br no sigui null que es quan acava de llegir
		  i++;
	      line = br.readLine(); //Llegir linea
		  System.out.println(line);  //Printar linea
		  text[i]=line; //Guardar la linea llegida a un array
		
		}
		
		br.close();
		fr.close();
		
		System. out. println();
		System.out.println("El text al revés: ");
		System. out. println();
			
		for (int c=text.length-2; c>=0;c--) {	
			System.out.println(text[c]);	
		}
		
	}catch (Exception e){
		
	}
		
	}

}

