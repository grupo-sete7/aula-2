package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.aula2.model.Pokemon;
import com.example.aula2.util.PokemonUtil;
import com.example.aula2.util.SharedPokemonUtil;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getPokemon();
    }

    /**
     * Metodo chamando os metodos do SharedPokemonUtil
     */
    private void getPokemon() {
        Log.i(PokemonUtil.TAG, "-------------------");
        Log.i(PokemonUtil.TAG, "Pegando pokemon");
        //Recupera o pokémon do SharedPreferences
        Pokemon myPokemon = SharedPokemonUtil.getPokemon(this);
        //Log.i(PokemonUtil.TAG, myPokemon.toString());
        //Verifica se já existe pokémon no SharedPreferences
        //Log.i(PokemonUtil.TAG, String.valueOf(SharedPokemonUtil.isExist(this)));
        //Deleta pokémon do SharedPreferences
        //SharedPokemonUtil.deletePokemon(this);
    }
}