package Ex;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

class EscriureNumeroFinal {

static Scanner sc = new Scanner(System.in);
static RandomAccessFile fichero = null;

public static void main(String[] args) {
    int numero;
    try {
        //se abre el fichero para lectura y escritura
        fichero = new RandomAccessFile("ficheros/enteros.dat", "rw");
        mostrarFichero(); //muestra el contenido original del fichero
        System.out.print("Introduce un n�mero entero para a�adir al final del fichero: ");                    
        numero = sc.nextInt(); //se lee el entero a a�adir en el fichero
        fichero.seek(fichero.length()); //nos situamos al final del fichero
        fichero.writeInt(numero);       //se escribe el entero
        mostrarFichero();//muestra el contenido del fichero despu�s de a�adir el n�mero

    } catch (FileNotFoundException ex) {
        System.out.println(ex.getMessage());
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    } finally {
        try {
            if (fichero != null) {
                fichero.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

public static void mostrarFichero() {
    int n;
    try {
        fichero.seek(0); //nos situamos al principio
        while (true) {
            n = fichero.readInt();  //se lee  un entero del fichero                                           
            System.out.println(n);  //se muestra en pantalla
        }
    } catch (EOFException e) {
        System.out.println("Fin de fichero");
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
}
}