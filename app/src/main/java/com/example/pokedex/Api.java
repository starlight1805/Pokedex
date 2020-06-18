package com.example.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL="https://pokeapi.co/api/v2/";
    @GET("pokemon?limit=964&offset=0")
    Call<Jsonresponse> getPokemon();
}
