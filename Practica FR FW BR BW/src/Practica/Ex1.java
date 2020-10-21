package Practica;

import java.io.FileReader;

public class Ex1 {

	public static void main(String[] args) {
		
	try {
			
		FileReader fr= new FileReader ("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\Practica FR FW BW BR\\Poema.txt");

		int lletra = fr.read();
		
		String text = "";
		
		while (lletra != -1){ 
			text= text +(char)lletra; 
			lletra= fr.read();	
		}
		
		System.out.println(text);
		
		String [] texto =  text.split(" ");
		
		for(int i=texto.length; i<1; i--) {
			System.out.println(texto[i]);
		}
			
			 
			
			
			
			
		
	}catch (Exception e){
		
	}
		
	}

}
