package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Main2Activity extends AppCompatActivity {
ImageView pokeimg;
TextView pokename,ID;
int number;
String pokname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pokeimg=findViewById(R.id.imageView3);
        pokename=findViewById(R.id.textView2);
        Bundle bundle=getIntent().getExtras();
        number=bundle.getInt("number");
        pokname=""+bundle.getString("name");
        Glide.with(this)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+number+".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokeimg);
        pokename.setText(pokname);
        ID=findViewById(R.id.textView);
        String num="#"+number;
        ID.setText(num);
    }
}
