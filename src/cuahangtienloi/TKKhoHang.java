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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author PC
 */
public class TKKhoHang extends javax.swing.JFrame {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String nowDate = dtf.format(now);
    private Connection conn; 
    String driver = "com.mysql.jdbc.Driver";
    
    public TKKhoHang() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        JTableHeader tableHeader = tbKhoHang.getTableHeader();
        tableHeader.setBackground(new java.awt.Color(75, 139, 197));
        tableHeader.setForeground(Color.white);
        tableHeader.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
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
           
            String SQL = "SELECT MaLoHang, SoLuong, DonVi, NgNhap, NgHetHan, XXu, nhanvien.TenNV, loaihang.TenLoai FROM nhaphang, nhanvien, loaihang WHERE nhaphang.MaNV = nhanvien.MaNV AND nhaphang.MaLoai = loaihang.MaLoai";    
            
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(SQL);
            Vector data = null;
            rs.last();
            int count;
            count = rs.getRow();
            
            
            rs.beforeFirst(); 
//            int i=0; 
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
                DefaultTableModel defaultTable =(DefaultTableModel) tbKhoHang.getModel();
                defaultTable.addRow(data);
              }
            rs.close();
            stat.close();
            
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
         return tfMaNhanVien2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        tfDonVi = new javax.swing.JTextField();
        tfThang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNgay = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();
        tfSoLuong2 = new javax.swing.JTextField();
        lbMaThanhVien2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfDonVi2 = new javax.swing.JTextField();
        lbKhachHang2 = new javax.swing.JLabel();
        lbSDT2 = new javax.swing.JLabel();
        tfXuatXu2 = new javax.swing.JTextField();
        lbDiemTichLuy6 = new javax.swing.JLabel();
        lbDiemTichLuy7 = new javax.swing.JLabel();
        tfMaNhanVien2 = new javax.swing.JTextField();
        tfLoaiSanPham2 = new javax.swing.JTextField();
        lbDiemTichLuy8 = new javax.swing.JLabel();
        btNhapHang1 = new javax.swing.JButton();
        dcNHH = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        IndexIcon = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        tfTimKiem = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhoHang = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLoaiHang = new javax.swing.JTable();
        tfTimKiem1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton8.setBackground(new java.awt.Color(75, 139, 197));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Kho Hàng");
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
        jButton9.setText("Đăng Xuất");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(0, 370, 300, 70);

        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NHẬP HÀNG");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(140, 30, 210, 30);
        jPanel2.add(tfSoLuong);
        tfSoLuong.setBounds(160, 100, 190, 22);
        jPanel2.add(tfDonVi);
        tfDonVi.setBounds(160, 130, 190, 22);
        jPanel2.add(tfThang);
        tfThang.setBounds(220, 160, 40, 20);

        jLabel2.setText("/");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(270, 160, 10, 16);
        jPanel2.add(tfNam);
        tfNam.setBounds(280, 160, 60, 20);

        jLabel3.setText("/");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(210, 160, 10, 16);
        jPanel2.add(tfNgay);
        tfNgay.setBounds(160, 160, 40, 20);

        lbMaThanhVien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaThanhVien.setText("Số lượng: ");
        jPanel2.add(lbMaThanhVien);
        lbMaThanhVien.setBounds(40, 100, 110, 16);

        lbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKhachHang.setText("Đơn vị nhập: ");
        jPanel2.add(lbKhachHang);
        lbKhachHang.setBounds(40, 130, 110, 16);

        lbSDT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSDT.setText("Ngày Hết Hạn: ");
        jPanel2.add(lbSDT);
        lbSDT.setBounds(40, 160, 110, 16);

        lbDiemTichLuy.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy.setText("Xuất xứ: ");
        jPanel2.add(lbDiemTichLuy);
        lbDiemTichLuy.setBounds(40, 190, 110, 16);
        jPanel2.add(tfXuatXu);
        tfXuatXu.setBounds(160, 190, 190, 22);
        jPanel2.add(tfMaNhanVien);
        tfMaNhanVien.setBounds(160, 220, 190, 22);

        lbDiemTichLuy1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy1.setText("Mã NV: ");
        jPanel2.add(lbDiemTichLuy1);
        lbDiemTichLuy1.setBounds(40, 220, 110, 16);

        lbDiemTichLuy2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy2.setText("Loại sản phẩm: ");
        jPanel2.add(lbDiemTichLuy2);
        lbDiemTichLuy2.setBounds(40, 250, 110, 16);
        jPanel2.add(tfLoaiSanPham);
        tfLoaiSanPham.setBounds(160, 250, 190, 22);

        btNhapHang.setText("Nhập Hàng");
        btNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapHangActionPerformed(evt);
            }
        });
        jPanel2.add(btNhapHang);
        btNhapHang.setBounds(190, 310, 140, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        jPanel3.setLayout(null);
        jPanel3.add(tfSoLuong2);
        tfSoLuong2.setBounds(160, 100, 190, 22);

        lbMaThanhVien2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMaThanhVien2.setText("Số lượng: ");
        jPanel3.add(lbMaThanhVien2);
        lbMaThanhVien2.setBounds(40, 100, 110, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("NHẬP HÀNG");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(130, 40, 210, 30);
        jPanel3.add(tfDonVi2);
        tfDonVi2.setBounds(160, 130, 190, 22);

        lbKhachHang2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKhachHang2.setText("Đơn vị nhập: ");
        jPanel3.add(lbKhachHang2);
        lbKhachHang2.setBounds(40, 130, 110, 16);

        lbSDT2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSDT2.setText("Ngày Hết Hạn: ");
        jPanel3.add(lbSDT2);
        lbSDT2.setBounds(40, 160, 110, 16);
        jPanel3.add(tfXuatXu2);
        tfXuatXu2.setBounds(160, 190, 190, 22);

        lbDiemTichLuy6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy6.setText("Xuất xứ: ");
        jPanel3.add(lbDiemTichLuy6);
        lbDiemTichLuy6.setBounds(40, 190, 110, 16);

        lbDiemTichLuy7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy7.setText("Mã NV: ");
        jPanel3.add(lbDiemTichLuy7);
        lbDiemTichLuy7.setBounds(40, 220, 110, 16);
        jPanel3.add(tfMaNhanVien2);
        tfMaNhanVien2.setBounds(160, 220, 190, 22);
        jPanel3.add(tfLoaiSanPham2);
        tfLoaiSanPham2.setBounds(160, 250, 190, 22);

        lbDiemTichLuy8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDiemTichLuy8.setText("Loại sản phẩm: ");
        jPanel3.add(lbDiemTichLuy8);
        lbDiemTichLuy8.setBounds(40, 250, 110, 16);

        btNhapHang1.setText("Nhập Hàng");
        btNhapHang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapHang1ActionPerformed(evt);
            }
        });
        jPanel3.add(btNhapHang1);
        btNhapHang1.setBounds(180, 310, 140, 40);
        jPanel3.add(dcNHH);
        dcNHH.setBounds(160, 160, 190, 22);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(1420, 260, 440, 500);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconReload.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1890, 150, 30, 30);

        IndexIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/IconCT.png"))); // NOI18N
        IndexIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IndexIconMouseClicked(evt);
            }
        });
        getContentPane().add(IndexIcon);
        IndexIcon.setBounds(60, 40, 100, 100);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Welcome");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1590, 60, 170, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("!!");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1860, 60, 30, 50);

        lbUserName.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbUserName.setForeground(new java.awt.Color(255, 255, 255));
        lbUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbUserName.setText("NVxx");
        getContentPane().add(lbUserName);
        lbUserName.setBounds(1770, 60, 90, 50);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 260, 910, 300);

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

        tfTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiem1ActionPerformed(evt);
            }
        });
        getContentPane().add(tfTimKiem1);
        tfTimKiem1.setBounds(420, 600, 210, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/Background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        TKKhoHang reset = new TKKhoHang();
        reset.setExtendedState(reset.getExtendedState() | TKKhoHang.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.dispose();
        DangNhap login = new DangNhap();
        login.setVisible(true);
        login.setExtendedState(login.getExtendedState() | DangNhap.MAXIMIZED_BOTH);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapHangActionPerformed
        
    }//GEN-LAST:event_btNhapHangActionPerformed

    private void btNhapHang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapHang1ActionPerformed
        String strSL = tfSoLuong2.getText();
        String DV = tfDonVi2.getText();
        SimpleDateFormat nhh = new SimpleDateFormat("yyyy-MM-dd");
        String NHH = nhh.format(dcNHH.getDate());
        String XX = tfXuatXu2.getText();
        String MNV = tfMaNhanVien2.getText();
        String LSP = tfLoaiSanPham2.getText();
        try{
        Integer.parseInt(tfSoLuong2.getText());
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
            TKKhoHang reset = new TKKhoHang();
            reset.setExtendedState(reset.getExtendedState() |TKKhoHang.MAXIMIZED_BOTH);
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
   
        
    }//GEN-LAST:event_btNhapHang1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        TKKhoHang reset = new TKKhoHang();
        reset.setExtendedState(reset.getExtendedState() | TKKhoHang.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
        reset.gettfMaNhanVien().setEditable(false);
        reset.gettfMaNhanVien().setText(lbUserName.getText());
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void IndexIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IndexIconMouseClicked
        this.dispose();
        TKTrangChu reset = new TKTrangChu();
        reset.setExtendedState(reset.getExtendedState() | TKTrangChu.MAXIMIZED_BOTH);
        reset.getAccount().setText(lbUserName.getText());
        
    }//GEN-LAST:event_IndexIconMouseClicked

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

    private void tbKhoHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhoHangMouseClicked
        

    }//GEN-LAST:event_tbKhoHangMouseClicked

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
   
    }//GEN-LAST:event_tbLoaiHangMouseClicked

    private void tfTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiem1ActionPerformed

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
            java.util.logging.Logger.getLogger(TKKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TKKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TKKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TKKhoHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TKKhoHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IndexIcon;
    private javax.swing.JButton btNhapHang;
    private javax.swing.JButton btNhapHang1;
    private com.toedter.calendar.JDateChooser dcNHH;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDiemTichLuy;
    private javax.swing.JLabel lbDiemTichLuy1;
    private javax.swing.JLabel lbDiemTichLuy2;
    private javax.swing.JLabel lbDiemTichLuy6;
    private javax.swing.JLabel lbDiemTichLuy7;
    private javax.swing.JLabel lbDiemTichLuy8;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbKhachHang2;
    private javax.swing.JLabel lbMaThanhVien;
    private javax.swing.JLabel lbMaThanhVien2;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbSDT2;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JTable tbKhoHang;
    private javax.swing.JTable tbLoaiHang;
    private javax.swing.JTextField tfDonVi;
    private javax.swing.JTextField tfDonVi2;
    private javax.swing.JTextField tfLoaiSanPham;
    private javax.swing.JTextField tfLoaiSanPham2;
    private javax.swing.JTextField tfMaNhanVien;
    private javax.swing.JTextField tfMaNhanVien2;
    private javax.swing.JTextField tfNam;
    private javax.swing.JTextField tfNgay;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfSoLuong2;
    private javax.swing.JTextField tfThang;
    private javax.swing.JTextField tfTimKiem;
    private javax.swing.JTextField tfTimKiem1;
    private javax.swing.JTextField tfXuatXu;
    private javax.swing.JTextField tfXuatXu2;
    // End of variables declaration//GEN-END:variables
}
