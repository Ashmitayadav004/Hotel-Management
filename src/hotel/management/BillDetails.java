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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anshu
 */
public class BillDetails extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    static String id;

    /**
     * Creates new form BillDetails
     */
    public BillDetails() {
        initComponents();
        jTable1.setDefaultEditor(Object.class, null);
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
            pst.setString(1, "Checkout");
            rs = pst.executeQuery();
            ResultSetMetaData ob = rs.getMetaData();
            int n = ob.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= n; i++) {
                    v.add(rs.getString("roomnumber"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("mobile"));
                    v.add(rs.getString("gender"));
                    v.add(rs.getString("indate"));
                    v.add(rs.getString("id"));
                    v.add(rs.getString("outdate"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("days"));
                    v.add(rs.getString("amount"));
                }
                df.addRow(v);
                // Disable editing for all cells
            }
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtupdate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 670));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Room Number", "Customer name", "Mobile No", "Gender", "Checkin", "Aadhar No", "Checkout", "Price", "No of Days", "Total Amount"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 248, 1190, 410));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 3, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/bill.jpg"))); // NOI18N
        jLabel1.setText("Customer Bill Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 557, 35));

        jButton1.setBackground(new java.awt.Color(255, 102, 153));
        jButton1.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 180, -1, 57));

        txtupdate.setFont(new java.awt.Font("Wide Latin", 3, 18)); // NOI18N
        getContentPane().add(txtupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 177, 277, 56));

        jButton2.setBackground(new java.awt.Color(255, 102, 153));
        jButton2.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 178, -1, 57));

        jLabel2.setFont(new java.awt.Font("Wide Latin", 3, 14)); // NOI18N
        jLabel2.setText("Search   By   Checkout   Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 178, -1, 56));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/close.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 0, 70, -1));

        jLabel3.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Double Click on row to open Bill");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(524, 70, 370, 46));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/back.jpg"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(1280, 670));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        showDataIntoTable();
        txtupdate.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            pst = con.prepareStatement("select * from customer where status=? and outdate=?");
            pst.setString(1, "Checkout");
            pst.setString(2, txtupdate.getText());
            rs = pst.executeQuery();
            ResultSetMetaData ob = rs.getMetaData();
            int n = ob.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//            String roomNumber = (String) df.getValueAt(selectedRow, 0);
            df.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= n; i++) {
                    v.add(rs.getString("roomnumber"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("mobile"));
                    v.add(rs.getString("gender"));
                    v.add(rs.getString("indate"));
                    v.add(rs.getString("id"));
                    v.add(rs.getString("outdate"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("days"));
                    v.add(rs.getString("amount"));
                }

                df.addRow(v);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 2) { // Check for double-click

            int selectedRow = jTable1.getSelectedRow(); // Get the selected row index
            if (selectedRow != -1) { // Check if a valid row is selected
                DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
                String roomNumber = (String) df.getValueAt(selectedRow, 0); // Room number
                String customerId = (String) df.getValueAt(selectedRow, 5); // Assuming ID is in the 6th column

                new BillPrint(roomNumber).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a valid row.");
            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtupdate;
    // End of variables declaration//GEN-END:variables
}
