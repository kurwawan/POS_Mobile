package com.example.kurwawan.posphone;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tvNamaKasirLogin;
    EditText etPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login Kasir");

        tvNamaKasirLogin = findViewById(R.id.tv_nama_kasir_login);
        etPin = findViewById(R.id.et_pin);

        Intent intent = getIntent();

        String NamaKasir = intent.getStringExtra("namakasir");
        tvNamaKasirLogin.setText(NamaKasir);

    }

    //TODO 1
    public void btnLoginKasir(View view) {
        String pin = etPin.getText().toString().trim();

        if (pin.equals("1234")){
            Intent intent = new Intent(LoginActivity.this, MenuUtamaActivity.class);
            //..... mencocokkan data dan pin kasir
            startActivity(intent);
        } else if (pin.isEmpty()) {
            Toast.makeText(this, "Masukkan PIN", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "PIN Salah", Toast.LENGTH_SHORT).show();
        }
    }


}
