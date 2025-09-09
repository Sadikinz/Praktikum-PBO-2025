// Muhammad Sadikin Samir
// 2409116031 
// Sistem Informasi A

package com.mycompany.postTest1;

import java.util.ArrayList;
import java.util.Scanner;

public class Konserseru {
    
    public String namaKonser, tempatKonser, tanggal;
    public int hargaTiket;
    
    static int menuPilih;
    public static boolean loop = true;

    static ArrayList <Konserseru> daftarKonser = new ArrayList<>();
    static Scanner key = new Scanner(System.in);
    
    public Konserseru(String namaKonser, String tempatKonser, String tanggal, int hargaTiket){
        this.namaKonser = namaKonser;
        this.tempatKonser = tempatKonser;
        this.tanggal = tanggal;
        this.hargaTiket = hargaTiket;
    }
    

    public static void main(String[] args) {        
        daftarKonser.add(new Konserseru("Pestapora", "jakarta", "7 - 9 September 2025", 225000));
        daftarKonser.add(new Konserseru("Smaland", "Samarinda", "3 Mei 2025", 160000));
        daftarKonser.add(new Konserseru("One For All", "^amarinda", "17-07-09", 50000));

        while(loop){
            System.out.println("\n===== Manajemen Event Konser =====");
            System.out.println("1. LIHAT JADWAL KONSER =====");
            System.out.println("2. TAMBAH JADWAL KONSER =====");
            System.out.println("3. PERBARUI JADWAL KONSER -=====");
            System.out.println("4. HAPUS JADWAL KONSER =====");
            System.out.println("5. KELUAR =============");
            System.out.println("====================================");
            System.out.println("\nPILIH MENU (1-5)");
            menuPilih = key.nextInt();
            key.nextLine();

            switch(menuPilih){
                case 1 -> {
                    for (Konserseru knsr :daftarKonser){
                        System.out.println("\n============================"); 
                        System.out.println("Nama: " + knsr.namaKonser);
                        System.out.println("Tempat: " + knsr.tempatKonser);
                        System.out.println("Tanggal: " + knsr.tanggal);
                        System.out.println("Harga: Rp " + knsr.hargaTiket);
                        System.out.println("============================="); 
            } 
                }
                case 2 -> {
                    System.out.println("\n===== TAMBAH JADWAL KONSER =====");

                    System.out.println("Masukkan Nama Konser: ");
                    String namaKonser = key.nextLine();

                    System.out.println("Masukkan Tempat Konser: ");
                    String tempatKonser = key.nextLine();

                    System.out.println("Masukkan Tanggal Pelaksanaan: ");
                    String tanggal = key.nextLine();

                    System.out.println("Masukkan Harga Tiket: ");
                    int hargaTiket = key.nextInt();
                    key.nextLine();
                    
                    Konserseru konser = new Konserseru(namaKonser, tempatKonser, tanggal, hargaTiket);
                    
                    daftarKonser.add(konser);
                    
                    System.out.println("\n==== Jadwal konser berhasil ditambahkan ====");

                }
                case 3 -> {
                    System.out.println("\n===== PERBARUI JADWAL KONSER =====");
                    if (daftarKonser.isEmpty()){
                        System.out.println("Tidak ada jadwal konser");
                    }else {
                        int index = 1;
                        for(Konserseru knsr : daftarKonser) {
                            System.out.println("\n============================"); 
                            System.out.println("Nama: " + knsr.namaKonser);
                            System.out.println("Tempat: " + knsr.tempatKonser);
                            System.out.println("Tanggal: " + knsr.tanggal);
                            System.out.println("Harga: Rp " + knsr.hargaTiket);
                            System.out.println("============================="); 
                            index++;
                        }

                        System.out.println("Pilih No Konser yang ingin diperbarui: ");
                        int ubah = key.nextInt();
                        key.nextLine();

                        if (ubah > 0 && ubah <= daftarKonser.size()) {
                            Konserseru baru = daftarKonser.get(ubah - 1);

                            System.out.println("Perbarui nama konser: ");
                            baru.namaKonser = key.nextLine();

                            System.out.println("Perbarui tempat konser: ");
                            baru.tempatKonser = key.nextLine();

                            System.out.println("Perbarui tanggal konser: ");
                            baru.tanggal = key.nextLine();

                            System.out.println("Perbarui harga tiket konser: ");
                            baru.hargaTiket = key.nextInt();
                            key.nextLine();

                            System.out.println("\n==== Jadwal konser berhasil diperbarui ====");
                        } else {
                            System.out.println("Nomor konser tidak valid");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("\n===== HAPUS JADWAL KONSER =====");
                    if (daftarKonser.isEmpty()) {
                        System.out.println("Tidak ada jadwal konser");
                    } else {
                        int index = 1;
                        for (Konserseru knsr : daftarKonser) {
                            System.out.println(index + ". " + knsr.namaKonser + " - " + knsr.tempatKonser);
                            index++;
                        }
                        System.out.print("Pilih Nomor Konser yang ingin dihapus: ");
                        int hapus = key.nextInt();
                        key.nextLine();

                        if (hapus > 0 && hapus <= daftarKonser.size()) {
                            Konserseru dihapus = daftarKonser.remove(hapus - 1); // hapus berdasarkan index
                            System.out.println("==== Jadwal konser \"" + dihapus.namaKonser + "\" berhasil dihapus ====");
                        } else {
                            System.out.println("Nomor konser tidak valid");
                        }
                    }
                }
                case 5 -> {
                    System.out.println("\n===== Terimakasih telah menggunakan program! =====");
                    loop = false;
                }
            }
        }
    }       
}
