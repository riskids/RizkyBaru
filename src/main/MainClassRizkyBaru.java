/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.RizkyBaruDatabase;
import entity.Penjualan;
import error.PenjualanException;
import service.PelangganDao;
import view.MainViewPenjualan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class MainClassRizkyBaru {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainViewPenjualan Pelanggan = new MainViewPenjualan();
                    Pelanggan.loadDatabase();
                    Pelanggan.setVisible(true);
                    
                } catch (SQLException ex) {
                } catch (PenjualanException ex) {
                }

            }
        });

    }

}
