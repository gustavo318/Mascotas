package com.jgmayer.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<PetModel> petModelList;

    private RecyclerView recyclerPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbarMain = findViewById(R.id.toolbarMain);
        toolbarMain.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.favorite) {
                    Intent intent = new Intent(MainActivity.this, FavoritePetsActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        FloatingActionButton floatingButtonMain = findViewById(R.id.floatingButtonMain);
        floatingButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.toast_camera_button, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerPet = findViewById(R.id.recyclerPet);
        recyclerPet.setLayoutManager(new LinearLayoutManager(this));

        generatePets();
        initPetAdapter();
    }

    private void initPetAdapter() {
        PetAdapter petAdapter = new PetAdapter(petModelList);
        recyclerPet.setAdapter(petAdapter);
    }
    private void generatePets() {
        petModelList = new ArrayList<>();
        petModelList.add(new PetModel(R.drawable.lolo, "lolo", 15));
        petModelList.add(new PetModel(R.drawable.merlin, "merlin", 16));
        petModelList.add(new PetModel(R.drawable.leia, "leia", 5));
        petModelList.add(new PetModel(R.drawable.duque, "duque", 17));
        petModelList.add(new PetModel(R.drawable.frodo, "frodo", 20));
        petModelList.add(new PetModel(R.drawable.baloo, "baloo", 12));
        petModelList.add(new PetModel(R.drawable.golfo, "golfo", 10));
    }
}


