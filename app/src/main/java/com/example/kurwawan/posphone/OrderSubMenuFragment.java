package com.example.kurwawan.posphone;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kurwawan.posphone.Adapter.ProdukAdapter;
import com.example.kurwawan.posphone.Model.Produk;
import com.example.kurwawan.posphone.View.OrderFragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderSubMenuFragment extends Fragment implements ProdukAdapter.ParentFragmentListener {
    ImageView ivGbrProduk;
    TextView tvNamaProduk;
    TextView tvHrgProduk;

    RecyclerView rvProduk;


    ArrayList<Produk> produkList;

    public OrderSubMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ini 5
        Toast toast = Toast.makeText(getContext(), getArguments().getString("word", "NONE WORD"), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.CENTER , 0, 48);
        toast.show();
        Toast.makeText(getContext(), getArguments().getString("key", "NONE"), Toast.LENGTH_LONG).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_order_sub_menu, container, false);

        ivGbrProduk = rootView.findViewById(R.id.iv_gambar_produk);
        tvNamaProduk = rootView.findViewById(R.id.tv_nama_produk);
        tvHrgProduk = rootView.findViewById(R.id.tv_harga_produk);
        rvProduk = rootView.findViewById(R.id.rv_produk);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvProduk.setLayoutManager(linearLayoutManager);

        int[] gambarProduk = {
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
        };

        String[] namaProduk = {
                "Ayam Goreng",
                "Nasi Goreng",
                "Bakmi Goreng",
        };

        String[] hargaProduk = {
                "100000",
                "200000",
                "300000"
        };

        produkList = new ArrayList<>();
        for (int i = 0; i < namaProduk.length; i++) {
            Produk produk = new Produk(gambarProduk[i], namaProduk[i], hargaProduk[i]);
            produkList.add(produk);
        }

        ProdukAdapter produkAdapter = new ProdukAdapter(produkList, this);
        rvProduk.setAdapter(produkAdapter);

        return rootView;
    }

    @Override
    public void addHarga(int harga) {
        Fragment parent = getParentFragment();
        if(parent instanceof OrderFragment){
            ((OrderFragment) parent).addHarga(harga);
        }
    }
}
