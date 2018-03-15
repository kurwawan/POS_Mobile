package com.example.kurwawan.posphone.View.View_Order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kurwawan.posphone.R;

public class RincianOrderActivity extends AppCompatActivity {

    Button btnDinneIn, btnTakeAway;
    LinearLayout llNoMeja;
    TextView tvStatusMeja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian_order);

        getSupportActionBar().setTitle("Rincian Order");

        btnDinneIn = findViewById(R.id.btn_dinne_in);
        btnTakeAway = findViewById(R.id.btn_take_away);
        llNoMeja = findViewById(R.id.ll_no_meja);
        tvStatusMeja = findViewById(R.id.tv_status_meja);

        //TODO: pilih Dinne In
        btnDinneIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llNoMeja.setVisibility(View.VISIBLE);
            }
        });

        //TODO: pilih Take Away
        btnTakeAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llNoMeja.setVisibility(View.GONE);
            }
        });

    }

    public void totHarga(int subTot, double diskon, double pajak){
        double disc = diskon/100;
        double hrgDisc = subTot*disc;

        double pjk = pajak/100;
        double hrgPjk = subTot*pjk;

        double total_harga = subTot+hrgDisc+hrgPjk;

        String tot = String.valueOf(total_harga);

        int total_bayar = Integer.parseInt(tot);
    }
}
