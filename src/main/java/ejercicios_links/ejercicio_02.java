/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_links;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adriano
 */
public class ejercicio_02 {
    public static void solicitarNumeros(ArrayList <Integer> listaNumeros) {
        Integer numero;
        boolean contador = true;
        String salir = "Si";
        Scanner teclado = new Scanner(System.in);

        System.out.println("------Lista de numeros Enteros----------");

        do {
            if (contador == true) {
                System.out.println("Introduce un numero mayor que 0 ");
                numero = teclado.nextInt();
                if (numero <=0) {
                    System.out.println("El numero no es correcto!!!");
                }else{
                    listaNumeros.add(numero);
                    contador = false;
                }
            }

            System.out.println("Introduce otro numero: ");
            numero = teclado.nextInt();
            if (numero <=0) {
                System.out.println("El numero no es correcto!!!");
            }else{
                listaNumeros.add(numero);
                contador = false;
            }
            
            System.out.println("Si quieres dejar de meter numeros escribe: \"Si\"");
            salir = teclado.next();
        } while (salir.equalsIgnoreCase("No"));
        //System.out.println(listaNumeros);
    }

    public static void rellenarDeCeros(ArrayList <Integer> listaNumeros) {
        ArrayList listaCopia = (ArrayList) listaNumeros.clone();
        for (int i = 0; i < listaNumeros.size(); i++) {
            for (int j = 0; j < listaCopia.size(); j++) {
                if ((i != j) && (listaNumeros.get(i) == listaCopia.get(j))) {
                    listaNumeros.set(i, 0);
                    listaNumeros.set(j, 0);
                }
            }
        }
        //System.out.println(listaNumeros);
    }

    public static void mostrarListas(ArrayList <Integer> listaNumeros) {
        System.out.println("------Lista de numeros Enteros----------");
        for (int i = 0; i < listaNumeros.size(); i++) {
            System.out.print(" " + listaNumeros.get(i) + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        ArrayList <Integer> listaNumeros = new ArrayList <> ();
        solicitarNumeros(listaNumeros);
        mostrarListas(listaNumeros);
        rellenarDeCeros(listaNumeros);
        mostrarListas(listaNumeros);
    }
}
