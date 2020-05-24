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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        txtDetails = findViewById(R.id.details_txt);
        Intent intent = getIntent();
        String pokemonJson = intent.getStringExtra("pokemonKey");
        Pokemon pokemon = Singletons.getGson().fromJson(pokemonJson, Pokemon.class);

        showDetail(pokemon);

    }

    private void showDetail(Pokemon pokemon) {

        txtDetails.setText(pokemon.getName());

    }

}
