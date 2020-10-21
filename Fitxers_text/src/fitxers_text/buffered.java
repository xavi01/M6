package fitxers_text;

import java.io.BufferedReader;
import java.io.FileReader;

public class buffered {

	public static void main(String[] args) {
		
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
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
