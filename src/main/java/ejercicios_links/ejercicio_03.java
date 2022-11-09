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
public class ejercicio_03 {
    public static void rellenarDias (String [] dias) {
        dias[0] = "Lunes";
        dias[1] = "Martes";
        dias[2] = "Miercoles";
        dias[3] = "Jueves";
        dias[4] = "Viernes";
        dias[5] = "Sabado";
        dias[6] = "Domingo";
    }

    public static void rellenarMes(ArrayList < ArrayList < Integer > > mes , String [] dias) {
        Scanner teclado = new Scanner(System.in);
        Integer semana = 4;
        Integer temperatura;

        System.out.println("Introduce la temperatura para el dia");

        for (int i = 0; i < semana; i++) {
            for (int j = 0; j < dias.length; j++) {
                System.out.println("Para la Semana " + i + " El " + dias[j] + " hizo una temperatura de: ");
                temperatura = teclado.nextInt();
                mes.add(new ArrayList<Integer>());
                mes.get(i).add(temperatura);
            }
        }
        //System.out.println(mes);
    }

    public static void mostrarMes(ArrayList < ArrayList < Integer > > mes , String [] dias) {
        for (int i = 0; i < mes.size(); i++) {

            for (int j = 0; j < mes.get(i).size(); j++) {


                System.out.println("Para el dia " + dias[j] + " de la semana " + i + " hizo una temperatura de: " + mes.get(i).get(j));
            }
        }
    }

    public static void calcularMedia(ArrayList < ArrayList < Integer > > mes , String [] dias) {
        double media =0;
        Integer suma = 0;
        Integer contador =0;
        
        for (int i = 0; i < mes.size(); i++) {
            for (int j = 0; j < mes.get(i).size(); j++) {
                suma = suma + mes.get(i).get(j);
                contador++;
            }
        }
        media = suma / contador;
        System.out.println("La temperatura Media es " + media + " Âºc");
    }

    public static void diasMasCalurosos(ArrayList < ArrayList < Integer > > mes , String [] dias) {
        Integer mayor;
        int se;
        String di;
        mayor = mes.get(0).get(0);
        di = dias[0];
        se = 0;
        for (int i = 0; i < mes.size(); i++) {
            for (int j = 0; j < mes.get(i).size(); j++) {
                if (mes.get(i).get(j) > mayor) {
                    mayor = mes.get(i).get(j);
                    di = dias[j];
                    se = i;
                }
            }
        }
        System.out.println(" El " + di + " de la semana " + se + " es el mas caluroso: " + mayor);
    }
    
    public static void main(String[] args) {
        String [] dias = new String[7];
        rellenarDias(dias);
        ArrayList < ArrayList < Integer > > mes = new ArrayList < >();
        rellenarMes(mes, dias);
        mostrarMes(mes, dias);
        calcularMedia(mes, dias);
        diasMasCalurosos(mes,dias);
    }
}
