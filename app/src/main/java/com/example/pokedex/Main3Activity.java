package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<String>data=new ArrayList<>();
    private JSONArray jsonArray;
    private JSONObject jsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new GridLayoutManager(this,2));
        Retrofit retrofit2=new Retrofit.Builder()
                .baseUrl(Api3.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api3 api=retrofit2.create(Api3.class);
        Call<Jsonresponse3> call2=api.getPokemon();
        call2.enqueue(new Callback<Jsonresponse3>() {
            @Override
            public void onResponse(Call<Jsonresponse3> call2, Response<Jsonresponse3> response3) {
                if(response3.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Im in",Toast.LENGTH_SHORT).show();
                    Jsonresponse3 jsonresponse3=response3.body();
                    jsonArray=jsonresponse3.getPokemon2();
                    for(int i=0;i<jsonArray.length();i++){
                        try {
                            jsonObject=jsonArray.getJSONObject(i);
                            data.add(jsonObject.getString("name"));
                            Log.d("pokemontypename",data.get(i));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }
                else Toast.makeText(getApplicationContext(),"Its Gone",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Jsonresponse3> call2, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
