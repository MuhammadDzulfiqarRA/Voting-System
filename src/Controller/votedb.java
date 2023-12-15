package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VoteDB {
    private static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/votedb", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam koneksi database: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void vote(String nama, int umurFromDatabase, String nik, int nomorUrut) {
        try {
            // Cek login
            if (checkLogin(nik, "")) {
                // Cek apakah nik sudah terdaftar di tabel 'masuk'
                if (isNikRegistered(nik)) {
                    // Cek umur pengguna
                    if (umurFromDatabase < 17) {
                        JOptionPane.showMessageDialog(null, "Tidak bisa melakukan voting - Umur tidak mencukupi");
                    } else {
                        // Cek apakah nik sudah memilih sebelumnya
                        if (!hasVoted(nik)) {
                            // Lakukan proses voting
                            String insertVoteQuery = "UPDATE pemilih SET vote_number = ? WHERE nik = ?";
                            try (PreparedStatement insertVoteStatement = conn.prepareStatement(insertVoteQuery)) {
                                insertVoteStatement.setInt(1, nomorUrut);
                                insertVoteStatement.setString(2, nik);
                                insertVoteStatement.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Terima kasih atas partisipasi Anda!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Anda sudah memilih. Tidak dapat memilih lagi.");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak terverifikasi - NIK tidak terdaftar di 'masuk'");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan dalam koneksi database: " + e.getMessage());
        }
    }

    private static boolean checkLogin(String nik, String nama) throws SQLException {
        // Query untuk memeriksa keberadaan nik dan nama pada tabel masuk
        String query = "SELECT * FROM pemilih WHERE nik = ? AND nama = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, nik);
            preparedStatement.setString(2, nama);

            // Eksekusi query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Jika hasil query mengandung baris, maka username dan password benar
            return resultSet.next();
        }
    }

    private static boolean isNikRegistered(String nik) throws SQLException {
        String query = "SELECT * FROM pemilih WHERE nik = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, nik);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    private static boolean hasVoted(String nik) throws SQLException {
        String query = "SELECT * FROM pemilih WHERE nik = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, nik);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}
