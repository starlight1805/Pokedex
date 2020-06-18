package com.example.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api3 {
    String BASE_URL="https://pokeapi.co/api/v2/";
    @GET("type/1")
    Call<Jsonresponse3> getPokemon();
}
