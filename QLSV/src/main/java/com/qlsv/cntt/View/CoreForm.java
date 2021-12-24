/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.View;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.Dao.CoreDAO;
import com.qlsv.cntt.Hepler.InforLogin;
import com.qlsv.cntt.Hepler.MesageHepler;
import com.qlsv.cntt.Hepler.Validator;
import com.qlsv.cntt.model.Core;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author NguyenCongPC
 */
public class CoreForm extends javax.swing.JPanel {

    private MenuForm menuForm;
    DefaultTableModel tableModel;

    /**
     * Creates new form CoreForm
     */
    public CoreForm() {
        initComponents();
        if(InforLogin.taiKhoan.getVaiTro().equals("Sinh Viên")){
            btnLuu.setEnabled(false);
            btnXoa.setEnabled(false);
        }
        
        initComboboxKhoa();
        initComboboxLop();
        initComboboxMon();
        initTable();
        showAll();
    }

    private void initComboboxLop() {
        String sql = "SELECT MaLop FROM Lop";
        try {
            Connection con = ConnectDB.ConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jcbLop.removeAllItems();
            while (rs.next()) {
                jcbLop.addItem(rs.getString("MaLop"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComboboxKhoa() {
        String sql = "SELECT MaKhoa FROM Khoa";
        try {
            Connection con = ConnectDB.ConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jcbKhoa.removeAllItems();
            while (rs.next()) {
                jcbKhoa.addItem(rs.getString("MaKhoa"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComboboxMon() {
        String sql = "SELECT MaMh FROM MonHoc";
        try {
            Connection con = ConnectDB.ConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            jcbMon.removeAllItems();
            while (rs.next()) {
                jcbMon.addItem(rs.getString("MaMh"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTable() {
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Mã Sinh Viên", "Họ Tên",
            "Mã Môn", "Lần Thi", "Điểm Thi", "Học Kỳ", "Điểm Tổng", "Điểm RL",
            "Mã Khoa",
            "Mã Lớp"});
        tblCores.setModel(tableModel);
    }

    private void showAll() {
        try {
            Connection con = ConnectDB.ConnectionDB();
            String sql = "select dt.MaSV, sv.HoTen, mh.MaMh, dt.LanThi\n"
                    + "	,dt.Diem, dt.HocKi, dt.DiemTong, dt.DiemRL ,kh.MaKhoa, sv.MaLop\n"
                    + "from Lop l\n"
                    + "inner join SinhVien sv on sv.MaLop = l.MaLop\n"
                    + "inner join DiemMh dt on sv.MaSV = dt.MaSV\n"
                    + "inner join MonHoc mh on dt.MaMh = mh.MaMh\n"
                    + "inner join Khoa kh on kh.MaKhoa = l.MaKhoa";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            tableModel.setRowCount(0);
            while (rs.next()) {
                String[] row = new String[]{
                    rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("MaMh"),
                    rs.getString("LanThi"), rs.getString("Diem"), rs.getString("HocKi"),
                    rs.getString("DiemTong"), rs.getString("DiemRL"),
                    rs.getString("MaKhoa"), rs.getString("MaLop")
                };
                tableModel.addRow(row);
            }
            tableModel.fireTableDataChanged();
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbKhoa = new javax.swing.JComboBox<>();
        jcbLop = new javax.swing.JComboBox<>();
        jcbHocKi = new javax.swing.JComboBox<>();
        jcbMon = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMsv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTenSv = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDiemThi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDiemTong = new javax.swing.JTextField();
        txtLanThi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDiemRL = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCores = new javax.swing.JTable();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Khoa:");

        jLabel2.setText("Lớp:");

        jLabel3.setText("Môn:");

        jLabel4.setText("Học kì:");

        jcbKhoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbHocKi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jcbMon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jcbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbHocKi, 0, 107, Short.MAX_VALUE))
                    .addComponent(jcbKhoa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbMon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jcbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbHocKi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel5.setText("Mã Sinh Viên:");

        jLabel6.setText("Tên sinh viên:");

        jLabel7.setText("Lần thi:");

        jLabel8.setText("Điểm thi:");

        txtDiemThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemThiActionPerformed(evt);
            }
        });

        jLabel9.setText("Điểm tổng:");

        jLabel10.setText("Điểm RL:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMsv, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(txtDiemThi))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSv, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiemTong, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLanThi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiemRL)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMsv)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtTenSv))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtLanThi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiemThi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDiemTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtDiemRL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));

        tblCores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCores);

        btnLuu.setText("Nhập");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jButton5.setText("In Bảng Điểm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                .addGap(35, 35, 35))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDiemThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemThiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemThiActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuilder builder = new StringBuilder();
        Validator.validatorEmpty(txtMsv, builder, "Mã sinh viên không được để trống");

        if (builder.length() > 0) {
            MesageHepler.showErrorDialog(menuForm, builder.toString(), "Lỗi !");
            return;
        }

        try {
            Core core = new Core();
            core.setMaSv(txtMsv.getText());
            core.setTenSv(txtTenSv.getText());
            core.setMaMh(jcbMon.getSelectedItem().toString());
            core.setLanThi(Integer.parseInt(txtLanThi.getText()));
            core.setDiem(Float.parseFloat(txtDiemThi.getText()));
            core.setHocKy(jcbHocKi.getSelectedItem().toString());
            core.setDiemTong(Float.parseFloat(txtDiemTong.getText()));
            core.setDiemRL(Float.parseFloat(txtDiemTong.getText()));
            core.setTenKhoa(jcbKhoa.getSelectedItem().toString());
            core.setMaLop(jcbLop.getSelectedItem().toString());
            CoreDAO dao = new CoreDAO();
            if (dao.save(core)) {
                MesageHepler.showMessageDialog(menuForm, "Sinh Viên Đã Được Thêm Điểm", "Thông báo !");
            } else {
                MesageHepler.showConfirmDialog(menuForm, "Sinh viên chưa được thêm điểm", "Cảnh báo !");
            }
            showAll();
        } catch (Exception e) {
            e.printStackTrace();
            MesageHepler.showErrorDialog(menuForm, e.getMessage(), "Lỗi !");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private boolean search() {
        PreparedStatement ps = null;
        Connection con = ConnectDB.ConnectionDB();
        if (con != null) {
            try {
                tableModel.setRowCount(0);
                String sql = "select dt.MaSV, sv.HoTen, mh.MaMh, dt.LanThi\n"
                        + "	,dt.Diem, dt.HocKi, dt.DiemTong, dt.DiemRL ,kh.MaKhoa, sv.MaLop\n"
                        + "from Lop l\n"
                        + "inner join SinhVien sv on sv.MaLop = l.MaLop\n"
                        + "inner join DiemMh dt on sv.MaSV = dt.MaSV\n"
                        + "inner join MonHoc mh on dt.MaMh = mh.MaMh\n"
                        + "inner join Khoa kh on kh.MaKhoa = l.MaKhoa\n"
                        + "where sv.MaSV = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, txtMsv.getText());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.add(rs.getString(1));
                    vector.add(rs.getString(2));
                    vector.add(rs.getString(3));
                    vector.add(rs.getString(4));
                    vector.add(rs.getFloat(5));
                    vector.add(rs.getString(6));
                    vector.add(rs.getFloat(7));
                    vector.add(rs.getFloat(8));
                    vector.add(rs.getString(9));
                    vector.add(rs.getString(10));
                    tableModel.addRow(vector);
                    return true;
                }
                tableModel.fireTableDataChanged();
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuilder builder = new StringBuilder();
        Validator.validatorEmpty(txtMsv, builder, "Mã sinh viên không được để trống");

        if (builder.length() > 0) {
            MesageHepler.showErrorDialog(menuForm, builder.toString(), "Lỗi !");
            return;
        }

        try {
            if (search()) {
                MesageHepler.showMessageDialog(menuForm, "Tìm thấy", "Thông báo !");
            } else {
                MesageHepler.showMessageDialog(menuForm, "Không Tìm Thấy", "Cảnh báo !");
            }
        } catch (Exception e) {
            e.printStackTrace();
            MesageHepler.showErrorDialog(menuForm, e.getMessage(), "Lỗi !");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        txtMsv.setText("");
        txtTenSv.setText("");
        txtDiemThi.setText("");
        txtDiemTong.setText("");
        txtLanThi.setText("");
        jcbHocKi.setSelectedItem("");
        jcbLop.setSelectedItem("");
        jcbMon.setSelectedItem("");
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (tblCores.getSelectedRow() == -1) {
            MesageHepler.showMessageDialog(menuForm, "Hãy chọn một dòng để xóa", "Thông báo !");
        } else if (tblCores.getSelectedRowCount() == 0) {
            MesageHepler.showMessageDialog(menuForm, "Không có dữ liệu để xóa", "Thông báo !");
        } else {
            try {
                String msv = tblCores.getModel()
                        .getValueAt(tblCores.getSelectedRow(), 0).toString();
                String mh = tblCores.getModel()
                        .getValueAt(tblCores.getSelectedRow(), 2).toString();
                CoreDAO dao = new CoreDAO();
                if (dao.delete(msv, mh)) {
                    MesageHepler.showMessageDialog(menuForm, "Xóa thành công", "Thông báo !");
                    showAll();
                } else {
                    MesageHepler.showMessageDialog(menuForm, "Xóa thất bại", "Cảnh báo !");
                }
            } catch (Exception ex) {
                Logger.getLogger(CoreForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFileChooser excelFile = new JFileChooser("D:\\Netbean Practive\\QLSV\\data excel");
        excelFile.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel files", "xls", "xlsx", "xlsm");
        excelFile.setFileFilter(fnef);
        FileOutputStream excelFout = null;
        BufferedOutputStream excelBout = null;
        XSSFWorkbook excelTableExport = null;
        int ex = excelFile.showSaveDialog(null);

        if (ex == JFileChooser.APPROVE_OPTION) {
            try {
                excelTableExport = new XSSFWorkbook();
                XSSFSheet excelSheet = excelTableExport.createSheet("Core Sheet");

                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(tableModel.getValueAt(i, j).toString());
                    }
                }
                excelFout = new FileOutputStream(excelFile.getSelectedFile() + ".xlsx");
                excelBout = new BufferedOutputStream(excelFout);
                excelTableExport.write(excelBout);
                JOptionPane.showMessageDialog(menuForm, "Exported Successfully !");
            } catch (FileNotFoundException exl) {
                exl.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (excelBout != null) {
                        excelBout.close();
                    }
                    
                    if (excelFout != null) {
                        excelFout.close();
                    }

                    if (excelTableExport != null) {
                        excelTableExport.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbHocKi;
    private javax.swing.JComboBox<String> jcbKhoa;
    private javax.swing.JComboBox<String> jcbLop;
    private javax.swing.JComboBox<String> jcbMon;
    private javax.swing.JTable tblCores;
    private javax.swing.JTextField txtDiemRL;
    private javax.swing.JTextField txtDiemThi;
    private javax.swing.JTextField txtDiemTong;
    private javax.swing.JTextField txtLanThi;
    private javax.swing.JTextField txtMsv;
    private javax.swing.JTextField txtTenSv;
    // End of variables declaration//GEN-END:variables
}
