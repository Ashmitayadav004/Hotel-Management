/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management;

import javax.swing.JFrame;

/**
 *
 * @author anshu
 */
public class HotelManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Hotel Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 670);
        frame.setVisible(true);
        new loading1().setVisible(true);
        try {
            // Your application logic here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
