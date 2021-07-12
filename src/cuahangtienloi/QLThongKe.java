/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangtienloi;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class QLThongKe extends javax.swing.JFrame {

    public Connection conn;
    public String driver = "com.mysql.jdbc.Driver";

    public QLThongKe(){
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        //Chỉnh style header
        JTableHeader headerdsTonKho = tb_TonKho.getTableHeader();
        headerdsTonKho.setBackground(new java.awt.Color(75, 139, 197));
        headerdsTonKho.setForeground(Color.white);
        headerdsTonKho.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // Chỉnh độ rộng cột cho table tb_TonKho
        tb_TonKho.getColumnModel().getColumn(0).setPreferredWidth(10);
        tb_TonKho.getColumnModel().getColumn(1).setPreferredWidth(225);
        tb_TonKho.getColumnModel().getColumn(2).setPreferredWidth(30);
        tb_TonKho.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        JTableHeader headerdsDoanhSo = tb_xephang_doanhso.getTableHeader();
        headerdsDoanhSo.setBackground(new java.awt.Color(75, 139, 197));
        headerdsDoanhSo.setForeground(Color.white);
        headerdsDoanhSo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        // Chỉnh độ rộng cột cho table tb_
        tb_xephang_doanhso.getColumnModel().getColumn(0).setPreferredWidth(20);
        tb_xephang_doanhso.getColumnModel().getColumn(1).setPreferredWidth(20);
        tb_xephang_doanhso.getColumnModel().getColumn(2).setPreferredWidth(240);
        tb_xephang_doanhso.getColumnModel().getColumn(3).setPreferredWidth(30);
        tb_xephang_doanhso.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        thongkeTonKho();
        
        
        JTableHeader headerdsKhachHang = tb_khachhang.getTableHeader();
        headerdsKhachHang.setBackground(new java.awt.Color(75, 139, 197));
        headerdsKhachHang.setForeground(Color.white);
        headerdsKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
                
        thongkeKhachHang();

        int year = Calendar.getInstance().get(Calendar.YEAR);
        String str_year = Integer.toString(year);
        tf_chart_doanhthu_nam.setText(str_year);
        
        hienthiBieuDo();
        
        //Hiển thị xếp hạng chuyên cần
        JTableHeader headerdsNhanSu = tbNhanSu.getTableHeader();
        headerdsNhanSu.setBackground(new java.awt.Color(75, 139, 197));
        headerdsNhanSu.setForeground(Color.white);
        headerdsNhanSu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        tbNhanSu.getColumnModel().getColumn(0).setPreferredWidth(30);
        tbNhanSu.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbNhanSu.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbNhanSu.getColumnModel().getColumn(3).setPreferredWidth(50);
        tbNhanSu.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        thongkeChuyenCan();
        
    }

    public javax.swing.JLabel getAccount() {
        return lbUserName;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        IndexIcon = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_TonKho = new javax.swing.JTable();
        tp_phanloai_locDs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tf_xlNgay_ngay = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tf_xlNgay_nam = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf_xlNgay_thang = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tf_xlThang_thang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_xlThang_nam = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tf_xlQuy_nam = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_xlQuy_quy = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tf_xlNam_nam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_xephang_doanhso = new javax.swing.JTable();
        btn_loc_doanhsoSP = new javax.swing.JButton();
        btn_xuat_excel_dssp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pn_chart_doanhthu = new javax.swing.JPanel();
        cb_loc_doanhthu = new javax.swing.JComboBox<>();
        tf_chart_doanhthu_nam = new javax.swing.JTextField();
        btn_apdung_chart = new javax.swing.JButton();
        btn_xuat_excel_doanhthu = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_khachhang = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        btn_xuat_excel_kh = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbNhanSu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Welcome");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1590, 60, 170, 50);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("!!");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1860, 60, 30, 50);

        lbUserName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(255, 255, 255));
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserName.setText("NVxx");
        getContentPane().add(lbUserName);
        lbUserName.setBounds(1770, 60, 90, 50);

        IndexIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconCT.png"))); // NOI18N
        IndexIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IndexIconMouseClicked(evt);
            }
        });
        getContentPane().add(IndexIcon);
        IndexIcon.setBounds(60, 40, 100, 100);

        jButton8.setBackground(new java.awt.Color(75, 139, 197));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Bán Hàng");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(0, 260, 300, 70);

        jButton9.setBackground(new java.awt.Color(75, 139, 197));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Thành Viên");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(0, 370, 300, 70);

        jButton7.setBackground(new java.awt.Color(75, 139, 197));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Nhân Viên");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(0, 480, 300, 70);

        jButton2.setBackground(new java.awt.Color(75, 139, 197));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thống Kê");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(0, 590, 300, 70);

        jButton10.setBackground(new java.awt.Color(75, 139, 197));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Kho Hàng");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(0, 700, 300, 70);

        jButton11.setBackground(new java.awt.Color(75, 139, 197));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Đăng Xuất");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(0, 810, 300, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconReload.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1890, 150, 30, 30);

        tb_TonKho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tb_TonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaSP", "Tên sản phẩm", "Tồn kho"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_TonKho.setToolTipText("");
        tb_TonKho.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tb_TonKho.setRowHeight(25);
        jScrollPane2.setViewportView(tb_TonKho);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1360, 260, 470, 260);

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel11.setText("Nhập ngày");

        tf_xlNgay_ngay.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tf_xlNgay_ngay.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel12.setText("tháng");

        tf_xlNgay_nam.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tf_xlNgay_nam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel13.setText("năm");

        tf_xlNgay_thang.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tf_xlNgay_thang.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_xlNgay_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_xlNgay_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_xlNgay_nam, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tf_xlNgay_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tf_xlNgay_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tf_xlNgay_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_phanloai_locDs.addTab("Theo ngày", jPanel2);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setText("Nhập tháng");

        tf_xlThang_thang.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tf_xlThang_thang.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel10.setText("năm");

        tf_xlThang_nam.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tf_xlThang_nam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_xlThang_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_xlThang_nam, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_xlThang_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tf_xlThang_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        tp_phanloai_locDs.addTab("Theo tháng", jPanel1);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("năm");

        tf_xlQuy_nam.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tf_xlQuy_nam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setText("Chọn quý");

        cb_xlQuy_quy.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        cb_xlQuy_quy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý 1", "Quý 2", "Quý 3", "Quý 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_xlQuy_quy, 0, 143, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_xlQuy_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_xlQuy_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cb_xlQuy_quy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(14, 14, 14))
        );

        tp_phanloai_locDs.addTab("Theo quý", jPanel3);

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setText("Hãy nhập năm");

        tf_xlNam_nam.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        tf_xlNam_nam.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(tf_xlNam_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_xlNam_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_phanloai_locDs.addTab("Theo năm", jPanel4);

        getContentPane().add(tp_phanloai_locDs);
        tp_phanloai_locDs.setBounds(820, 570, 420, 91);

        tb_xephang_doanhso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tb_xephang_doanhso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hạng", "MaSP", "Tên sản phẩm", "Doanh số"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_xephang_doanhso.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tb_xephang_doanhso.setRowHeight(25);
        jScrollPane1.setViewportView(tb_xephang_doanhso);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(820, 660, 530, 220);

        btn_loc_doanhsoSP.setText("Lọc");
        btn_loc_doanhsoSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loc_doanhsoSPMouseClicked(evt);
            }
        });
        getContentPane().add(btn_loc_doanhsoSP);
        btn_loc_doanhsoSP.setBounds(1250, 600, 100, 25);

        btn_xuat_excel_dssp.setText("Xuất");
        btn_xuat_excel_dssp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuat_excel_dsspMouseClicked(evt);
            }
        });
        getContentPane().add(btn_xuat_excel_dssp);
        btn_xuat_excel_dssp.setBounds(1250, 630, 100, 25);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel2.setText("TỒN KHO SẢN PHẨM");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1480, 230, 260, 30);

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("XẾP HẠNG CHUYÊN CẦN");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(1410, 540, 400, 30);

        javax.swing.GroupLayout pn_chart_doanhthuLayout = new javax.swing.GroupLayout(pn_chart_doanhthu);
        pn_chart_doanhthu.setLayout(pn_chart_doanhthuLayout);
        pn_chart_doanhthuLayout.setHorizontalGroup(
            pn_chart_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        pn_chart_doanhthuLayout.setVerticalGroup(
            pn_chart_doanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        getContentPane().add(pn_chart_doanhthu);
        pn_chart_doanhthu.setBounds(310, 260, 1030, 260);

        cb_loc_doanhthu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo ngày trong năm", "Theo tháng trong năm" }));
        cb_loc_doanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_loc_doanhthuActionPerformed(evt);
            }
        });
        getContentPane().add(cb_loc_doanhthu);
        cb_loc_doanhthu.setBounds(310, 220, 156, 22);

        tf_chart_doanhthu_nam.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tf_chart_doanhthu_nam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(tf_chart_doanhthu_nam);
        tf_chart_doanhthu_nam.setBounds(470, 220, 77, 25);

        btn_apdung_chart.setText("Áp dụng");
        btn_apdung_chart.setMaximumSize(new java.awt.Dimension(100, 25));
        btn_apdung_chart.setMinimumSize(new java.awt.Dimension(100, 25));
        btn_apdung_chart.setPreferredSize(new java.awt.Dimension(100, 25));
        btn_apdung_chart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_apdung_chartMouseClicked(evt);
            }
        });
        getContentPane().add(btn_apdung_chart);
        btn_apdung_chart.setBounds(560, 220, 110, 25);

        btn_xuat_excel_doanhthu.setText("Xuất");
        btn_xuat_excel_doanhthu.setMaximumSize(new java.awt.Dimension(62, 25));
        btn_xuat_excel_doanhthu.setMinimumSize(new java.awt.Dimension(62, 25));
        btn_xuat_excel_doanhthu.setPreferredSize(new java.awt.Dimension(62, 25));
        btn_xuat_excel_doanhthu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuat_excel_doanhthuMouseClicked(evt);
            }
        });
        getContentPane().add(btn_xuat_excel_doanhthu);
        btn_xuat_excel_doanhthu.setBounds(680, 220, 90, 25);

        tb_khachhang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tb_khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaKH", "Họ tên", "Lượt mua", "Tiền", "ĐTL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_khachhang.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tb_khachhang.setRowHeight(25);
        jScrollPane3.setViewportView(tb_khachhang);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(310, 570, 500, 310);

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel15.setText("THỐNG KÊ KHÁCH HÀNG");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(390, 532, 320, 40);

        btn_xuat_excel_kh.setText("Xuất");
        btn_xuat_excel_kh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_xuat_excel_khMouseClicked(evt);
            }
        });
        getContentPane().add(btn_xuat_excel_kh);
        btn_xuat_excel_kh.setBounds(710, 540, 100, 25);

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel16.setText("XẾP HẠNG DOANH SỐ SẢN PHẨM");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(860, 540, 400, 30);

        tbNhanSu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbNhanSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên", "SĐT", "DCC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNhanSu.setIntercellSpacing(new java.awt.Dimension(5, 5));
        tbNhanSu.setRowHeight(25);
        jScrollPane4.setViewportView(tbNhanSu);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(1362, 572, 470, 310);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/Background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IndexIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IndexIconMouseClicked
        this.dispose();
        QLTrangChu reset = new QLTrangChu();
        reset.setExtendedState(reset.getExtendedState() | QLTrangChu.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_IndexIconMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        QLBanHang reset = new QLBanHang();
        reset.setExtendedState(reset.getExtendedState() | QLBanHang.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        this.dispose();
        QLKhachHang reset = new QLKhachHang();
        reset.setExtendedState(reset.getExtendedState() | QLKhachHang.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.dispose();
        QLNhanSu reset = new QLNhanSu();
        reset.setExtendedState(reset.getExtendedState() | QLNhanSu.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        QLThongKe reset = new QLThongKe();
        reset.setExtendedState(reset.getExtendedState() | QLThongKe.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.dispose();
        QLKhoHang reset = new QLKhoHang();
        reset.setExtendedState(reset.getExtendedState() | QLKhoHang.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        this.dispose();
        DangNhap login = new DangNhap();
        login.setVisible(true);
        login.setExtendedState(login.getExtendedState() | DangNhap.MAXIMIZED_BOTH);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        QLThongKe reset = new QLThongKe();
        reset.setExtendedState(reset.getExtendedState() | QLThongKe.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_loc_doanhsoSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loc_doanhsoSPMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel) tb_xephang_doanhso.getModel();
        tableModel.setRowCount(0);
        xeploaiDoanhSoSP();
    }//GEN-LAST:event_btn_loc_doanhsoSPMouseClicked

    private void btn_xuat_excel_dsspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuat_excel_dsspMouseClicked
        xuatExcel_DoanhSoSP();
    }//GEN-LAST:event_btn_xuat_excel_dsspMouseClicked

    private void btn_apdung_chartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_apdung_chartMouseClicked
        pn_chart_doanhthu.removeAll();
        pn_chart_doanhthu.setLayout(new CardLayout());
        
        hienthiBieuDo();
    }//GEN-LAST:event_btn_apdung_chartMouseClicked

    private void btn_xuat_excel_doanhthuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuat_excel_doanhthuMouseClicked
        
        int type = cb_loc_doanhthu.getSelectedIndex();

        if (type == 0) {
            try {
                xuatExcel_DoanhThuNgay();
            } catch (SQLException ex) {
                Logger.getLogger(QLThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QLThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QLThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (type == 1) {
            try {
                xuatExcel_DoanhThuThang();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QLThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(QLThongKe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(QLThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btn_xuat_excel_doanhthuMouseClicked

    private void btn_xuat_excel_khMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xuat_excel_khMouseClicked
        xuatExel_KhachHang();
    }//GEN-LAST:event_btn_xuat_excel_khMouseClicked

    private void cb_loc_doanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_loc_doanhthuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_loc_doanhthuActionPerformed

    private void xuatExel_KhachHang() {
        try {
            DefaultTableModel tableModel = (DefaultTableModel) tb_khachhang.getModel();

            int checkTable = tableModel.getRowCount();

            if (checkTable == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Không thể xuất ra Excel!");
            } else {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Báo cáo dữ liệu khách hàng");

                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow(0);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("MaKH");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Họ tên");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Lượt mua");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Tiền");

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("Điểm TL");

                // Xử lý bảng
                for (int i = 0; i < tableModel.getRowCount(); i++) {

                    String MaKH = tableModel.getValueAt(i, 0).toString();
                    String TenKH = tableModel.getValueAt(i, 1).toString();
                    String luotmua = tableModel.getValueAt(i, 2).toString();
                    int iluotmua = Integer.parseInt(luotmua);
                    String tien = tableModel.getValueAt(i, 3).toString();
                    int itien = Integer.parseInt(tien);
                    String dtl = tableModel.getValueAt(i, 4).toString();
                    int idtl = Integer.parseInt(dtl);

                    System.out.println("MaKH:" + MaKH + "\tTên:" + TenKH + "\tLượt mua:" + iluotmua + "\tTiền:" + itien + "\tĐiểm TL:" + idtl);

                    row = sheet.createRow(1 + i);

                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(MaKH);

                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(TenKH);

                    cell = row.createCell(2, CellType.NUMERIC);
                    cell.setCellValue(iluotmua);

                    cell = row.createCell(3, CellType.NUMERIC);
                    cell.setCellValue(itien);

                    cell = row.createCell(4, CellType.NUMERIC);
                    cell.setCellValue(idtl);
                }

                // Lưu báo cáo ra file 
                String file_name = "KhachHang";
                String path = "c:/shop/excel/KhachHang/";

                File f = new File(path + file_name + ".xlsx");
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();

                // Thông báo thành công
                JFrame mess = new JFrame();
                JOptionPane.showMessageDialog(mess, "Đã xuất thành công excel!");
            }
            
        
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally
    }

    private void xuatExcel_DoanhThuNgay() throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
        Class.forName(driver);
        String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
        conn = DriverManager.getConnection(urlUnicode);

        String nam = tf_chart_doanhthu_nam.getText().toString();
        String SQL_String = null;

        ArrayList<String> lsngay = new ArrayList<>();
        ArrayList<Integer> lsdoanhthu = new ArrayList<>();

        try {
            SQL_String = "SELECT NgLap Ngay, SUM(TongTien) DoanhThu "
                    + "FROM hoadon where YEAR(NgLap) = '" + nam + "' "
                    + "GROUP BY Ngay "
                    + "ORDER BY Ngay ASC";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL_String);
            while (rs.next()) {
                String ngay = rs.getString(1);
                lsngay.add(ngay);
                int doanhso = rs.getInt(2);
                lsdoanhthu.add(doanhso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Báo cáo doanh thu sản phẩm theo ngày");

        XSSFRow row = null;
        Cell cell = null;

        row = sheet.createRow(0);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Ngày");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Doanh số");

        for (int i = 0; i < lsngay.size(); i++) {
            System.out.println("Ngày:" + lsngay.get(i) + "\tDoanh thu:" + lsdoanhthu.get(i));

            row = sheet.createRow(1 + i);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(lsngay.get(i));

            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(lsdoanhthu.get(i));
        }

        String file_name = "DoanhThuCacNgayTrong_" + nam;
        File f = new File("c:/shop/excel/DoanhThuTheoNgay/" + file_name + ".xlsx");
        try (FileOutputStream fis = new FileOutputStream(f)) {
            workbook.write(fis);
        }

        JFrame mess = new JFrame();
        JOptionPane.showMessageDialog(mess, "Đã xuất thành công excel!");

        conn.close();
    }

    private void xuatExcel_DoanhThuThang() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName(driver);
        String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
        conn = DriverManager.getConnection(urlUnicode);

        String nam = tf_chart_doanhthu_nam.getText().toLowerCase().toString();
        String SQL_String = null;

        ArrayList<String> lsthang = new ArrayList<>();
        ArrayList<Integer> lsdoanhthu = new ArrayList<>();

        try {
            SQL_String = "SELECT MONTH(NgLap) Thang, SUM(TongTien) DoanhThu "
                    + "FROM hoadon "
                    + "where YEAR(NgLap) = '" + nam + "' "
                    + "GROUP BY MONTH(NgLap) "
                    + "ORDER BY MONTH(NgLap) ASC ;";
            
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL_String);
            
            while (rs.next()) {
                String thang = rs.getString(1);
                lsthang.add(thang);
                int doanhso = rs.getInt(2);
                lsdoanhthu.add(doanhso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Báo cáo doanh thu sản phẩm theo ngày");

        XSSFRow row = null;
        Cell cell = null;

        row = sheet.createRow(0);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Tháng");

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Doanh số");

        for (int i = 0; i < lsthang.size(); i++) {
            System.out.println("Tháng:" + lsthang.get(i) + "\tDoanh thu:" + lsdoanhthu.get(i));

            row = sheet.createRow(1 + i);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(lsthang.get(i));

            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(lsdoanhthu.get(i));
        }

        String file_name = "DoanhThuCacThangTrong_" + nam;
        File f = new File("c:/shop/excel/DoanhThuTheoThang/" + file_name + ".xlsx");
        try (FileOutputStream fis = new FileOutputStream(f)) {
            workbook.write(fis);
        }

        JFrame mess = new JFrame();
        JOptionPane.showMessageDialog(mess, "Đã xuất thành công excel!");

        conn.close();
    }

    private void thongkeChuyenCan(){
        try {
            //Load driver
            Class.forName(driver).newInstance();
            //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);
           
            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode); 
            //-----
            System.out.println("Connected to the database");
           
            String SQL = "SELECT MaNV, LoaiNV, TinhTrang, TenNV, sdtNV, DiemChuyenCan FROM nhanvien ORDER BY DiemChuyenCan DESC";    
            System.out.print(SQL);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL);
            Vector data = null;
            rs.last();
            
            rs.beforeFirst(); 
            
            while (rs.next()) {
                int LoaiNV = rs.getInt("LoaiNV");
                int TinhTrang = rs.getInt("TinhTrang");
                if((LoaiNV==2) & (TinhTrang==1)){
                    
                    data = new Vector();
                    data.add(rs.getString("MaNV"));
                    data.add(rs.getString("TenNV"));
                    data.add(rs.getString("sdtNV"));
                    data.add(rs.getString("DiemChuyenCan"));
                    // Thêm một dòng vào table model
                    DefaultTableModel dsNhanSu =(DefaultTableModel) tbNhanSu.getModel();
                    dsNhanSu.addRow(data);

                }
                
              }
            rs.close();
            stat.close();
            conn.close();
        }catch(SQLException se)
        {
               se.printStackTrace();
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally

    }
    
    private void thongkeTonKho() {
        try {
            Class.forName(driver).newInstance();

            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";

            conn = DriverManager.getConnection(urlUnicode);

            System.out.println("Connected to the database");
            String SQL = "SELECT MaLoai, TenLoai, TongSLHienTai FROM loaihang ORDER BY TongSLHienTai ASC";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL);

            DefaultTableModel tableModel = (DefaultTableModel) tb_TonKho.getModel();

            while (rs.next()) {
                String masp = rs.getString(1);
                String tensp = rs.getString(2);
                int tonkho = rs.getInt(3);

                tableModel.addRow(new Object[]{
                    masp, tensp, tonkho
                });
            }

            conn.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void thongkeKhachHang() {

        try {
            Class.forName(driver).newInstance();

            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";

            conn = DriverManager.getConnection(urlUnicode);

            System.out.println("Connected to the database");
            String SQL = "SELECT kh.MaKH, kh.TenKH, COUNT(kh.MaKH) LuotMua, SUM(hd.TongTien) Tien, kh.DiemTichLuy FROM khachhang kh JOIN hoadon hd where kh.MaKH = hd.MaKH GROUP BY kh.MaKH ORDER BY Tien DESC";

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL);

            DefaultTableModel tableModel = (DefaultTableModel) tb_khachhang.getModel();

            while (rs.next()) {
                
                String makh = rs.getString(1);
                if(!makh.equals("")){
                    String ten = rs.getString(2);
                    int luotmua = rs.getInt(3);
                    int tien = rs.getInt(4);
                    int dtl = rs.getInt(5);

                    tableModel.addRow(new Object[]{
                        makh, ten, luotmua, tien, dtl
                    });
                }
                
            }

            conn.close();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void xuatExcel_DoanhSoSP() {
        try {
            
            DefaultTableModel tableModel = (DefaultTableModel) tb_xephang_doanhso.getModel();
            int checkTable = tableModel.getRowCount();

            if (checkTable == 0) {
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Không thể xuất ra Excel!");
            } else {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Báo cáo doanh số sản phẩm");

                XSSFRow row = null;
                Cell cell = null;

                row = sheet.createRow(0);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("Hạng");

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("Mã sản phẩm");

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("Tên sản phẩm");

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Doanh số");

                // Xử lý bảng
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String HangSP = tableModel.getValueAt(i, 0).toString();
                    int iHangSP = Integer.parseInt(HangSP);
                    String MaSP = tableModel.getValueAt(i, 1).toString();
                    String TenSP = tableModel.getValueAt(i, 2).toString();
                    String DoanhSoSP = tableModel.getValueAt(i, 3).toString();
                    int iDoanhSoSP = Integer.parseInt(DoanhSoSP);

                    System.out.println("Hạng:" + iHangSP + "\tTên:" + TenSP + "\tMaSP:" + MaSP + "\tDoanh số:" + iDoanhSoSP);

                    row = sheet.createRow(1 + i);

                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(iHangSP);

                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(MaSP);

                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(TenSP);

                    cell = row.createCell(3, CellType.NUMERIC);
                    cell.setCellValue(iDoanhSoSP);
                }

                // Lưu báo cáo ra file 
                String file_name = null;
                String path = null;
                int type = tp_phanloai_locDs.getSelectedIndex();

                if (type == 0) {
                    // Xuất excel dạng xếp loại theo ngày
                    String ngay = tf_xlNgay_ngay.getText().toLowerCase().toString();
                    String thang = tf_xlNgay_thang.getText().toLowerCase().toString();
                    String nam = tf_xlNgay_nam.getText().toLowerCase().toString();
                    file_name = "XHDT_NGAY_" + ngay + "_" + thang + "_" + nam;
                    path = "c:/shop/excel/XHDS_THEO_NGAY/";
                }
                if (type == 1) {
                    // Xuất excel dạng xếp loại theo tháng
                    String thang = tf_xlThang_thang.getText().toLowerCase().toString();
                    String nam = tf_xlThang_nam.getText().toLowerCase().toString();
                    file_name = "XHDT_THANG_" + thang + "_" + nam;
                    path = "c:/shop/excel/XHDS_THEO_THANG/";
                }
                if (type == 2) {
                    // Xuất excel dạng xếp loại theo quý
                    String quy = cb_xlQuy_quy.getSelectedItem().toString();
                    String nam = tf_xlQuy_nam.getText().toLowerCase().toString();
                    file_name = "XHDT_QUY_" + quy + "_" + nam;
                    path = "c:/shop/excel/XHDS_THEO_QUY/";
                }
                if (type == 3) {
                    // Xuất excel dạng xếp loại theo năm
                    String nam = tf_xlNam_nam.getText().toLowerCase().toString();
                    file_name = "XHDT_NAM_" + nam;
                    path = "c:/shop/excel/XHDS_THEO_NAM/";
                }

                File f = new File(path + file_name + ".xlsx");
                FileOutputStream fis = new FileOutputStream(f);
                workbook.write(fis);
                fis.close();

                // Thông báo thành công
                JFrame mess = new JFrame();
                JOptionPane.showMessageDialog(mess, "Đã xuất thành công excel!");
            }        
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally
        
    }

    private void xeploaiDoanhSoSP(){
        try {
            int type = tp_phanloai_locDs.getSelectedIndex();
            String SQL_String = null;
            Class.forName(driver);
            //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);

            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode);
            DefaultTableModel tableModel = (DefaultTableModel) tb_xephang_doanhso.getModel();
            tableModel.setRowCount(0);

            // xếp loại theo ngày
            if (type == 0) {
                // Lấy dữ liệu
                String ngay = tf_xlNgay_ngay.getText().toLowerCase().toString();
                String thang = tf_xlNgay_thang.getText().toLowerCase().toString();
                String nam = tf_xlNgay_nam.getText().toLowerCase().toString();


                // Hàm kiểm tra ngày 
                // Xử lý thông tin
                SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                        + "FROM cthd, loaihang "
                        + "WHERE loaihang.MaLoai=cthd.MaSP "
                        + "AND MaHD IN (SELECT MaHD FROM hoadon WHERE NgLap = '"
                        + nam + "-" + thang + "-" + ngay + "') "
                        + "GROUP BY MaSP ORDER BY SL DESC";
            }

            // Xếp loại theo tháng
            if (type == 1) {
                // Lấy dữ liệu
                String thang = tf_xlThang_thang.getText().toLowerCase().toString();
                String nam = tf_xlThang_nam.getText().toLowerCase().toString();


                // Xử lý thông tin
                SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                        + "FROM cthd, loaihang "
                        + "WHERE loaihang.MaLoai=cthd.MaSP "
                        + "AND MaHD IN (SELECT MaHD "
                        + "FROM hoadon "
                        + "WHERE MONTH(NgLap) = '" + thang + "' "
                        + "AND YEAR(NgLap) = '" + nam + "') "
                        + "GROUP BY MaSP ORDER BY SL DESC";
            }

            // Xếp loại theo quý
            if (type == 2) {
                // Lấy dữ liệu
                String nam = tf_xlQuy_nam.getText().toLowerCase().toString();
                int quy = cb_xlQuy_quy.getSelectedIndex();

                

                // Xứ lý thông tin
                // Quý 1
                if (quy == 0) {
                    SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                            + "FROM cthd, loaihang "
                            + "WHERE loaihang.MaLoai=cthd.MaSP "
                            + "AND MaHD "
                            + "IN (SELECT MaHD FROM hoadon WHERE (MONTH(NgLap) BETWEEN '1' AND '3') "
                            + "AND YEAR(NgLap) = '" + nam + "') "
                            + "GROUP BY MaSP ORDER BY SL DESC";
                }

                // Quý 2
                if (quy == 1) {
                    SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                            + "FROM cthd, loaihang "
                            + "WHERE loaihang.MaLoai=cthd.MaSP "
                            + "AND MaHD "
                            + "IN (SELECT MaHD FROM hoadon WHERE (MONTH(NgLap) BETWEEN '4' AND '6') "
                            + "AND YEAR(NgLap) = '" + nam + "') "
                            + "GROUP BY MaSP ORDER BY SL DESC";
                }

                // Quý 3
                if (quy == 2) {
                    SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                            + "FROM cthd, loaihang "
                            + "WHERE loaihang.MaLoai=cthd.MaSP "
                            + "AND MaHD "
                            + "IN (SELECT MaHD FROM hoadon WHERE (MONTH(NgLap) BETWEEN '7' AND '9') "
                            + "AND YEAR(NgLap) = '" + nam + "') "
                            + "GROUP BY MaSP ORDER BY SL DESC";
                }

                // Quý 4
                if (quy == 3) {
                    SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                            + "FROM cthd, loaihang "
                            + "WHERE loaihang.MaLoai=cthd.MaSP "
                            + "AND MaHD "
                            + "IN (SELECT MaHD FROM hoadon WHERE (MONTH(NgLap) BETWEEN '10' AND '12') "
                            + "AND YEAR(NgLap) = '" + nam + "') "
                            + "GROUP BY MaSP ORDER BY SL DESC";
                }
            }

            // Xếp loại theo năm
            if (type == 3) {
                // Lấy dữ liệu
                String nam = tf_xlNam_nam.getText().toLowerCase().toString();


                // Xử lý thông tin
                SQL_String = "SELECT MaSP, TenLoai, SUM(SoLuong) SL "
                        + "FROM cthd, loaihang "
                        + "WHERE loaihang.MaLoai=cthd.MaSP "
                        + "AND MaHD IN (SELECT MaHD "
                        + "FROM hoadon "
                        + "WHERE YEAR(NgLap) = '" + nam + "') "
                        + "GROUP BY MaSP ORDER BY SL DESC";
            }

            // Truy vấn CSDL với type tương ứng
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL_String);

            if (!rs.isBeforeFirst()) {
                JFrame m = new JFrame();
                JOptionPane.showMessageDialog(m, "Không tìm thấy kết quả!");
                return;
            }

            while (rs.next()) {
                String masp = rs.getString(1);
                String tensp = rs.getString(2);
                int doanhso = rs.getInt(3);
                System.out.println("masp:\t" + masp + "\ttensp:\t" + tensp + "\tdoanhso:\t" + doanhso);
                tableModel.addRow(new Object[]{
                    tableModel.getRowCount() + 1, masp, tensp, doanhso
                });
            }

            conn.close();

            }catch(SQLException se)
            {
                   se.printStackTrace();
            }catch(Exception e){
                    // Xu ly cac loi cho Class.forName
                    e.printStackTrace();
            }finally{

                   }// Ket thuc khoi finally
        }

        private void hienthiBieuDo() {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            String nam = tf_chart_doanhthu_nam.getText().toString();
            int type = cb_loc_doanhthu.getSelectedIndex();
            String SQL;
            try {

                Class.forName(driver).newInstance();
                String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
                conn = DriverManager.getConnection(urlUnicode);

                // Lọc theo ngày
                if (type == 0) {
                    SQL = "SELECT NgLap Ngay, SUM(TongTien) DoanhThu FROM hoadon where YEAR(NgLap) = ? GROUP BY Ngay ORDER BY Ngay ASC";

                    PreparedStatement stat = conn.prepareStatement(SQL);
                    stat.setString(1,nam);

                    ResultSet rs = stat.executeQuery();

                    if (!rs.isBeforeFirst()) {
                        JFrame m = new JFrame();
                        JOptionPane.showMessageDialog(m, "Không tìm thấy kết quả!");
                        return;
                    }

                    while (rs.next()) {
                        String ngay = rs.getString(1);
                        int doanhso = rs.getInt(2);
                        System.out.println("Ngay:" + ngay + "\tDoanh so:" + doanhso);
                        dataset.addValue(doanhso, "Doanh số", ngay);
                    }

                    JFreeChart chart = ChartFactory.createLineChart("THỐNG KÊ DOANH THU THEO NGÀY - NĂM " + nam, "Ngày", "Doanh thu", dataset);
                    ChartPanel chartPanel = new ChartPanel(chart);
                    chartPanel.setPreferredSize(new Dimension(pn_chart_doanhthu.getWidth(), pn_chart_doanhthu.getHeight() - 20));

                    pn_chart_doanhthu.removeAll();
                    pn_chart_doanhthu.setLayout(new CardLayout());
                    pn_chart_doanhthu.add(chartPanel);
                    pn_chart_doanhthu.revalidate();
                    pn_chart_doanhthu.repaint();
                }

                // Lọc theo tháng
                if (type == 1) {
                    SQL = "SELECT MONTH(NgLap) Thang, SUM(TongTien) DoanhThu FROM hoadon where YEAR(NgLap) = ? GROUP BY MONTH(NgLap) ORDER BY MONTH(NgLap) ASC ;";

                    PreparedStatement stat = conn.prepareStatement(SQL);
                    stat.setString(1,nam);

                    ResultSet rs = stat.executeQuery();

                    if (!rs.isBeforeFirst()) {
                        JFrame m = new JFrame();
                        JOptionPane.showMessageDialog(m, "Không tìm thấy kết quả!");
                        return;
                    }

                    while (rs.next()) {
                        String thang = rs.getString(1);
                        int doanhso = rs.getInt(2);
                        dataset.addValue(doanhso, "Doanh số", thang);
                        System.out.println(doanhso + "\t" + thang);
                    }

                    JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ DOANH SỐ THEO THÁNG - NĂM " + nam, "Tháng", "Doanh thu", dataset);
                    ChartPanel chartPanel = new ChartPanel(chart);
                    chartPanel.setPreferredSize(new Dimension(pn_chart_doanhthu.getWidth(), pn_chart_doanhthu.getHeight() - 20));

                    pn_chart_doanhthu.removeAll();
                    pn_chart_doanhthu.setLayout(new CardLayout());
                    pn_chart_doanhthu.add(chartPanel);
                    pn_chart_doanhthu.revalidate();
                    pn_chart_doanhthu.repaint();
                }

                conn.close();
        }catch(SQLException se)
        {
               se.printStackTrace();
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally
    }

    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IndexIcon;
    private javax.swing.JButton btn_apdung_chart;
    private javax.swing.JButton btn_loc_doanhsoSP;
    private javax.swing.JButton btn_xuat_excel_doanhthu;
    private javax.swing.JButton btn_xuat_excel_dssp;
    private javax.swing.JButton btn_xuat_excel_kh;
    private javax.swing.JComboBox<String> cb_loc_doanhthu;
    private javax.swing.JComboBox<String> cb_xlQuy_quy;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JPanel pn_chart_doanhthu;
    private javax.swing.JTable tbNhanSu;
    private javax.swing.JTable tb_TonKho;
    private javax.swing.JTable tb_khachhang;
    private javax.swing.JTable tb_xephang_doanhso;
    private javax.swing.JTextField tf_chart_doanhthu_nam;
    private javax.swing.JTextField tf_xlNam_nam;
    private javax.swing.JTextField tf_xlNgay_nam;
    private javax.swing.JTextField tf_xlNgay_ngay;
    private javax.swing.JTextField tf_xlNgay_thang;
    private javax.swing.JTextField tf_xlQuy_nam;
    private javax.swing.JTextField tf_xlThang_nam;
    private javax.swing.JTextField tf_xlThang_thang;
    private javax.swing.JTabbedPane tp_phanloai_locDs;
    // End of variables declaration//GEN-END:variables
}
