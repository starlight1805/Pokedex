package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class typesActivity extends AppCompatActivity {
    private RecyclerView recyclerView2;
    private RecyclerView.Adapter myAdapter;
    private ArrayList<typesofpokemon> data2 =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);
        recyclerView2 = (RecyclerView) findViewById(R.id.type_recycler_view);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager( new LinearLayoutManager(this));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Apitypes.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apitypes api=retrofit.create(Apitypes.class);
        Call<Jsonresponse2> call2=api.gettypes();
        call2.enqueue(new Callback<Jsonresponse2>() {
            @Override
            public void onResponse(Call<Jsonresponse2> call2, Response<Jsonresponse2> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Im in",Toast.LENGTH_SHORT).show();
                    Jsonresponse2 jsonresponse2=response.body();
                    data2 = new ArrayList<typesofpokemon>(Arrays.<typesofpokemon>asList(jsonresponse2.getResults()));
                    myAdapter=new RecyclertypeAdapter(data2, getApplicationContext());
                    recyclerView2.setAdapter(myAdapter);
                }
                else Toast.makeText(getApplicationContext(),"Its Gone",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Jsonresponse2> call2, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
