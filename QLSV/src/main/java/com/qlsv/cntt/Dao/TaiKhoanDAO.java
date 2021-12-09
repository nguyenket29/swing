/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NguyenCongPC
 */
public class TaiKhoanDAO {
    public TaiKhoan checkLogin(String username, String password) throws Exception{
        String sql = "SELECT * FROM TaiKhoan WHERE taikhoan = ? and matkhau = ?";
        try(
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                TaiKhoan tk = new TaiKhoan();
                tk.setTaiKhoan(username);
                tk.setVaiTro(rs.getString("vaitro"));
                return tk;
            }
        }
        return null;
    }
}
