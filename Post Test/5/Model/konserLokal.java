package Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Lokal")
public class konserLokal extends konser implements Diskon {

    public konserLokal() {
        super(); 
    }

    public konserLokal(String namaKonser, String tempatKonser, String tanggal, double hargaTiket) {
        super(namaKonser, tempatKonser, tanggal, hargaTiket);
    }

    @Override
    public void lihatKonser() {
        System.out.println("\n[Konser Lokal] " + getNamaKonser());
        System.out.println("Tempat: " + getTempatKonser());
        System.out.println("Tanggal: " + getTanggal());
        System.out.println("Harga Tiket: Rp " + getHargaTiket());
    }

    @Override
    public int diskonTiket(int persen) {
        return (int) (getHargaTiket() - (getHargaTiket() * persen / 100));
    }
}
