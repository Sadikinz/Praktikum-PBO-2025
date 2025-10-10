package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "konser")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "jenis_konser", discriminatorType = DiscriminatorType.STRING)
public abstract class konser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nama_konser")
    private String namaKonser;

    @Column(name = "tempat_konser")
    private String tempatKonser;

    private String tanggal;

    @Column(name = "harga_tiket")
    private double hargaTiket;

    public konser() {
    }

    public konser(String namaKonser, String tempatKonser, String tanggal, double hargaTiket) {
        this.namaKonser = namaKonser;
        this.tempatKonser = tempatKonser;
        this.tanggal = tanggal;
        this.hargaTiket = hargaTiket;
    }

    public int getId() {
        return id;
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

    public double getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(double hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    public abstract void lihatKonser();
}
