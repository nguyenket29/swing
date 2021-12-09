/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlsv.cntt.View;

import com.qlsv.cntt.Controller.ConnectDB;
import com.qlsv.cntt.Dao.StudentDAO;
import com.qlsv.cntt.Hepler.ImgHelpler;
import com.qlsv.cntt.Hepler.MesageHepler;
import com.qlsv.cntt.Hepler.Validator;
import com.qlsv.cntt.model.Student;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.File;
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
import javax.swing.CellRendererPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author NguyenCongPC
 */
public class SVForm extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    private MenuForm menuForm;
    private byte[] personalImg;

    /**
     * Creates new form SVForm
     */
    public SVForm() {
        initComponents();

        initTable();
        initCombobox();
        showAll();
    }

    private void initCombobox() {
        String sql = "SELECT MaLop FROM Lop";
        try {
            Connection con = ConnectDB.ConnectionDB();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbxLop.removeAllItems();
            while (rs.next()) {
                cbxLop.addItem(rs.getString("MaLop"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(SVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTable() {
        tableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 7) {
                    TableColumn tb = tblStudents.getColumn("Hình");
                    tb.setMaxWidth(80);
                    tb.setMinWidth(60);
                    tblStudents.setRowHeight(60);
                    return ImageIcon.class;
                }
                return Object.class;
            }

        };
        tableModel.setColumnIdentifiers(new Object[]{"Mã Sinh Viên", "Họ Tên",
            "Email", "Số Điện Thoại", "Giới Tính", "Địa Chỉ", "Lớp", "Hình"});
        tblStudents.setModel(tableModel);
    }

    private void showAll() {
        try {
            Connection con = ConnectDB.ConnectionDB();
            String sql = "SELECT * FROM SinhVien";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            tableModel.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("MaSV"), rs.getString("HoTen"), rs.getString("Email"),
                    rs.getString("SDT"),
                    Integer.parseInt(rs.getString("GioiTinh")) == 1 ? "Nam" : "Nữ",
                    rs.getString("DiaChi"),
                    rs.getString("MaLop"),
                    new ImageIcon(ImgHelpler.createImgFromByteArray(rs.getBytes("HinhAnh"), "jpg"))
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbxLop = new javax.swing.JComboBox<>();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdbNam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnHuyBo = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnChinhSua = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSv = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        txtTenSv = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        txtImg = new javax.swing.JLabel();
        btnOpenImg = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblStudents);

        jLabel8.setText("Lớp:");

        cbxLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Giới Tính: ");

        buttonGroup1.add(rdbNam);
        rdbNam.setText("Nam");

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");
        rdbNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNuActionPerformed(evt);
            }
        });

        jLabel7.setText("Địa Chỉ: ");

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnHuyBo.setText("Làm Mới");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnChinhSua.setText("Chỉnh Sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã SV:");

        jLabel3.setText("Họ Tên: ");

        jLabel4.setText("Email: ");

        jLabel5.setText("Số ĐT:");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtImg, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtImg, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnOpenImg.setText("Mở ảnh");
        btnOpenImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenImgActionPerformed(evt);
            }
        });

        btnExcel.setText("In Thông Tin");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSdt)
                                    .addComponent(txtDiaChi)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMaSv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenSv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxLop, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHuyBo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLuu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnChinhSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(btnOpenImg, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtTenSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(rdbNam)
                                .addComponent(rdbNu)
                                .addComponent(btnExcel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyBo)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu)
                        .addGap(18, 18, 18)
                        .addComponent(btnChinhSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbxLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOpenImg)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdbNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        StringBuilder builder = new StringBuilder();
        Validator.validatorEmpty(txtMaSv, builder, "Mã sinh viên không được để trống");

        if (builder.length() > 0) {
            MesageHepler.showErrorDialog(menuForm, builder.toString(), "Lỗi !");
            return;
        }

        try {
            StudentDAO dao = new StudentDAO();
            Student st = dao.findById(txtMaSv.getText());
            if (st != null) {
                txtTenSv.setText(st.getHoTen());
                txtEmail.setText(st.getEmail());
                txtSdt.setText(st.getSoDT());
                rdbNam.setSelected(st.getGioiTinh() == 1);
                rdbNu.setSelected(st.getGioiTinh() == 0);
                txtDiaChi.setText(st.getDiaChi());
                cbxLop.setSelectedItem(st.getMaLop());
                search();
                if (st.getHinhAnh() != null) {
                    Image img = ImgHelpler.createImgFromByteArray(st.getHinhAnh(), "jpg");
                    txtImg.setIcon(new ImageIcon(img));
                    personalImg = st.getHinhAnh();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sinh Viên Không Tìm Thấy !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private boolean search() {
        PreparedStatement ps = null;
        Connection con = ConnectDB.ConnectionDB();
        if (con != null) {
            try {
                tableModel.setRowCount(0);
                String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, txtMaSv.getText());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Vector vector = new Vector();
                    vector.add(rs.getString(1));
                    vector.add(rs.getString(2));
                    vector.add(rs.getString(3));
                    vector.add(rs.getString(4));
                    vector.add(rs.getInt(5) == 1 ? "Nam" : "Nữ");
                    vector.add(rs.getString(6));
                    vector.add(rs.getString(7));
                    try {
                        vector.add(new ImageIcon(ImgHelpler.
                                createImgFromByteArray(rs.getBytes("HinhAnh"), "jpg")));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        txtMaSv.setText("");
        txtTenSv.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSdt.setText("");
        personalImg = null;
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        StringBuilder builder = new StringBuilder();
        Validator.validatorEmpty(txtMaSv, builder, "Mã sinh viên không được để trống");

        if (builder.length() > 0) {
            MesageHepler.showErrorDialog(menuForm, builder.toString(), "Lỗi !");
            return;
        }

        try {
            Student std = new Student();
            std.setMaSV(txtMaSv.getText());
            std.setHoTen(txtTenSv.getText());
            std.setEmail(txtEmail.getText());
            std.setSoDT(txtSdt.getText());
            std.setGioiTinh(rdbNam.isSelected() ? 1 : 0);
            std.setDiaChi(txtDiaChi.getText());
            std.setMaLop(cbxLop.getSelectedItem().toString());
            std.setHinhAnh(personalImg);
            StudentDAO dao = new StudentDAO();
            if (dao.save(std)) {
                MesageHepler.showMessageDialog(menuForm, "Sinh Viên Đã Được Lưu Vào CSDL", "Thông báo !");
            } else {
                MesageHepler.showConfirmDialog(menuForm, "Sinh viên chưa được lưu vào CSDL", "Cảnh báo !");
            }
            showAll();
        } catch (Exception e) {
            e.printStackTrace();
            MesageHepler.showErrorDialog(menuForm, e.getMessage(), "Lỗi !");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        StringBuilder builder = new StringBuilder();
        Validator.validatorEmpty(txtMaSv, builder, "Mã sinh viên không được để trống");

        if (builder.length() > 0) {
            MesageHepler.showErrorDialog(menuForm, builder.toString(), "Lỗi !");
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Xác nhận cập nhật sinh viên !") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            Student std = new Student();
            std.setMaSV(txtMaSv.getText());
            std.setHoTen(txtTenSv.getText());
            std.setEmail(txtEmail.getText());
            std.setSoDT(txtSdt.getText());
            std.setGioiTinh(rdbNam.isSelected() ? 1 : 0);
            std.setDiaChi(txtDiaChi.getText());
            std.setMaLop(cbxLop.getSelectedItem().toString());
            std.setHinhAnh(personalImg);

            StudentDAO dao = new StudentDAO();
            if (dao.update(std)) {
                MesageHepler.showMessageDialog(menuForm, "Sinh Viên Đã Được Chỉnh Sửa", "Thông báo !");
            } else {
                MesageHepler.showConfirmDialog(menuForm, "Sinh viên chưa được chỉnh sửa", "Cảnh báo !");
            }
            showAll();
        } catch (Exception e) {
            e.printStackTrace();
            MesageHepler.showErrorDialog(menuForm, e.getMessage(), "Lỗi !");
        }
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        StringBuilder builder = new StringBuilder();
        Validator.validatorEmpty(txtMaSv, builder, "Mã sinh viên không được để trống");

        if (builder.length() > 0) {
            MesageHepler.showErrorDialog(menuForm, builder.toString(), "Lỗi !");
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa sinh viên !") == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            StudentDAO dao = new StudentDAO();
            if (dao.delete(txtMaSv.getText())) {
                MesageHepler.showMessageDialog(menuForm, "Sinh Viên Đã Xóa", "Thông báo !");
            } else {
                MesageHepler.showConfirmDialog(menuForm, "Sinh viên chưa được xóa", "Cảnh báo !");
            }
            showAll();
        } catch (Exception e) {
            e.printStackTrace();
            MesageHepler.showErrorDialog(menuForm, e.getMessage(), "Lỗi !");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnOpenImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenImgActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    return file.getName().toLowerCase().endsWith(".jpg");
                }
            }

            @Override
            public String getDescription() {
                return "Image file .jpg";
            }
        });
        if (chooser.showOpenDialog(menuForm) == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            Image img = ImgHelpler.resize(icon.getImage(), 200, 190);
            ImageIcon resizeImg = new ImageIcon(img);
            txtImg.setIcon(resizeImg);
            personalImg = ImgHelpler.toByte(img, "jpg");
        } catch (Exception e) {
            e.printStackTrace();
            MesageHepler.showErrorDialog(menuForm, e.getMessage(), "Lỗi !");
        }
    }//GEN-LAST:event_btnOpenImgActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
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
                XSSFSheet excelSheet = excelTableExport.createSheet("Students Sheet");

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
    }//GEN-LAST:event_btnExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnOpenImg;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxLop;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rdbNam;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtImg;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenSv;
    // End of variables declaration//GEN-END:variables
}