/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.Core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NguyenCongPC
 */
public class CoreDAO {

    public boolean save(Core core) throws Exception {
        String sql = "INSERT INTO DiemMh(MaSV, MaMh, LanThi, Diem, "
                + "HocKi, DiemTong, DiemRL) VALUES (?,?,?,?,?,?,?)";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, core.getMaSv());
            preparedStatement.setString(2, core.getMaMh());
            preparedStatement.setInt(3, core.getLanThi());
            preparedStatement.setFloat(4, core.getDiem());
            preparedStatement.setString(5, core.getHocKy());
            preparedStatement.setFloat(6, core.getDiemTong());
            preparedStatement.setFloat(7, core.getDiemRL());

            return preparedStatement.executeUpdate() > 0;
        }
    }

    public Core findById(String msv) throws Exception {
        String sql = "select dt.MaSV, sv.HoTen, mh.MaMh, dt.LanThi\n"
                + "	,dt.Diem, dt.HocKi, dt.DiemTong, dt.DiemRL ,kh.MaKhoa, sv.MaLop\n"
                + "from Lop l\n"
                + "inner join SinhVien sv on sv.MaLop = l.MaLop\n"
                + "inner join DiemMh dt on sv.MaSV = dt.MaSV\n"
                + "inner join MonHoc mh on dt.MaMh = mh.MaMh\n"
                + "inner join Khoa kh on kh.MaKhoa = l.MaKhoa\n"
                + "where sv.MaSV = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, msv);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Core st = new Core();
                st.setMaSv(rs.getString("MaSV"));
                st.setTenSv(rs.getString("HoTen"));
                st.setMaMh(rs.getString("MaMh"));
                st.setLanThi(rs.getInt("LanThi"));
                st.setDiem(rs.getFloat("Diem"));
                st.setHocKy(rs.getString("HocKi"));
                st.setMaLop(rs.getString("MaLop"));
                st.setDiemTong(rs.getFloat("DiemTong"));
                st.setDiemRL(rs.getFloat("DiemRL"));
                return st;
            }
            return null;
        }
    }

    public boolean delete(String msv, String mh) throws Exception {
        String sql = "DELETE FROM DiemMh WHERE MaSV = ? AND MaMh = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, msv);
            preparedStatement.setString(2, mh);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
