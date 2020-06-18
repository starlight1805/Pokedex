package com.example.pokedex;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<Pokemon> results;
    private Context mcontext;
    public RecyclerViewAdapter(ArrayList<Pokemon> results, Context mcontext) {
        this.results = results;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflator=LayoutInflater.from(mcontext);
        view=mInflator.inflate(R.layout.cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.pokename.setText("#"+results.get(position).getNumber()+"   "+results.get(position).getName());
        Glide.with(mcontext)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+results.get(position).getNumber()+".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.pokimg);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,Main2Activity.class);
                intent.putExtra("number",results.get(position).getNumber());
                intent.putExtra("name",results.get(position).getName());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView pokimg;
        TextView pokename;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pokename=(TextView)itemView.findViewById(R.id.pokename_id);
            pokimg =(ImageView) itemView.findViewById(R.id.pokeimg_id);
            cardView=itemView.findViewById(R.id.cardview_id);
        }
    }
}
