/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_links;

import java.util.Scanner;

/**
 *
 * @author Adriano
 */

class Nodo {
    public int info;
    public Nodo siguiente;

    public Nodo() {
        siguiente = null;
        info = 0;
    }

    public Nodo(int x) {
        siguiente = null;
        info = x;
    }

    public Nodo(int x, Nodo siguiente) {
        info = x;
        this.siguiente = siguiente;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

class ListaEnlazada {
    protected Nodo primero;
    private int tamaño = 0;

    public ListaEnlazada() {
        primero = null;
        tamaño = 0;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean esVacio() {
        return primero == null;
    }

    public void insertaAlFinal(int x) {
        Nodo nuevo = new Nodo(x);
        Nodo p;
        
        if (primero == null) {
            primero = nuevo;
        } else {
            p = primero;
            while (p.getSiguiente() != null) {
                p = p.getSiguiente();
            }
            p.setSiguiente(nuevo);
        }
        
        tamaño++;
    }
    
    public void insertarP(int x, int pos){
        Nodo nuevo= new Nodo(x,null);
        if(pos==1){
            nuevo.setSiguiente(primero);
            primero=nuevo;
        }else{
            Nodo p=primero;
            int cont=1;
            while(p!=null && cont<pos-1){
                p=p.getSiguiente();
                cont++;
            }
            if(p!=null){
                nuevo.setSiguiente(p.getSiguiente());
                p.setSiguiente(nuevo);
            }else{
                System.out.println("Posiciòn no valida");
            }
        }
    }
    
    public Nodo posicionDeLaiesima(int pos){
        Nodo a=primero;
        int con=0;
        for(int i=1;a!=null;i++){
            con++;
            if(con==pos) {
                return a;
            }
            a=a.getSiguiente();
        }
        return null;
    }
    
    public void suprimirLaIesima(int pos) {
        Nodo tem;
        if(pos<1 || pos>getTamaño()){
            System.out.println("La posicion no existe");
        }else{
            if(pos==1){
                primero=primero.getSiguiente();
            }else{
                Nodo p=primero;
                int con=1;
                while(con<pos-1){
                    p=p.getSiguiente();
                    con++;
                }
                tem=p.getSiguiente();
                p.setSiguiente(tem.getSiguiente());
            }
        }
    }
    
    public void devolverUltimaPosicion() {
        Nodo a = primero, anterior, siguiente;
        int con = 0, posi = 0, numero = 0;
        while (a != null) {
            con++;
            anterior = a;
            siguiente = a.getSiguiente();
            if (siguiente == null) {
                posi = con;
                numero = a.getInfo();
            }
            a = a.getSiguiente();
        }
        System.out.println("la ultima posicion de la iesima es " + posi + " con numero [" + numero + "]");
    }
    
    public void ordenAscendente(){
        Nodo p,q;
        int aux;
        p=primero;
        while(p.getSiguiente()!=null){
            q=p.getSiguiente();
            while(q!=null){
                if(p.getInfo()>q.getInfo()){
                    aux=p.getInfo();
                    p.setInfo(q.getInfo());
                    q.setInfo(aux);
                }
                q=q.getSiguiente();
            }
            p=p.getSiguiente();
        }
    }
    
    public void insertarOrdenada(int x){
        Nodo nuevo= new Nodo(x);
        if(primero==null){
            primero=nuevo;
        }else{
            if(x<primero.getInfo()){
                nuevo.setSiguiente(primero);
                primero=nuevo;
            }else{
                Nodo p=primero;
                while(p.getSiguiente()!=null && p.getSiguiente().getInfo()<x){
                    p=p.getSiguiente();
                    nuevo.setSiguiente(p.getSiguiente());
                    p.setSiguiente(nuevo);
                }
            }
        }
    }
    
    public boolean estaOrdenado(){
        Nodo p=primero;
        while(p.getSiguiente()!=null){
            if(p.getInfo()>p.getSiguiente().getInfo()){
                return false;
            }
            p=p.getSiguiente();
        }
        return true;
    }
    
    public boolean verificarSiSeEncuentraNumero(int inf) {
        Nodo a = primero;
        boolean verificar = false;
        while (a != null) {
            if (a.getInfo() == inf) {
                verificar = true;
                break;
            }
            a = a.getSiguiente();
        }
        return verificar;
    }
    
    public void mostrarInversa() {
        alreves(primero);
    }

    public void alreves(Nodo p) {
        if (p != null) {
            alreves(p.siguiente);
            System.out.print("[" + p.info + "]" + "==>");
        }
    }
    
    public void imprimirNElementos(int can) {
        Nodo a = primero;
        int con = 0;
        int total=getTamaño()-can;
        Nodo inicio;
        for(inicio=primero;inicio!=null;inicio=inicio.getSiguiente()){
            con++;
            if(con>total && con<=getTamaño()){
                System.out.println(inicio.getInfo());
            }
        }
    }
    
    public void elementoCentral() {
        Nodo a = primero;
        int con = 0, medio = getTamaño() / 2;
        if (!esVacio()) {
            while (a != null) {
                Nodo aux = a;
                Nodo siguiente = a.getSiguiente();
                con++;
                if (con == medio) {
                    if (getTamaño() % 2 == 0) {
                        System.out.println("Elemento central es [" + aux.getInfo() + "] y [" + siguiente.getInfo() + "]");
                    } else {
                        System.out.println("Elemento decntral es[" + siguiente.getInfo() + "]");
                    }
                }
                a = a.getSiguiente();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    public void mostrar() {
        Nodo p = primero;
        while (p != null) {
            System.out.print("[" + p.getInfo() + "] ==> ");
            p = p.getSiguiente();
        }
    } 
}

public class ejercicio_06 {
    public static void menurPrincipal() {
        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int num;
        int opcion;
        
        do {
            System.out.println("\n");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1: AGREGAR LISTA INICIO ");
            System.out.println("2: MOSTRAR LISTA");
            System.out.println("3: AÑADIR EN LA POCION IESIMA");
            System.out.println("4: DEVOLVER LA POSCION DE LA IESIMA DE UN ELEMENTO");
            System.out.println("5: ORDENAR LISTA DE FORMA CRECIENTE");
            System.out.println("6: VERIFICAR SI UNA LISTA ESTA ORDENADA");
            System.out.println("7: VERIFICAR SI UN NUMERO SE ENCUENTRA EN LA LISTA");
            System.out.println("8: INVERTIR LA LISTA");
            System.out.println("9: MOSTRAR N ELMENTOS DE LA LISTA");
            System.out.println("10: ELEMENTO CENTRAL DE LA LISTA");
            System.out.println("11: AGREGAR UN NUMERO EN LA LISTA ORDENADA");
            System.out.println("12: SUPRIMIR UN NUMERO");
            System.out.println("13: SALIR");
            System.out.println("OPCION");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("INGRESE CANTIDAD DE NUMEROS");
                    int cantidad = sc.nextInt();
                    for (int i = 0; i < cantidad; i++) {
                        System.out.println("NUMERO [ " + (1 + i) + " ]");
                        int x = sc.nextInt();
                        lista.insertaAlFinal(x);
                    }
                    break;

                case 2:
                    if (lista.esVacio()) {
                        System.out.println("La lista esta vacia ");
                    } else {
                        System.out.println("MOSTRANDO LISTA ");
                        lista.mostrar();
                    }
                    break;
                case 3:
                    if (lista.esVacio()) {
                        System.out.println("La lista esta vacia ");
                    } else {
                        System.out.println("Igrese numero ");
                        num = sc.nextInt();
                        System.out.println("Ingrese posicion");
                        int pos = sc.nextInt();
                        lista.insertarP(num, pos);
                    }
                    break;

                case 4:
                    if (lista.esVacio()) {
                        System.out.println("Lista vacia");
                    } else {
                        System.out.println("Ingrese numero a buscar");
                        int nume = sc.nextInt();
                        if (lista.posicionDeLaiesima(nume) != null) {
                            System.out.println("La posicion es " + lista.posicionDeLaiesima(nume));
                        } else {
                            System.out.println("La pocicion no se encontro " + lista.posicionDeLaiesima(nume));
                        }
                        System.out.println("");
                    }
                    break;
                    
                case 5:
                    if (lista.esVacio()) {
                        System.out.println("Lista vacia");
                    } else {
                        System.out.println("ORDENANDO DE FORMA CRECIENTE");
                        lista.ordenAscendente();
                        lista.mostrar();
                    }
                    break;
                    
                case 6:
                    System.out.println("VERIFICANDO");
                    if (lista.estaOrdenado()) {
                        System.out.println("La lista esta ordena ");
                    } else {
                        System.out.println("La lista no esta ordenada");
                    }
                    break;
                    
                case 7:
                    if (lista.esVacio()) {
                        System.out.println("Lista vacia ");
                    } else {
                        System.out.println("Ingrese numero a buscar");
                        int numeros = sc.nextInt();
                        
                        if (lista.verificarSiSeEncuentraNumero(numeros)) {
                            System.out.println("NUMERO ENCONTRADO EN LA LISTA");
                        } else {
                            System.out.println("NUMERO NO ENCONTRADO EN LA LISTA");
                        }
                    }
                    break;

                case 8:
                    System.out.println("LISTA INVERTIDA");
                    lista.mostrarInversa();
                    break;
    
                case 9:
                    if (lista.esVacio()) {
                        System.out.println("Lista vacia ");
                    } else {
                        System.out.println("cunatos elementos desea mostrar");
                        num = sc.nextInt();
                        if (num <= lista.getTamaño()) {
                            lista.imprimirNElementos(num);
                        } else {
                            System.out.println("NO EXISTE ESA CANTIDAD DE NUMEROS EN LA LISTA");
                        }
                    }
                    break;

                case 10:
                    if (lista.esVacio()) {
                        System.out.println("Lista vacia ");
                    } else {
                        System.out.println("MOSTRANDO NUMERO CENTRAL");
                        lista.elementoCentral();
                    }
                    break;
                    
                case 11:
                    if (lista.esVacio()) {
                        System.out.println("No hay elementos en la lista ");
                    } else {
                        System.out.println("Ingrese numero");
                        num = sc.nextInt();
                        lista.insertarOrdenada(num);
                        lista.mostrar();
                    }
                    break;
                    
                case 12:
                    if (lista.esVacio()) {
                        System.out.println("La posicion a buscar ");
                    } else {
                        System.out.println("Ingrese numero ");
                        int n = sc.nextInt();
                        lista.suprimirLaIesima(n);
                        System.out.println("Elemento eliminado");
                    }
                    break;

                default:
                    System.out.println("SALIENDO DEL PROGRAMA ");
            }
        } while (opcion != 13);
    }

    public static void main(String[] args) {
        menurPrincipal();
    }
}
