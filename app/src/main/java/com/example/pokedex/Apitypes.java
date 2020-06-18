package com.example.pokedex;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apitypes {
    String base_url="https://pokeapi.co/api/v2/";
    @GET("type")
    Call<Jsonresponse2> gettypes();
}
