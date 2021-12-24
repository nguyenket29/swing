/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.Khoa;
import com.qlsv.cntt.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public boolean save(TaiKhoan sdao) throws Exception {
        String sql = "INSERT INTO TaiKhoan(taikhoan, matkhau, vaitro) VALUES (?,?,?)";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, sdao.getTaiKhoan());
            preparedStatement.setString(2, sdao.getMatKhau());
            preparedStatement.setString(3, "Sinh Viên");

            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public TaiKhoan findById(String username){
        String sql = "select * from TaiKhoan where taikhoan = ?";
        try(
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TaiKhoan tk = new TaiKhoan();
                tk.setTaiKhoan(rs.getString(1));
                tk.setMatKhau(rs.getString(2));
                tk.setVaiTro(rs.getString(3));
                return tk;
            }
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public boolean update(TaiKhoan tk) throws Exception {
        String sql = "UPDATE TaiKhoan SET matkhau = ? WHERE taikhoan = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, tk.getMatKhau());
            preparedStatement.setString(2, tk.getTaiKhoan());
            
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
