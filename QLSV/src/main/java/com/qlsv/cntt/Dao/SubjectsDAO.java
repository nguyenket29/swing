/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.Dao;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.model.Subjects;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author NguyenCongPC
 */
public class SubjectsDAO {
    public boolean save(Subjects sdao) throws Exception {
        String sql = "INSERT INTO MonHoc(MaMh, TenMh, TinChi) VALUES (?,?,?)";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, sdao.getMaMon());
            preparedStatement.setString(2, sdao.getTenMon());
            preparedStatement.setInt(3, sdao.getTinChi());

            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean update(Subjects s) throws Exception {
        String sql = "UPDATE MonHoc SET TenMh = ?, TinChi = ? WHERE MaMh = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, s.getTenMon());
            preparedStatement.setInt(2, s.getTinChi());
            preparedStatement.setString(3, s.getMaMon());
            
            return preparedStatement.executeUpdate() > 0;
        }
    }
    
    public boolean delete(String mh) throws Exception {
        String sql = "DELETE FROM MonHoc WHERE MaMh = ?";
        try (
                Connection con = ConnectDB.ConnectionDB();
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {
            preparedStatement.setString(1, mh);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
