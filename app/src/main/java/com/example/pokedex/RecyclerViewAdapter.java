package com.example.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mcontext;
    private List<Pokemon> mData;
    private ArrayList<Pokemon> results;

    public RecyclerViewAdapter(ArrayList<Pokemon> results) {
        this.results = results;
    }

    public RecyclerViewAdapter(Context mcontext, List<Pokemon> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.pokimg.setImageResource(mData.get(position).getImage());
        holder.pokename.setText(mData.get(position).getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
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
