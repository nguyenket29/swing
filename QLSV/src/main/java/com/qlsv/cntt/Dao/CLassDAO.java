/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.Lop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author NguyenCongPC
 */
public class CLassDAO {    
    public boolean save(Lop lop) throws Exception {
        String sql = "INSERT INTO Lop(MaLop, TenLop, MaKhoa) VALUES (?,?,?)";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, lop.getMaLop());
            preparedStatement.setString(2, lop.getTenLop());
            preparedStatement.setString(3, lop.getMaKhoa());

            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean update(Lop s) throws Exception {
        String sql = "UPDATE Lop SET TenLop = ?, MaKhoa = ? WHERE MaLop = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, s.getTenLop());
            preparedStatement.setString(2, s.getMaKhoa());
            preparedStatement.setString(3, s.getMaLop());
            
            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String mh) throws Exception {
        String sql = "DELETE FROM Lop WHERE MaLop = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, mh);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
