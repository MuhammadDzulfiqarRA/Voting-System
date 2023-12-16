package voting;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DashboardPemilih extends javax.swing.JFrame {

    public int loginSession;
    private Thread countdownThread;
    public int countdown;
    private volatile boolean isRunning = true;
    private Thread countdownThread2;
    public int countdown2;
    private volatile boolean isRunning2 = true;
    
    public DashboardPemilih() {
        initComponents();
        startCountDown();
        countdown2 = 72;
        startCountDown2();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pemiluTimeLabel = new javax.swing.JLabel();
        pemiluTimeHourLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sessionTimeLabel = new javax.swing.JLabel();
        sessionTimeCountdownLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        fotoPaslon1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paslon1TextArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        fotoPaslon2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paslon2TextArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        fotoPaslon3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        paslon3TextArea = new javax.swing.JTextArea();
        voteNowButton = new javax.swing.JButton();
        paslonLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        
        ImageIcon imgAnies = new ImageIcon("D:\\KINANTHI\\KULIAH\\Semester_5\\Pemrograman Berorientasi Objek\\Praktikum\\Sistem Voting\\Voting-System\\src\\asset\\anis.jpg");
        ImageIcon imgPrabowo = new ImageIcon("D:\\KINANTHI\\KULIAH\\Semester_5\\Pemrograman Berorientasi Objek\\Praktikum\\Sistem Voting\\Voting-System\\src\\asset\\prabowo.jpg");
        ImageIcon imgGanjar = new ImageIcon("D:\\KINANTHI\\KULIAH\\Semester_5\\Pemrograman Berorientasi Objek\\Praktikum\\Sistem Voting\\Voting-System\\src\\asset\\ganjar.jpg");
        
        setImage(fotoPaslon1, imgAnies);
        setImage(fotoPaslon2, imgPrabowo);
        setImage(fotoPaslon3, imgGanjar);

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        pemiluTimeLabel.setText("Sisa Waktu Pemilu:");

        pemiluTimeHourLabel.setText("Jam");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pemiluTimeLabel)
                    .addComponent(pemiluTimeHourLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pemiluTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pemiluTimeHourLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        sessionTimeLabel.setText("Sesi Anda akan berakhir pada :");

        sessionTimeCountdownLabel.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sessionTimeLabel)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(sessionTimeCountdownLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sessionTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sessionTimeCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));

        fotoPaslon1.setText("anies");
        fotoPaslon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        paslon1TextArea.setColumns(20);
        paslon1TextArea.setLineWrap(true);
        paslon1TextArea.setEditable(false);
        paslon1TextArea.setRows(5);
        paslon1TextArea.setText("Paslon 1\nCalon Presiden: Anies Rasyid Baswedan\nCalon Wakil Presiden: Muhaimin Iskandar\n\nVisi: Indonesia Adil dan Makmur Untuk Semua\nMisi:\n1. Memastikan ketersediaan kebutuhan pokok dan biaya hidup murah melalui kemandirian pangan, ketahanan energi, dan kedaulatan air.\n2. Mengentaskan kemiskinan dengan memperluas kesempatan berusaha dan menciptakan lapangan kerja, mewujudkan upah berkeadilan, menjamin kemajuan ekonomi berbasis kemandirian dan pemerataan, serta mendukung korporasi Indonesia berhasil di negeri sendiri dan bertumbuh di kancah global.\n3. Mewujudkan keadilan ekologis berkelanjutan untuk generasi mendatang.\n4. Membangun kota dan desa berbasis kawasan yang manusiawi, berkeadilan, dan saling memajukan.\n5. Mewujudkan manusia Indonesia yang sehat, cerdas, produktif, berakhlak, serta berbudaya.\n6. Mewujudkan keluarga Indonesia yang sejahtera dan bahagia sebagai akar kekuatan bangsa.\n7. Memperkuat sistem pertahanan dan keamanan negara, serta meningkatkan peran dan kepemimpinan Indonesia dalam kancah global untuk mewujudkan kepentingan nasional dan perdamaian dunia.\n8. Memulihkan kualitas demokrasi, menegakkan hukum dan HAM, memberantas korupsi tanpa tebang pilih, serta menyelenggarakan pemerintahan yang berpihak pada rakyat.");
        paslon1TextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(paslon1TextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(fotoPaslon1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fotoPaslon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(102, 204, 255));

        fotoPaslon2.setText("Prabowo");
        fotoPaslon2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        paslon2TextArea.setColumns(20);
        paslon2TextArea.setLineWrap(true);
        paslon2TextArea.setEditable(false);
        paslon2TextArea.setRows(5);
        paslon2TextArea.setText("Paslon 2\nCalon Presiden: Prabowo Subianto\nCalon Wakil Presiden: Gibran Rakabuming Raka\n\nVisi: Bersama Indonesia Maju Menuju Indonesia Emas 2045\nMisi:\n1. Memperkokoh ideologi Pancasila, demokrasi, dan hak asasi manusia (HAM).\n2. Memantapkan sistem pertahanan keamanan negara dan mendorong kemandirian bangsa melalui swasembada pangan, energi, air, ekonomi syariah, ekonomi digital, ekonomi hijau, dan ekonomi biru.\n3. Melanjutkan pengembangan infrastruktur dan meningkatkan lapangan kerja yang berkualitas, mendorong kewirausahaan, mengembangkan industri kreatif serta mengembangkan agro-maritim industri di sentra produksi melalui peran aktif koperasi.\n4. Memperkuat pembangunan sumber daya manusia (SDM), sains, teknologi, pendidikan, kesehatan, prestasi olahraga, kesetaraan gender, serta penguatan peran perempuan, pemuda (generasi milenial dan generasi Z), dan penyandang disabilitas.\n5. Melanjutkan hilirisasi dan mengembangkan industri berbasis sumber daya alam untuk meningkatkan nilai tambah di dalam negeri.\n6. Membangun dari desa dan dari bawah untuk pertumbuhan ekonomi, pemerataan ekonomi, dan pemberantasan kemiskinan.\n7. Memperkuat reformasi politik, hukum, dan birokrasi, serta memperkuat pencegahan dan pemberantasan korupsi, narkoba, judi, dan penyelundupan.\n8. Memperkuat penyelarasan kehidupan yang harmonis dengan lingkungan, alam dan budaya, serta peningkatan toleransi antarumat beragama untuk mencapai masyarakat yang adil dan makmur.");
        paslon2TextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(paslon2TextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(fotoPaslon2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(fotoPaslon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 0, 51));

        fotoPaslon3.setText("ganjar");
        fotoPaslon3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        paslon3TextArea.setColumns(20);
        paslon3TextArea.setLineWrap(true);
        paslon3TextArea.setEditable(false);
        paslon3TextArea.setRows(5);
        paslon3TextArea.setText("Paslon 3\nCalon Presiden: Ganjar Pranowo\nCalon Wakil Presiden: Mahfud MD\n\nVisi: Gerak Cepat Menuju Indonesia Unggul\nMisi:\n1. Manusia Indonesia yang sehat, terdidik, dan sejahtera.\n2. Indonesia unggul dalam bidang inovasi dan teknologi.\n3. Ekonomi yang tangguh dan berdikari.\n4. Hilangnya kemiskinan dan ketimpangan antarwilayah dari akarnya.\n5. Ekosistem digital yang mengutamakan akses internet cepat dan terjangkau.\n6. Pembangunan ekonomi yang memperhatikan kelestarian lingkungan.\n7. Demokrasi terjaga melalui pemberantasan korupsi dan pemerintahan inklusif berlandaskan supremasi hukum.\n8. Indonesia bangsa terhormat di kancah internasional, serta pertahanan yang tangguh dan modern");
        paslon3TextArea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(paslon3TextArea);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(fotoPaslon3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fotoPaslon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap())
        );

        voteNowButton.setText("Pilih Sekarang!");
        voteNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voteNowButtonActionPerformed(evt);
            }
        });

        paslonLabel.setText("PASANGAN CALON PRESIDEN DAN WAKIL PRESIDEN 2024");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(paslonLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(voteNowButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paslonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(voteNowButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      
    private void voteNowButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loginSession = countdown;
        new VoteJPanel().setVisible(true);
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
    
    private void stopCountdownThread() {
        isRunning = false; // Set flag isRunning menjadi false
        if (countdownThread != null && countdownThread.isAlive()) {
            try {
                countdownThread.join(); // Tunggu hingga thread countdown selesai
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        countdownThread = null; // Reset thread countdown
        isRunning = true;
    }
    
    private void startCountDown(){
        stopCountdownThread(); // Hentikan thread countdown jika sedang berjalan
        sessionTimeCountdownLabel.setText(countdown + " detik.");
        countdownThread = new Thread(() -> {
            while (countdown > 0 && isRunning) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                countdown--;
                SwingUtilities.invokeLater(() -> sessionTimeCountdownLabel.setText(countdown + " detik."));
            }
            JOptionPane.showMessageDialog(this, "Sesi Anda telah berakhir, silakan masuk kembali.");
            new Utama().setVisible(true);
            this.dispose();
        });
        countdownThread.start();
    }
    
    private void stopCountdownThread2() {
        isRunning2 = false; // Set flag isRunning menjadi false
        if (countdownThread2 != null && countdownThread2.isAlive()) {
            try {
                countdownThread2.join(); // Tunggu hingga thread countdown selesai
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        countdownThread2 = null; // Reset thread countdown
        isRunning2 = true;
    }
    
    private void startCountDown2(){
        stopCountdownThread2(); // Hentikan thread countdown jika sedang berjalan
        pemiluTimeHourLabel.setText(countdown2 + " Jam.");
        countdownThread2 = new Thread(() -> {
            while (countdown2 > 0 && isRunning2) {
                try {
                    Thread.sleep(3600000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                countdown2--;
                SwingUtilities.invokeLater(() -> pemiluTimeHourLabel.setText(countdown2 + " Jam."));
            }
            JOptionPane.showMessageDialog(this, "Pemilu telah selesai.");
            this.dispose();
        });
        countdownThread2.start();
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
            java.util.logging.Logger.getLogger(DashboardPemilih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardPemilih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardPemilih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardPemilih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardPemilih().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fotoPaslon1;
    private javax.swing.JLabel fotoPaslon2;
    private javax.swing.JLabel fotoPaslon3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea paslon1TextArea;
    private javax.swing.JTextArea paslon2TextArea;
    private javax.swing.JTextArea paslon3TextArea;
    private javax.swing.JLabel paslonLabel;
    private javax.swing.JLabel pemiluTimeHourLabel;
    private javax.swing.JLabel pemiluTimeLabel;
    private javax.swing.JLabel sessionTimeCountdownLabel;
    private javax.swing.JLabel sessionTimeLabel;
    private javax.swing.JButton voteNowButton;
    // End of variables declaration//GEN-END:variables
}
