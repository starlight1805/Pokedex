package com.example.pokedex;


import org.json.JSONArray;

public class Jsonresponse3 {
    private JSONArray pokemon;

    public Jsonresponse3(JSONArray pokemon) {
        this.pokemon = pokemon;
    }

    public JSONArray getPokemon2() {
        return pokemon;
    }
}
