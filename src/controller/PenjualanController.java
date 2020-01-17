/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.PenjualanModel;
import view.PenjualanVIew;
import javax.swing.JOptionPane;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class PenjualanController {

    private PenjualanModel model;

    public void setModel(PenjualanModel model) {
        this.model = model;
    }

    public void resetPelanggan(PenjualanVIew view) {
        model.resetPelanggan();

    }

    public void insertPelanggan(PenjualanVIew view) {
        String tgl = view.getTxtTgl().getText();
        Integer galon_terjual = Integer.parseInt(view.getTxtGalon().getText());
        Integer jumlah = Integer.parseInt(view.getTxtJumlah().getText());

        if (galon_terjual.equals(0)) {
            JOptionPane.showMessageDialog(view, "Masih Nol!");
        }else if (tgl.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Tanggal masih kosong");
        }else {
            model.setTgl(tgl);
            model.setGalon(galon_terjual);
            model.setJumlah(jumlah);
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Berhasil Input Data");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void updatePelanggan(PenjualanVIew view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }

        Integer id = Integer.parseInt(view.getTxtId().getText());

        String tgl = view.getTxtTgl().getText();
        Integer galon_terjual = Integer.parseInt(view.getTxtGalon().getText());
        Integer jumlah = Integer.parseInt(view.getTxtJumlah().getText());

        if (galon_terjual.equals(0)) {
            JOptionPane.showMessageDialog(view, "Tgl Masih Kosong");
        }else {
            model.setTgl(tgl);
            model.setGalon(galon_terjual);
            model.setJumlah(jumlah);
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Berhasil Update Data");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void deletePelanggan(PenjualanVIew view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);

            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

}
