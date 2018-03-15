package com.example.kurwawan.posphone.View.View_Riwayat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kurwawan.posphone.R;
import com.example.kurwawan.posphone.View.MenuUtamaActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatFragment extends Fragment {


    public RiwayatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MenuUtamaActivity) getActivity()).getSupportActionBar().setTitle("Riwayat Transaksi");

        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }

}
