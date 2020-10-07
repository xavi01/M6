package PracticaCMD;

import java.util.Scanner;
import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;


class CMD {

	public static void main(String[] args) throws IOException {
		
		
		Scanner lector = new Scanner(System.in);
		String comanda;	
		String exit = "exit";
		
		File ruta = new File ("C:\\Users\\xavie\\Escritorio"); //Ruta inicial que anira cambiant

		System.out.print(ruta.getParent()+">");
		comanda = lector.nextLine(); //Entrar comanda
		
        String[] parts = comanda.split(" "); //Partir comanda
		
		
		
		while(!exit.equals(comanda)) {
			
			
		if(parts[0].equals("dir") || parts[0].equals("DIR") ) {    //DIR   
			
			   String [] llista = ruta.list();
			   ArrayList<File> llistafiles = new ArrayList();	
			   int dirs =0;
			   int archivos=0;
			   
			   for(String a:llista) { //Creem un for de strings, que recorrera l'arrray de Strings llista[]
				   File b = new File(ruta,a); //Creem objecte file per poder ficarlo dins d'un ArrayList d'objectes File
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
				   System.out.println(Day + "/" + Month + "/" + Year + "  " + Hour + ":" + Minute + "     "+"<DIR>" + "     "+c.getName() +" " + c.length() +" bytes");	
				   dirs++;
				   }else {
				   System.out.println(Day + "/" + Month + "/" + Year + "  " + Hour + ":" + Minute + "              " +c.getName() +" " + c.length() +" bytes");	
				   archivos++;
				   }
				   
				   
			   }
			   
			   System.out.println("                " +archivos + " archivos");
			   System.out.println("                " +dirs + " dirs");
			    
			   System.out.print(ruta.getParent()+">");
			   comanda = lector.nextLine();
			   parts = comanda.split(" "); //Partir comanda			  	
	    }   
		
		
		
		
		
		
		else if(parts[0].equals("cd") || parts[0].equals("CD") ) {	 //CD				
		    
		    ruta= new File(parts[1]); //Renombrar ruta per accedir a aquesta
		    
			System.out.print(ruta.getParent()+">");		
			comanda = lector.nextLine();
			parts = comanda.split(" ");				
		}
		
		
				
		
		else if(parts[0].equals("mkdir") ) {	 //mkdir
				
	    	File f = new File(ruta, parts[1]);
		    	    	
	    	if (!f.exists()) {  //Comprovem si el fitxer no existeix 	            	          
	                    if (f.createNewFile()) {  //Se cree el fitxer, si s'ha creat correctament
	                        System.out.println("Fitxer " + f.getName() + " creat");
	                    } else {   //No s'ha creat correctament
	                        System.out.println("No s'ha pogut crear " + f.getName());
	                    }      
	        } else { //El fitxer ja existeix
	            System.out.println("Fichero " + f.getName() + " ya existe");
	        }
	    	
			System.out.print(ruta.getParent()+">");		
			comanda = lector.nextLine();
			parts = comanda.split(" ");			
		}
		
	
	     
	     
		else if(parts[0].equals("del") ) {	 //del
								
			File d = new File(ruta, parts[1]);       
			
			if (!d.exists()) {  //Comprovem si el fitxer no existeix 
	            System.out.println("El fitxer " + d.getName() + " no existeix");	            	                                  
	        } else { //El fitxer existeix

	        	if (d.delete()) {  //S'ha eliminat, si s'ha eliminat correctament
                    System.out.println("Fitxer " + d.getName() + " eliminat");
                } else {   //No s'ha creat correctament
                    System.out.println("No s'ha pogut eliminar " + d.getName());
                }      	
	        }
			 	
			
	       System.out.print(ruta.getParent()+">");		
		   comanda = lector.nextLine();
		   parts = comanda.split(" ");			
		}
			
	     
   
		
		else if(parts[0].equals("rename") ) {	 //rename
				
		   File r = new File(ruta, parts[1]);
		   File r1 = new File(ruta, parts[2]);
			
			if (!r.exists()) {  //Comprovem si el fitxer existeix o no
	            System.out.println("El fitxer " + r.getName() + " no existeix");	            	                                  
	        } else { //El fitxer existeix
	        	if (r.renameTo(r1)) {  //S'ha renombrat correctament
                   System.out.println("Fitxer " + r.getName() + " renombrat");
               } else {   //No s'ha renombrat correctament
                   System.out.println("No s'ha pogut renombrar " + r.getName());
               }      	
	        }		 	
			
	       System.out.print(ruta.getParent()+">");		
		   comanda = lector.nextLine();
		   parts = comanda.split(" ");			   		
		}
		
		
		else {
			System.out.println("Comanda erronea.");
			
			  System.out.print(ruta.getParent()+">");		
			   comanda = lector.nextLine();
			   parts = comanda.split(" ");
		}
				
		

		}
					
	}

}

