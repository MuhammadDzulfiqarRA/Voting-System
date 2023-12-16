package voting;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controller.VoteDB;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class DashboardAdmin extends javax.swing.JFrame {

    VoteDB voteDB;
    public DashboardAdmin() {
        voteDB = new VoteDB();
        getPaslonCount(Utama.anies, 1);
        getPaslonCount(Utama.prabowo, 2);
        getPaslonCount(Utama.ganjar, 3);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        paslon1AdminPanel = new javax.swing.JPanel();
        fotoPaslon1Admin = new javax.swing.JLabel();
        totalVotePaslon1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paslon1NameAdminTA = new javax.swing.JTextArea();
        totalVotePaslon1Number = new javax.swing.JLabel();
        paslon2AdminPanel = new javax.swing.JPanel();
        totalVotePaslon2 = new javax.swing.JLabel();
        fotoPaslonAdmin2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paslon2NameAdminTA = new javax.swing.JTextArea();
        totalVotePaslon2Number = new javax.swing.JLabel();
        paslon3AdminPanel = new javax.swing.JPanel();
        fotoPaslon3Admin = new javax.swing.JLabel();
        totalVotePaslon3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        paslon3NameAdmin3 = new javax.swing.JTextArea();
        totalVotePaslon3Number = new javax.swing.JLabel();
        totalAllVoteLabel = new javax.swing.JLabel();
        totalAllVoteNumberLabel = new javax.swing.JLabel();
        adminMessageLabel = new javax.swing.JLabel();
        adminNameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        paslon1AdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        
        ImageIcon imgAnies = new ImageIcon("D:\\KINANTHI\\KULIAH\\Semester_5\\Pemrograman Berorientasi Objek\\Praktikum\\Sistem Voting\\Voting-System\\src\\asset\\anis.jpg");
        ImageIcon imgPrabowo = new ImageIcon("D:\\KINANTHI\\KULIAH\\Semester_5\\Pemrograman Berorientasi Objek\\Praktikum\\Sistem Voting\\Voting-System\\src\\asset\\prabowo.jpg");
        ImageIcon imgGanjar = new ImageIcon("D:\\KINANTHI\\KULIAH\\Semester_5\\Pemrograman Berorientasi Objek\\Praktikum\\Sistem Voting\\Voting-System\\src\\asset\\ganjar.jpg");
        
        setImage(fotoPaslon1Admin, imgAnies);
        setImage(fotoPaslonAdmin2, imgPrabowo);
        setImage(fotoPaslon3Admin, imgGanjar);
              
        adminNameLabel.setText(LoginAdmin.admin.getUsername());

        fotoPaslon1Admin.setText("fotoPakAnies");
        fotoPaslon1Admin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalVotePaslon1.setText("Total Vote :");

        paslon1NameAdminTA.setColumns(20);
        paslon1NameAdminTA.setEditable(false);
        paslon1NameAdminTA.setLineWrap(true);
        paslon1NameAdminTA.setRows(5);
        paslon1NameAdminTA.setText("Paslon 1\n\nCalon Presiden : Anies Rasyid Baswedan\nCalon Wakil Presiden : Muhaimin Iskandar");
        paslon1NameAdminTA.setWrapStyleWord(true);
        paslon1NameAdminTA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(paslon1NameAdminTA);

        totalVotePaslon1Number.setText(Integer.toString(Utama.anies.getVoteNumber()));

        javax.swing.GroupLayout paslon1AdminPanelLayout = new javax.swing.GroupLayout(paslon1AdminPanel);
        paslon1AdminPanel.setLayout(paslon1AdminPanelLayout);
        paslon1AdminPanelLayout.setHorizontalGroup(
            paslon1AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paslon1AdminPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(fotoPaslon1Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalVotePaslon1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalVotePaslon1Number, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        paslon1AdminPanelLayout.setVerticalGroup(
            paslon1AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paslon1AdminPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(paslon1AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalVotePaslon1Number, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addGroup(paslon1AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fotoPaslon1Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                        .addComponent(totalVotePaslon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        paslon2AdminPanel.setBackground(new java.awt.Color(255, 255, 255));

        totalVotePaslon2.setText("Total Vote :");

        fotoPaslonAdmin2.setText("fotoPakPrabowo");
        fotoPaslonAdmin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        paslon2NameAdminTA.setColumns(20);
        paslon2NameAdminTA.setEditable(false);
        paslon2NameAdminTA.setRows(5);
        paslon2NameAdminTA.setText("Paslon 2\n\nCalon Presiden : Prabowo Subianto\nCalon Wakil Presiden : Gibran Rakabuming Raka");
        paslon2NameAdminTA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(paslon2NameAdminTA);

        totalVotePaslon2Number.setText(Integer.toString(Utama.prabowo.getVoteNumber()));

        javax.swing.GroupLayout paslon2AdminPanelLayout = new javax.swing.GroupLayout(paslon2AdminPanel);
        paslon2AdminPanel.setLayout(paslon2AdminPanelLayout);
        paslon2AdminPanelLayout.setHorizontalGroup(
            paslon2AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paslon2AdminPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(fotoPaslonAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2)
                .addGap(18, 18, 18)
                .addComponent(totalVotePaslon2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalVotePaslon2Number, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        paslon2AdminPanelLayout.setVerticalGroup(
            paslon2AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paslon2AdminPanelLayout.createSequentialGroup()
                .addGroup(paslon2AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paslon2AdminPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, paslon2AdminPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(paslon2AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalVotePaslon2Number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(paslon2AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(totalVotePaslon2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fotoPaslonAdmin2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(17, 17, 17))
        );

        paslon3AdminPanel.setBackground(new java.awt.Color(255, 255, 255));

        fotoPaslon3Admin.setText("jLabel1");
        fotoPaslon3Admin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        totalVotePaslon3.setText("Total Vote :");

        paslon3NameAdmin3.setColumns(20);
        paslon3NameAdmin3.setEditable(false);
        paslon3NameAdmin3.setLineWrap(true);
        paslon3NameAdmin3.setRows(5);
        paslon3NameAdmin3.setText("Paslon 3\n\nCalon Presiden : Ganjar Pranowo\nCalon Wakil Presiden : Mahfud MD\n");
        paslon3NameAdmin3.setWrapStyleWord(true);
        paslon3NameAdmin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(paslon3NameAdmin3);

        totalVotePaslon3Number.setText(Integer.toString(Utama.ganjar.getVoteNumber()));

        javax.swing.GroupLayout paslon3AdminPanelLayout = new javax.swing.GroupLayout(paslon3AdminPanel);
        paslon3AdminPanel.setLayout(paslon3AdminPanelLayout);
        paslon3AdminPanelLayout.setHorizontalGroup(
            paslon3AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paslon3AdminPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(fotoPaslon3Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(totalVotePaslon3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalVotePaslon3Number, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        paslon3AdminPanelLayout.setVerticalGroup(
            paslon3AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paslon3AdminPanelLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(paslon3AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paslon3AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fotoPaslon3Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalVotePaslon3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalVotePaslon3Number, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        totalAllVoteLabel.setText("Total All Vote :");
        int totalVote = Utama.anies.getVoteNumber()+Utama.prabowo.getVoteNumber()+Utama.ganjar.getVoteNumber();
        totalAllVoteNumberLabel.setText(Integer.toString(totalVote));

        adminMessageLabel.setText("Halo,");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paslon1AdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paslon2AdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paslon3AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(totalAllVoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totalAllVoteNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(adminMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(paslon1AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(paslon2AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paslon3AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAllVoteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(totalAllVoteNumberLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }
    
    private void setImage(JLabel jlabel, ImageIcon icon){
        Image scaleImage = getScaledImage(icon.getImage(), 120, 125);
        icon = new ImageIcon(scaleImage);
        jlabel.setIcon(icon);   
    }
    
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
    
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
    
        return resizedImg;
    }
    
    public void getPaslonCount(Paslon paslon, int nomor_urut){
        voteDB.getPaslonVoteCount(paslon, nomor_urut);
    }
    
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
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminMessageLabel;
    private javax.swing.JLabel adminNameLabel;
    private javax.swing.JLabel fotoPaslon1Admin;
    private javax.swing.JLabel fotoPaslon3Admin;
    private javax.swing.JLabel fotoPaslonAdmin2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel paslon1AdminPanel;
    private javax.swing.JTextArea paslon1NameAdminTA;
    private javax.swing.JPanel paslon2AdminPanel;
    private javax.swing.JTextArea paslon2NameAdminTA;
    private javax.swing.JPanel paslon3AdminPanel;
    private javax.swing.JTextArea paslon3NameAdmin3;
    private javax.swing.JLabel totalAllVoteLabel;
    private javax.swing.JLabel totalAllVoteNumberLabel;
    private javax.swing.JLabel totalVotePaslon1;
    private javax.swing.JLabel totalVotePaslon1Number;
    private javax.swing.JLabel totalVotePaslon2;
    private javax.swing.JLabel totalVotePaslon2Number;
    private javax.swing.JLabel totalVotePaslon3;
    private javax.swing.JLabel totalVotePaslon3Number;
    // End of variables declaration//GEN-END:variables
}
