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
import android.widget.Toast;

import com.example.burgerdrawerfoodlist.Model;
import com.example.burgerdrawerfoodlist.R;
import com.example.burgerdrawerfoodlist.adapter.DrinksAdapter;
import com.example.burgerdrawerfoodlist.adapter.FavoriteAdapter;

import java.util.ArrayList;


public class FavoritesFragment extends Fragment implements FavoriteAdapter.ItemClickListener {

    ArrayList<Model> modelFavorites = new ArrayList<>();

    Context context;

    FavoriteAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context; // Initialize the context here
    }

    public FavoritesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        modelFavorites.add(new Model("Lentog Tanjung", "https://o-cdn-cas.sirclocdn.com/parenting/images/Lentog_Tanjung.width-800.format-webp.webp"));
        modelFavorites.add(new Model("Wedang Coro", "https://img-z.okeinfo.net/okz/500/library/images/2023/11/08/6g83tytieteyc9j702j3_21211.JPG"));
        modelFavorites.add(new Model("Kopi Jetak", "https://static.promediateknologi.id/crop/0x0:0x0/750x500/webp/photo/2023/01/21/2453723392.jpg"));
        modelFavorites.add(new Model("Jenang", "https://www.wowkeren.com/display/images/photo/2021/01/07/00346668s2.jpg"));


        View view = inflater.inflate(R.layout.fragment_foods, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvFoods);



        adapter = new FavoriteAdapter(context, modelFavorites);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), adapter.getItem(position).getNama(), Toast.LENGTH_SHORT).show();
    }
}