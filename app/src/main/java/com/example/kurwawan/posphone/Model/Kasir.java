package com.example.kurwawan.posphone.Model;

/**
 * Created by zerotohero on 28/02/18.
 */

public class Kasir {

    private String id;

    private int gbrKasir;
    private String namaKasir;

    public Kasir() {

    }

    public Kasir(int gbrKasir, String namaKasir) {
        this.gbrKasir = gbrKasir;
        this.namaKasir = namaKasir;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public int getGbrKasir() {
        return gbrKasir;
    }

    public void setGbrKasir(int gbrKasir) {
        this.gbrKasir = gbrKasir;
    }
}
