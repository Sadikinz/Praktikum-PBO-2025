package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/konser";
    private static final String USER = "root";
    private static final String PASS = ""; 

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Koneksi berhasil ke " + URL);
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver MySQL tidak ditemukan! Pastikan dependensi ada di pom.xml");
        } catch (SQLException e) {
            System.out.println("❌ Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }
}
