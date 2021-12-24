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
public class Core {
    private String maSv;
    private String tenSv;
    private String maMh;
    private int lanThi;
    private float diem;
    private String hocKy;
    private float diemTong;
    private float diemRL;
    private String tenKhoa;
    private String maLop;

    public Core() {
    }

    public Core(String maSv, String tenSv, String maMh, int lanThi, float diem,
            String hocKy, float diemTong, String tenKhoa, String maLop,float diemRL) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.maMh = maMh;
        this.lanThi = lanThi;
        this.diem = diem;
        this.hocKy = hocKy;
        this.diemTong = diemTong;
        this.tenKhoa = tenKhoa;
        this.maLop = maLop;
        this.diemRL = diemRL;
    }

    public float getDiemRL() {
        return diemRL;
    }

    public void setDiemRL(float diemRL) {
        this.diemRL = diemRL;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMh) {
        this.maMh = maMh;
    }

    public int getLanThi() {
        return lanThi;
    }

    public void setLanThi(int lanThi) {
        this.lanThi = lanThi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    public String getHocKy() {
        return hocKy;
    }

    public void setHocKy(String hocKy) {
        this.hocKy = hocKy;
    }

    public float getDiemTong() {
        return diemTong;
    }

    public void setDiemTong(float diemTong) {
        this.diemTong = diemTong;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}
