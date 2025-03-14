package com.hdt6;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class PokemonDataTest {

    // Creando la base de un Map global usando a Kleavor como ejemplo
    private Map<String, Pokemon> testCreateGlobalPoke() throws IOException {
        File tempFile = File.createTempFile("pokemon_test", ".csv");
        FileWriter writer = new FileWriter(tempFile);
        writer.write("Name,PokedexNumber,Type1,Type2,Classification,Height(m),Weight(kg),Abilities,Generation,LegendaryStatus\n");
        writer.write("Kleavor,900,Bug,Rock,Mantis Pokémon,1.8,89,\"Swarm, Sheer-force, Sharpness\",8,No\n");
        writer.flush();
        writer.close();
        Map<String, Pokemon> globalPoke = PokemonReader.pokemonReader(tempFile.getAbsolutePath());
        tempFile.delete();
        return globalPoke;
    }

    // Test 1: Agregando a Kleavor a la coleccion personal del usuario usando HashMap
    @Test
    public void testAddKleavorToUserPoke() throws IOException {
        Map<String, Pokemon> globalPoke = testCreateGlobalPoke();
        Map<String, Pokemon> userPoke = new HashMap<>();

        assertFalse(userPoke.containsKey("Kleavor"));
        
        PokemonData.addToUserPokemon("Kleavor", userPoke, globalPoke);
        
        assertTrue(userPoke.containsKey("Kleavor"));
        Pokemon kleavor = userPoke.get("Kleavor");
        assertEquals("Kleavor", kleavor.getName());
    }
    
    // Test 2: Intentar agregar a Kleavor otra vez, para asegurarse que no hayan duplicadas
    @Test
    public void testDuplicateKleavor() throws IOException {
        Map<String, Pokemon> globalPoke = testCreateGlobalPoke();
        Map<String, Pokemon> userPoke = new HashMap<>();

        PokemonData.addToUserPokemon("Kleavor", userPoke, globalPoke);
        int sizeAfterFirstAdd = userPoke.size();
        
        PokemonData.addToUserPokemon("Kleavor", userPoke, globalPoke);
        
        assertEquals(sizeAfterFirstAdd, userPoke.size());
    }
}
