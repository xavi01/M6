package Exercici1;

import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


class file {

	public static void main(String[] args) {
		
		File ruta = new File("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\ExercicisGIT\\M6","HOLAQUETAL.txt");
		File f1 = new File(ruta,"HOLA QUE TAL1.txt");
		File ruta1 = new File("C:\\Users\\xavie\\Escritorio\\SALLE\\LLUBES\\M6 - ACCES A DADES\\ExercicisGIT\\M6");
			
			System.out.println(ruta.getName());
			System.out.println(f1.getParent());

			
	   String [] llista = ruta1.list();
	   ArrayList<File> llistafiles = new ArrayList();
	   
	   
	   for(String a:llista) { //Creem un for de strings, que recorrera l'arrray de Strings llista[]
		   File b = new File(ruta1,a); //Creem objecte file per poder ficarlo dins d'un ArrayList d'objectes File
		   llistafiles.add(b);//Afegim l'objecte File "b" a l'array llistafiles[]
	   }
	  
	   
	   
	   for(File c:llistafiles) {
		   
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTimeInMillis(c.lastModified());
		   
		   int Year = calendar.get(Calendar.YEAR);
		   int Month = calendar.get(Calendar.MONTH);
		   int Day = calendar.get(Calendar.DAY_OF_MONTH);
		   int Hour = calendar.get(Calendar.HOUR);
		   int Minute = calendar.get(Calendar.MINUTE);  
		   
		   
		   	   if (c.isDirectory()) {
		   		  System.out.println(Day + "/" + Month + "/" + Year + "  " + Hour + ":" + Minute + "  " +c.getName()+ " is a directory i té un tamany de " + c.length() +" bytes.");
		   	   }
		   	   if (c.isFile()) {
		   		  System.out.println(Day + "/" + Month + "/" + Year + "  " + Hour + ":" + Minute + "  " +c.getName()+ " is a File i té un tamany de " + c.length() + " bytes.");
		   	   }
	   }
	   
	   
		
	   
	}
}
