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
public class Lop {
    private String MaLop;
    private String TenLop;
    private String MaKhoa;

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String MaKhoa) {
        this.MaKhoa = MaKhoa;
    }

    public Lop(String MaLop, String TenLop, String MaKhoa) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.MaKhoa = MaKhoa;
    }

    public Lop() {
    }
}
