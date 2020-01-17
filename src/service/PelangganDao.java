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
public interface PelangganDao {

    //Untuk melakukan aktifitas CRUD
    // Get By ID dan Get By Email
    public void insertPelanggan(Penjualan pelanggan) throws PenjualanException;

    public void updatePelanggan(Penjualan pelanggan) throws PenjualanException;

    public void deletePelanggan(Integer id) throws PenjualanException;

    // Jika ingin meload semua data pelanggan
    public List<Penjualan> selectAllPelanggan() throws PenjualanException;
}
