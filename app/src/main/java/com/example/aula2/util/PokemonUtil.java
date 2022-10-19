package com.example.aula2.util;

import com.example.aula2.model.Pokemon;
import com.google.gson.Gson;

/**
 * Classe util com os metodos de Gson para tratar os objetos pokémon
 */
public class PokemonUtil {

    public static final String TAG = "POKEMON";

    /**
     * Metodo para transformar um objeto pokémon em um Json
     * @param pokemon
     * @return String Json do pokémon em formato String
     */
    public static String pokemonToJson(Pokemon pokemon) {
        if (pokemon != null) {
            Gson gson = new Gson();
            String myjson = gson.toJson(pokemon);

            return myjson;
        }
        return "";
    }

    /**
     * Metodo para transformar um json em um objeto pokémon
     * @param json do pokémon
     * @return Pokemon Json transformado em objeto
     */
    public static Pokemon jsonToPokemon(String json) {
        Pokemon myPokemon = new Pokemon();
        if(json != null) {
            Gson gson = new Gson();
            myPokemon = gson.fromJson(json, Pokemon.class);

            return myPokemon;
        }
        return myPokemon;
    }
}
