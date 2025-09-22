package Model;

public class konserLokal extends konser {

    public konserLokal(String namaKonser, String tempatKonser, String tanggal, int hargaTiket) {
        super(namaKonser, tempatKonser, tanggal, hargaTiket);
    }

    @Override
    public void lihatKonser() {
        System.out.println("\n[Konser Lokal] " + getNamaKonser());
        System.out.println("================================");
        System.out.println("Tempat Konser: " + getTempatKonser());
        System.out.println("Tanggal: " + getTanggal());
        System.out.println("Harga Tiket: " + getHargaTiket());
        System.out.println("================================");
    }
}
