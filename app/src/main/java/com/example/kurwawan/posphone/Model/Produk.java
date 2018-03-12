package com.example.kurwawan.posphone.Model;

/**
 * Created by zerotohero on 02/03/18.
 */

public class Produk {

    private String id;

    private int gambarProduk;
    private String namaProduk;
    private String hargaProduk;

    public Produk() {

    }

    public Produk(int gambarProduk, String namaProduk, String hargaProduk) {
        this.gambarProduk = gambarProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
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
}
