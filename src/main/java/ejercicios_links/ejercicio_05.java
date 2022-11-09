package ejercicios_links;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adriano
 */

class Nodo {
    private double info;
    private Nodo siguiente;

    public Nodo(){
        siguiente=null;
    }

    public Nodo (double x){
        siguiente=null;
        info=x;
    }

    public Nodo(double x,Nodo siguiente){
        info=x;
        this.siguiente=siguiente;
    }

    public double getInfo() {
        return info;
    }

    public void setInfo(double info) {
        this.info = info;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    public void VerNodo(){
        System.out.println("[ "+info+" ]");
    }
}

class ListaEnLazada {
    protected Nodo primero;
    private int tamaño = 0;

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public ListaEnLazada() {
        primero = null;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public boolean esVacio() {
        return primero == null;
    }

    public void insertarAlinicio(double x) {
        Nodo nuevo = new Nodo(x);
        nuevo.setInfo(x);
        
        if (esVacio()) {
            primero = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero = nuevo;
        }
        tamaño++;
    }

    public void insertarAlFinal(double x) {
        Nodo nuevo = new Nodo(x);
        nuevo.setInfo(x);
        if (esVacio()) {
            primero = nuevo;
        } else {
            Nodo aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        tamaño++;
    }

    public void mostrar() {
        Nodo p = primero;
        while (p != null) {
            System.out.println("[ " + p.getInfo() + " ]");
            p = p.getSiguiente();
        }
    }

    public void borrarPrimero() {
        primero = primero.getSiguiente();
    }

    public void mayor() {
        Nodo a = primero;
        double mayor = primero.getInfo();
        
        while (a != null) {
            if (a.getInfo() > mayor) {
                mayor = a.getInfo();
            }
            a = a.getSiguiente();
        }
        
        System.out.println("El mayor es " + mayor);
    }

    public void menor() {
        Nodo a = primero;
        double menor = primero.getInfo();
            while (a != null) {
            if (a.getInfo() < menor) {
                menor = a.getInfo();
            }
            a = a.getSiguiente();
        }
        System.out.println("El menor es " + menor);
    }

    public void promedio() {
        Nodo a = primero;
        double suma = 0;
        int con = 0;
        
        while (a != null) {
            suma += a.getInfo();
            con++;
            a = a.getSiguiente();
        }
        
        double promedio = suma / con;
        
        System.out.println("el promedio es " + promedio);
    }

    public int buscarPosicion(double x) {
        Nodo a = primero;
        int posi = -1;
        int con = 0;
        while (a != null) {
            con++;
            if (a.getInfo() == x) {
                posi = con;
            }
            a = a.getSiguiente();
        }
        return posi;
    }

    public void borrar(int pos) {
        if (pos >= 0 && pos < getTamaño()) {
            if (pos == 0) {
                primero = primero.getSiguiente();
            } else {
                Nodo aux = primero.getSiguiente();
                for (int i = 0; i < getTamaño(); i++) {
                    aux = aux.getSiguiente();  
                } 
                Nodo siguiente = aux.getSiguiente();
                aux.setSiguiente(siguiente.getSiguiente());
            }
            tamaño--;
        }
    }

    public void ordenarAcendente() {
        Nodo a=primero;
        double aux;
        
        while(a!=null){
            Nodo siguiente=a.getSiguiente();
            if(a.getInfo()>siguiente.getInfo()){
                aux= a.getInfo();
                a.setInfo(siguiente.getInfo());
                siguiente.setInfo(a.getInfo());
            }
            a=a.getSiguiente();
        }
    }
}

public class ejercicio_05 {
    public static Scanner sc = new Scanner(System.in);
    public static ListaEnLazada miLista = new ListaEnLazada();

    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("menu de opciones");
            System.out.println("[1] Ingresar elementos a las lista");
            System.out.println("[2] Mostrar lista");
            System.out.println("[3] Ingrese Elemento Al final");
            System.out.println("[4] Borrar numero del inicio");
            System.out.println("[5] Mayor numero");
            System.out.println("[6] Menor numero");
            System.out.println("[7] Promedio");
            System.out.println("[8] Ordenar Acendente ");
            System.out.println("[9] Eliminar por posicion");
            System.out.println("[10] Salir");
            System.out.println("Ingrese opcion[1-10]");
            op = sc.nextInt();
            
            switch (op) {
                case 1:
                    double x = 0;
                    System.out.println("numero de elementos de la lista");
                    int n = sc.nextInt();
                    for (int j = 0; j < n; j++) {
                        System.out.println("Ingrese numero: " + j);
                        x = sc.nextDouble();
                        miLista.insertarAlinicio(x);
                    }
                    break;
                    
                case 2:
                    System.out.println("Los numeros ingresados son: ");
                    miLista.mostrar();
                    break;
                    
                case 3:
                    double e;
                    System.out.println("numero de elementos de la lista");
                    int r = sc.nextInt();
                    for (int i = 0; i < r; i++) {
                        System.out.println("Ingrese numer: " + i);
                        e = sc.nextDouble();
                        miLista.insertarAlFinal(e);
                    }
                    break;
                    
                case 4:
                    System.out.println("Borrando numero del inicio");
                    miLista.borrarPrimero();
                    break;
                    
                case 5:
                    miLista.mayor();
                    break;
                    
                case 6:
                    miLista.menor();
                    break;
                    
                case 7:
                    System.out.println("Promedio ");
                    miLista.promedio();
                    break;
                case 8:
                    System.out.println("ORDENAMIENTO ACENDENTE");
                    miLista.ordenarAcendente();
                    miLista.mostrar();
                    break;
                case 9:
                    System.out.println("Ingrese Numero a eliminar ");
                    double numero=sc.nextDouble();

                    if(miLista.buscarPosicion(numero)!=-1){
                        int p=miLista.buscarPosicion(numero);
                        miLista.borrar(p);
                        System.out.println("numero eliminado");
                    }else{
                        System.out.println("Numero no encontrado ");
                    }
                    break;

                default:
                    System.out.println("Saliendo del programa ");
                    
            }
            
        } while (op != 10);
    }
}
