package com.example.kurwawan.posphone.View.View_Order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kurwawan.posphone.Adapter.RincianOrderAdapter;
import com.example.kurwawan.posphone.Model.Produk;
import com.example.kurwawan.posphone.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RincianOrderActivity extends AppCompatActivity {

    Button btnDinneIn, btnTakeAway;
    RecyclerView rv_rincian_order;
    LinearLayout llNoMeja;
    TextView tvStatusMeja;
    TextView tv_sub_total;
    int totalHarga = 0;
    ArrayList<Produk> listOrder = new ArrayList<Produk>();
    RincianOrderAdapter rincianOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian_order);

        getSupportActionBar().setTitle("Rincian Order");
        //Total Harga
        totalHarga = getIntent().getIntExtra("total", 0);
        tv_sub_total = findViewById(R.id.tv_sub_total);
        tv_sub_total.setText("" + totalHarga);

        String dataListOrder = getIntent().getStringExtra("listOrder");
        if(!dataListOrder.isEmpty()){
            Gson convertListOrder = new Gson();
            //convert json string list order ke arrayList kembali
            listOrder = convertListOrder.fromJson(dataListOrder, new TypeToken<ArrayList<Produk>>(){}.getType());
        }

        btnDinneIn = findViewById(R.id.btn_dinne_in);
        btnTakeAway = findViewById(R.id.btn_take_away);
        llNoMeja = findViewById(R.id.ll_no_meja);
        tvStatusMeja = findViewById(R.id.tv_status_meja);
        rv_rincian_order = findViewById(R.id.rv_rincian_order);
        rincianOrderAdapter = new RincianOrderAdapter(listOrder);
        rv_rincian_order.setLayoutManager(new LinearLayoutManager(this));
        rv_rincian_order.setAdapter(rincianOrderAdapter);
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

    //TODO: Method Total
    public void totHarga(int subTot, double diskon, double pajak){
        double disc = diskon/100;
        double hrgDisc = subTot*disc;

        double pjk = pajak/100;
        double hrgPjk = subTot*pjk;

        double total_harga = subTot+hrgDisc+hrgPjk;

        String tot = String.valueOf(total_harga);

        int total_bayar = Integer.parseInt(tot);
    }

    private void getPajak(){
            //panggil API pake retrofit mungkin :v / basic http url
    }
}
