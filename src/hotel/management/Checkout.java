/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.management;

import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anshu
 */
public class Checkout extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Checkout
     */
    public Checkout() {
        initComponents();
        SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        checkout.setText(obj.format(date));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "sukku@imunni");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        showDataIntoTable();
    }

    public void showDataIntoTable() {
        try {
            pst = con.prepareStatement("select * from customer where status=?");
            pst.setString(1, "NULL");
            rs = pst.executeQuery();
            ResultSetMetaData ob = rs.getMetaData();
            int n = ob.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= n; i++) {
                    v.add(rs.getString("name"));
                    v.add(rs.getString("mobile"));
                    v.add(rs.getString("id"));
                    v.add(rs.getString("bed"));
                    v.add(rs.getString("roomtype"));
                    v.add(rs.getString("indate"));
//                    v.add(rs.getString("billid"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("roomnumber"));

//                     v.add(rs.getString("amount"));
//                      v.add(rs.getString("days"));
//                       v.add(rs.getString("outdate"));
                }
                df.addRow(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        txtmobile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtaadhar = new javax.swing.JTextField();
        checkout = new javax.swing.JTextField();
        txtroomno = new javax.swing.JTextField();
        txtcheckin = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        days = new javax.swing.JTextField();
        checkoutnow = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 70, 39));

        jLabel1.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/Customer Check Out.png"))); // NOI18N
        jLabel1.setText("Customer Check out");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 287, 49));

        jLabel2.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 77, -1, -1));

        search.setBackground(new java.awt.Color(255, 0, 51));
        search.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(763, 74, -1, -1));

        txtmobile.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });
        getContentPane().add(txtmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 160, 157, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel3.setText("Customer Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 127, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel4.setText("Mobile Number");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 127, -1, -1));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel5.setText("Aadhar Number");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 127, -1, -1));

        txtname.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 160, 141, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel6.setText("Check in Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 229, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel7.setText("Check out Date(Today)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 217, -1, -1));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel8.setText("Price per Day");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 229, -1, -1));

        txtaadhar.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        getContentPane().add(txtaadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 160, 166, -1));

        checkout.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        getContentPane().add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(796, 268, 164, -1));

        txtroomno.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        getContentPane().add(txtroomno, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 74, 137, -1));

        txtcheckin.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        txtcheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcheckinActionPerformed(evt);
            }
        });
        getContentPane().add(txtcheckin, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 268, 157, -1));

        txtprice.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 268, 141, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cust Name", "Mobile", "Aadhar", "Bed", "Roomtype", "Checkin Date", "price", "Room num"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 962, 264));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel9.setText("Number of days");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1119, 127, -1, -1));

        jLabel10.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        jLabel10.setText("Total Amount");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1119, 217, -1, -1));

        amount.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        getContentPane().add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1119, 268, 140, -1));

        days.setFont(new java.awt.Font("Sitka Text", 3, 16)); // NOI18N
        getContentPane().add(days, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 160, 147, -1));

        checkoutnow.setBackground(new java.awt.Color(255, 51, 51));
        checkoutnow.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        checkoutnow.setText("Check Out Now");
        checkoutnow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutnowActionPerformed(evt);
            }
        });
        getContentPane().add(checkoutnow, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 430, -1, -1));

        clear.setBackground(new java.awt.Color(255, 51, 51));
        clear.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1107, 520, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/back.jpg"))); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(1280, 670));
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkoutActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            pst = con.prepareStatement("select * from customer where roomnumber=?and status=?");
            pst.setString(1, txtroomno.getText());
            pst.setString(2, "NULL");
            rs = pst.executeQuery();

            if (rs.next()) {
                txtname.setText(rs.getString("name"));
                txtmobile.setText(rs.getString("mobile"));
                txtaadhar.setText(rs.getString("id"));
                txtprice.setText(rs.getString("price"));
                txtcheckin.setText(rs.getString("indate"));

                String s1, s2;
                s1 = checkout.getText();
//            s2=txtcheckin.getText();
                s2 = rs.getString("indate");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    Date d1 = format.parse(s1);
                    Date d2 = format.parse(s2);
                    long diff = d1.getTime() - d2.getTime();
                    int day = (int) diff / (24 * 60 * 60 * 1000);

                    if (day == 0) {
                        day = 1;
                        days.setText(String.valueOf(day));
                        double price = Double.parseDouble(rs.getString("price")) * day;
                        amount.setText(String.valueOf(price));

                    }

                } catch (ParseException ex) {
                    Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(forgot.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close the PreparedStatement
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    Logger.getLogger(forgot.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }//GEN-LAST:event_searchActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        txtname.setText("");
        txtmobile.setText("");
        txtroomno.setText("");
        txtaadhar.setText("");
        txtprice.setText("");
//        checkout.setText("");
        days.setText("");
        txtcheckin.setText("");
        amount.setText("");

    }//GEN-LAST:event_clearActionPerformed

    private void txtcheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcheckinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcheckinActionPerformed

    private void checkoutnowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutnowActionPerformed
        try {
            // TODO add your handling code here:
            pst = con.prepareStatement("update customer set status=? where roomnumber=? and indate=?");
            pst.setString(1, "Checkout");
            pst.setString(2, txtroomno.getText());
            pst.setString(3, txtcheckin.getText());
            pst.executeUpdate();

            pst = con.prepareStatement("UPDATE customer SET status=?, days=?, amount=?,outdate=? WHERE roomnumber=? AND indate=?");
            pst.setString(1, "Checkout");
            pst.setInt(2, Integer.parseInt(days.getText())); // Save the number of days
            pst.setDouble(3, Double.parseDouble(amount.getText())); // Save the total amount
            pst.setString(4, checkout.getText());
            pst.setString(5, txtroomno.getText());
            pst.setString(6, txtcheckin.getText());
            pst.executeUpdate();

            pst = con.prepareStatement("update room set status=? where roomnumber=? ");
            pst.setString(1, "Not Booked");
            pst.setString(2, txtroomno.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Checkout Succcessfully");
            showDataIntoTable();

            txtname.setText("");
            txtmobile.setText("");
            txtroomno.setText("");
            txtaadhar.setText("");
            txtprice.setText("");
//        checkout.setText("");
            days.setText("");
            txtcheckin.setText("");
            amount.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_checkoutnowActionPerformed

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
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JTextField checkout;
    private javax.swing.JButton checkoutnow;
    private javax.swing.JButton clear;
    private javax.swing.JTextField days;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton search;
    private javax.swing.JTextField txtaadhar;
    private javax.swing.JTextField txtcheckin;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtroomno;
    // End of variables declaration//GEN-END:variables
}
