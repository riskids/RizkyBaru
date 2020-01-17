/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class Penjualan {

    private Integer id;
    private String tgl;
    private Integer galon_terjual;
    private Integer jumlah;

    public Penjualan() {
        
    }

    public Penjualan(String tgl, Integer galon_terjual, Integer jumlah) {
        this.tgl = tgl;
        this.galon_terjual = galon_terjual;
        this.jumlah = jumlah;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.tgl);
        hash = 67 * hash + Objects.hashCode(this.galon_terjual);
        hash = 67 * hash + Objects.hashCode(this.jumlah);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Penjualan other = (Penjualan) obj;
        if (!Objects.equals(this.tgl, other.tgl)) {
            return false;
        }
        if (!Objects.equals(this.galon_terjual, other.galon_terjual)) {
            return false;
        }
        if (!Objects.equals(this.jumlah, other.jumlah)) {
            return false;
        }
        return true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public Integer getGalon() {
        return galon_terjual;
    }

    public void setGalon(Integer galon_terjual) {
        this.galon_terjual = galon_terjual;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

}
