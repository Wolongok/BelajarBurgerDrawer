package com.example.burgerdrawerfoodlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.burgerdrawerfoodlist.Model;
import com.example.burgerdrawerfoodlist.R;

import java.util.ArrayList;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.MyViewHolder> {

    private DrinksAdapter.ItemClickListener mClickListener;
    Context context;
    ArrayList<Model> modelDrinks;

    public DrinksAdapter(Context context, ArrayList<Model> modelDrinks) {
        this.context = context;
        this.modelDrinks = modelDrinks;
    }

    @NonNull
    @Override
    public DrinksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinksAdapter.MyViewHolder holder, int position) {
        Model currentItem = modelDrinks.get(position);
        holder.tvDrinks.setText(currentItem.getNama());


        Glide.with(context)
                .load(currentItem.getImg())
                .into(holder.imgDrinks);
    }

    @Override
    public int getItemCount() {
        return modelDrinks.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDrinks;
        TextView tvDrinks;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            imgDrinks = itemView.findViewById(R.id.img);
            tvDrinks = itemView.findViewById(R.id.tvNama);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mClickListener != null) {
                        mClickListener.onItemClick(view, getAdapterPosition());
                    }
                }
            });



        }




    }
    public void setClickListener(DrinksAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public Model getItem(int id) {return modelDrinks.get(id);}
}
