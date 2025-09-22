package Model;

public class konser {
    public String namaKonser,tempatKonser,tanggal;
    public int hargaTiket;
    
    public  konser(){   
    }

    public konser(String namaKonser, String tempatKonser, String tanggal, int hargaTiket) {
    this.namaKonser = namaKonser;
    this.tempatKonser = tempatKonser;
    this.tanggal = tanggal;
    this.hargaTiket = hargaTiket;
    }
    
    public String getNamaKonser() {
        return namaKonser;
    }

    public void setNamaKonser(String namaKonser) {
        this.namaKonser = namaKonser;
    }

    public String getTempatKonser() {
        return tempatKonser;
    }

    public void setTempatKonser(String tempatKonser) {
        this.tempatKonser = tempatKonser;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(int hargaTiket) {
        this.hargaTiket = hargaTiket;
    }
    
    public void lihatKonser(){
        System.out.println("\n" + namaKonser);
        System.out.println("================================");
        System.out.println("Tempat Konser: " + tempatKonser);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Harga TIket: " + hargaTiket);
        System.out.println("================================");
    }
}