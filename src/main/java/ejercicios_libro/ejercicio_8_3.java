/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_libro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Adriano
 */

class Nodo{
    
    int dato;
    Nodo adelante;
    Nodo atras;
    // ...
    
    public Nodo(int entrada){
        dato = entrada;
        adelante = atras = null;
    }
    
}

class ListaDoble{
    Nodo cabeza;
    // métodos de la clase (implementación en apartado 8.9)
    public ListaDoble(){
        ;
    }
    
    public ListaDoble insertarCabezaLista(int entrada){
        Nodo nuevo; 
        nuevo = new Nodo(entrada);
        nuevo.adelante = cabeza; 
        if (cabeza != null ){
            cabeza.atras = nuevo;
        }
        cabeza = nuevo; 
        return this;
    }
    public ListaDoble insertaDespues(Nodo anterior, int entrada){
        Nodo nuevo; 
        nuevo = new Nodo(entrada);
        nuevo.adelante = anterior.adelante;
        if (anterior.adelante != null){
            anterior.adelante.atras = nuevo;
        }
        anterior.adelante = nuevo;
        nuevo.atras = anterior;
        return this;
    }
    public void eliminar (int entrada){
        Nodo actual; 
        boolean encontrado = false;
        actual = cabeza; 
        // Bucle de búsqueda 
        while ((actual != null) && (!encontrado)){
            /* la comparación se realiza con el método equals()..., 
            depende del tipo Elemento */
            encontrado = (actual.dato == entrada);
            if (!encontrado)
            actual = actual.adelante;
        }
        
         // Enlace de nodo anterior con el siguiente
        if (actual != null) {
            //distingue entre nodo cabecera o resto de la lista
            if (actual == cabeza){
                cabeza = actual.adelante;
                if (actual.adelante != null){
                    actual.adelante.atras = null;
                }
            }else if (actual.adelante != null){ // No es el último nodo 
                actual.atras.adelante = actual.adelante;
                actual.adelante.atras = actual.atras;
            }else{ // último nodo 
                actual.atras.adelante = null;
            }
            actual = null;
        }
    }
    public void visualizar() {;}
    public void buscarLista(int destino) {;}
}

class IteradorLista{
    private Nodo actual;
    
    public IteradorLista(ListaDoble ld){
        actual = ld.cabeza;
    }
    
    public Nodo siguiente(){
        Nodo a;
        a = actual;
        if (actual != null){
            actual = actual.adelante;
        }
        return a;
    } 
}

public class ejercicio_8_3 {
    public static void main(String [] ar) throws IOException{
        Random r;
        int d, x1, x2;
        final int M = 29; // número de elementos de la lista
        final int MX = 999;
        BufferedReader entrada = new BufferedReader(
        new InputStreamReader(System.in));
        ListaDoble listaDb;
        r = new Random(); 
        listaDb = new ListaDoble();
        
        for (int j = 1; j <= M ; j++){
            d = r.nextInt(MX) + 1;
            listaDb.insertarCabezaLista(d);
        }

        System.out.println("Elementos de la lista original");
        listaDb.visualizar();
        // rango de valores
        System.out.println("\nRango que va a contener la lista");
        x1 = Integer.parseInt(entrada.readLine());
        x2 = Integer.parseInt(entrada.readLine());
        // crea iterador asociado a la lista
        IteradorLista iterador = new IteradorLista(listaDb);
        Nodo a;
        // recorre la lista con el iterador
        a = iterador.siguiente();
        while (a != null){
            int w;
            w = a.getDato();
            if (!(w >= x1 && w <= x2)){ // fuera de rango
                listaDb.eliminar(w);
            }
            a = iterador.siguiente();
        }
        System.out.println("Elementos actuales de la lista");
        listaDb.visualizar();
    }
}
