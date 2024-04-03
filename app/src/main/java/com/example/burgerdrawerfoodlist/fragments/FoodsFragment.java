package com.example.burgerdrawerfoodlist.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.burgerdrawerfoodlist.Model;
import com.example.burgerdrawerfoodlist.R;
import com.example.burgerdrawerfoodlist.adapter.FoodsAdapter;

import java.util.ArrayList;


public class FoodsFragment extends Fragment implements FoodsAdapter.ItemClickListener {

    ArrayList<Model> modelFoods = new ArrayList<>();

    Context context;

    FoodsAdapter adapter;





    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context; // Initialize the context here
    }
    public FoodsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foods, container, false);





        // Inflate the layout for this fragment
        modelFoods.add(new Model("Soto Kudus", "https://o-cdn-cas.sirclocdn.com/parenting/images/makanan-khas-kudus.width-800.format-webp.webp"));
        modelFoods.add(new Model("Lentog Tanjung", "https://o-cdn-cas.sirclocdn.com/parenting/images/Lentog_Tanjung.width-800.format-webp.webp"));
        modelFoods.add(new Model("Opor Sunggingan", "https://o-cdn-cas.sirclocdn.com/parenting/images/Opor_Ayam_Bakar_Kudus.width-800.format-webp.webp"));
        modelFoods.add(new Model("Jenang", "https://www.wowkeren.com/display/images/photo/2021/01/07/00346668s2.jpg"));
        modelFoods.add(new Model("Pecel Pakis", "https://o-cdn-cas.sirclocdn.com/parenting/images/Pecel_Pakis_Colo.width-800.format-webp.webp"));
        modelFoods.add(new Model("Nasi Pindang", "https://o-cdn-cas.sirclocdn.com/parenting/images/Nasi_Pindang_Kudus.width-800.format-webp.webp"));



        RecyclerView recyclerView = view.findViewById(R.id.rvFoods);



        adapter = new FoodsAdapter(context, modelFoods);
        adapter.    setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return view;



    }




    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), adapter.getItem(position).getNama(), Toast.LENGTH_SHORT).show();

    }
}