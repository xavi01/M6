package fitxers_text;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class filewriter {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		try {
			FileWriter fw = new FileWriter("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\HOLA.txt",true); //Creem file Writer
			
			String frase = scan.nextLine(); //Entrem frase a escriure
			
			String[] lletres =  frase.split("");
			String[] vocals = {"a", "e", "i", "o", "u"};
			
			fw.write("\n");
					
			for (String a:lletres) {
				
				if(a.equals(vocals[0]) || a.equals(vocals[1]) || a.equals(vocals[2]) || a.equals(vocals[3]) || a.equals(vocals[4])) {
					a="i"; //Si es ("a,e,i,o,u") sera una "i"
				}
				
				fw.write(a);
			}
			
			fw.close();
			
			FileReader fr = new FileReader("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\HOLA.txt");  //Creem File Reader
			
			int read = fr.read();  // Retorna -1 quan acava de llegir tot
			
			while (read!=-1) {
				System.out.println((char)read);
				read = fr.read(); 
			}
			
			fr.close();
			
		}catch (Exception e) {
			
		}

	}

}
