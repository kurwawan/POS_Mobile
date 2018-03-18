package com.example.kurwawan.posphone.Model;

import java.util.Objects;

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
    public Produk(String id,int gambarProduk, String namaProduk, String hargaProduk) {
        this.id = id;
        this.gambarProduk = gambarProduk;
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
    }
    public Produk(String namaProduk, String hargaProduk, String jmlProduk) {
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.jmlProduk = jmlProduk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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


    //2 method hashCode dan equal di override agar object Produk dianggap sama bila memiliki id yang sama
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(!(obj instanceof  Produk))
            return false;
        Produk produk = (Produk) obj;
        return id.equals(produk.id);
    }
}
