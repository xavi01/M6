package fitxers_text;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class reemplazar_palabras {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		try {
			FileReader fr= new FileReader ("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\hola.txt");		
			
			int lletra = fr.read();  //Llegir contingut arxiu
			String text ="";
			
			while (lletra != -1){ //Mentres no sigui -1(-1 es quna ha acavat de llegir tot)	
				text= text +(char)lletra; //Escriure el contingut del arxiu a un string lletra per lletra
				lletra= fr.read();	//Llegir contingut de l'arxiu
			}
			
			System.out.println(text); //Et mostra el text original que hiha a l'arxiu
			
			System.out.print("Quina paraula vols cambiar: ");
			String pararula_cambiar = scan.nextLine();
			
			
			if(text.contains(pararula_cambiar)) { //Si el text té la paraula a cambiar entrara
				
				System.out.print("Quina serà la paraula nova: ");
				String pararula_nova = scan.nextLine();
				
				text = text.replaceAll(pararula_cambiar, pararula_nova); //cambiar la paraula
				
				System.out.println(text);
				fr.close();
				
				
				FileWriter fw = new FileWriter("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\hola.txt");
				fw.write(text); //Escriu al fitxer el contingut del string text
				fw.close();
				
				
			}else {
				System.out.println("No s'ha trobat la paraula.");
			}
	
		}catch (Exception e){
			
		}
		
	}

}
