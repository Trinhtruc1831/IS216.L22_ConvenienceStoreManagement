/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangtienloi;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author PC
 */
public class QLKhoHang extends javax.swing.JFrame {

    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String nowDate = dtf.format(now);
    private Connection conn; 
    String driver = "com.mysql.jdbc.Driver";
    
    public QLKhoHang() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        JTableHeader headerKhoHang = tbKhoHang.getTableHeader();
        headerKhoHang.setBackground(new java.awt.Color(75, 139, 197));
        headerKhoHang.setForeground(Color.white);
        headerKhoHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        tbKhoHang.getColumnModel().getColumn(0).setPreferredWidth(70);
        tbKhoHang.getColumnModel().getColumn(1).setPreferredWidth(50);
        tbKhoHang.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbKhoHang.getColumnModel().getColumn(3).setPreferredWidth(130);
        tbKhoHang.getColumnModel().getColumn(4).setPreferredWidth(130);
        tbKhoHang.getColumnModel().getColumn(5).setPreferredWidth(120);
        tbKhoHang.getColumnModel().getColumn(6).setPreferredWidth(150);
        tbKhoHang.getColumnModel().getColumn(7).setPreferredWidth(300);
        
        JTableHeader headerLoaiHang = tbLoaiHang.getTableHeader();
        headerLoaiHang.setBackground(new java.awt.Color(75, 139, 197));
        headerLoaiHang.setForeground(Color.white);
        headerLoaiHang.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        tbLoaiHang.getColumnModel().getColumn(1).setPreferredWidth(400);
        tbLoaiHang.getColumnModel().getColumn(2).setPreferredWidth(150);
        

        
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
           
            String SQL1 = "SELECT MaLoHang, SoLuong, DonVi, NgNhap, NgHetHan, XXu, nhanvien.TenNV, loaihang.TenLoai FROM nhaphang, nhanvien, loaihang WHERE nhaphang.MaNV = nhanvien.MaNV AND nhaphang.MaLoai = loaihang.MaLoai";    
            
            Statement stat1 = conn.createStatement();
            ResultSet rs1 = stat1.executeQuery(SQL1);
            Vector data1 = null;
            rs1.last();
            
            
            rs1.beforeFirst(); 
//            int i=0; 
            while (rs1.next()) {
                data1 = new Vector();
                data1.add(rs1.getString("MaLoHang"));
                data1.add(rs1.getInt("SoLuong"));
                data1.add(rs1.getString("DonVi"));
                data1.add(rs1.getString("NgNhap"));
                data1.add(rs1.getString("NgHetHan"));
                data1.add(rs1.getString("XXu"));
                data1.add(rs1.getString("TenNV"));
                data1.add(rs1.getString("TenLoai"));
                
                // Thêm một dòng vào table model
                DefaultTableModel dsKhoHang =(DefaultTableModel) tbKhoHang.getModel();
                dsKhoHang.addRow(data1);
              }
            rs1.close();
            stat1.close();
            
            String SQL2 = "SELECT MaLoai, TenLoai, GiaTien, DiemSanPham, TongSLHienTai FROM loaihang";    
            
            Statement stat2 = conn.createStatement();
            ResultSet rs2 = stat2.executeQuery(SQL2);
            Vector data2 = null;
            rs2.last();
            
            
            rs2.beforeFirst(); 
//            int i=0; 
            while (rs2.next()) {
                data2 = new Vector();
                data2.add(rs2.getString("MaLoai"));
                data2.add(rs2.getString("TenLoai"));
                data2.add(rs2.getInt("GiaTien"));
                data2.add(rs2.getString("DiemSanPham"));
                data2.add(rs2.getInt("TongSLHienTai"));
                
                // Thêm một dòng vào table model
                DefaultTableModel dsLoaiHang =(DefaultTableModel) tbLoaiHang.getModel();
                dsLoaiHang.addRow(data2);
              }
            rs2.close();
            stat2.close();
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
     
    public javax.swing.JLabel getAccount(){
        return lbUserName;
    }
    public javax.swing.JTextField gettfMaNhanVien(){
         return tfMaNhanVien;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhoHang = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfDiem = new javax.swing.JTextField();
        tfTenSanPham = new javax.swing.JTextField();
        tfGiaThanh = new javax.swing.JTextField();
        lbThongBao1 = new javax.swing.JLabel();
        lbMSP = new javax.swing.JLabel();
        btNhapHang1 = new javax.swing.JButton();
        btCapNhat2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        tfDonVi = new javax.swing.JTextField();
        lbMaThanhVien = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbDiemTichLuy = new javax.swing.JLabel();
        tfXuatXu = new javax.swing.JTextField();
        tfMaNhanVien = new javax.swing.JTextField();
        lbDiemTichLuy1 = new javax.swing.JLabel();
        lbDiemTichLuy2 = new javax.swing.JLabel();
        tfLoaiSanPham = new javax.swing.JTextField();
        btNhapHang = new javax.swing.JButton();
        btCapNhat1 = new javax.swing.JButton();
        lbThongBao = new javax.swing.JLabel();
        lbMLH = new javax.swing.JLabel();
        dcNHH = new com.toedter.calendar.JDateChooser();
        tfTimKiem = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        tfTimKiem1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLoaiHang = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        IndexIcon = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tbKhoHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbKhoHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MLH", "SL", "Đơn vị", "NgNhap", "NgHetHan", "XXu", "NVPT", "Loại SP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhoHang.setIntercellSpacing(new java.awt.Dimension(10, 10));
        tbKhoHang.setRowHeight(35);
        tbKhoHang.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tbKhoHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhoHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhoHang);
        if (tbKhoHang.getColumnModel().getColumnCount() > 0) {
            tbKhoHang.getColumnModel().getColumn(5).setHeaderValue("XXu");
            tbKhoHang.getColumnModel().getColumn(6).setHeaderValue("NVPT");
            tbKhoHang.getColumnModel().getColumn(7).setHeaderValue("Loại SP");
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 260, 910, 250);

        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("THÊM SẢN PHẨM MỚI");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(140, 50, 210, 30);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tên sản phẩm:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(40, 180, 90, 16);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Giá thành:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(60, 210, 70, 16);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Điểm:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(80, 240, 48, 16);
        jPanel3.add(tfDiem);
        tfDiem.setBounds(140, 240, 230, 22);
        jPanel3.add(tfTenSanPham);
        tfTenSanPham.setBounds(140, 180, 230, 22);
        jPanel3.add(tfGiaThanh);
        tfGiaThanh.setBounds(140, 210, 230, 22);

        lbThongBao1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(lbThongBao1);
        lbThongBao1.setBounds(60, 140, 150, 20);

        lbMSP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel3.add(lbMSP);
        lbMSP.setBounds(210, 140, 70, 20);

        btNhapHang1.setText("Nhập Hàng");
        btNhapHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapHang1ActionPerformed(evt);
            }
        });
        jPanel3.add(btNhapHang1);
        btNhapHang1.setBounds(100, 440, 140, 40);

        btCapNhat2.setText("Cập Nhật");
        btCapNhat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhat2ActionPerformed(evt);
            }
        });
        jPanel3.add(btCapNhat2);
        btCapNhat2.setBounds(260, 440, 140, 40);

        jTabbedPane1.addTab("Thêm SP Mới", jPanel3);

        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NHẬP HÀNG");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(140, 50, 210, 30);
        jPanel2.add(tfSoLuong);
        tfSoLuong.setBounds(160, 170, 190, 22);
        jPanel2.add(tfDonVi);
        tfDonVi.setBounds(160, 200, 190, 22);

        lbMaThanhVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaThanhVien.setText("Số lượng: ");
        jPanel2.add(lbMaThanhVien);
        lbMaThanhVien.setBounds(40, 170, 110, 16);

        lbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKhachHang.setText("Đơn vị nhập: ");
        jPanel2.add(lbKhachHang);
        lbKhachHang.setBounds(40, 200, 110, 16);

        lbSDT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSDT.setText("Ngày Hết Hạn: ");
        jPanel2.add(lbSDT);
        lbSDT.setBounds(40, 230, 110, 16);

        lbDiemTichLuy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy.setText("Xuất xứ: ");
        jPanel2.add(lbDiemTichLuy);
        lbDiemTichLuy.setBounds(40, 260, 110, 16);
        jPanel2.add(tfXuatXu);
        tfXuatXu.setBounds(160, 260, 190, 22);
        jPanel2.add(tfMaNhanVien);
        tfMaNhanVien.setBounds(160, 290, 190, 22);

        lbDiemTichLuy1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy1.setText("Mã NV: ");
        jPanel2.add(lbDiemTichLuy1);
        lbDiemTichLuy1.setBounds(40, 290, 110, 16);

        lbDiemTichLuy2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy2.setText("Loại sản phẩm: ");
        jPanel2.add(lbDiemTichLuy2);
        lbDiemTichLuy2.setBounds(40, 320, 110, 16);
        jPanel2.add(tfLoaiSanPham);
        tfLoaiSanPham.setBounds(160, 320, 190, 22);

        btNhapHang.setText("Nhập Hàng");
        btNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapHangActionPerformed(evt);
            }
        });
        jPanel2.add(btNhapHang);
        btNhapHang.setBounds(100, 440, 140, 40);

        btCapNhat1.setText("Cập Nhật");
        btCapNhat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCapNhat1ActionPerformed(evt);
            }
        });
        jPanel2.add(btCapNhat1);
        btCapNhat1.setBounds(260, 440, 140, 40);

        lbThongBao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(lbThongBao);
        lbThongBao.setBounds(60, 140, 150, 20);

        lbMLH.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(lbMLH);
        lbMLH.setBounds(210, 140, 70, 20);
        jPanel2.add(dcNHH);
        dcNHH.setBounds(160, 230, 190, 22);

        jTabbedPane1.addTab("Nhập Hàng", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(1420, 260, 470, 620);

        tfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemActionPerformed(evt);
            }
        });
        getContentPane().add(tfTimKiem);
        tfTimKiem.setBounds(420, 230, 210, 20);

        jButton3.setText("Tìm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(640, 230, 60, 20);

        tfTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiem1ActionPerformed(evt);
            }
        });
        getContentPane().add(tfTimKiem1);
        tfTimKiem1.setBounds(420, 600, 210, 20);

        jButton4.setText("Tìm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(640, 600, 60, 20);

        tbLoaiHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbLoaiHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSP", "Tên", "Giá", "Điểm", "SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLoaiHang.setIntercellSpacing(new java.awt.Dimension(10, 10));
        tbLoaiHang.setRowHeight(35);
        tbLoaiHang.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tbLoaiHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLoaiHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbLoaiHang);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(420, 630, 910, 250);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Welcome");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1590, 60, 170, 50);

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconReload.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1890, 150, 30, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/Background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    //Lưu lại thông số trước khi cập nhật
    int ThsSL = 0;
    String ThsLSP = "";
    private void tbKhoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhoHangMouseClicked
        DefaultTableModel dsKhoHang =(DefaultTableModel)tbKhoHang.getModel();
        int SelectedRows = tbKhoHang.getSelectedRow();
        
        lbThongBao.setText("Mã lô hàng cập nhật: ");
        lbMLH.setText(dsKhoHang.getValueAt(SelectedRows,0).toString());
        tfSoLuong.setText(dsKhoHang.getValueAt(SelectedRows,1).toString());
        ThsSL = Integer.parseInt(dsKhoHang.getValueAt(SelectedRows,1).toString());
        tfDonVi.setText(dsKhoHang.getValueAt(SelectedRows,2).toString());
        
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
           
            String SQL = "SELECT NgHetHan, MaLoai, MaNV  FROM nhaphang WHERE MaLoHang = ?";  
            
            PreparedStatement stat = conn.prepareStatement(SQL);
            stat.setString(1,dsKhoHang.getValueAt(SelectedRows,0).toString());
            ResultSet rs = stat.executeQuery();
            Vector data = null;
            rs.last();
            int count;
            count = rs.getRow();
            
            rs.beforeFirst(); 
            rs.next();
            
            Date NHH = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("NgHetHan"));
            dcNHH.setDate(NHH);
            tfMaNhanVien.setText(rs.getString("MaNV"));
            tfXuatXu.setText(dsKhoHang.getValueAt(SelectedRows,5).toString());
            tfLoaiSanPham.setText(rs.getString("MaLoai"));
            ThsLSP = rs.getString("MaLoai");
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
                       
    }//GEN-LAST:event_tbKhoHangMouseClicked

    
    private void btNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapHangActionPerformed
        
        String strSL = tfSoLuong.getText();
        String DV = tfDonVi.getText();
        SimpleDateFormat nhh = new SimpleDateFormat("yyyy-MM-dd");
        String NHH = nhh.format(dcNHH.getDate());
        
        String XX = tfXuatXu.getText();
        String MNV = tfMaNhanVien.getText();
        String LSP = tfLoaiSanPham.getText();
        
        try{
        Integer.parseInt(tfSoLuong.getText());
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Số lượng nhập không đúng định dạng!",  "", JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        int SL = Integer.parseInt(strSL);
        String prefixLessTen = "LH0";
        String prefixEqMoreTen = "LH";
        try {
            //Load driver
            Class.forName(driver).newInstance();
            //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);

            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode);
            //-----
            System.out.println("Connected to the database Them");
            //Tạo mã nv bằng cách đếm dòng hiện tại, tạo string = NV_xx
            String SQL1 = "SELECT * FROM nhaphang";
            Statement stat1 = conn.createStatement();
            ResultSet rs1 = stat1.executeQuery(SQL1);
            rs1.last();
            int countnv;//Thứ tự mã lớn nhất hiện tại
            countnv = rs1.getRow() + 1;//Do Mã bắt đầu từ 01

            System.out.print(countnv);

            String strcounthd = String.valueOf(countnv);
            String MLH="";
            if(countnv<10){
                MLH = prefixLessTen+strcounthd;
            }
            else{
                MLH = prefixEqMoreTen+strcounthd;
            }
            rs1.close();
            stat1.close();

            System.out.print(MLH);

            //Insert hóa đơn
            String SQL2 = "INSERT INTO nhaphang VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement stat2 = conn.prepareStatement(SQL2);
            stat2.setString(1, MLH);
            stat2.setInt(2, SL);
            stat2.setString(3, DV);
            stat2.setString(4, nowDate);
            stat2.setString(5, NHH);
            stat2.setString(6, XX);
            stat2.setString(7, MNV);
            stat2.setString(8, LSP);

            stat2.executeUpdate();
            stat2.close();

            String SQL3 = "SELECT TongSLHienTai FROM loaihang WHERE MaLoai = ?";
            PreparedStatement stat3 = conn.prepareStatement(SQL3);
            stat3.setString(1, LSP);
            ResultSet rs3 = stat3.executeQuery();
            rs3.last();
            rs3.beforeFirst();
            rs3.next();
            int oldSL = Integer.parseInt(rs3.getString("TongSLHienTai"));
            int newSL = oldSL + SL;

            String SQL4 = "UPDATE loaihang SET TongSLHienTai = ? WHERE MaLoai = ?";
            PreparedStatement stat4 = conn.prepareStatement(SQL4);
            stat4.setInt(1, newSL);
            stat4.setString(2, LSP);

            stat4.executeUpdate();
            stat4.close();

            JOptionPane.showMessageDialog(null, "Nhập thành công một lô hàng!",  "", JOptionPane.WARNING_MESSAGE);
            conn.close();
            this.dispose();
            QLKhoHang reset = new QLKhoHang();
            reset.setExtendedState(reset.getExtendedState() |QLKhoHang.MAXIMIZED_BOTH);
            reset.getAccount().setText(lbUserName.getText());
            reset.gettfMaNhanVien().setEditable(false);
            reset.gettfMaNhanVien().setText(lbUserName.getText());
        }catch(SQLException se)
        {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Mã loại hàng không tồn tại!",  "", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        }finally{

        }// Ket thuc khoi finally
            
        
    }//GEN-LAST:event_btNhapHangActionPerformed

    private void tfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiemActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        DefaultTableModel dsKhoHang =(DefaultTableModel) tbKhoHang.getModel();
        String keyword = tfTimKiem.getText();

        String keywordOther = '%'+keyword+'%';

        dsKhoHang.setRowCount(0);

        try {
            //Load driver
            Class.forName(driver).newInstance();

            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode);
            //-----
            System.out.println("Connected to the database");
            String SQL = "SELECT DISTINCT MaLoHang, SoLuong, DonVi, NgNhap, NgHetHan, XXu, nhanvien.TenNV, loaihang.TenLoai FROM nhaphang, nhanvien, loaihang WHERE nhaphang.MaNV=nhanvien.MaNV AND nhaphang.MaLoai = loaihang.MaLoai AND ( MaLoHang = ? OR TenLoai LIKE ? OR TenNV LIKE ? OR XXu LIKE ? OR NgHetHan LIKE ?)";

            PreparedStatement stat = conn.prepareStatement(SQL);
            stat.setString(1,keyword);
            stat.setString(2,keywordOther);
            stat.setString(3,keywordOther);
            stat.setString(4,keywordOther);
            stat.setString(5,keywordOther);

            ResultSet rs = stat.executeQuery();
            Vector data = null;
            rs.last();
            
            rs.beforeFirst();
            
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("MaLoHang"));
                data.add(rs.getInt("SoLuong"));
                data.add(rs.getString("DonVi"));
                data.add(rs.getString("NgNhap"));
                data.add(rs.getString("NgHetHan"));
                data.add(rs.getString("XXu"));
                data.add(rs.getString("TenNV"));
                data.add(rs.getString("TenLoai"));
                
                // Thêm một dòng vào table model
                dsKhoHang.addRow(data);
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
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tfTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiem1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel dsLoaiHang =(DefaultTableModel) tbLoaiHang.getModel();
        String keyword = tfTimKiem1.getText();

        String keywordOther = '%'+keyword+'%';

        dsLoaiHang.setRowCount(0);

        try {
            //Load driver
            Class.forName(driver).newInstance();

            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode);
            //-----
            System.out.println("Connected to the database");
            String SQL1 = "SELECT * FROM loaihang WHERE MaLoai = ? OR TenLoai LIKE ? OR GiaTien LIKE ? OR DiemSanPham LIKE ? OR TongSLHienTai LIKE ?";    
            
            PreparedStatement stat1 = conn.prepareStatement(SQL1);
            stat1.setString(1,keyword);
            stat1.setString(2,keywordOther);
            stat1.setString(3,keywordOther);
            stat1.setString(4,keywordOther);
            stat1.setString(5,keywordOther);

            ResultSet rs1 = stat1.executeQuery();
            Vector data1 = null;
            rs1.last();
            
            
            rs1.beforeFirst(); 
//            int i=0; 
            while (rs1.next()) {
                data1 = new Vector();
                data1.add(rs1.getString("MaLoai"));
                data1.add(rs1.getString("TenLoai"));
                data1.add(rs1.getInt("GiaTien"));
                data1.add(rs1.getString("DiemSanPham"));
                data1.add(rs1.getInt("TongSLHienTai"));
                
                dsLoaiHang.addRow(data1);
              }
            rs1.close();
            stat1.close();
            conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e){
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        }finally{

        }// Ket thuc khoi finally
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbLoaiHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLoaiHangMouseClicked
        DefaultTableModel dsLoaiHang =(DefaultTableModel)tbLoaiHang.getModel();
        int SelectedRows = tbLoaiHang.getSelectedRow();
        
        lbThongBao1.setText("Mã lô hàng cập nhật: ");
        lbMSP.setText(dsLoaiHang.getValueAt(SelectedRows,0).toString());
        tfTenSanPham.setText(dsLoaiHang.getValueAt(SelectedRows,1).toString());
        tfGiaThanh.setText(dsLoaiHang.getValueAt(SelectedRows,2).toString());
        tfDiem.setText(dsLoaiHang.getValueAt(SelectedRows,3).toString());
        
             
    }//GEN-LAST:event_tbLoaiHangMouseClicked

    private void btCapNhat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhat1ActionPerformed
        int SL = Integer.parseInt(tfSoLuong.getText());
        String MLH = lbMLH.getText();
        String DV = tfDonVi.getText();
        SimpleDateFormat nhh = new SimpleDateFormat("yyyy-MM-dd");
        String NHH = nhh.format(dcNHH.getDate());
        String XX = tfXuatXu.getText();
        String MNV = tfMaNhanVien.getText();
        String LSP = tfLoaiSanPham.getText();
        
        try{
        Integer.parseInt(tfSoLuong.getText());
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Số lượng nhập không đúng định dạng!",  "", JOptionPane.WARNING_MESSAGE);
        }

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

            String SQL = "UPDATE nhaphang SET SoLuong = ?, DonVi = ?, NgNhap = ?, NgHetHan = ?, XXu = ?, MaNV = ?, MaLoai = ? WHERE MaLoHang = ?";
            PreparedStatement stat = conn.prepareStatement(SQL);
            stat.setInt(1, SL);
            stat.setString(2, DV);
            stat.setString(3, nowDate);
            stat.setString(4, NHH);
            stat.setString(5, XX);
            stat.setString(6, MNV);
            stat.setString(7, LSP);
            stat.setString(8, MLH);

            stat.executeUpdate();
            stat.close();

            String SQL3 = "SELECT TongSLHienTai FROM loaihang WHERE MaLoai = ?";
            PreparedStatement stat3 = conn.prepareStatement(SQL3);
            stat3.setString(1,ThsLSP);
            ResultSet rs3 = stat3.executeQuery();
            rs3.last();
            rs3.beforeFirst();
            rs3.next();
            int oldSL1 = Integer.parseInt(rs3.getString("TongSLHienTai"));
            oldSL1 = oldSL1 - ThsSL;
            rs3.close();
            stat3.close();

            //Trừ lại số lượng hàng cũ của mã hàng cũ
            String SQL4 = "UPDATE loaihang SET TongSLHienTai = ? WHERE MaLoai = ?";
            PreparedStatement stat4 = conn.prepareStatement(SQL4);
            stat4.setInt(1, oldSL1);
            stat4.setString(2, ThsLSP);

            stat4.executeUpdate();
            stat4.close();

            String SQL5 = "SELECT TongSLHienTai FROM loaihang WHERE MaLoai = ?";
            PreparedStatement stat5 = conn.prepareStatement(SQL5);
            stat5.setString(1,LSP);
            ResultSet rs5 = stat5.executeQuery();
            rs5.last();
            rs5.beforeFirst();
            rs5.next();
            int newSL1 = Integer.parseInt(rs5.getString("TongSLHienTai"));
            newSL1 = newSL1 + SL;
            rs5.close();
            stat5.close();

            String SQL6 = "UPDATE loaihang SET TongSLHienTai = ? WHERE MaLoai = ?";
            PreparedStatement stat6 = conn.prepareStatement(SQL6);
            stat6.setInt(1, newSL1);
            stat6.setString(2, LSP);

            stat6.executeUpdate();
            stat6.close();

            JOptionPane.showMessageDialog(null, "Cập nhật lô hàng thành công!",  "", JOptionPane.WARNING_MESSAGE);

            this.dispose();
            QLKhoHang reset = new QLKhoHang();
            reset.setExtendedState(reset.getExtendedState() | QLKhoHang.MAXIMIZED_BOTH);
            reset.getAccount().setText(lbUserName.getText());
            reset.gettfMaNhanVien().setEditable(false);
            reset.gettfMaNhanVien().setText(lbUserName.getText());

            conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e){
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        }finally{

        }// Ket thuc khoi finally
    }//GEN-LAST:event_btCapNhat1ActionPerformed

    private void btNhapHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapHang1ActionPerformed

        String Ten = tfTenSanPham.getText();
        String strGia = tfGiaThanh.getText();
        String strDiem = tfDiem.getText();
        
        try{
        Integer.parseInt(tfGiaThanh.getText());
        Integer.parseInt(tfDiem.getText());
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Giá thành hoặc điểm sản phẩm nhập không đúng định dạng!",  "", JOptionPane.WARNING_MESSAGE);
        }
        
        if(Ten.equals("") | strGia.equals("") | strDiem.equals("") ){
            JOptionPane.showMessageDialog(null, "Trường thông tin không hợp lệ!",  "", JOptionPane.WARNING_MESSAGE);
            
            this.dispose();
            QLKhoHang reset = new QLKhoHang();
            reset.setExtendedState(reset.getExtendedState() |QLKhoHang.MAXIMIZED_BOTH);
            reset.getAccount().setText(lbUserName.getText());
            reset.gettfMaNhanVien().setEditable(false);
            reset.gettfMaNhanVien().setText(lbUserName.getText());
        }
        else{
            int Gia = Integer.parseInt(strGia);
            int Diem = Integer.parseInt(strDiem);
            String prefixLessTen = "ML0";
            String prefixEqMoreTen = "ML";
            try {
                //Load driver
                Class.forName(driver).newInstance();
                //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);

                //Kết nối với Font chữ Unicode
                String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
                //Tạo kết nối
                conn = DriverManager.getConnection(urlUnicode);
                //-----
                System.out.println("Connected to the database Them");
                //Tạo mã nv bằng cách đếm dòng hiện tại, tạo string = NV_xx
                String SQL1 = "SELECT * FROM loaihang";
                Statement stat1 = conn.createStatement();
                ResultSet rs1 = stat1.executeQuery(SQL1);
                rs1.last();
                int countlh;//Thứ tự mã lớn nhất hiện tại
                countlh = rs1.getRow() + 1;//Do Mã bắt đầu từ 01


                String strcountlh = String.valueOf(countlh);
                String MSP="";
                if(countlh<10){
                    MSP = prefixLessTen+strcountlh;
                }
                else{
                    MSP = prefixEqMoreTen+strcountlh;
                }
                rs1.close();
                stat1.close();

                System.out.print(MSP);

                //Insert hóa đơn
                String SQL2 = "INSERT INTO loaihang VALUES(?,?,?,?,0)";
                PreparedStatement stat2 = conn.prepareStatement(SQL2);
                stat2.setString(1, MSP);
                stat2.setString(2, Ten);
                stat2.setInt(3, Gia);
                stat2.setInt(4, Diem);
                stat2.executeUpdate();
                stat2.close();

                JOptionPane.showMessageDialog(null, "Thêm một mặt hàng mới thành công!",  "", JOptionPane.WARNING_MESSAGE);
                conn.close();
                this.dispose();
                QLKhoHang reset = new QLKhoHang();
                reset.setExtendedState(reset.getExtendedState() |QLKhoHang.MAXIMIZED_BOTH);
                reset.getAccount().setText(lbUserName.getText());
                reset.gettfMaNhanVien().setEditable(false);
                reset.gettfMaNhanVien().setText(lbUserName.getText());
            }catch(SQLException se)
            {
                se.printStackTrace();
            }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
            }finally{

            }// Ket thuc khoi finally 
        }
        
           
    }//GEN-LAST:event_btNhapHang1ActionPerformed

    private void btCapNhat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCapNhat2ActionPerformed
       
        String MSP = lbMSP.getText();
        String Ten = tfTenSanPham.getText();
        int Gia = Integer.parseInt(tfGiaThanh.getText());
        int Diem = Integer.parseInt(tfDiem.getText());

        try{
        Integer.parseInt(tfGiaThanh.getText());
        Integer.parseInt(tfDiem.getText());
        }catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Giá thành hoặc điểm sản phẩm nhập không đúng định dạng!",  "", JOptionPane.WARNING_MESSAGE);
        }
        
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

            String SQL = "UPDATE loaihang SET TenLoai = ?, GiaTien = ?, DiemSanPham = ? WHERE MaLoai = ?";
            PreparedStatement stat = conn.prepareStatement(SQL);
            stat.setString(1, Ten);
            stat.setInt(2, Gia);
            stat.setInt(3, Diem);
            stat.setString(4, MSP);

            stat.executeUpdate();
            stat.close();


            JOptionPane.showMessageDialog(null, "Cập nhật thông tin mặt hàng thành công!",  "", JOptionPane.WARNING_MESSAGE);

            this.dispose();
            QLKhoHang reset = new QLKhoHang();
            reset.setExtendedState(reset.getExtendedState() | QLKhoHang.MAXIMIZED_BOTH);
            reset.getAccount().setText(lbUserName.getText());
            reset.gettfMaNhanVien().setEditable(false);
            reset.gettfMaNhanVien().setText(lbUserName.getText());

            conn.close();
        }catch(SQLException se)
        {
            se.printStackTrace();
        }catch(Exception e){
            // Xu ly cac loi cho Class.forName
            e.printStackTrace();
        }finally{

        }// Ket thuc khoi finally
    }//GEN-LAST:event_btCapNhat2ActionPerformed

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

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
        QLKhoHang reset = new QLKhoHang();
        reset.setExtendedState(reset.getExtendedState() | QLKhoHang.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jLabel7MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLKhoHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IndexIcon;
    private javax.swing.JButton btCapNhat1;
    private javax.swing.JButton btCapNhat2;
    private javax.swing.JButton btNhapHang;
    private javax.swing.JButton btNhapHang1;
    private com.toedter.calendar.JDateChooser dcNHH;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbDiemTichLuy;
    private javax.swing.JLabel lbDiemTichLuy1;
    private javax.swing.JLabel lbDiemTichLuy2;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbMLH;
    private javax.swing.JLabel lbMSP;
    private javax.swing.JLabel lbMaThanhVien;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lbThongBao1;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JTable tbKhoHang;
    private javax.swing.JTable tbLoaiHang;
    private javax.swing.JTextField tfDiem;
    private javax.swing.JTextField tfDonVi;
    private javax.swing.JTextField tfGiaThanh;
    private javax.swing.JTextField tfLoaiSanPham;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenSanPham;
    private javax.swing.JTextField tfTimKiem;
    private javax.swing.JTextField tfTimKiem1;
    private javax.swing.JTextField tfXuatXu;
    // End of variables declaration//GEN-END:variables
}
