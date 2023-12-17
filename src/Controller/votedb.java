package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import voting.LoginPemilih;
import voting.Paslon;
import voting.LoginAdmin;

public class VoteDB {
    private Connection conn;
    
    public VoteDB(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting", "root", "");
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam koneksi database: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
    
    public boolean verifikasiNikDanUmur(String nik, String nama) {
        String queryMasuk = "SELECT * FROM pemilih WHERE nik = ? AND nama = ?";
        try (PreparedStatement masukStatement = conn.prepareStatement(queryMasuk)) {
            masukStatement.setString(1, nik);
            masukStatement.setString(2, nama);
            try (ResultSet masukResultSet = masukStatement.executeQuery()) {
                if (masukResultSet.next()) {
                    // Data ditemukan di tabel 'masuk', lanjutkan verifikasi umur pada tabel 'votdb'
                    String queryVotdb = "SELECT umur FROM pemilih WHERE nik = ?";
                    try (PreparedStatement votdbStatement = conn.prepareStatement(queryVotdb)) {
                        votdbStatement.setString(1, nik);
                        try (ResultSet votdbResultSet = votdbStatement.executeQuery()) {
                            if (votdbResultSet.next()) {
                                // Verifikasi umur
                                if (votdbResultSet.getInt("umur") < 17) {
                                    JOptionPane.showMessageDialog(null, "Tidak bisa melakukan voting - Umur tidak mencukupi");
                                    return false;
                                } else {
                                    String selectQuery = "SELECT vote_number FROM pemilih WHERE nik = ?";
                                    LoginPemilih.user.setNama(nama);
                                    LoginPemilih.user.setNik(nik);
                                    LoginPemilih.user.setUmur(votdbResultSet.getInt("umur"));
                                    try (PreparedStatement selectStatement = conn.prepareStatement(selectQuery)){
                                        selectStatement.setString(1, nik);
                                        try (ResultSet resultSet = selectStatement.executeQuery()){
                                            if(resultSet.next()){
                                                if(resultSet.getInt("vote_number") == 0){
                                                    return true;
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Anda sudah memilih. Tidak dapat masuk lagi.");
                                                }
                                                
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Gagal mengeksekusi query.");
                                            }
                                        } catch (Exception e) {
                                            // TODO: handle exception
                                        }
                                    } catch (Exception e) {
                                        // TODO: handle exception
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Data umur tidak ditemukan untuk NIK ini");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak terverifikasi - Nama atau NIK tidak terdaftar di 'masuk'");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam koneksi database: " + e.getMessage());
        }
        return false;
    }

    public void vote(String nama, int umur, String nik, Paslon paslon, int nomorUrut) {
        try {
            // Lakukan proses voting
            String updVoteQuery = "UPDATE pemilih SET vote_number = ? WHERE nik = ?";
            try (PreparedStatement updVoteStatement = conn.prepareStatement(updVoteQuery)) {
                updVoteStatement.setInt(1, nomorUrut);
                updVoteStatement.setString(2, nik);
                updVoteStatement.executeUpdate();
                LoginPemilih.user.setVoteNumber(nomorUrut);
                JOptionPane.showMessageDialog(null, "Terima kasih atas partisipasi Anda!");    
            }
            String updateVoteQuery = "UPDATE paslon SET jumlah_vote = ? WHERE nomor_urut = ?";
            try (PreparedStatement updateVoteStatement = conn.prepareStatement(updateVoteQuery)) {
                String getVoteQuery = "SELECT jumlah_vote FROM paslon WHERE nomor_urut = ?";
                try (PreparedStatement getVoteStatement = conn.prepareStatement(getVoteQuery)){
                    getVoteStatement.setInt(1, nomorUrut);
                    try (ResultSet getVoteResultSet = getVoteStatement.executeQuery()) {
                        if (getVoteResultSet.next()) {
                            int vote_count = getVoteResultSet.getInt("jumlah_vote");
                            updateVoteStatement.setInt(2, nomorUrut);
                            updateVoteStatement.setInt(1, vote_count+1);
                            updateVoteStatement.executeUpdate();
                            paslon.setVoteNumber(vote_count);
                        }
                    }
                }
                        
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam koneksi database: " + e.getMessage());
        }
    }
    
    public void getPaslonVoteCount(Paslon paslon, int nomor_urut){
        String selectQuery = "SELECT jumlah_vote FROM paslon WHERE nomor_urut = ?";
        try (PreparedStatement paslonStatement = conn.prepareStatement(selectQuery)){
            paslonStatement.setInt(1, nomor_urut);
            try (ResultSet resultSet = paslonStatement.executeQuery()){
                if (resultSet.next()){
                    paslon.setVoteNumber(resultSet.getInt("jumlah_vote"));
                }
            } catch (Exception e) {
                
            }
        } catch (Exception e) {
            
        }
    }
    
    public boolean checkLoginAdmin(String username, String password) {
        try {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                LoginAdmin.admin.setUsername(username);
                LoginAdmin.admin.setPassword(password);
                // Eksekusi query
                ResultSet resultSet = preparedStatement.executeQuery();
                
                // Jika hasil query mengandung baris, maka username dan password benar
                return resultSet.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam koneksi database: " + e.getMessage());
            return false;
        }
    }
}
