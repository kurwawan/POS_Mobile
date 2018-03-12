package com.example.kurwawan.posphone.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kurwawan.posphone.Model.Riwayat;
import com.example.kurwawan.posphone.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by zerotohero on 09/03/18.
 */

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.RiwayatViewHolder>{

    private ArrayList<Riwayat> riwayatList;
    private Context context;

    public RiwayatAdapter(ArrayList<Riwayat> riwayatList, Context context) {
        this.riwayatList = riwayatList;
        this.context = context;
    }

    @Override
    public RiwayatAdapter.RiwayatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_riwayat, parent, false);
        RiwayatAdapter.RiwayatViewHolder riwayatViewHolder = new RiwayatAdapter.RiwayatViewHolder(v);
        return riwayatViewHolder;
    }

    @Override
    public void onBindViewHolder(RiwayatAdapter.RiwayatViewHolder holder, int position) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

    }

    @Override
    public int getItemCount() {
        return riwayatList.size();
    }

    public class RiwayatViewHolder extends RecyclerView.ViewHolder {
        TextView tvTanggalRiwayat;
        TextView tvJamRiwayat;
        public RiwayatViewHolder(View itemView) {
            super(itemView);

            tvTanggalRiwayat = itemView.findViewById(R.id.tv_tanggal_riwayat);
            tvJamRiwayat = itemView.findViewById(R.id.tv_jam);
        }
    }
}
