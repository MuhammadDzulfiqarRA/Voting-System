package voting;

import javax.swing.JOptionPane;

import controller.VoteDB;

public class VoteJPanel extends javax.swing.JFrame {
    
    private VoteDB voteDB;
    private boolean sudahMemilih = false;
    
    public VoteJPanel() {
        voteDB = new VoteDB();
        System.out.println(LoginPemilih.user.getNik());
        initComponents();
    }
    
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
    }
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Tutup frame saat ini (VoteJPanel)
        this.dispose();
    }
    
    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!sudahMemilih) {
            konfirmasiVoting(Utama.anies, 1);
        } else {
            JOptionPane.showMessageDialog(this, "Anda sudah memilih. Tidak dapat memilih lagi.");
        }
    }
    
    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!sudahMemilih) {
            konfirmasiVoting(Utama.prabowo, 2);
        } else {
            JOptionPane.showMessageDialog(this, "Anda sudah memilih. Tidak dapat memilih lagi.");
        }
    }
    
    private void Btn3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!sudahMemilih) {
            konfirmasiVoting(Utama.ganjar, 3);
        } else {
            JOptionPane.showMessageDialog(this, "Anda sudah memilih. Tidak dapat memilih lagi.");
        }
    }
    
    private void konfirmasiVoting(Paslon paslon, int nomorUrut) {
        int jawaban = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin?");
        if (jawaban == JOptionPane.YES_OPTION) {
            // Update database voting
            voteDB.vote(LoginPemilih.user.getNama(), LoginPemilih.user.getUmur(), LoginPemilih.user.getNik(), paslon, nomorUrut);
            JOptionPane.showMessageDialog(this, "Terima kasih atas partisipasi Anda!");
            sudahMemilih = true;
            LoginPemilih.utamaPanel.dispose();
            this.dispose();
            // Beralih ke UtamaPanel setelah verifikasi
            Utama utama = new Utama();
            utama.setVisible(true);
        }
    }
    
    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new VoteJPanel().setVisible(true);
        }
    });
    }

    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btn3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
}
