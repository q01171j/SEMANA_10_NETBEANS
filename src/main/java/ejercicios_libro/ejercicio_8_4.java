/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_libro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Adriano
 */

class Nodo {
    
    String dato;
    Nodo enlace;
    
    public Nodo (String entrada) {
        dato = entrada;
        enlace = this; 
    }
}

class ListaCircular {
    private Nodo lc;
    public ListaCircular(){
        lc = null;
    }
    public ListaCircular insertar(String entrada){
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        if (lc != null) // lista circular no vacía
        {
        nuevo.enlace = lc.enlace;
        lc.enlace = nuevo;
        }
        lc = nuevo;
        return this;
    }
    public void eliminar(String entrada){
        Nodo actual;
        actual = lc;
        while ((actual.enlace != lc) && !(actual.enlace.dato.equals(entrada))){
            if (!actual.enlace.dato.equals(entrada))
            actual = actual.enlace;
        }
        // Enlace de nodo anterior con el siguiente
        // si se ha encontrado el nodo.
        if (actual.enlace.dato.equals(entrada)){
            Nodo p;
            p = actual.enlace; // Nodo a eliminar
            if (lc == lc.enlace){ // Lista con un solo nodo
            lc = null;
            }else{
                if (p == lc){
                    lc = actual; // Se borra el elemento referenciado por lc,
                    // el nuevo acceso a la lista es el anterior
                }
            actual.enlace = p.enlace;
            }
            p = null;
        }
    }
    public void borrarLista()
    {
        Nodo p;
        if (lc != null){
            p = lc;
            do {
            Nodo t;
            t = p;
            p = p.enlace;
            t = null; // no es estrictamente necesario
            }while(p != lc);
        }
        else
            System.out.println("\n\t Lista vacía.");
        lc = null;
    }
    public void recorrer(){
        Nodo p;
        if (lc != null){
            p = lc.enlace; // siguiente nodo al de acceso
            do {
            System.out.println("\t" + p.dato);
            p = p.enlace;
            }while (p != lc.enlace);
        }
        else
         System.out.println("\t Lista Circular vacía.");
    }
}

public class ejercicio_8_4 {
    public static void main(String[] args) throws IOException {
        String palabra;
        ListaCircular listaCp;
        int opc;
        BufferedReader entrada = new BufferedReader(
        new InputStreamReader(System.in));
        listaCp = new ListaCircular();
        System.out.println("\n Entrada de Nombres. Termina con ^Z.\n");
        while ((palabra = entrada.readLine())!= null){
            String nueva;
            nueva = new String(palabra);
            listaCp.insertar(nueva);
        }
        System.out.println("\t\tLista circular de palabras");
        listaCp.recorrer();
        System.out.println("\n\t Opciones para manejar la lista");
        do {
            System.out.println("1. Eliminar una palabra.\n");
            System.out.println("2. Mostrar la lista completa.\n");
            System.out.println("3. Salir y eliminar la lista.\n");
            do {
                opc = Integer.parseInt(entrada.readLine());
            }while (opc<1 || opc>3);
            switch (opc) {
                case 1: System.out.print("Palabra a eliminar: ");
                palabra = entrada.readLine();
                listaCp.eliminar(palabra);
                break;
                case 2: System.out.println("Palabras en la Lista:\n");
                listaCp.recorrer();
                break;
                case 3: System.out.print("Eliminación de la lista.");
                listaCp.borrarLista();
            }
        }while (opc != 3);
    }
}
