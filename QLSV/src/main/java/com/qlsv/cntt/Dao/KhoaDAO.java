/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.Khoa;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author NguyenCongPC
 */
public class KhoaDAO {
    public boolean save(Khoa sdao) throws Exception {
        String sql = "INSERT INTO Khoa(MaKhoa, TenKhoa) VALUES (?,?)";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, sdao.getMaKhoa());
            preparedStatement.setString(2, sdao.getTenKhoa());

            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean update(Khoa s) throws Exception {
        String sql = "UPDATE Khoa SET TenKhoa = ? WHERE MaKhoa = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, s.getTenKhoa());
            preparedStatement.setString(2, s.getMaKhoa());
            
            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String mk) throws Exception {
        String sql = "DELETE FROM Khoa WHERE MaKhoa = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, mk);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
