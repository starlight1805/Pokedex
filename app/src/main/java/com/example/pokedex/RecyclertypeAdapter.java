package com.example.pokedex;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclertypeAdapter extends RecyclerView.Adapter<RecyclertypeAdapter.MyViewHolder2> {
    private Context mycontext;
    private ArrayList<typesofpokemon>data;


    public RecyclertypeAdapter(ArrayList<typesofpokemon> data, Context mycontext) {
        this.mycontext = mycontext;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view2;
        LayoutInflater myInflater=LayoutInflater.from(mycontext);
        view2=myInflater.inflate(R.layout.cardviewtypes,parent,false);
        return new MyViewHolder2(view2);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder2, final int position2) {
        holder2.poketype.setText(data.get(position2).getName());
        Typeface face = Typeface.MONOSPACE;
        holder2.poketype.setTypeface(face);
        holder2.cardViewtypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(mycontext,Main3Activity.class);
                intent4.putExtra("number",data.get(position2).getNumber());
                intent4.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mycontext.startActivity(intent4);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView poketype;
        CardView cardViewtypes;
        public MyViewHolder2(@NonNull View itemView2) {
            super(itemView2);
            poketype=itemView2.findViewById(R.id.poketype);
            cardViewtypes=itemView2.findViewById(R.id.cardviewtype_id);
        }
    }
}

