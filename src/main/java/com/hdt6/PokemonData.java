package com.hdt6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Autor: Fabian Prado Dluzniewski #23427  
 * Curso: Algoritmos y Estructuras de Datos  
 * Profesor: Douglas Barrios  
 * Universidad del Valle de Guatemala  
 * 
 * Descripción: Esta clase contiene metodos para manejar a los Pokemon
 *   Agregar un Pokemon a la colección del usuario
 *   Mostrar la informacion de un Pokemon
 *   // los nombres y Type1 de los Pokemon en la colección del usuario, en orden de Type1
 *   // el nombre y el tipo Type1 de los Pokemon existentes en global, en orden de Type1
 *   // el nombre de los Pokemon que tienen una habilidad especifica, indicada por el usuario
 */

public class PokemonData {

    /**
     * Agrega un Pokemon a la colección del usuario
     * Si el Pokemon ya existe en colección, no se agrega y se informa que se está tratando de repetir
     * Si el Pokemon no existe en en global se muestra un error
     *
     * @param name           Nombre del Pokemon para agregar
     * @param userPoke       Colección del usuario (HashMap) donde se almacenan los Pokemon
     * @param globalPoke     Mapa con los Pokemon globales 
     */
    public static void addToUserPokemon(String name, Map<String, Pokemon> userPoke, Map<String, Pokemon> globalPoke) {
        if (userPoke.containsKey(name)) {
            System.out.println("El Pokemon ya está en la colección del usuario");
            return;
        }
        if (!globalPoke.containsKey(name)) {
            System.out.println("Error: El Pokemon introducido no existe");
            return;
        }
        userPoke.put(name, globalPoke.get(name));
        System.out.println("Pokemon agregado");
    }

    /**
     * Muestra los datos de un Pokemon
     *
     * @param name          Nombre del Pokemon
     * @param globalPoke    Mapa con los Pokemon globales 
     */
     public static void showPokemon(String name, Map<String, Pokemon> globalPoke) {
        if (!globalPoke.containsKey(name)) {
            System.out.println("Error: El Pokemon introducido no existe");
            return;
        }
        System.out.println(globalPoke.get(name).toString());
    }

    /**
     * Muestra nombre y Type1 de los Pokemon en la colección del usuario
     *
     * @param userPoke Colección del usuario (HashMap) donde se almacenan los Pokemon
     */
    public static void showUserPokemon(Map<String, Pokemon> userPoke) {
        if (userPoke.isEmpty()) {
            System.out.println("La colección de Pokemon del usuario esta vacía");
            return;
        }
        List<Pokemon> placeHolder = new ArrayList<>(userPoke.values());
        Collections.sort(placeHolder, Comparator.comparing(Pokemon::getType1));

        System.out.println("Pokemon en la colección del usuario, ordenados segun su Type1:");
        for (Pokemon i : placeHolder) {
            System.out.println("Nombre: " + i.getName() + " - Type1: " + i.getType1());
        }
    }

    /**
     * Muestra el nombre y el Type1 de todos los Pokemon existentes
     *
     * @param globalPoke Mapa con los Pokemon globales
     */
    public static void showAllPokemon(Map<String, Pokemon> globalPoke) {

        List<Pokemon> placeHolder = new ArrayList<>(globalPoke.values());
        Collections.sort(placeHolder, Comparator.comparing(Pokemon::getType1));
        System.out.println("Pokemon existentes:");
        for (Pokemon k : placeHolder) {
            System.out.println("Nombre: " + k.getName() + " - Type1: " + k.getType1());
        }
    }

}
