/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import config.Koneksi;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormTransaksi extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tableModel;
    Connection cn = config.Koneksi.Koneksi();
    
    public void judulMenu() {
         Object[] judul = {
        "Kode Menu", "Nama Menu", "Harga", "Ukuran"
        };
        tableModel = new DefaultTableModel(null, judul);
        tb_menu.setModel(tableModel);
    }
    
    public void judulKeranjang() {
        Object[] judul = {
            "Kode Menu", "Nama Menu", "Harga", "Ukuran", "Jumlah", "Subtotal", "Total", "Bayar", "Kembalian", "Tanggal"
        };
        tableModel = new DefaultTableModel(null, judul);
        tb_keranjang.setModel(tableModel);
    }
    
    public void tampilDataMenu(String where){
       try {
        st = cn.createStatement();
        tableModel.getDataVector().removeAllElements();
        tableModel.fireTableDataChanged();
        rs = st.executeQuery("SELECT * FROM menu " + where);
        
           
        while (rs.next()) {
            Object[] data = {
            rs.getString("kode_barang"),
            rs.getString("nama_barang"),
            rs.getString("harga"),
            rs.getString("ukuran"),
        };
            
            tableModel.addRow(data);
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tampilDataKeranjang(String where){
        try {
            st = cn.createStatement();
            tableModel.getDataVector().removeAllElements();
            tableModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM transaksi " + where);
            
            while (rs.next()) {
                Object[] data = {
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("harga"),
                    rs.getString("ukuran"),
                    rs.getString("jumlah"),
                    rs.getString("subtotal"),
                    rs.getString("total"),
                    rs.getString("bayar"),
                    rs.getString("kembalian"),
                    rs.getString("tanggal"),
                };
                tableModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void subTotal(){
        String harga = txtHarga.getText();
        String jumlah = txtJumlah.getText();
        
        int hargaa = Integer.parseInt(harga);
        try {
            if (jumlah.matches("\\d+")) {
                int jumlahh = Integer.parseInt(jumlah);
                if (jumlahh < 1) {
                    JOptionPane.showMessageDialog(null, "jumlah harus lebih besar atau sama dengan 1");
                    txtJumlah.setText("1");
                    jumlahh = 1;
                }
                int total = hargaa * jumlahh;
                String total_harga = Integer.toString(total);
                txtSubtotal.setText(total_harga);
            } else {
                JOptionPane.showMessageDialog(null, "Masukkan hanya angka tanpa simbol!");
                txtJumlah.setText(null);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Hanya Angka!");
            txtJumlah.setText(null);
        }
        
    }
    
    
    public void reset() {
        txtKode.setText("");
        txtMenu.setText("");
        txtHarga.setText("");
        txtUkuran.setText("");
        txtJumlah.setText("");
        txtSubtotal.setText("");
        tb_menu.setEnabled(true);
        tb_keranjang.setEnabled(true);
        bt_update.setEnabled(true);
        bt_delete.setEnabled(true);
    }
    
    public void restart(){
        txtKode.setText("");
        txtMenu.setText("");
        txtHarga.setText("");
        txtUkuran.setText("");
        txtSubtotal.setText("");
        bt_delete.setEnabled(true);
    }
    
    public void tanggal() {
        Date currenDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        txtTanggal.setText(dateFormat.format(currenDate));
    }
      
    public FormTransaksi() {
        initComponents();
        judulMenu();
        tampilDataMenu("");
        judulKeranjang();
        tampilDataKeranjang("");
        tanggal();
        setLocationRelativeTo(this);
        bt_update.setEnabled(false);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_keranjang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_menu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtMenu = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        bt_update = new javax.swing.JButton();
        bt_done = new javax.swing.JButton();
        bt_add = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();
        txtTanggal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUkuran = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1163, 104));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-transaction-64.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Transaksi");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-back-45 (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 849, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tb_keranjang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tb_keranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_keranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_keranjang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 710, 220));

        tb_menu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tb_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_menuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_menu);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 710, 210));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Menu");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Transaksi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Harga :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Kode Menu:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Jumlah :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Subtotal");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Nama Menu :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));
        getContentPane().add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 280, 40));
        getContentPane().add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, 280, 40));
        getContentPane().add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 280, 40));
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 280, 40));

        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJumlahKeyReleased(evt);
            }
        });
        getContentPane().add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 280, 40));

        bt_update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-update-24.png"))); // NOI18N
        bt_update.setText("UPDATE");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });
        getContentPane().add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 700, 140, -1));

        bt_done.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_done.setText("DONE");
        bt_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_doneActionPerformed(evt);
            }
        });
        getContentPane().add(bt_done, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 700, 100, -1));

        bt_add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cart-24.png"))); // NOI18N
        bt_add.setText("ADD");
        bt_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_addActionPerformed(evt);
            }
        });
        getContentPane().add(bt_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 100, -1));

        bt_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-24.png"))); // NOI18N
        bt_delete.setText("DELETE");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(bt_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 430, 140, -1));

        bt_reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refresh-24.png"))); // NOI18N
        bt_reset.setText("RESET");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });
        getContentPane().add(bt_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 700, 140, -1));

        txtTanggal.setEnabled(false);
        getContentPane().add(txtTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 120, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Ukuran:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));

        txtUkuran.setEnabled(false);
        getContentPane().add(txtUkuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 280, 40));

        txtBayar.setText("1");
        getContentPane().add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 20, 40));

        txtKembalian.setText("1");
        getContentPane().add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 20, 40));

        txtTotal.setText("1");
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, -1, 40));

        setSize(new java.awt.Dimension(1185, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame FormDashboard = new FormDashboard();
        this.setVisible(false);
        FormDashboard.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_addActionPerformed
        try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO transaksi VALUES('" + txtKode.getText() + "','" + txtMenu.getText() +"','"+ txtHarga.getText() +"','"+ txtUkuran.getText()+"','"+ txtJumlah.getText()+"','"+ txtSubtotal.getText()+"','"+ txtTotal.getText() +"','"+ txtBayar.getText() +"','"+ txtKembalian.getText()+"','"+ txtTanggal.getText() + "')");
            tampilDataKeranjang("");
            JOptionPane.showMessageDialog(null, "Simpan berhasil");
        } catch (Exception e) {
            e.printStackTrace();
        }
        tb_menu.setEnabled(false);
    }//GEN-LAST:event_bt_addActionPerformed

    private void tb_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_menuMouseClicked
        txtKode.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 0).toString());
        txtMenu.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 1).toString());
        txtHarga.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 2).toString());
        txtUkuran.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_tb_menuMouseClicked

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        try {
            st = cn.createStatement();
            String kode_barang = txtKode.getText();
            String nama_barang = txtMenu.getText();
            String harga = txtHarga.getText();
            String ukuran = txtUkuran.getText();
            String jumlah = txtJumlah.getText();
            String subtotal = txtSubtotal.getText();
            String total = txtTotal.getText();
            String bayar = txtBayar.getText();
            String kembalian = txtKembalian.getText();
            String tanggal = txtTanggal.getText();
            
            String updateQuery = "UPDATE transaksi SET"
                    + "jumlah='" + jumlah + "',"
                    + "subtotal='" + subtotal + "'WHERE kode_barang='" + kode_barang +"'";
            st.executeQuery(updateQuery);
            bt_add.setEnabled(true);
            bt_update.setEnabled(false);
            tampilDataKeranjang("");
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            restart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin menghapus?",  
                    "Information", JOptionPane.YES_NO_OPTION)) == 0 ){
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM transaksi WHERE kode_barang = '" + tableModel.getValueAt(tb_keranjang.getSelectedRow(),4) + "");
                tampilDataKeranjang("");
                restart();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bt_add.setEnabled(true);
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Apakah yakin ingin mereset?",  
                    "Information", JOptionPane.YES_NO_OPTION)) == 0 ){
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM transaksi"); 
                tampilDataKeranjang("");
                reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_resetActionPerformed

    private void bt_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_doneActionPerformed
        JFrame FormKeranjang = new FormKeranjang();
        this.setVisible(false);
        FormKeranjang.setVisible(true);
    }//GEN-LAST:event_bt_doneActionPerformed

    private void tb_keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_keranjangMouseClicked
        txtKode.setText(tb_keranjang.getValueAt(tb_keranjang.getSelectedRow(), 0).toString());
        txtMenu.setText(tb_keranjang.getValueAt(tb_keranjang.getSelectedRow(), 1).toString());
        txtHarga.setText(tb_keranjang.getValueAt(tb_keranjang.getSelectedRow(), 2).toString());
        txtUkuran.setText(tb_keranjang.getValueAt(tb_keranjang.getSelectedRow(), 3).toString());
        txtJumlah.setText(tb_keranjang.getValueAt(tb_keranjang.getSelectedRow(), 4).toString());
        txtSubtotal.setText(tb_keranjang.getValueAt(tb_keranjang.getSelectedRow(), 5).toString());
        bt_add.setEnabled(false);
        bt_update.setEnabled(true);
    }//GEN-LAST:event_tb_keranjangMouseClicked

    private void txtJumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyReleased
        subTotal();
    }//GEN-LAST:event_txtJumlahKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_add;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_done;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_update;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_keranjang;
    private javax.swing.JTable tb_menu;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtMenu;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUkuran;
    // End of variables declaration//GEN-END:variables
}
