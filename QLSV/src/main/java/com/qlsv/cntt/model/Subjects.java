/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.model;

/**
 *
 * @author NguyenCongPC
 */
public class Subjects {
    private String maMon;
    private String tenMon;
    private int tinChi;

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getTinChi() {
        return tinChi;
    }

    public void setTinChi(int tinChi) {
        this.tinChi = tinChi;
    }

    public Subjects(String maMon, String tenMon, int tinChi) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.tinChi = tinChi;
    }

    public Subjects() {
    }
}
