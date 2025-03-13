package com.hdt6;

import java.util.Scanner;
import java.util.Map;
import com.hdt6.factory.MapFactory;
import com.hdt6.factory.PokemonFactory;

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

        MapFactory factory = null;
        PokemonFactory pokemonFactory = new PokemonFactory();
        Map<String, Pokemon> userPoke = null;
        Map<String, Pokemon> globalPoke = PokemonReader.pokemonReader("pokemon_data_pokeapi.csv");

        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("\nElija que tipo de Hash quiere que sea su coleccion");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.print("Introduzca su accion: ");
            
            String choice1 = scanner.nextLine();
            System.out.println();
            try {
                factory = pokemonFactory.getFactory(choice1);
                userPoke = factory.createMap();
                validChoice = true; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        boolean seguir = true;
        while (seguir) {

            System.out.println("1. Agregar un Pokemon");
            System.out.println("2. Mostrar informacion sobre un Pokemon");
            System.out.println("3. Mostrar informacion de Pokemones en coleccion");
            System.out.println("4. Mostrar informacion de todos los Pokemones existentes");
            System.out.println("5. Encontrar Pokemon por habilidad");
            System.out.println("6. Salir\n");
            System.out.print("Introduzca su accion: ");
            
            String choice2 = scanner.nextLine();

            switch (choice2) {
                case "1":
                    // Metodo para agregar un Pokemon a la coleccion del usuario
                    System.out.print("Ingrese el nombre del Pokemon a agregar: ");
                    String nameToAdd = scanner.nextLine();
                    System.out.println();
                    PokemonData.addToUserPokemon(nameToAdd, userPoke, globalPoke);
                    break;

                case "2":
                    // Metodo para informacion de Pokemon
                    System.out.print("Ingrese el nombre del Pokemon a mostrar: ");
                    String nameToShow = scanner.nextLine();
                    System.out.println();
                    PokemonData.showPokemon(nameToShow, globalPoke);
                    break;

                case "3":
                    // Metodo para informacion de Pokemones en coleccion
                    PokemonData.showUserPokemon(userPoke);
                    System.out.println();
                    break;
                case "4":
                    // Metodo para informacion de todos los Pokemones
                    PokemonData.showAllPokemon(globalPoke);
                    System.out.println();
                    break;
                case "5":
                    // Metodo para encontrar un Pokemon por habilidad
                    System.out.print("Ingrese la habilidad a buscar: ");
                    String ability = scanner.nextLine();
                    System.out.println();
                    PokemonData.showPokemonsByAbility(ability, globalPoke);
                    System.out.println();
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