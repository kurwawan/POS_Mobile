package com.example.kurwawan.posphone;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kurwawan.posphone.Adapter.KategoriAdapter;
import com.example.kurwawan.posphone.Model.Kategori;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {

    TextView tvKategori;
    RecyclerView rvKategori;
    EditText etSearchProduk;

    ArrayList<Kategori> kategoriList;

    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MenuUtamaActivity) getActivity()).getSupportActionBar().setTitle("Order");

        View rootView = inflater.inflate(R.layout.fragment_order, container, false);

        tvKategori = rootView.findViewById(R.id.tv_kategori);
        rvKategori = rootView.findViewById(R.id.rv_kategori);
        etSearchProduk = rootView.findViewById(R.id.et_search_produk);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvKategori.setLayoutManager(linearLayoutManager);

        //TODO Search Product
        etSearchProduk.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });

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

        KategoriAdapter kategoriAdapter = new KategoriAdapter(kategoriList, getActivity());
        rvKategori.setAdapter(kategoriAdapter);

        return rootView;

    }

    //TODO Method HIDE after Search Product
    private void performSearch() {
        etSearchProduk.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }


}
