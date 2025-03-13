package com.hdt6.factory;

public class PokemonFactory {
    public MapFactory getFactory(String choice) {
        switch(choice) {
            case "1":
                return new HashMapFactory();
            case "2":
                return new TreeMapFactory();
            case "3":
                return new LinkedHashMapFactory();
            default:
                throw new IllegalArgumentException("Opcion invalida, introduzca una opcion de nuevo");
        }
    }
}
