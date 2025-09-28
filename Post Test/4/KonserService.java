package View;

import Model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KonserService {
    private final ArrayList<konser> daftarKonser;
    private final Scanner key = new Scanner(System.in);

    public KonserService() {
        daftarKonser = new ArrayList<>();
    }

    public void lihat() {
        System.out.println("\n===== Daftar Data Konser =====");
        if (daftarKonser.isEmpty()) {
            System.out.println("Belum ada data konser.");
        } else {
            for (konser k : daftarKonser) {
                k.lihatKonser();
            }
        }
    }

    public void tambah() {
        System.out.println("\n===== Tambah Data Konser =====");
        System.out.println("1. Konser Lokal");
        System.out.println("2. Konser Nasional");
        System.out.print("Pilih jenis konser (1-2): ");
        int jenis = key.nextInt();
        key.nextLine();

        System.out.print("Masukkan Nama Konser: ");
        String nama = key.nextLine();
        System.out.print("Masukkan Tempat Konser: ");
        String tempat = key.nextLine();
        System.out.print("Masukkan Tanggal: ");
        String tanggal = key.nextLine();
        System.out.print("Masukkan Harga Tiket: ");
        int harga = key.nextInt();
        key.nextLine();

        konser kr;
        if (jenis == 1) {
            kr = new konserLokal(nama, tempat, tanggal, harga);
        } else {
            kr = new konserNasional(nama, tempat, tanggal, harga);
        }

        daftarKonser.add(kr);
        System.out.println("Data konser berhasil ditambahkan!");
    }

    public void tambah(konser kr) {
        daftarKonser.add(kr);
    }

    public void perbarui() {
        System.out.println("\n===== Perbarui Data Konser =====");
        System.out.print("Masukkan Nama Konser yang ingin diperbarui: ");
        String cari = key.nextLine();

        for (konser k : daftarKonser) {
            if (k.getNamaKonser().equalsIgnoreCase(cari)) {
                System.out.println("Konser ditemukan: " + cari);
                System.out.println("1. Nama Konser");
                System.out.println("2. Tempat Konser");
                System.out.println("3. Tanggal");
                System.out.println("4. Harga Tiket");
                System.out.print("Pilih data yang ingin diperbarui (1-4): ");
                int pilih = key.nextInt();
                key.nextLine();

                switch (pilih) {
                    case 1 -> {
                        System.out.print("Masukkan Nama Baru: ");
                        k.setNamaKonser(key.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Masukkan Tempat Baru: ");
                        k.setTempatKonser(key.nextLine());
                    }
                    case 3 -> {
                        System.out.print("Masukkan Tanggal Baru: ");
                        k.setTanggal(key.nextLine());
                    }
                    case 4 -> {
                        System.out.print("Masukkan Harga Tiket Baru: ");
                        k.setHargaTiket(key.nextInt());
                        key.nextLine();
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
                System.out.println("Data konser berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Konser tidak ditemukan.");
    }

    public void hapus() {
        System.out.println("\n===== Hapus Data Konser =====");
        System.out.print("Masukkan Nama Konser yang ingin dihapus: ");
        String cari = key.nextLine();

        for (konser k : daftarKonser) {
            if (k.getNamaKonser().equalsIgnoreCase(cari)) {
                daftarKonser.remove(k);
                System.out.println("Data konser berhasil dihapus!");
                return;
            }
        }
        System.out.println("Konser tidak ditemukan.");
    }

    public void search() {
        System.out.println("\n===== Cari Data Konser =====");
        System.out.print("Masukkan Nama Konser: ");
        String cari = key.nextLine();

        for (konser k : daftarKonser) {
            if (k.getNamaKonser().equalsIgnoreCase(cari)) {
                System.out.println("Konser ditemukan!");
                k.lihatKonser();
                return;
            }
        }
        System.out.println("Konser tidak ditemukan.");
    }
    
    public void diskon() {
    System.out.println("\n===== Hitung Diskon Tiket =====");
    System.out.print("Masukkan Nama Konser: ");
    String cari = key.nextLine();

    for (konser k : daftarKonser) {
        if (k.getNamaKonser().equalsIgnoreCase(cari) && k instanceof Diskon diskon) {
            System.out.print("Masukkan Persentase Diskon: ");
            int persen = key.nextInt();
            key.nextLine();
            int hargaDiskon = diskon.diskonTiket(persen);
            System.out.println("Harga setelah diskon: " + hargaDiskon);
            return;
        }
    }
    System.out.println("Konser tidak ditemukan.");
}
}
