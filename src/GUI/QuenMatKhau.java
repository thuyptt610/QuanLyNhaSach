/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Connect.SQLServerProvider;
import Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class QuenMatKhau extends javax.swing.JFrame {
   private SQLServerProvider cn;
    private Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    /**
     * Creates new form QuenMatKhau
     */
    public QuenMatKhau() {
        initComponents();
         this.setLocationRelativeTo(null);
        cn = new SQLServerProvider();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnLayLaiMK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnQuayLaiLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Email đăng kí:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 94, 28));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 197, 25));

        btnLayLaiMK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLayLaiMK.setForeground(new java.awt.Color(0, 204, 0));
        btnLayLaiMK.setText("Lấy lại mật khẩu");
        btnLayLaiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayLaiMKActionPerformed(evt);
            }
        });
        getContentPane().add(btnLayLaiMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 137, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Lấy lại mật khẩu");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 262, -1));

        btnQuayLaiLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuayLaiLogin.setForeground(new java.awt.Color(255, 153, 51));
        btnQuayLaiLogin.setText("Quay lại trang Login");
        btnQuayLaiLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuayLaiLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 140, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nenquenpass.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLayLaiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayLaiMKActionPerformed
        // TODO add your handling code here:
       String email = txtEmail.getText().trim();

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào Email đăng kí");
            return;
        }
        try {
            conn = cn.open();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Không thể kết nối đến cơ sở dữ liệu.");
                return;
            }
            String query = "SELECT * FROM TAIKHOAN WHERE EMAIL=?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            // Kiểm tra xem email có tồn tại
            if (resultSet.next()) {
                String matKhau = resultSet.getString("MATKHAU");
                JOptionPane.showMessageDialog(this, "Mật khẩu của bạn là: " + matKhau);
            } else {
                JOptionPane.showMessageDialog(this, "Email này chưa được đăng kí!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi truy vấn cơ sở dữ liệu.");
        } finally {
            // Đóng các resource sau khi sử dụng
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }   
        txtEmail.setText("");
    }//GEN-LAST:event_btnLayLaiMKActionPerformed

    private void btnQuayLaiLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiLoginActionPerformed
        // TODO add your handling code here:
         Login lg=new Login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnQuayLaiLoginActionPerformed

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
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLayLaiMK;
    private javax.swing.JButton btnQuayLaiLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
