package Control;

import View.KonserService;
import Model.model;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean jalan = true;
        
        KonserService kr = new KonserService();
        try (Scanner key = new Scanner(System.in)) {
            kr.tambah(new model("Smaland", "Kadrie Oening", "23 Desember 2025", 150000));
            kr.tambah(new model("Pestapora", "GBK", "7-10 September", 200000));
            kr.tambah(new model("Stacas", "Gor 27 September Unmul", "27 Agustus 2025", 150000));
                      
            while (jalan) {
                System.out.println("\n===== Daftar Menu KonserKu =====");
                System.out.println("1. Lihat Daftar Konser");
                System.out.println("2. Tambah Daftar Data Konser");
                System.out.println("3. Perbarui Daftar Data Konser");
                System.out.println("4. Hapus Daftar Data Konser");
                System.out.println("5. Cari Daftar Data Konser");
                System.out.println("6. Keluar");
                System.out.print("Pilih Mennu (1-6): ");
                int pilih_menu = key.nextInt();
                key.nextLine();
                
                switch(pilih_menu) {
                    case 1 -> kr.lihat();
                    case 2 -> kr.tambah();
                    case 3 -> kr.perbarui();
                    case 4 -> kr.hapus();
                    case 5 -> kr.search();
                    case 6 -> {
                        jalan = false;
                        System.out.println("Terimakasih Telah Menggunakan Program KonserKu");
                    }
                    default -> System.out.println("Pilihan Tidak Valid, Silahkan Coba Lagi.");
                    
                }
            }
        }
    }
}
