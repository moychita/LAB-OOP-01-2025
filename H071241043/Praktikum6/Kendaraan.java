package Praktikum6;

public abstract class Kendaraan {
    String id;
    String merek;
    String model;
    int tahunProduksi;
    String warna;
    String tipeKendaraan;

    public Kendaraan (String merek, String model){
        this.merek = merek;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public String gettWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public double hitungPajak(double nilaiJual, int kepemilikanKe) {
        double tarif = 0.02;
        if (kepemilikanKe == 2) {
            tarif = 0.025;
        } else if (kepemilikanKe >= 3) {
            tarif = 0.03;
        }
        double swdkllj = 143000;
        return (tarif * nilaiJual) + swdkllj;
    }

    public String getTipeKendaraan() {
        return tipeKendaraan;
    }
}
