package fitxers_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class buffered {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			
			FileReader fr = new FileReader ("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\hola.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine(); //Buffered line et llegeix tota una linea
			
			while(line != null) { //Anira mostrant linea linea mentre br no sigui null que es quan acava de llegir
		      line = br.readLine();
			  System.out.println(line);
			}
			
			br.close();
			fr.close();
			
			FileWriter fw = new FileWriter("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\hola.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			System.out.print("Entra un nom: ");
			String nom = scan.nextLine();
			
			bw.newLine(); //Escriu un salt de linea 
			//bw.write("/n"); una altra manera de salt de linea
			bw.write(nom);
			
			bw.close();
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
