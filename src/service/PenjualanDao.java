/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Penjualan;
import error.PenjualanException;
import java.util.List;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public interface PenjualanDao {

    //Untuk melakukan aktifitas CRUD
    // Get By ID dan Get By Email
    public void insertPenjualan(Penjualan Penjualan) throws PenjualanException;

    public void updatePenjualan(Penjualan Penjualan) throws PenjualanException;

    public void deletePenjualan(Integer id) throws PenjualanException;

    // Jika ingin meload semua data Penjualan
    public List<Penjualan> selectAllPenjualan() throws PenjualanException;
}
