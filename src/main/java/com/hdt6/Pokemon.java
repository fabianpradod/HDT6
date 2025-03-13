package com.hdt6;

/**
 * Autor: Fabian Prado Dluzniewski #23427
 * Curso: Algoritmos y Estructuras de Datos
 * Profesor: Douglas Barrios
 * Universidad del Valle de Guatemala
 *
 * Descripción: Clase de cada Pokémon con su información básica
 */
 public class Pokemon {
     private String name;
     private int pokedexNumber;
     private String type1;
     private String type2;
     private String classification;
     private double height;
     private double weight;
     private String abilities;
     private int generation;
     private String isLegendary;
 
     public Pokemon(String name, int pokedexNumber, String type1, String type2, String classification,
                    double height, double weight, String abilities, int generation, String isLegendary) {
         this.name = name;
         this.pokedexNumber = pokedexNumber;
         this.type1 = type1;
         this.type2 = type2;
         this.classification = classification;
         this.height = height;
         this.weight = weight;
         this.abilities = abilities;
         this.generation = generation;
         this.isLegendary = isLegendary;
     }
 
     public String getName() {
        return name; 
    }
    public void setName(String name) {
        this.name = name; 
    }

     public int getPokedexNumber() {
        return pokedexNumber;
    }
     public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

     public String getType1() {
        return type1; 
    }
     public void setType1(String type1) {
        this.type1 = type1; 
    }

     public String getType2() {
        return type2;
    }
     public void setType2(String type2) {
        this.type2 = type2;
    }

     public String getClassification() {
        return classification;
    }
     public void setClassification(String classification) {
        this.classification = classification;
    }

     public double getHeight() {
        return height;
    }
     public void setHeight(double height) {
        this.height = height;
    }

     public double getWeight() {
        return weight;
    }
     public void setWeight(double weight) {
        this.weight = weight;
    }

     public String getAbilities() {
        return abilities;
    }
     public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

     public int getGeneration() {
        return generation;
    }
     public void setGeneration(int generation) {
        this.generation = generation;
    }

     public String getLegendary() {
        return isLegendary;
    }
     public void setLegendary(String legendary) {
        isLegendary = legendary;
    }
 
     @Override
     public String toString() {
         return "Pokemon: \n" +
                 "\nNombre : " + name +
                 "\nNumero de pokedex : " + pokedexNumber +
                 "\nType1 : " + type1 +
                 "\nType2 : " + type2 + 
                 "\nClasificacion : " + classification + 
                 "\nAltura : " + height +
                 "\nPeso : " + weight +
                 "\nHabilidades : " + abilities +
                 "\nGeneracion : " + generation +
                 "\nLegendario : " + isLegendary +"\n";
     }
 }