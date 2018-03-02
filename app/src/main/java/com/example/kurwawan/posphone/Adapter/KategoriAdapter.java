package com.example.kurwawan.posphone.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kurwawan.posphone.Model.Kategori;
import com.example.kurwawan.posphone.R;

import java.util.ArrayList;

/**
 * Created by zerotohero on 01/03/18.
 */

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder> {

    private ArrayList<Kategori> kategoriList;
    private Context context;

    public KategoriAdapter(ArrayList<Kategori> kategoriList, Context context) {
        this.kategoriList = kategoriList;
        this.context = context;
    }

    @Override
    public KategoriAdapter.KategoriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kategori, parent, false);
        KategoriAdapter.KategoriViewHolder kategoriViewHolder = new KategoriAdapter.KategoriViewHolder(v);
        return kategoriViewHolder;
    }

    @Override
    public void onBindViewHolder(KategoriAdapter.KategoriViewHolder holder, int position) {
        holder.tvKategori.setText(kategoriList.get(position).getKategoriProduk());

        holder.cvKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return kategoriList.size();
    }

    public class KategoriViewHolder extends RecyclerView.ViewHolder {
        CardView cvKategori;
        TextView tvKategori;
        public KategoriViewHolder(View itemView) {
            super(itemView);

            cvKategori = itemView.findViewById(R.id.cv_kategori);
            tvKategori = itemView.findViewById(R.id.tv_kategori);
        }
    }
}
