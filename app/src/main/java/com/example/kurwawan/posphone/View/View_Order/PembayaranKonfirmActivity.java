package com.example.kurwawan.posphone.View.View_Order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kurwawan.posphone.R;

public class PembayaranKonfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran_konfirm);

        getSupportActionBar().setTitle("Konfirmasi Pembayaran");
    }
}
