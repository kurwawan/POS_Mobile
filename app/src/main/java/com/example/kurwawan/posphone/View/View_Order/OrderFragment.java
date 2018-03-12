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

import com.example.kurwawan.posphone.View.MenuUtamaActivity;
import com.example.kurwawan.posphone.View.View_Order.OrderMenuFragment;
import com.example.kurwawan.posphone.View.View_Order.OrderSubMenuFragment;
import com.example.kurwawan.posphone.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {
    EditText etSearchProduk;
    TextView tvTotHarga;

    int totHarga = 0;
    boolean hasSubMenu = false;

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
//                Intent intent = new Intent(getActivity(), RincianOrderActivity.class);
//                startActivity(intent);
            }
        });

        return rootView;

    }

    //TODO: Tot Harga
    public void addHarga(int harga){
        totHarga += harga;
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

    public void goToOrderSubMenu(int pos, String word){
        OrderSubMenuFragment orderSubMenuFragment = new OrderSubMenuFragment();
        //ini akang kurwwn
        Bundle bundle = new Bundle();
        if(pos == 0){
            bundle.putString("key", " Posisi 1");

        }
        else if (pos == 1){
            bundle.putString("key", " Posisi 2");
        }
        //ini 4
        bundle.putString("word", word);
        orderSubMenuFragment.setArguments(bundle);
        getChildFragmentManager().beginTransaction().replace(R.id.frameLayout2, orderSubMenuFragment).commit();
        hasSubMenu = true;
    }

    public void popChildStack(){
        if(hasSubMenu){
            hasSubMenu = false;
            OrderMenuFragment orderMenuFragment = new OrderMenuFragment();
            getChildFragmentManager().beginTransaction().replace(R.id.frameLayout2, orderMenuFragment, null).commit();
        }
    }

    public boolean hasSubMenu(){
        return this.hasSubMenu;
    }


}
