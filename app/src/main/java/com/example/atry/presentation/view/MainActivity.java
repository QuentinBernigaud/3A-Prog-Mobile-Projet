package com.example.atry.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.atry.R;
import com.example.atry.Singletons;
import com.example.atry.presentation.controller.MainController;
import com.example.atry.presentation.model.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private ListeAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(
                this,
                Singletons.getGson(),
                Singletons.getSharedPreferences(getApplicationContext())
                );
        controller.onStart();




    }

        //refresh

    public void showList(List<Pokemon> pokemonList){

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);



            mAdapter = new ListeAdapter(pokemonList, new ListeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Pokemon item) {
                    controller.onItemClick(item);
                }
            });
            recyclerView.setAdapter(mAdapter);

        }



    public void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }


    public void navigateToDetails(Pokemon pokemon) {

        Intent myIntent = new Intent(MainActivity.this, DetailsActivity.class);
        myIntent.putExtra("pokemonKey", Singletons.getGson().toJson(pokemon));
        MainActivity.this.startActivity(myIntent);

    }
}
