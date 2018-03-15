package com.example.kurwawan.posphone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kurwawan.posphone.Model.Kategori;
import com.example.kurwawan.posphone.R;
import com.example.kurwawan.posphone.View.View_Order.RincianOrderActivity;

import java.util.ArrayList;

/**
 * Created by zerotohero on 01/03/18.
 */

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.KategoriViewHolder>{

    private ArrayList<Kategori> kategoriList;
    private Context context;

    public interface KategoriListener{
        //ini 1
        void goToProduk(int pos, String word);
    }

    private KategoriListener mListener;

    public KategoriAdapter(ArrayList<Kategori> kategoriList, Context context, KategoriListener listener) {
        this.kategoriList = kategoriList;
        this.context = context;
        mListener = listener;
    }

    @Override
    public KategoriAdapter.KategoriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kategori, parent, false);
        KategoriAdapter.KategoriViewHolder kategoriViewHolder = new KategoriAdapter.KategoriViewHolder(v);
        return kategoriViewHolder;
    }

    @Override
    public void onBindViewHolder(final KategoriAdapter.KategoriViewHolder holder, final int position) {
        holder.tvKategori.setText(kategoriList.get(position).getKategoriProduk());

        holder.cvKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ini 2
                mListener.goToProduk(position, kategoriList.get(position).getKategoriProduk());
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
