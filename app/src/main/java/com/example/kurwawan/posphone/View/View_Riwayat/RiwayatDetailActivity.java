package com.example.kurwawan.posphone.View.View_Riwayat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kurwawan.posphone.R;

public class RiwayatDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_detail);

        getSupportActionBar().setTitle("Detail Riwayat Transaksi");
    }
}
