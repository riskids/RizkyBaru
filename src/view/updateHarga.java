/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JTextField;
import view.PenjualanVIew;
/**
 *
 * @author Riski Dwi
 */
public class updateHarga extends javax.swing.JFrame {

    /**
     * Creates new form isiTanki
     */
    public updateHarga() {
        initComponents();
    }
    
    public JTextField getHargaField(){
        
        return txtInputHarga;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtInputHarga = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        Label_nama_keuntungan6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_update_harga = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(44, 148, 230));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtInputHarga.setBackground(new java.awt.Color(44, 148, 230));
        txtInputHarga.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        txtInputHarga.setForeground(new java.awt.Color(255, 255, 255));
        txtInputHarga.setBorder(null);
        txtInputHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputHargaActionPerformed(evt);
            }
        });
        txtInputHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInputHargaKeyTyped(evt);
            }
        });
        jPanel1.add(txtInputHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 225, 40));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 230, 20));

        Label_nama_keuntungan6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_nama_keuntungan6.setForeground(new java.awt.Color(255, 255, 255));
        Label_nama_keuntungan6.setText("Masukan Harga Per Galon");
        jPanel1.add(Label_nama_keuntungan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, 29));

        jPanel2.setBackground(new java.awt.Color(219, 236, 248));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_update_harga.setBackground(new java.awt.Color(44, 148, 230));
        btn_update_harga.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_update_harga.setForeground(new java.awt.Color(255, 255, 255));
        btn_update_harga.setText("Ubah");
        btn_update_harga.setBorder(null);
        btn_update_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_hargaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_update_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 230, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 400, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtInputHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputHargaActionPerformed

    private void txtInputHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInputHargaKeyTyped
        // TODO add your handling code here:
        char ketikan = evt.getKeyChar();
        if (!(Character.isDigit(ketikan))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtInputHargaKeyTyped

    private void btn_update_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_hargaActionPerformed
        // TODO add your handling code here:

        getHargaField();
        PenjualanVIew penjualan = new PenjualanVIew();
        penjualan.updateHarga(getHargaField().getText());
        this.setVisible(false);
        
         //ambil value dari tabel
        PenjualanVIew view = new PenjualanVIew();
        view.tampilUntung();
        view.tampilGalon();
        view.tampilTankiSatuan();
        view.tampilTanki();
    }//GEN-LAST:event_btn_update_hargaActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_nama_keuntungan6;
    private javax.swing.JButton btn_update_harga;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtInputHarga;
    // End of variables declaration//GEN-END:variables
}
