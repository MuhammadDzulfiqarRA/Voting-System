package voting;

import Controller.VoteDB;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class VoteJPanel extends javax.swing.JFrame {
    
    private VoteDB voteDB;
    private String password;
    private String username;
    private boolean sudahMemilih = false;
    private User user = Masuk.user;
    /**
     * Creates new form VoteJPanel1
     */
    public VoteJPanel(String password, String username) {
        voteDB = new VoteDB();
        this.password = password;
        this.username = username;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btn3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Btn1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Btn3.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        Btn3.setText("3");
        Btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("SILAHKAN PILIH NOMOR PASANGAN CALON");

        jButton4.setBackground(new java.awt.Color(51, 102, 255));
        jButton4.setFont(new java.awt.Font("Bookman Old Style", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("<< kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Btn1.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        Btn1.setText("1");
        Btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1ActionPerformed(evt);
            }
        });

        Btn2.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        Btn2.setText("2");
        Btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn3ActionPerformed
        // TODO add your handling code here:
        if (!sudahMemilih) {
            konfirmasiVoting(3);
        } else {
            JOptionPane.showMessageDialog(this, "Anda sudah memilih. Tidak dapat memilih lagi.");
        }
    }//GEN-LAST:event_Btn3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         // Kembali ke menu DashboardPemilih
        DashboardPemilih dashboard = new DashboardPemilih(); // Sesuaikan dengan konstruktor DashboardPemilih
        dashboard.setVisible(true);

        // Tutup frame saat ini (VoteJPanel)
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn1ActionPerformed
        // TODO add your handling code here:
        if (!sudahMemilih) {
            konfirmasiVoting(1);
        } else {
            JOptionPane.showMessageDialog(this, "Anda sudah memilih. Tidak dapat memilih lagi.");
        }
    }//GEN-LAST:event_Btn1ActionPerformed

    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn2ActionPerformed
        // TODO add your handling code here:
        if (!sudahMemilih) {
            konfirmasiVoting(2);
        } else {
            JOptionPane.showMessageDialog(this, "Anda sudah memilih. Tidak dapat memilih lagi.");
        }
    }//GEN-LAST:event_Btn2ActionPerformed

    private void konfirmasiVoting(int nomorUrut) {
        int jawaban = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin?");
        if (jawaban == JOptionPane.YES_OPTION) {
            // Update database voting
            VoteDB.vote(username, getUmurFromDatabase(password), password, nomorUrut);
            JOptionPane.showMessageDialog(this, "Terima kasih atas partisipasi Anda!");
            sudahMemilih = true;

//            // Update database voting
//            VoteDB.vote(nama, getUmurFromDatabase(nik), nik, nomorUrut);
//            JOptionPane.showMessageDialog(this, "Terverifikasi");
//            sudahMemilih = true;
//
//            // Ambil frame yang mengandung panel ini
//            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
//
//            // Beralih ke UtamaPanel setelah verifikasi
//            UtamaPanel utamaPanel = new UtamaPanel(nik, nama);
//
//            // Gantikan panel UtamaPanel yang mungkin ada di frame
//            frame.getContentPane().removeAll();
//            frame.getContentPane().add(utamaPanel);
//            frame.revalidate();
//            frame.repaint();
        }
    }
    private int getUmurFromDatabase(String password) {
        // Ambil umur dari database berdasarkan NIK
        // Implementasikan akses database sesuai kebutuhan
        return 17; // Contoh umur sederhana untuk keperluan demonstrasi
    }
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
            java.util.logging.Logger.getLogger(VoteJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteJPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            String password = "ContohNIK";
            String username = "ContohNama";
            new VoteJPanel(password, username).setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btn3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
