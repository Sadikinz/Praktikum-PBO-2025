package Model;

public class konserNasional extends konser implements Diskon {

    public konserNasional(String namaKonser, String tempatKonser, String tanggal, int hargaTiket) {
        super(namaKonser, tempatKonser, tanggal, hargaTiket);
    }

    @Override
    public void lihatKonser() {
        System.out.println("\n[Konser Nasional] " + getNamaKonser());
        System.out.println("================================");
        System.out.println("Tempat Konser: " + getTempatKonser());
        System.out.println("Tanggal: " + getTanggal());
        System.out.println("Harga Tiket: " + getHargaTiket());
        System.out.println("================================");
    }
    
    @Override
    public int diskonTiket(int persen){
        return hargaTiket - (hargaTiket * persen / 100);
    }

}
