/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.management;

import java.awt.print.PrinterException;
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
public class BillPrint extends javax.swing.JFrame {
//String id=CustomerDetailsBill.idd;

    String nm;
    String mobile;
    String gender;
    String roomnumber;
    String indate;
    String outdate;
    String price;
    String days;
    String amount;
    String aadhar;

    /**
     * Creates new form BillPrint
     */
    public BillPrint(String roomnumber) {
        this.roomnumber = roomnumber;
        initComponents();
        connect();
        populateBill();

//        txtbill.setText("\t\t-: Holiday Hotel :-\n");
//        txtbill.setText(txtbill.getText() + "**********************************************************************************\n");
//        txtbill.setText(txtbill.getText() + "Bill ID:- " + aadhar + "\n");
//        txtbill.setText(txtbill.getText() + "Customer Details:- \n");
//        txtbill.setText(txtbill.getText() + "Name:- " + nm + "\n");
//        txtbill.setText(txtbill.getText() + "Mobile Number:- " + mobile + "\n");
//        txtbill.setText(txtbill.getText() + "Gender:- " + gender + "\n");
//        txtbill.setText(txtbill.getText() + "**********************************************************************************\n");
//        txtbill.setText(txtbill.getText() + "Room Details:- \n");
//        txtbill.setText(txtbill.getText() + "Room Number:- " + roomnumber + "\n");
//
//        txtbill.setText(txtbill.getText() + "Price:- " + price + "\n");
//        txtbill.setText(txtbill.getText() + "Check IN Date=" + indate + "\t\tNumber of Days=" + days + "\n");
//        txtbill.setText(txtbill.getText() + "Check OUT Date=" + outdate + "\t\tTotal Amount=" + amount + "\n");
//        txtbill.setText(txtbill.getText() + "**********************************************************************************\n");
//        txtbill.setText(txtbill.getText() + "\t\t" + "                    Thank You,Please Visit Again.");
    }

//    public void connect() {
//        PreparedStatement pst;
//        ResultSet rs;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "sukku@imunni");
//            pst = con.prepareStatement("select * from customer where roomnumber=?");
//
//            pst.setString(1, roomnumber);
//            rs = pst.executeQuery();
//            if (rs.next()) {
//
//                nm = rs.getString("name");
//                mobile = rs.getString("mobile");
//                roomnumber = rs.getString("roomnumber");
//                aadhar = rs.getString("id");
//                gender = rs.getString("gender");
//                indate = rs.getString("indate");
//                outdate = rs.getString("outdate");
//                price = rs.getString("price");
//                days = rs.getString("days");
//                amount = rs.getString("amount");
//
//            }
//
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void connect() {
        PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels", "root", "sukku@imunni");
            pst = con.prepareStatement("select * from customer where roomnumber=?");
            pst.setString(1, roomnumber);
            rs = pst.executeQuery();
            if (rs.next()) {
                nm = rs.getString("name");
                mobile = rs.getString("mobile");
                aadhar = rs.getString("id");
                gender = rs.getString("gender");
                indate = rs.getString("indate");
                outdate = rs.getString("outdate");
                price = rs.getString("price");
                days = rs.getString("days");
                amount = rs.getString("amount");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateBill() {
        txtbill.setText("\t\t-: Holiday Hotel :-\n");
        txtbill.append("**********************************************************************************\n");
        txtbill.append("Bill ID:- " + aadhar + "\n");
        txtbill.append("Customer Details:- \n");
        txtbill.append("Name:- " + nm + "\n");
        txtbill.append("Mobile Number:- " + mobile + "\n");
        txtbill.append("Gender:- " + gender + "\n");
        txtbill.append("**********************************************************************************\n");
        txtbill.append("Room Details:- \n");
        txtbill.append("Room Number:- " + roomnumber + "\n");
        txtbill.append("Price:- " + price + "\n");
        txtbill.append("Check IN Date=" + indate + "\t\tNumber of Days=" + days + "\n");
        txtbill.append("Check OUT Date=" + outdate + "\t\tTotal Amount=" + amount + "\n");
        txtbill.append("**********************************************************************************\n");
        txtbill.append("\t\t" + "                    Thank You, Please Visit Again.");
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
        txtbill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setEditable(false);
        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 35, 633, 400));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 0, 60, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 448, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/bac.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            txtbill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
////    public static void main(String args[]) {
////        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new BillPrint().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables

}