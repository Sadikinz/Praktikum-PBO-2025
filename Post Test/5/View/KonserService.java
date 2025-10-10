package View;

import Model.konser;
import Model.konserLokal;
import Model.konserNasional;
import jakarta.persistence.*;
import java.util.List;
import java.util.Scanner;

public class KonserService {

    private final Scanner key = new Scanner(System.in);
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("KonserPU");
    private final EntityManager em = emf.createEntityManager();

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
        double harga = key.nextDouble();
        key.nextLine();

        konser ksr;
        if (jenis == 1) {
            ksr = new konserLokal(nama, tempat, tanggal, harga);
        } else {
            ksr = new konserNasional(nama, tempat, tanggal, harga);
        }

        em.getTransaction().begin();
        em.persist(ksr);
        em.getTransaction().commit();

        System.out.println("Data konser berhasil ditambahkan!");
    }

    public void lihatSemua() {
        List<konser> daftar = em.createQuery("SELECT k FROM konser k", konser.class).getResultList();

        System.out.println("\n===== Daftar Semua Konser =====");
        for (konser k : daftar) {
            System.out.println("ID: " + k.getId());
            System.out.println("Nama: " + k.getNamaKonser());
            System.out.println("Tempat: " + k.getTempatKonser());
            System.out.println("Tanggal: " + k.getTanggal());
            System.out.println("Harga: Rp " + k.getHargaTiket());
            System.out.println("-----------------------------------");
        }
    }

    public void perbarui() {
        System.out.print("\nMasukkan ID konser yang ingin diperbarui: ");
        int id = key.nextInt();
        key.nextLine();

        konser ksr = em.find(konser.class, id);
        if (ksr == null) {
            System.out.println("Konser tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Nama Baru: ");
        ksr.setNamaKonser(key.nextLine());
        System.out.print("Masukkan Tempat Baru: ");
        ksr.setTempatKonser(key.nextLine());
        System.out.print("Masukkan Tanggal Baru: ");
        ksr.setTanggal(key.nextLine());
        System.out.print("Masukkan Harga Baru: ");
        ksr.setHargaTiket(key.nextDouble());
        key.nextLine();

        em.getTransaction().begin();
        em.merge(ksr);
        em.getTransaction().commit();

        System.out.println("Data konser berhasil diperbarui!");
    }

    public void hapus() {
        System.out.print("\nMasukkan ID konser yang ingin dihapus: ");
        int id = key.nextInt();
        key.nextLine();

        konser ksr = em.find(konser.class, id);
        if (ksr == null) {
            System.out.println("Konser tidak ditemukan!");
            return;
        }

        em.getTransaction().begin();
        em.remove(ksr);
        em.getTransaction().commit();

        System.out.println("Data konser berhasil dihapus!");
    }

    public void cariDataKonser() {
        System.out.print("\nMasukkan nama konser yang ingin dicari: ");
        String nama = key.nextLine();

        List<konser> hasil = em.createQuery(
                "SELECT k FROM konser k WHERE k.namaKonser LIKE :nama", konser.class)
                .setParameter("nama", "%" + nama + "%")
                .getResultList();

        if (hasil.isEmpty()) {
            System.out.println("Tidak ada konser dengan nama \"" + nama + "\".");
        } else {
            for (konser k : hasil) {
                System.out.println("ID: " + k.getId());
                System.out.println("Nama: " + k.getNamaKonser());
                System.out.println("Tempat: " + k.getTempatKonser());
                System.out.println("Tanggal: " + k.getTanggal());
                System.out.println("Harga: Rp " + k.getHargaTiket());
                System.out.println("-----------------------------------");
            }
        }
    }

    public void hitungDiskon() {
        System.out.print("\nMasukkan ID konser: ");
        int id = key.nextInt();
        key.nextLine();
        System.out.print("Masukkan diskon (%): ");
        double diskon = key.nextDouble();
        key.nextLine();

        konser ksr = em.find(konser.class, id);
        if (ksr == null) {
            System.out.println("Konser tidak ditemukan!");
            return;
        }

        double hargaAsli = ksr.getHargaTiket();
        double hargaAkhir = hargaAsli - (hargaAsli * (diskon / 100));

        System.out.println("\n===== Perhitungan Diskon =====");
        System.out.println("Nama Konser : " + ksr.getNamaKonser());
        System.out.println("Harga Asli  : Rp " + hargaAsli);
        System.out.println("Diskon " + diskon + "% : Rp " + (hargaAsli * (diskon / 100)));
        System.out.println("Harga Akhir : Rp " + hargaAkhir);
    }
}
