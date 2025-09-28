package Control;

import View.KonserService;
import Model.konserLokal;
import Model.konserNasional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean jalan = true;
        KonserService kr = new KonserService();

        kr.tambah(new konserLokal("Smaland", "Kadrie Oening", "23 Desember 2025", 150000));
        kr.tambah(new konserNasional("Pestapora", "GBK", "7-10 September", 500000));
        kr.tambah(new konserLokal("Stacas", "GOR 27 September Unmul", "27 Agustus 2025", 150000));

        try (Scanner key = new Scanner(System.in)) {
            while (jalan) {
                System.out.println("\n===== Daftar Menu KonserKu =====");
                System.out.println("1. Lihat Daftar Konser");
                System.out.println("2. Tambah Data Konser");
                System.out.println("3. Perbarui Data Konser");
                System.out.println("4. Hapus Data Konser");
                System.out.println("5. Cari Data Konser");
                System.out.println("6. Hitung Diskon Tiket");
                System.out.println("7. Keluar");
                System.out.print("Pilih menu (1-7): ");
                int pilih = key.nextInt();
                key.nextLine();
                
                switch (pilih) {
                    case 1 -> kr.lihat();
                    case 2 -> kr.tambah();
                    case 3 -> kr.perbarui();
                    case 4 -> kr.hapus();
                    case 5 -> kr.search();
                    case 6 -> kr.diskon();
                    case 7 -> {
                        jalan = false;
                        System.out.println("Terima kasih telah menggunakan KonserKu!");
                    }
                    default -> System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }
}
