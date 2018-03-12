package com.example.kurwawan.posphone.Model;

/**
 * Created by zerotohero on 09/03/18.
 */

public class Riwayat {

    private long date;
    private long time;

    public Riwayat() {

    }

    public Riwayat(long date, long time) {
        this.date = date;
        this.time = time;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
