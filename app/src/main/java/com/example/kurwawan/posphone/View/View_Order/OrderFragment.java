package com.example.kurwawan.posphone.View.View_Order;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kurwawan.posphone.Model.Produk;
import com.example.kurwawan.posphone.View.MenuUtamaActivity;
import com.example.kurwawan.posphone.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {
    EditText etSearchProduk;
    TextView tvTotHarga;

    int totHarga = 0;
    boolean hasSubMenu = false;
    //Untuk menampung listOrder berdasarkan id(String) produk
    ArrayList<Produk> listOrder = new ArrayList<>();

    Button btnRincianOrder;

    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MenuUtamaActivity) getActivity()).getSupportActionBar().setTitle("Order");

        View rootView = inflater.inflate(R.layout.fragment_order, container, false);

        etSearchProduk = rootView.findViewById(R.id.et_search_produk);
        tvTotHarga = rootView.findViewById(R.id.tv_tot_harga);
        btnRincianOrder = rootView.findViewById(R.id.btn_rincian_order);

        //TODO: Search Product
        etSearchProduk.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });

        //TODO: Cek Rincian Order
        btnRincianOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvTotHarga.equals(null)) { //BELUM BISA
                    Toast.makeText(getActivity(), "Lakukan Order", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), RincianOrderActivity.class);
                    Gson dataListOrder = new Gson();
                    // kirim data list order ke list rincian order dalam json String
                    intent.putExtra("listOrder", dataListOrder.toJson(listOrder));
                    intent.putExtra("total", totHarga);
                    startActivity(intent);
                }
            }
        });

        return rootView;

    }

    //TODO: Tot Harga
    public void addHarga(Produk produk) {
        int index = listOrder.indexOf(produk);
        if(index != -1){
            String jumlah = listOrder.get(index).getJmlProduk();
            listOrder.get(index).setJmlProduk("" + (Integer.parseInt(jumlah) + 1));
        }
        else {
            //jika index != -1 maka ada order  produk dengan id sama
            //ambil jumlah order terakhir untuk produk ini
            //belum ada order produk dengan id sama
            produk.setJmlProduk("1");
            listOrder.add(produk);
        }
        totHarga += Integer.parseInt(produk.getHargaProduk());
        tvTotHarga.setText("Rp. " + totHarga);
    }

    //TODO: Method HIDE after Search Product
    private void performSearch() {
        etSearchProduk.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (view.findViewById(R.id.frameLayout2) != null) {
            if (savedInstanceState != null) {
                return;
            }
            OrderMenuFragment orderMenuFragment = new OrderMenuFragment();
            getChildFragmentManager().beginTransaction().add(R.id.frameLayout2, orderMenuFragment, null).commit();
        }
    }

    //TODO:
    public void goToOrderSubMenu(int pos, String word) {
        OrderSubMenuFragment orderSubMenuFragment = new OrderSubMenuFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.frameLayout2, orderSubMenuFragment).commit();
        hasSubMenu = true;
    }

    public void popChildStack() {
        if (hasSubMenu) {
            hasSubMenu = false;
            OrderMenuFragment orderMenuFragment = new OrderMenuFragment();
            getChildFragmentManager().beginTransaction().replace(R.id.frameLayout2, orderMenuFragment, null).commit();
        }
    }

    public boolean hasSubMenu() {
        return this.hasSubMenu;
    }


}
