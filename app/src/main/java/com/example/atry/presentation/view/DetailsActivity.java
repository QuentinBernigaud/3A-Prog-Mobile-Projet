package com.example.atry.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atry.R;
import com.example.atry.Singletons;
import com.example.atry.presentation.controller.MainController;
import com.example.atry.presentation.model.Pokemon;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtDetails;
    private TextView txtDetailsUrl;
    private TextView txtDetailsWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        txtDetails = findViewById(R.id.details_txt);
        txtDetailsUrl = findViewById(R.id.Url_txt);
        txtDetailsWeight = findViewById(R.id.Weight_txt);


        Intent intent = getIntent();

        String pokemonJson = intent.getStringExtra("pokemonKey");
        Pokemon pokemon = Singletons.getGson().fromJson(pokemonJson, Pokemon.class);

        String pokemonJsonUrl = intent.getStringExtra("pokemonKeyUrl");
        Pokemon pokemonUrl = Singletons.getGson().fromJson(pokemonJsonUrl, Pokemon.class);

        String pokemonJsonWeight = intent.getStringExtra("pokemonKeyWeight");
        Pokemon pokemonWeight = Singletons.getGson().fromJson(pokemonJsonWeight, Pokemon.class);

        showDetail(pokemon);
        showDetail(pokemonUrl);
        showDetail(pokemonWeight);

    }

    private void showDetail(Pokemon pokemon) {

        txtDetails.setText(pokemon.getName());
        txtDetailsUrl.setText(pokemon.getUrl());
        txtDetailsWeight.setText(pokemon.getWeight());

    }

}
