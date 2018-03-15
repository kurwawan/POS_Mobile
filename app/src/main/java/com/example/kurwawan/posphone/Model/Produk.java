package com.example.kurwawan.posphone.Model;

/**
 * Created by zerotohero on 02/03/18.
 */

public class Produk {

    private String id;

    private int gambarProduk;
    private String namaProduk;
    private String hargaProduk;

    private String jmlProduk;

    public Produk() {

    }

    public Produk(int gambarProduk, String namaProduk, String hargaProduk) {
        this.gambarProduk = gambarProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
    }

    public Produk(String namaProduk, String hargaProduk, String jmlProduk) {
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.jmlProduk = jmlProduk;
    }

    public int getGambarProduk() {
        return gambarProduk;
    }

    public void setGambarProduk(int gambarProduk) {
        this.gambarProduk = gambarProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hatgaProduk) {
        this.hargaProduk = hatgaProduk;
    }

    public String getJmlProduk() {
        return jmlProduk;
    }

    public void setJmlProduk(String jmlProduk) {
        this.jmlProduk = jmlProduk;
    }
}
