/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import config.Koneksi;
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author asus
 */
public class FormMenu extends javax.swing.JFrame {
    
    public Statement st; 
    public ResultSet rs; 
    public DefaultTableModel tabModel;
    Connection cn = config.Koneksi.Koneksi();
    
    public void judul() {
        Object[] judul = {
        "Kode Menu", "Nama Menu", "Harga", "Ukuran"
    };
        tabModel = new DefaultTableModel(null, judul);
        tb_menu.setModel(tabModel);
    }
    
    public void tampilData(String where) {
       try {
        st = cn.createStatement();
        tabModel.getDataVector().removeAllElements();
        tabModel.fireTableDataChanged();
        rs = st.executeQuery("SELECT * FROM menu " + where);
        
           
        while (rs.next()) {
            Object[] data = {
            rs.getString("kode_barang"),
            rs.getString("nama_barang"),
            rs.getString("harga"),
            rs.getString("ukuran"),
        };
            
            tabModel.addRow(data);
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void reset() {
        txtKode.setText("");
        txtMenu.setText("");
        txtHarga.setText("");
        inputUkuran.setSelectedItem("");
    }
    
    public FormMenu() {
        initComponents();
        judul();
        tampilData("");
        bt_delete.setEnabled(false);
        bt_update.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_menu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtMenu = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        inputUkuran = new javax.swing.JComboBox();
        bt_reset = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1102, 778));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(1142, 104));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-coffee-64.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Minuman");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-back-45 (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 852, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        tb_menu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
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
        jScrollPane1.setViewportView(tb_menu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 640, 280));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Kode Menu :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nama Menu :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Harga :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ukuran :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        txtKode.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(txtKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 430, 60));

        txtMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 430, 60));

        txtHarga.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 430, 60));

        inputUkuran.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inputUkuran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Small", "Medium", "Large", " " }));
        inputUkuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUkuranActionPerformed(evt);
            }
        });
        getContentPane().add(inputUkuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 280, 60));

        bt_reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-refresh-24.png"))); // NOI18N
        bt_reset.setText("RESET");
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });
        getContentPane().add(bt_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 120, -1));

        bt_save.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-save-24.png"))); // NOI18N
        bt_save.setText("SAVE");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });
        getContentPane().add(bt_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 147, 110, -1));

        bt_update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-update-24.png"))); // NOI18N
        bt_update.setText("UPDATE");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });
        getContentPane().add(bt_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, -1, -1));

        bt_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bt_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-24.png"))); // NOI18N
        bt_delete.setText("DELETE");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(bt_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 130, -1));

        setSize(new java.awt.Dimension(1189, 855));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputUkuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUkuranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUkuranActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
       try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO menu VALUES('" + txtKode.getText() + "','" + txtMenu.getText() + "','"+ txtHarga.getText()+ "','"+ inputUkuran.getSelectedItem() + "')");
            tampilData("");
            JOptionPane.showMessageDialog(null, "Simpan Berhasil");
            txtKode.setText("");
            txtMenu.setText("");
            txtHarga.setText("");
            inputUkuran.setSelectedItem("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        reset();
    }//GEN-LAST:event_bt_resetActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
         try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                    st = cn.createStatement();
                    st.executeUpdate("DELETE FROM menu WHERE kode_barang='"
                    + tabModel.getValueAt(tb_menu.getSelectedRow(), 0) + "'");
                    tampilData("");
                    reset();
                }
            }   catch (Exception e) {
            e.printStackTrace();
            }
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void tb_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_menuMouseClicked
        txtKode.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 0).toString());
        txtMenu.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 1).toString());
        txtHarga.setText(tb_menu.getValueAt(tb_menu.getSelectedRow(), 2).toString());
        inputUkuran.setSelectedItem(tb_menu.getValueAt(tb_menu.getSelectedRow(), 3).toString());
        bt_save.setEnabled(false);
        bt_update.setEnabled(true);
        bt_delete.setEnabled(true);
    }//GEN-LAST:event_tb_menuMouseClicked

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        try {
            st = cn.createStatement();
            String kode_barang = txtKode.getText(); // Ambil NPK dari input
            String nama_barang = txtMenu.getText(); // Ambil Nama dari input
            String harga = txtHarga.getText(); // Ambil Jenis Kelamin dari input
            String ukuran = inputUkuran.getSelectedItem().toString(); // Ambil Mapel dari input

            // Gunakan perintah UPDATE dengan kondisi WHERE sesuai ID (NIS)
            st.executeUpdate("UPDATE menu SET "
                + "nama_barang='" + nama_barang + "', "
                + "harga='" + harga + "', "
                + "ukuran='" + ukuran + "' WHERE kode_barang='" + kode_barang + "'");

            tampilData(""); // Tampilkan data yang telah diperbarui
            JOptionPane.showMessageDialog(null, "Update Berhasil");
            reset();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }//GEN-LAST:event_bt_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame FormDashoard = new FormDashboard();
        this.setVisible(false);
        FormDashoard.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_update;
    private javax.swing.JComboBox inputUkuran;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_menu;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtMenu;
    // End of variables declaration//GEN-END:variables

}