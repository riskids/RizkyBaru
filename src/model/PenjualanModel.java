/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.RizkyBaruDatabase;
import entity.Penjualan;
import error.PenjualanException;
import event.PenjualanListener;
import service.PelangganDao;
import view.PenjualanVIew;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class PenjualanModel {

    private int id;
    private String tgl;
    private Integer galon_terjual;
    private Integer jumlah;
    private PenjualanListener listener;

    public PenjualanListener getListener() {
        return listener;
    }

    public void setListener(PenjualanListener listener) {
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
        fireOnChange();
    }

    public Integer getGalon() {
        return galon_terjual;
    }

    public void setGalon(Integer galon_terjual) {
        this.galon_terjual = galon_terjual;
        fireOnChange();
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
        fireOnChange();
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Penjualan Pelanggan) {
        if (listener != null) {
            listener.onInsert(Pelanggan);
        }
    }

    protected void fireOnUpdate(Penjualan Pelanggan) {
        if (listener != null) {
            listener.onUpdate(Pelanggan);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertPelanggan() throws SQLException, PenjualanException {
        PelangganDao dao = RizkyBaruDatabase.getPelangganDao();

        Penjualan Pelanggan = new Penjualan();
        Pelanggan.setTgl(tgl);
        Pelanggan.setGalon(galon_terjual);
        Pelanggan.setJumlah(jumlah);

        dao.insertPelanggan(Pelanggan);
        fireOnInsert(Pelanggan);

    }

    public void updatePelanggan() throws SQLException, PenjualanException {
        PelangganDao dao = RizkyBaruDatabase.getPelangganDao();

        Penjualan Pelanggan = new Penjualan();
        Pelanggan.setTgl(tgl);
        Pelanggan.setGalon(galon_terjual);
        Pelanggan.setJumlah(jumlah);
        Pelanggan.setId(id);

        dao.updatePelanggan(Pelanggan);
        fireOnUpdate(Pelanggan);
    }

    public void deletePelanggan() throws SQLException, PenjualanException {
        
        PelangganDao dao = RizkyBaruDatabase.getPelangganDao();
        dao.deletePelanggan(id);
        fireOnDelete();
    }
    
    public void resetPelanggan(){
        setId(0);
        setTgl("");
        setGalon(0);
        setJumlah(0);
    
    }

}
