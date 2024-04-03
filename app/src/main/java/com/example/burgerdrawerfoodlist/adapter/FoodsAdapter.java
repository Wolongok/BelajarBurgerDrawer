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

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.MyViewHolder> {

    private ItemClickListener mClickListener;
    Context context;
    ArrayList<Model> modelFoods;

    public FoodsAdapter(Context context, ArrayList<Model> modelFoods) {
        this.context = context;
        this.modelFoods = modelFoods;
    }

    @NonNull
    @Override
    public FoodsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row, parent, false);
        return new MyViewHolder(view);
        }


    @Override
    public void onBindViewHolder(@NonNull FoodsAdapter.MyViewHolder holder, int position) {
        Model currentItem = modelFoods.get(position);
        holder.tvFoods.setText(currentItem.getNama());


        Glide.with(context)
                .load(currentItem.getImg())
                .into(holder.imgFoods);
    }

    @Override
    public int getItemCount() {
        return modelFoods.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoods;
        TextView tvFoods;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            imgFoods = itemView.findViewById(R.id.img);
            tvFoods = itemView.findViewById(R.id.tvNama);

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
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public Model getItem(int id) {return modelFoods.get(id);}
}
