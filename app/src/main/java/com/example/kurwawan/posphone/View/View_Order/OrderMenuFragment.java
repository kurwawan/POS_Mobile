package com.example.kurwawan.posphone.View.View_Order;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kurwawan.posphone.Adapter.KategoriAdapter;
import com.example.kurwawan.posphone.Adapter.KategoriAdapter.KategoriListener;
import com.example.kurwawan.posphone.Model.Kategori;
import com.example.kurwawan.posphone.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderMenuFragment extends Fragment implements KategoriListener {
    TextView tvKategori;
    RecyclerView rvKategori;
    ArrayList<Kategori> kategoriList;

    public OrderMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_order_menu, container, false);

        tvKategori = rootView.findViewById(R.id.tv_kategori);
        rvKategori = rootView.findViewById(R.id.rv_kategori);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvKategori.setLayoutManager(linearLayoutManager);

        String[] kategoriProduk = {
                "Promo",
                "Semua",
                "Makanan",
                "Minuman"
        };

        kategoriList = new ArrayList<>();
        for (int i=0; i<kategoriProduk.length; i++) {
            Kategori kategori = new Kategori(kategoriProduk[i]);
            kategoriList.add(kategori);
        }

        KategoriAdapter kategoriAdapter = new KategoriAdapter(kategoriList, getActivity(),this);
        rvKategori.setAdapter(kategoriAdapter);

        return rootView;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    //ini 3
    @Override
    public void goToProduk(int pos, String word) {
        Fragment parent = getParentFragment();
        if(parent instanceof OrderFragment){
            ((OrderFragment) parent).goToOrderSubMenu(pos, word);
        }
    }
}
