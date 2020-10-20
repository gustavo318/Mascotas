package com.jgmayer.mascotas;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FavoritePetsActivity extends AppCompatActivity {

    private List<PetModel> petModelList;

    private RecyclerView recyclerFavoritePets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pets);

        Toolbar toolbarFavoritePets = findViewById(R.id.toolbarFavoritePets);
        toolbarFavoritePets.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        recyclerFavoritePets = findViewById(R.id.recyclerFavoritePets);
        recyclerFavoritePets.setLayoutManager(new LinearLayoutManager(this));

        generatePets();
        initPetAdapter();
    }

    private void initPetAdapter() {
        PetAdapter petAdapter = new PetAdapter(petModelList);
        recyclerFavoritePets.setAdapter(petAdapter);
    }

    private void generatePets() {
        petModelList = new ArrayList<>();
        petModelList .add(new PetModel(R.drawable.golfo, "golfo", 18));
        petModelList .add(new PetModel(R.drawable.baloo, "baloo", 14));
        petModelList .add(new PetModel(R.drawable.frodo, "frodo", 5));
        petModelList .add(new PetModel(R.drawable.duque, "duque", 20));
        petModelList .add(new PetModel(R.drawable.lolo, "lolo", 12));
    }
}

