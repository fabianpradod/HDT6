package com.hdt6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Autor: Fabian Prado Dluzniewski #23427
 * Curso: Algoritmos y Estructuras de Datos
 * Profesor: Douglas Barrios
 * Universidad del Valle de Guatemala
 *
 * Descripción: Clase que se encarga de leer el archivo CSV con los datos de los Pokemon
 * y almacenar cada entrada en un Map, donde el key es el nombre del Pokemon
 */

public class PokemonReader {

    /**
     * Lee el archivo CSV y retorna un Map con el nombre del Pokemon como llave y el objeto Pokemon como valor
     * 
     * Asumimos el siguiente formato:
     * Name, PokedexNumber, Type1, Type2, Classification, Height(m), Weight(kg), Abilities, Generation, LegendaryStatus
     *
     * @param file Nombre del archivo CSV, en este caso pokemon_data_pokeapi.csv
     * @return Map<String, Pokemon> 
     */

    public static Map<String, Pokemon> pokemonReader(String file) {
        Map<String, Pokemon> globalPoke = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                // Procesar la data de cada Pokemon
                String name = data[0].trim();
                int pokedexNumber = Integer.parseInt(data[1].trim());
                String type1 = data[2].trim();
                String type2 = data[3].trim();
                String classification = data[4].trim();
                double height = Double.parseDouble(data[5].trim());
                double weight = Double.parseDouble(data[6].trim());
                String abilities = data[7].trim();
                int generation = Integer.parseInt(data[8].trim());
                String isLegendary = data[9].trim();
                
                // Crear objeto Pokemon y agregarlo al mapa con el nombre como llave
                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification,
                                              height, weight, abilities, generation, isLegendary);
                globalPoke.put(name, pokemon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return globalPoke;
    }
}

