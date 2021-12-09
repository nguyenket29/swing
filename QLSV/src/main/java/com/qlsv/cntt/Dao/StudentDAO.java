/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.Student;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author NguyenCongPC
 */
public class StudentDAO {

    public boolean save(Student student) throws Exception {
        String sql = "INSERT INTO SinhVien(MaSV, HoTen, Email, SDT, "
                + "GioiTinh, DiaChi, MaLop, HinhAnh) VALUES (?,?,?,?,?,?,?,?)";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, student.getMaSV());
            preparedStatement.setString(2, student.getHoTen());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getSoDT());
            preparedStatement.setInt(5, student.getGioiTinh());
            preparedStatement.setString(6, student.getDiaChi());
            preparedStatement.setString(7, student.getMaLop());
            if(student.getHinhAnh() != null){
                Blob hinh = new SerialBlob(student.getHinhAnh());
                preparedStatement.setBlob(8, hinh);
            }else {
                Blob hinh = null;
                preparedStatement.setBlob(8, hinh);
            }
            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public Student findById(String msv) throws Exception {
        String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, msv);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {                
                Student st = new Student();
                st.setMaSV(rs.getString("MaSV"));
                st.setHoTen(rs.getString("HoTen"));
                st.setEmail(rs.getString("Email"));
                st.setSoDT(rs.getString("SDT"));
                st.setGioiTinh(rs.getInt("GioiTinh"));
                st.setDiaChi(rs.getString("DiaChi"));
                st.setMaLop(rs.getString("MaLop"));
                st.setHinhAnh(rs.getBytes("HinhAnh"));
                return st;
            }
            return null;
        }
    }
    
    public boolean update(Student student) throws Exception {
        String sql = "UPDATE SinhVien SET HoTen = ?, Email = ?, "
                + "SDT = ?, GioiTinh = ? , DiaChi = ?, MaLop = ?, HinhAnh = ? WHERE MaSV = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(8, student.getMaSV());
            preparedStatement.setString(1, student.getHoTen());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getSoDT());
            preparedStatement.setInt(4, student.getGioiTinh());
            preparedStatement.setString(5, student.getDiaChi());
            preparedStatement.setString(6, student.getMaLop());
            if(student.getHinhAnh() != null){
                Blob hinh = new SerialBlob(student.getHinhAnh());
                preparedStatement.setBlob(7, hinh);
            }else {
                Blob hinh = null;
                preparedStatement.setBlob(7, hinh);
            }
            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String msv) throws Exception {
        String sql = "DELETE FROM SinhVien WHERE MaSV = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, msv);
            
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
