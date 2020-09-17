package Exercici1;
import java.util.Scanner; 

public class Programa { 
	public static void main(String[]args) {
		
	Scanner scan= new Scanner(System.in); 
	int a=0;
	
	System.out.print("Entrar numero de alumnes: "); 

	a= scan.nextInt();
	scan.nextLine();
	
	String [] nomAlumnes = new String [a];
	
	int c=0;
	
	while(c<a) {
		
		System.out.println("Entrar el nom de l'alumne " + c + ": "); 
		nomAlumnes[c] = scan.nextLine();
		c++;
		
	}
	
	for(int i=0; i<nomAlumnes.length; i++) {		
		System.out.println(nomAlumnes[i]); 
	}
	
	
	
	
	
	
	//System.out.print("Entra numero 2: "); 
	//int n2 = scan.nextInt(); 
	//int n3 = n1+n2; 
	//System.out.println("La súma és: " + n3); 
	//if(n3>0 && n3<=5) { 
	//System.out.println("1"); 
	//} else if(n3>5 && n3<=8) {
	//	System.out.println("2"); 
	//	} 
	//else if(n3>8) {
	//	System.out.println("3"); } 
	//else { 
	//	System.out.println("ERROR!"); 
	}
} 
	
 