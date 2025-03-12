package com.hdt6;

import java.util.Scanner;

/**
 * Autor: Fabian Prado Dluzniewski #23427
 * Curso: Algoritmos y Estructuras de Datos
 * Profesor: Douglas Barrios
 * Universidad del Valle de Guatemala
 *
 * Descripción: 
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean seguir = true;
        while (seguir) {

            System.out.println("\n1. Agregar un Pokemon");
            System.out.println("2. Mostrar informacion sobre un Pokemon");
            System.out.println("3. Mostrar informacion de Pokemones en coleccion");
            System.out.println("4. Mostrar informacion de todos los Pokemones existentes");
            System.out.println("5. Encontrar Pokemon por habilidad");
            System.out.println("6. Salir\n");
            System.out.print("Introduzca su accion: ");
            
            String choice = scanner.nextLine();
            System.out.println();

            // Falta agregar la creacion de la coleccion del usuario


            switch (choice) {
                case "1":
                    // Metodo para agregar Pokemon
                    break;
                case "2":
                    // Metodo para informacion de Pokemon
                    break;
                case "3":
                    // Metodo para informacion de Pokemones en coleccion
                    break;
                case "4":
                    // Metodo para informacion de todos los Pokemones
                    break;
                case "5":
                    // Metodo para encontrar un Pokemon por habilidad
                    break;
                case "6":
                    seguir = false;
                    break;
                default:
                    System.out.println("Opcion invalida, introduzca una opcion de nuevo");
            }
        }

        scanner.close();
    }
}