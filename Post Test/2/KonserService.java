package View;

import Model.model;
import java.util.ArrayList;
import java.util.Scanner;

public class KonserService {
    String cari;
    int pilih;
    boolean ketemu = false;
    
    Scanner key = new Scanner(System.in);
    private final ArrayList<model> daftarKonser;
    
    public KonserService() {
        daftarKonser = new ArrayList<>();
    }
    
    public void lihat(){
        System.out.println("\n===== Daftar DataKonser");
        for(model k : daftarKonser) {
            k.lihatKonser();
            System.out.println();
        }
    }
    
    public void tambah(){
        model kr = new model();
        System.out.println("\n ===== Tambah Data Konser =====");
        System.out.print("Masukkan Nama Konser: ");
        kr.setNamaKonser(key.nextLine());
        
        System.out.print("Masukkan Tempat Konser: ");
        kr.setTempatKonser(key.nextLine());
        
        System.out.print("Masukkan Tanggal: ");
        kr.setTanggal(key.nextLine());
        
        System.out.print("Masukkan Harga Tiket: ");
        kr.setHargaTiket(key.nextInt());
        key.nextLine();
        
        daftarKonser.add(kr);
        
        System.out.println("\nData Konser Berhasil Disimpan!");
    }
    
    public void tambah(model kr){
        daftarKonser.add(kr);
    }
    
    public void perbarui(){
        System.out.println("\n ===== Perbarui Data Konser =====");
        System.out.print("Masukkan Nama Konser ang Ingin Diperbarui: ");
        cari = key.nextLine();
        
        for (model k : daftarKonser) {
            if(k.getNamaKonser().equalsIgnoreCase(cari)) {
                System.out.println(cari + " Tersedia");
                System.out.println("Pilih Yang Ingin Diperbarui");
                System.out.println("1. Nama Konser");
                System.out.println("2. Tempat Konser");
                System.out.println("3. Tanggal");
                System.out.println("4. Harga Tiket");
                System.out.print("Masukkan Pilihan (1-4): ");
                pilih = key.nextInt();
                key.nextLine();
                
                switch(pilih)  {
                   case 1 -> {
                       System.out.print("Masukkan Nama Baru: ");
                       k.setNamaKonser(key.nextLine());
                       break;
                    }
                    case 2 -> {
                       System.out.print("Masukkan Tempat Baru: ");
                       k.setTempatKonser(key.nextLine());
                       break;
                    }
                    case 3 -> {
                       System.out.print("Masukkan Tanggal Baru: ");
                       k.setTanggal(key.nextLine());
                       break;
                    }
                    case 4 -> {
                       System.out.print("Masukkan Harga Tiket Baru: ");
                       k.setHargaTiket(key.nextInt());
                       break;
                    }
                    default ->{
                        System.out.println("Pilihan Tidak Valid, Coba Lagi");
                    }
               }
                System.out.println("Data Konser \"" + cari + "\" Berhasil Diperbarui!");
                return;
            }
        }
        System.out.println("Konser \"" + cari + "\" Tidak Ditemukan");
    }
    
    public void hapus(){
        System.out.println("\n===== Hapus Data Konser =====");
        System.out.print("Masukkan Nama Konser Yang Ingin Dihapus: ");
        cari = key.nextLine();
         
        for (model k : daftarKonser) {
             if (k.getNamaKonser().equalsIgnoreCase(cari)) {
                 daftarKonser.remove(k);
                 System.out.println("Konser \"" + cari + "\" Berhasil Dihapus!");
                 return;
             }
        }
        System.out.println("Konser \"" + cari + "\" Tidak Ditemukan");
     }
     
    public void search() {
        System.out.println("\n===== Cari Data Konser =====");
        System.out.print("Masukkan Nama Konser Yang Ingin Dicari: ");
        cari = key.nextLine();
         
        for (model k : daftarKonser) {
            if (k.getNamaKonser().equalsIgnoreCase(cari)) {
                System.out.println("Konser Berhasil Ditemukan");
                k.lihatKonser();
                ketemu = true;
                break;
            }
        }
        if (!ketemu)
            System.out.println("Konser \"" + cari + "\" Tidak Ditemukan");
    }
}

