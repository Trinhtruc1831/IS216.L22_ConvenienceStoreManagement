/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangtienloi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MessageDialogHoaDon extends javax.swing.JFrame {

    private Connection conn; 
    String driver = "com.mysql.jdbc.Driver";
    /**
     * Creates new form MessageDialogHoaDon
     */
    public MessageDialogHoaDon() {
        initComponents();
        setVisible(true);
        this.setLocationRelativeTo(null);
        tbHoaDon.getColumnModel().getColumn(0).setPreferredWidth(60);
        tbHoaDon.getColumnModel().getColumn(1).setPreferredWidth(180);
        tbHoaDon.getColumnModel().getColumn(2).setPreferredWidth(60);
        tbHoaDon.getColumnModel().getColumn(3).setPreferredWidth(65);
        tbHoaDon.getColumnModel().getColumn(4).setPreferredWidth(30);
        tbHoaDon.getColumnModel().getColumn(5).setPreferredWidth(110);
        tbHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        
        
        
    }
    public javax.swing.JLabel getNhanVien(){
        return lbNhanVien;
    }
    public javax.swing.JLabel getNgayLap(){
        return lbNgayLap;
    }
    public javax.swing.JLabel getKhachHang(){
        return lbKhachHang;
    }
    public javax.swing.JLabel getDiemTichLuy(){
        return lbDiemTichLuy;
    }
    public javax.swing.JLabel getTong(){
        return lbTong;
    }
    public javax.swing.JLabel getGiamGia(){
        return lbGiamGia;
    }
    public javax.swing.JLabel getTongTien(){
        return lbTongTien;
    }
    public javax.swing.JTable getHoaDon(){
        return tbHoaDon;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbNhanVien = new javax.swing.JLabel();
        lbNgayLap = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbDiemTichLuy = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbTong = new javax.swing.JLabel();
        lbGiamGia = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        btThanhToan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(372, 572));
        setPreferredSize(new java.awt.Dimension(372, 572));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Châu Thành");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 50, 190, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cửa Hàng Tiện Lợi");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 20, 190, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cuahangtienloi/Image/LogoCT.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 20, 40, 40);

        jLabel3.setText("Khách hàng:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 140, 80, 16);

        jLabel5.setText("Nhân viên:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 100, 70, 16);

        jLabel6.setText("Ngày lập:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 120, 70, 16);

        lbNhanVien.setText("Nhân viên:");
        getContentPane().add(lbNhanVien);
        lbNhanVien.setBounds(93, 100, 70, 16);

        lbNgayLap.setText("Ngày lập:");
        getContentPane().add(lbNgayLap);
        lbNgayLap.setBounds(93, 120, 70, 16);

        lbKhachHang.setText("Khách hàng:");
        getContentPane().add(lbKhachHang);
        lbKhachHang.setBounds(93, 140, 80, 16);

        lbDiemTichLuy.setText("Điểm");
        getContentPane().add(lbDiemTichLuy);
        lbDiemTichLuy.setBounds(300, 140, 40, 16);

        jLabel14.setText("Điểm tích lũy:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(220, 140, 80, 16);

        tbHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Điểm", "Giá", "SL", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tbHoaDon);
        if (tbHoaDon.getColumnModel().getColumnCount() > 0) {
            tbHoaDon.getColumnModel().getColumn(1).setResizable(false);
            tbHoaDon.getColumnModel().getColumn(2).setResizable(false);
            tbHoaDon.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 330, 250);

        jLabel7.setText("Tổng:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 440, 70, 20);

        jLabel8.setText("Giảm giá:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 460, 70, 20);

        jLabel9.setText("Tổng tiền:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 480, 80, 20);

        lbTong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTong.setText("Tổng:");
        getContentPane().add(lbTong);
        lbTong.setBounds(240, 440, 110, 20);

        lbGiamGia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbGiamGia.setText("Giảm giá:");
        getContentPane().add(lbGiamGia);
        lbGiamGia.setBounds(240, 460, 110, 20);

        lbTongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTongTien.setText("Tổng tiền:");
        lbTongTien.setToolTipText("");
        getContentPane().add(lbTongTien);
        lbTongTien.setBounds(240, 480, 110, 20);

        btThanhToan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        btThanhToan.setText("THANH TOÁN");
        btThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThanhToanActionPerformed(evt);
            }
        });
        getContentPane().add(btThanhToan);
        btThanhToan.setBounds(240, 510, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThanhToanActionPerformed
        DefaultTableModel dsHoaDon =(DefaultTableModel) tbHoaDon.getModel();
        int row = dsHoaDon.getRowCount();
        System.out.println("Số chi tiết sản phẩm: "+ row);
        
        
        try {
            
            //Load driver
            Class.forName(driver).newInstance();
            //conn = DriverManager.getConnection(url+dbName+strUnicode,userName,password);
           
            //Kết nối với Font chữ Unicode
            String urlUnicode = "jdbc:mysql://localhost:3306/quanlycuahang?user=root&password=&useUnicode=true&characterEncoding=utf8";
            //Tạo kết nối
            conn = DriverManager.getConnection(urlUnicode); 
            
//            this.dispose();
//            QLBanHang tempt = new QLBanHang();
            //MaNV
            String MNV = lbNhanVien.getText();

            //NgLap
            String NL = lbNgayLap.getText();
            //String NL = lbNgayLap.getText();

            //SDT lấy MaKH
            String SDTKH = lbKhachHang.getText();

            //DTL
            String strDTL = lbDiemTichLuy.getText();
            int DTL = Integer.parseInt(strDTL);

            //Tổng trước khi giảm giá
            String T = lbTong.getText();

            //GiamGia
            String strGG = lbGiamGia.getText();
            int GG = Integer.parseInt(strGG);

            //Điểm TL của khách hàng dùng trong hóa đơn kì này
            int DD = GG/1000;

            //TongTien
            String strTT = lbTongTien.getText();
            int TT = Integer.parseInt(strTT);


            int SelectedRows = tbHoaDon.getSelectedRow();

            String hdprefixLessTen = "HD0";
            String hdprefixEqMoreTen = "HD";

            //-----
            System.out.println("Connected to the database");
           //Tạo mã hd bằng cách đếm dòng hiện tại, tạo string = HD_xx
            String SQL1 = "SELECT * FROM hoadon";    
            Statement stat1 = conn.createStatement();
            ResultSet rs1 = stat1.executeQuery(SQL1);
            rs1.last();
            
            
            int counthd;//Thứ tự mã lớn nhất hiện tại
            counthd = rs1.getRow() + 1;//Do Mã bắt đầu từ 01
            String strcounthd = String.valueOf(counthd);
            String MHD="";
            if(counthd<10){
                MHD = hdprefixLessTen+strcounthd;
            }
            else{
                MHD = hdprefixEqMoreTen+strcounthd;
            }
            rs1.close();
            stat1.close();
           
            System.out.print(MHD);
            String MKH;
            if(SDTKH.equals("")){
                MKH = "";
            }
            else{
               //Tìm mã khách hàng theo số điện thoại
                String SQL2 = "SELECT MaKH FROM khachhang WHERE sdtKH = ?"; 
                PreparedStatement stat2 = conn.prepareStatement(SQL2);
                stat2.setString(1, SDTKH);

                ResultSet rs2 = stat2.executeQuery();

                rs2.next();
                MKH = rs2.getString(1);
                System.out.println(MKH);
                rs2.close();
                stat2.close(); 
                
                String SQL7 = "SELECT DiemTichLuy FROM khachhang WHERE MaKH = ?"; 
                PreparedStatement stat7 = conn.prepareStatement(SQL7);
                stat7.setString(1, MKH);

                ResultSet rs7 = stat7.executeQuery();

                rs7.next();
                int oldDTL = Integer.parseInt(rs7.getString(1)); 
                rs7.close();
                stat7.close(); 
                
                int newDTL = oldDTL - DD +DTL;
                String SQL8 = "UPDATE khachhang SET DiemTichLuy = ? WHERE MaKH = ?"; 
                PreparedStatement stat8 = conn.prepareStatement(SQL8);
                stat8.setInt(1, newDTL);
                stat8.setString(2, MKH);
                stat8.executeUpdate();
                stat8.close();
                
            }
                        
            
            //Insert hóa đơn
            String SQL3 = "INSERT INTO hoadon VALUES(?,?,?,?,?,?,?)"; 
            PreparedStatement stat3 = conn.prepareStatement(SQL3);
            stat3.setString(1, MHD);
            stat3.setString(2, NL);
            stat3.setString(3, MKH);
            stat3.setString(4, MNV);
            stat3.setInt(5, TT);
            stat3.setInt(6, DTL);
            stat3.setInt(7, GG);

            stat3.executeUpdate();
            stat3.close();
            

            
            
            for(int i=0;i<row;i++){
                String MSP = dsHoaDon.getValueAt(i,0).toString();
                String strSL = dsHoaDon.getValueAt(i,4).toString();
                int SL = Integer.parseInt(strSL);
                //Thêm chi tiết hóa đơn        
                String SQL4 = "INSERT INTO cthd VALUES(?,?,?)"; 
                PreparedStatement stat4 = conn.prepareStatement(SQL4);
                stat4.setString(1, MSP);
                stat4.setString(2, MHD);
                stat4.setInt(3, SL);

                stat4.executeUpdate();
                stat4.close();
                
                
                //Update lại số lượng tống
                
                ///Lấy số lượng hiện tại
                String SQL5 = "SELECT TongSLHienTai FROM loaihang WHERE MaLoai = ?"; 
                PreparedStatement stat5 = conn.prepareStatement(SQL5);
                stat5.setString(1, MSP);

                ResultSet rs5 = stat5.executeQuery();

                rs5.next();
                String strSLHT = rs5.getString(1);
                int SLHT = Integer.parseInt(strSLHT);
                System.out.println(SLHT);
                rs5.close();
                stat5.close();
            
                int newSL = SLHT - SL;
                ///update
                String SQL6 = "UPDATE loaihang SET TongSLHienTai = ? WHERE MaLoai = ?"; 
                PreparedStatement stat6 = conn.prepareStatement(SQL6);
                stat6.setInt(1, newSL);
                stat6.setString(2, MSP);
                stat6.executeUpdate();
                stat6.close();
                
                
            }
            //update lại điểm chuyên cần của nhân viên
            
             ///Lấy số lượng hiện tại
            String SQL7 = "SELECT DiemChuyenCan, LoaiNV FROM nhanvien WHERE MaNV = ?"; 
            PreparedStatement stat7 = conn.prepareStatement(SQL7);
            stat7.setString(1, MNV);

            ResultSet rs7 = stat7.executeQuery();

            rs7.next();
            String strDCCHT = rs7.getString("DiemChuyenCan");
            int LoaiNV = rs7.getInt("LoaiNV");
            int DCCHT = Integer.parseInt(strDCCHT);
            System.out.println(strDCCHT);
            rs7.close();
            stat7.close();
            
            if(LoaiNV != 1){
                int newDCC = DCCHT + 1;
                ///update
                String SQL8 = "UPDATE nhanvien SET DiemChuyenCan = ? WHERE MaNV = ?"; 
                PreparedStatement stat8 = conn.prepareStatement(SQL8);
                stat8.setInt(1, newDCC);
                stat8.setString(2, MNV);
                stat8.executeUpdate();
                stat8.close();
            }
            
            

            JOptionPane.showMessageDialog(null, "Thanh toán thành công!",  "", JOptionPane.WARNING_MESSAGE);
            this.dispose();

            conn.close();
        }catch(SQLException se)
        {
               se.printStackTrace();
        }catch(Exception e){
                // Xu ly cac loi cho Class.forName
                e.printStackTrace();
        }finally{
             
               }// Ket thuc khoi finally
    
        
       
    }//GEN-LAST:event_btThanhToanActionPerformed

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
            java.util.logging.Logger.getLogger(MessageDialogHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessageDialogHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessageDialogHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessageDialogHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessageDialogHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThanhToan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiemTichLuy;
    private javax.swing.JLabel lbGiamGia;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbNgayLap;
    private javax.swing.JLabel lbNhanVien;
    private javax.swing.JLabel lbTong;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JTable tbHoaDon;
    // End of variables declaration//GEN-END:variables
}
