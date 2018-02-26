package com.example.kurwawan.posphone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lvKasir;

    private String[] daftarKasir = new String[]{
            "Kasir 1", "Kasir 2 ", "Kasir 3", "Kasir 4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Ganti Operator");

        lvKasir = findViewById(R.id.lv_kasir);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, 
                R.layout.list_kasir, 
                R.id.tv_kasir, daftarKasir);
        lvKasir.setAdapter(adapter);

        lvKasir.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }
}