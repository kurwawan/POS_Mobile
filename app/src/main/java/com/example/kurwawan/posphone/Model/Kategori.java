package com.example.kurwawan.posphone.Model;

/**
 * Created by zerotohero on 01/03/18.
 */

public class Kategori {
    private String id;
    private String kategoriProduk;

    public Kategori(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }

    public String getKategoriProduk() {
        return kategoriProduk;
    }

    public void setKategoriProduk(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }
}
