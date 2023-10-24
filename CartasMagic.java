/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.bd;

/**
 *
 * @author carlo
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Carta {
    String nombre;
    String tipo;
    String formato;

    public Carta(String nombre, String tipo, String formato) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.formato = formato;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFormato() {
        return formato;
    }
}

public class CartasMagic {
    public static void main(String[] args) {
        ArrayList<Carta> cartas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Listar cartas por tipo y formato");
            System.out.println("2. Insertar una nueva carta");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            if (opcion == 1) {
                System.out.print("Tipo de carta: ");
                String tipoBuscado = scanner.nextLine();
                System.out.print("Formato de carta: ");
                String formatoBuscado = scanner.nextLine();

                ArrayList<Carta> cartasFiltradas = new ArrayList<>();
                for (Carta carta : cartas) {
                    if (carta.getTipo().equalsIgnoreCase(tipoBuscado) && carta.getFormato().equalsIgnoreCase(formatoBuscado)) {
                        cartasFiltradas.add(carta);
                    }
                }

                // Ordenar las cartas por nombre
                Collections.sort(cartasFiltradas, Comparator.comparing(Carta::getNombre));

                System.out.println("Cartas encontradas:");
                for (Carta carta : cartasFiltradas) {
                    System.out.println("Nombre: " + carta.getNombre());
                    System.out.println("Tipo: " + carta.getTipo());
                    System.out.println("Formato: " + carta.getFormato());
                    System.out.println();
                }
            } else if (opcion == 2) {
                System.out.print("Nombre de la carta: ");
                String nombre = scanner.nextLine();
                System.out.print("Tipo de la carta: ");
                String tipo = scanner.nextLine();
                System.out.print("Formato de la carta: ");
                String formato = scanner.nextLine();

                Carta nuevaCarta = new Carta(nombre, tipo, formato);
                cartas.add(nuevaCarta);

                System.out.println("Carta agregada con éxito.");
            } else if (opcion == 3) {
                System.out.println("Saliendo del programa.");
                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}

