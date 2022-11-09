/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_libro;

import java.util.Random;

/**
 *
 * @author Adriano
 */

class ListaOrdenada extends Lista {
    public ListaOrdenada(){
        super();
    }
    
    public ListaOrdenada insertaOrden(int entrada){
        Nodo nuevo ;
        nuevo = new Nodo(entrada);
        if (primero == null){ // lista vacía
            primero = nuevo;
        }else if (entrada < primero.getDato()){
            nuevo. setEnlace(primero);
            primero = nuevo;
        }else{ /* búsqueda del nodo anterior a partir del que 
            se debe insertar */
            Nodo anterior, p;
            anterior = p = primero;
            while ((p.getEnlace() != null) && (entrada > p.getDato())){
                anterior = p;
                p = p.getEnlace();
            }
            
            if (entrada > p.getDato()){ //se inserta después del último nodo 
                anterior = p;
            }
            // Se procede al enlace del nuevo nodo 
            nuevo.setEnlace(anterior.getEnlace());
            anterior.setEnlace(nuevo);
        }
        return this;
    }
}

public class ejercicio_8_2 {
    public static void main(String [] a){
        Random r;
        int d;
        ListaOrdenada lista;
        int k;
        r = new Random(); // generador de números aleatorios 
        lista = new ListaOrdenada(); // crea lista vacía
        k = r.nextInt(99)+1; // número de elementos 
        // inserta elementos en la lista
        for (; k >= 0; k-- ){
            d = r.nextInt();
            lista.insertaOrden(d);
        }
        // escribe los elementos de la lista
        System.out.println("Elementos de la lista ordenada \n");
        lista.visualizar(); 
    }
}
