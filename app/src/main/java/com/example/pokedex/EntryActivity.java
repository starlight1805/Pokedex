package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EntryActivity extends AppCompatActivity {
    Button types,pokemons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        types=findViewById(R.id.Button1);
        pokemons=findViewById(R.id.Button2);
        pokemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(EntryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        types.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(EntryActivity.this,typesActivity.class);
                startActivity(intent2);
            }
        });
    }
}
