package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Pokemon>data=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new GridLayoutManager(this,2));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);
        Call<Jsonresponse> call=api.getPokemon();
        call.enqueue(new Callback<Jsonresponse>() {
            @Override
            public void onResponse(Call<Jsonresponse> call, Response<Jsonresponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Im in",Toast.LENGTH_SHORT).show();
                    Jsonresponse jsonresponse=response.body();
                    data= new ArrayList<Pokemon>(Arrays.asList(jsonresponse.getResults()));
                    mAdapter=new RecyclerViewAdapter(data, getApplicationContext());
                    recyclerView.setAdapter(mAdapter);
                }
                else Toast.makeText(getApplicationContext(),"Its Gone",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Jsonresponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
