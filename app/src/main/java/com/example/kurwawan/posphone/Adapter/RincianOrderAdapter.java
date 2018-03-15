package com.example.kurwawan.posphone.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kurwawan.posphone.Model.Produk;
import com.example.kurwawan.posphone.R;

import java.util.ArrayList;

/**
 * Created by zerotohero on 13/03/18.
 */

public class RincianOrderAdapter extends RecyclerView.Adapter<RincianOrderAdapter.RincianOrderViewHolder> {

    private ArrayList<Produk> produkList;
    private Context context;

    public RincianOrderAdapter(ArrayList<Produk> produkList, Context context) {
        this.produkList = produkList;
        this.context = context;
    }

    @Override
    public RincianOrderAdapter.RincianOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rincian_order, parent, false);
        RincianOrderAdapter.RincianOrderViewHolder rincianOrderViewHolder = new RincianOrderAdapter.RincianOrderViewHolder(v);
        return rincianOrderViewHolder;
    }

    @Override
    public void onBindViewHolder(RincianOrderAdapter.RincianOrderViewHolder holder, int position) {
        holder.tvJmlPesanan.setText(produkList.get(position).getJmlProduk());
        holder.tvNamaMenu.setText(produkList.get(position).getNamaProduk());
        holder.tvHargaMenu.setText(produkList.get(position).getJmlProduk());

    }

    @Override
    public int getItemCount() {
        return produkList.size();
    }

    public class RincianOrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvJmlPesanan, tvNamaMenu, tvHargaMenu;
        public RincianOrderViewHolder(View itemView) {
            super(itemView);
            tvJmlPesanan = itemView.findViewById(R.id.tv_jml_order);
            tvNamaMenu = itemView.findViewById(R.id.tv_nama_menu_order);
            tvHargaMenu = itemView.findViewById(R.id.tv_harga_order);
        }
    }
}
