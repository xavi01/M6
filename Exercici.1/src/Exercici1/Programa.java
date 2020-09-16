package Exercici1;
import java.util.Scanner; 

public class Programa { 
	public static void main(String[]args) {
		
	Scanner scan= new Scanner(System.in); 
	System.out.print("Entrar numero 1: "); 
	int n1 = scan.nextInt();
	System.out.print("Entra numero 2: "); 
	int n2 = scan.nextInt(); 
	int n3 = n1+n2; 
	System.out.println("La súma és: " + n3); 
	if(n3>0 && n3<=5) { 
		System.out.println("1"); 
	} else if(n3>5 && n3<=8) {
		System.out.println("2"); 
		} 
	else if(n3>8) {
		System.out.println("3"); } 
	else { 
		System.out.println("ERROR!"); 
	}
} 
	}
