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
import service.PenjualanDao;
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

    protected void fireOnInsert(Penjualan Penjualan) {
        if (listener != null) {
            listener.onInsert(Penjualan);
        }
    }

    protected void fireOnUpdate(Penjualan Penjualan) {
        if (listener != null) {
            listener.onUpdate(Penjualan);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertPenjualan() throws SQLException, PenjualanException {
        PenjualanDao dao = RizkyBaruDatabase.getPenjualanDao();

        Penjualan Penjualan = new Penjualan();
        Penjualan.setTgl(tgl);
        Penjualan.setGalon(galon_terjual);
        Penjualan.setJumlah(jumlah);

        dao.insertPenjualan(Penjualan);
        fireOnInsert(Penjualan);

    }

    public void updatePenjualan() throws SQLException, PenjualanException {
        PenjualanDao dao = RizkyBaruDatabase.getPenjualanDao();

        Penjualan Penjualan = new Penjualan();
        Penjualan.setTgl(tgl);
        Penjualan.setGalon(galon_terjual);
        Penjualan.setJumlah(jumlah);
        Penjualan.setId(id);

        dao.updatePenjualan(Penjualan);
        fireOnUpdate(Penjualan);
    }

    public void deletePenjualan() throws SQLException, PenjualanException {
        
        PenjualanDao dao = RizkyBaruDatabase.getPenjualanDao();
        dao.deletePenjualan(id);
        fireOnDelete();
    }
    
    public void resetPenjualan(){
        setId(0);
        setTgl("");
        setGalon(0);
        setJumlah(0);
    
    }

}
