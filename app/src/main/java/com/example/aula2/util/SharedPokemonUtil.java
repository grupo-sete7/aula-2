package com.example.aula2.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.aula2.model.Pokemon;

/**
 * Classe util com os metodos de SharedPreferences para tratar os objetos pokémon
 */
public class SharedPokemonUtil {

    public static final String KEY = "POKEMON";
    static SharedPreferences sharedPref = null;

    /**
     * Inicia o SharedPreferences para reutilizar nos metodos se necessário
     * @param context Contexto da activity
     */
    private static void initSharedPref(Context context) {
        sharedPref = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    /**
     * Metodo para salvar pokémon no SharedPreferences
     * @param pokemon Pokémon para ser salvo
     * @param context Contexto da activity
     */
    public static void savePokemon(Pokemon pokemon, Context context) {
        String jsonPokemon = PokemonUtil.pokemonToJson(pokemon);
        Log.i(PokemonUtil.TAG, jsonPokemon);
        //
        initSharedPref(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, jsonPokemon).apply();
    }

    /**
     * Metodo para deletar pokémon já salvo no SharedPreferences
     * @param context
     */
    public static void deletePokemon(Context context) {
        initSharedPref(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(KEY).apply();
    }

    /**
     * Metodo para buscar pokémon já salvo no SharedPreferences
     * @param context Contexto da activity
     * @return Pokemon já salvo
     */
    public static Pokemon getPokemon(Context context) {
        initSharedPref(context);
        String jsonPokemon = sharedPref.getString(KEY, "");
        if(!jsonPokemon.equals("")) {
            Pokemon pokemon = PokemonUtil.jsonToPokemon(jsonPokemon);
            return pokemon;
        }
        return null;
    }

    /**
     * Metodo para verificar se existe pokémon salvo no SharedPreferences
     * @param context Contexto da activity
     * @return boolean true se tiver pokemon salvo, falso se nao
     */
    public static boolean isExist(Context context) {
        if(getPokemon(context) == null) {
            return false;
        }

        return true;
    }
}
