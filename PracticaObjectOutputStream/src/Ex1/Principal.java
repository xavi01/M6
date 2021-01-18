package Ex1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		try {

			ArrayList<Producte> llistap = new ArrayList<>();
			ArrayList<ticket> llistat = new ArrayList<>();

			//IMPORTAR PROCUTES
			
			File archivo = new File("productes.dat");

			if (archivo.exists()) {  //Comprovar si l'arxiu existeix
				FileInputStream fis = new FileInputStream("productes.dat");
				
				if (fis.available() != 0) { //Si hiha algo escrit entrara
					ObjectInputStream ois = new ObjectInputStream(fis);

					while (fis.available() != 0) { //Mentres hi haigi algo u anira guardant
						Producte p = (Producte) ois.readObject();
						//System.out.println(p.toString());
						llistap.add(p);
					}
					ois.close();
					fis.close();
				}						
			}
			
			//IMPORTAR TICKETS
			
			File archivo1 = new File("tickets.dat");
			
			if (archivo1.exists()) {  //Comprovar si l'arxiu de tickets existeix
				FileInputStream fis1 = new FileInputStream("tickets.dat");
				
				if (fis1.available() != 0) { //Si hiha algo escrit entrara
					ObjectInputStream ois1 = new ObjectInputStream(fis1);

					while (fis1.available() != 0) { //Mentres hi haigi algo u anira guardant
						ticket t = (ticket) ois1.readObject();
						//System.out.println(p.toString());
						llistat.add(t);
					}
					ois1.close();
					fis1.close();
				}				
			}
			
			int c = 0;
			boolean sortir = false;

			while (sortir != true) {

				System.out.println("1. Crear producte i ticket.");
				System.out.println("2. Mostrar preu d'un producte.");
				System.out.println("3. Modificar preu d'un producte.");
				System.out.println("4. Mostrar tots els productes i tickets.");
				System.out.println("5. Esborrar un producte.");
				System.out.println("6. Sortir.");

				System.out.print("Triar opcio: ");
				c = scan.nextInt();
				System.out.println();

				if (c == 1) { // Crear producte i ticket

					System.out.print("Entrar nom producte: ");
					String nom = scan.next();

					System.out.print("Entrar preu producte: ");
					Double preu = scan.nextDouble();

					System.out.print("Entrar stock producte: ");
					int stock = scan.nextInt();
					System.out.println();

					Producte p = new Producte(nom, preu, stock);
					llistap.add(p);
					
					
					System.out.print("Entrar codi ticket: ");
					int codi = scan.nextInt();

					System.out.print("Entrar nom empleat: ");
					String empleat = scan.next();

					System.out.print("Entrar data ticket: ");
					String data = scan.next();					
									
					System.out.println();
					
					ticket t = new ticket(codi, empleat, data, p);
					llistat.add(t);
									
				}

				if (c == 2) { // Mostrar preu d'un producte
					boolean p = false;
					System.out.print("De quin producte vols saber el preu: ");

					String nomp = scan.next(); // Entrar nom del prod per buscarlo

					for (Producte product : llistap) { // producte es cada producte de dins l'array
						if (product.getNom().equals(nomp)) { // Si el nom introduit es igual a algun producte mostrara
																// el preu
							System.out.println("El preu es: " + product.getPreu() + "€");
							p = true; // Li direm que ha trobat el producte
						}
					}

					if (p == false) { // En cas de no trobar el producte ens avisara
						System.out.println("No s'ha trobat el producte.");
					}
					System.out.println();

				}

				if (c == 3) { // Modificar preu d'un producte

					boolean p = false;
					System.out.print("De quin producte vols modificar el preu: ");

					String nomp = scan.next(); // Entrar nom del prod per buscarlo

					for (Producte product : llistap) { // producte es cada producte de dins l'array
						if (product.getNom().equals(nomp)) { // Si el nom introduit es igual a algun producte de l'array
							System.out.print("Quin preu li vols posar: ");
							double preu = scan.nextDouble();
							product.setPreu(preu);
							p = true; // Li direm que ha trobat el producte
						}
					}

					if (p == false) { // En cas de no trobar el producte ens avisara
						System.out.println("No s'ha trobat el producte.");
					}
					System.out.println();

				}

				if (c == 4) { // Mostrar tots els productes i tickets

					for (Producte product : llistap) { // producte es cada producte de dins l'array
						System.out.println(product.toString());
					}
					
					for (ticket ticket : llistat) { // ticket es cada ticket de dins l'array
						System.out.println(ticket.toString());
					}
					
					System.out.println();
				}

				if (c == 5) { // Esorrar un producte

					boolean p = false;
					System.out.print("Quin producte vols esborrar: ");

					String nomp = scan.next(); // Entrar nom del prod per buscarlo

					for (Producte product : llistap) { // producte es cada producte de dins l'array

						if (product.getNom().equals(nomp)) { // Si el nom introduit es igual a algun producte de l'array
							llistap.remove(product);
							p = true; // Li direm que ha trobat el producte
							break; // Sortir del foreach
						}
					}

					if (p == false) { // En cas de no trobar el producte ens avisara
						System.out.println("No s'ha trobat el producte.");
					}
					System.out.println();

				}

				if (c == 6) { // Sortir

					FileOutputStream fos = new FileOutputStream("productes.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (Producte p : llistap) {						
						oos.writeObject(p); //Guardar objecte producte al arxiu
					}

					fos.close();
					oos.close();
					
					FileOutputStream fos1 = new FileOutputStream("tickets.dat");
					ObjectOutputStream oos1 = new ObjectOutputStream(fos1);

					for (ticket t : llistat) {						
						oos1.writeObject(t); //Guardar objecte ticket al arxiu
					}

					fos1.close();
					oos1.close();
					
	
					sortir = true;

				}

			}

		} catch (Exception e) {

		}

	}
}
