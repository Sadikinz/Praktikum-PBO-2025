package Control;

import View.KonserService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KonserService service = new KonserService();
        Scanner key = new Scanner(System.in);
        boolean jalan = true;

        while (jalan) {
            System.out.println("\n===== Menu Konser (ORM) =====");
            System.out.println("1. Lihat Daftar Konser");
            System.out.println("2. Tambah Data Konser");
            System.out.println("3. Perbarui Data Konser");
            System.out.println("4. Hapus Data Konser");
            System.out.println("5. Cari Data Konser");
            System.out.println("6. Hitung Diskon Tiket");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");
            int pilih = key.nextInt();
            key.nextLine();

            switch (pilih) {
                case 1 -> service.lihatSemua();
                case 2 -> service.tambah();
                case 3 -> service.perbarui();
                case 4 -> service.hapus();
                case 5 -> service.cariDataKonser();
                case 6 -> service.hitungDiskon();
                case 7 -> {
                    System.out.println("Terima kasih telah menggunakan Program KonserKu!");
                    jalan = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }

        key.close();
    }
}
