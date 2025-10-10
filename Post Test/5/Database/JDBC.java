package Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    public void tampilDataKonser() {
        try (Connection conn = Koneksi.getConnection()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM konser";
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n===== Data Konser dari Database =====");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nama Konser   : " + rs.getString("nama_konser"));
                System.out.println("Tempat Konser : " + rs.getString("tempat_konser"));
                System.out.println("Tanggal       : " + rs.getString("tanggal"));
                System.out.println("Harga Tiket   : " + rs.getInt("harga_tiket"));
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }
}
