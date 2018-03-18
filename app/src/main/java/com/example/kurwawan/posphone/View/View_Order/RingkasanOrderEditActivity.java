package com.example.kurwawan.posphone.View.View_Order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kurwawan.posphone.R;

public class RingkasanOrderEditActivity extends AppCompatActivity {

    Button btnTambahPorsi, btnKurangPorsi;
    TextView tvJmlPorsi;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringkasan_order_edit);

        getSupportActionBar().setTitle("Rincian Order");

        tvJmlPorsi = findViewById(R.id.tv_jml_porsi);

        btnTambahPorsi = findViewById(R.id.btn_tambah_porsi);
        btnTambahPorsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahPorsi();
            }
        });

        btnKurangPorsi = findViewById(R.id.btn_kurang_porsi);
        btnKurangPorsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kurangPorsi();
            }
        });
    }

    private void kurangPorsi() {
        i = i -1;
        int x = 0;
        if (i>=0) {
            tvJmlPorsi.setText(""+i);
        } else if (i<0) {
            tvJmlPorsi.setText("");
        }

    }

    private void tambahPorsi() {
        i = i +1;
        tvJmlPorsi.setText(""+i);
    }

}
