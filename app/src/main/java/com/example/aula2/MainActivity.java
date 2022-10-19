package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.aula2.model.Pokemon;
import com.example.aula2.util.PokemonUtil;
import com.example.aula2.util.SharedPokemonUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        initPokemon();
        Button mButton = findViewById(R.id.button);
        mButton.setOnClickListener(v -> {
            //Muda de activity
            startActivity(new Intent(this, MainActivity2.class));
        });
    }

    /**
     * Metodo para criar objeto e salvar no SharedPreferences
     */
    private void initPokemon() {
        Log.i(PokemonUtil.TAG, "-------------------");
        Log.i(PokemonUtil.TAG, "Iniciando pokemon");
        //criando objeto
        Pokemon myPokemon = new Pokemon(4, "Charmander", 0.6f, 8.5f, "Fogo");
        //Salvando pokémon no SharedPreferences
        SharedPokemonUtil.savePokemon(myPokemon, this);
    }
}