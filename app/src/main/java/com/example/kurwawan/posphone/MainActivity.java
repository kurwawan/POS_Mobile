package com.example.kurwawan.posphone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kurwawan.posphone.Adapter.KasirAdapter;
import com.example.kurwawan.posphone.Model.Kasir;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvKasir;
    ImageView imgKasir;
    RecyclerView rvKasir;

    ArrayList<Kasir> kasirList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Ganti Operator");

        tvKasir = findViewById(R.id.tv_kasir);
        imgKasir = findViewById(R.id.img_kasir);
        rvKasir = findViewById(R.id.rv_list_kasir);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvKasir.setLayoutManager(linearLayoutManager);

        String[] namaKasir = {
                "Kasir 1",
                "Kasir 2",
                "Kasir 3",
                "Kasir 4"
        };

        int[] gbrKasir = {
                R.drawable.ic_akun,
                R.drawable.ic_akun,
                R.drawable.ic_akun,
                R.drawable.ic_akun
        };

        kasirList = new ArrayList<>();
        for (int i=0; i<namaKasir.length; i++) {
            Kasir kasir = new Kasir(gbrKasir[i], namaKasir[i]);
            kasirList.add(kasir);
        }

        KasirAdapter kasirAdapter = new KasirAdapter(kasirList, MainActivity.this);
        rvKasir.setAdapter(kasirAdapter);
    }
}