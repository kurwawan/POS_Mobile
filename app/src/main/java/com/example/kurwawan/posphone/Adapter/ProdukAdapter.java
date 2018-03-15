package com.example.kurwawan.posphone.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kurwawan.posphone.Model.Produk;
import com.example.kurwawan.posphone.R;

import java.util.ArrayList;

/**
 * Created by zerotohero on 02/03/18.
 */

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder> {

    private ArrayList<Produk> produkList;

    private ParentFragmentListener mListener;

    public interface ParentFragmentListener{
        void addHarga(int harga);
    }

    public ProdukAdapter(ArrayList<Produk> produkList, ParentFragmentListener listener) {
        this.produkList = produkList;
        this.mListener = listener;
    }

    @Override
    public ProdukAdapter.ProdukViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu, parent, false);
        ProdukAdapter.ProdukViewHolder produkViewHolder = new ProdukAdapter.ProdukViewHolder(v);
        return produkViewHolder;
    }

    @Override
    public void onBindViewHolder(ProdukAdapter.ProdukViewHolder holder, final int position) {
        holder.imgProduk.setImageResource(produkList.get(position).getGambarProduk());

        holder.tvNamaPoduk.setText(produkList.get(position).getNamaProduk());
        holder.tvHargaProduk.setText(produkList.get(position).getHargaProduk());

        holder.cvProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.addHarga(Integer.parseInt(produkList.get(position).getHargaProduk()));



            }
        });
    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }

    public class ProdukViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduk;
        TextView tvNamaPoduk;
        TextView tvHargaProduk;
        CardView cvProduk;
        public ProdukViewHolder(View itemView) {
            super(itemView);

            imgProduk = itemView.findViewById(R.id.iv_gambar_produk);
            tvNamaPoduk = itemView.findViewById(R.id.tv_nama_produk);
            tvHargaProduk = itemView.findViewById(R.id.tv_harga_produk);
            cvProduk = itemView.findViewById(R.id.cv_produk);
        }
    }
}
