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

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder> {

    private FavoriteAdapter.ItemClickListener mClickListener;
    Context context;
    ArrayList<Model> modelFavorites;

    public FavoriteAdapter(Context context, ArrayList<Model> modelFavorites) {
        this.context = context;
        this.modelFavorites = modelFavorites;
    }

    @NonNull
    @Override
    public FavoriteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.MyViewHolder holder, int position) {
        Model currentItem = modelFavorites.get(position);
        holder.tvFavorites.setText(currentItem.getNama());


        Glide.with(context)
                .load(currentItem.getImg())
                .into(holder.imgFavorites);
    }

    @Override
    public int getItemCount() {
        return modelFavorites.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFavorites;
        TextView tvFavorites;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            imgFavorites = itemView.findViewById(R.id.img);
            tvFavorites = itemView.findViewById(R.id.tvNama);

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
    public void setClickListener(FavoriteAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public Model getItem(int id) {return modelFavorites.get(id);}
}
