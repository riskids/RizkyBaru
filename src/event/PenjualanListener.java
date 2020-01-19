/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

import entity.Penjualan;
import model.PenjualanModel;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public interface PenjualanListener {
    
    //parameter dari model Pelanggan
    public void onChange(PenjualanModel model);
    
    //parameter dari entity databases Pelanggan
    public void onInsert(Penjualan Pelanggan);
    public void onUpdate(Penjualan Pelanggan);
    
    //karna tidak perlu menambahkan data ke dalam tabel,
    //jadi ondelete tidak perlu memasukkan data 
    // alias tidak perlu memakai parameter
    public void onDelete();
    
}
