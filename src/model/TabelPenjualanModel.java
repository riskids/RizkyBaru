/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Penjualan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class TabelPenjualanModel extends AbstractTableModel {

    private List<Penjualan> list = new ArrayList<Penjualan>();

    public void setList(List<Penjualan> list) {
        this.list = list;
    }

    public boolean add(Penjualan e) {
        
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Penjualan get(int index) {
        return list.get(index);
    }

    public Penjualan set(int index, Penjualan element) {
        
        try {
            return list.set(index, element);
        } finally {
            //karena set merubah, jadi pake fireTablRowsUpdate
            fireTableRowsUpdated(index, index);
        }
        
    }

    public Penjualan remove(int index) {
        
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
        
    }

    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Tanggal";
            case 2:
                return "Galon Terjual";
            case 3:
                return "Jumlah";
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getTgl();
            case 2:
                return list.get(rowIndex).getGalon();
            case 3:
                return list.get(rowIndex).getJumlah();
            default:
                return null;
        }
    }

}
