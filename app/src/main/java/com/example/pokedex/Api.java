package com.example.pokedex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL="https://pokeapi.co/api/v2/";
    @GET("pokemon")
    Call<List<Pokemon>> getPokemon();
}
