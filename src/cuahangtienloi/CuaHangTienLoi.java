/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuahangtienloi;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author PC
 */
public class CuaHangTienLoi {

    public CuaHangTienLoi() {

        DangNhap hang = new DangNhap();
        hang.setExtendedState(hang.getExtendedState() | DangNhap.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        new CuaHangTienLoi();
    }

}
