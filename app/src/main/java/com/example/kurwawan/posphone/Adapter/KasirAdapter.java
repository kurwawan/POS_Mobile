package com.example.kurwawan.posphone.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kurwawan.posphone.View.LoginActivity;
import com.example.kurwawan.posphone.Model.Kasir;
import com.example.kurwawan.posphone.R;

import java.util.ArrayList;

/**
 * Created by zerotohero on 26/02/18.
 */

public class KasirAdapter extends RecyclerView.Adapter<KasirAdapter.KasirViewHolder> {

    private ArrayList<Kasir> kasirList;
    private Context context;

    public KasirAdapter(ArrayList<Kasir> kasirList, Context context) {
        this.kasirList = kasirList;
        this.context = context;
    }

    @Override
    public KasirAdapter.KasirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kasir, parent, false);
        KasirAdapter.KasirViewHolder kasirViewHolder = new KasirAdapter.KasirViewHolder(v);
        return kasirViewHolder;
    }

    @Override
    public void onBindViewHolder(KasirAdapter.KasirViewHolder holder, final int position) {
        holder.ivImgKasir.setImageResource(kasirList.get(position).getGbrKasir());
        holder.tvNamaKasir.setText(kasirList.get(position).getNamaKasir());

        holder.cvKasir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                intent.putExtra("namakasir", kasirList.get(position).getNamaKasir());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kasirList.size();
    }

    public class KasirViewHolder extends RecyclerView.ViewHolder {
        CardView cvKasir;
        ImageView ivImgKasir;
        TextView tvNamaKasir;
        public KasirViewHolder(View itemView) {
            super(itemView);

            cvKasir = itemView.findViewById(R.id.cv_kasir);
            ivImgKasir = itemView.findViewById(R.id.img_kasir);
            tvNamaKasir = itemView.findViewById(R.id.tv_kasir);
        }
    }
}
