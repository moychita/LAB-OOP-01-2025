public class Product {

    String nama;
    int ID;
    double harga;
    int stok;

    Product(String nama, int ID, double harga, int stok) {
        this.nama = nama;
        this.ID = ID;
        this.harga = harga;
        this.stok = stok <= 0 ? 0 : stok;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    String getName() {
        return nama;
    }
    
    void setID(int ID) {
        this.ID = ID;
    }

    int getID() {
        return ID;
    }

    void setHarga(double harga) {
        this.harga = harga;
    }

    double getHarga() {
        return harga;
    }

    String formatHarga(double harga) {
        String fHarga = String.format("%,.0f", harga);
        return fHarga.replace(",", ".");

    }

    void setStok(int stok) {
        this.stok = stok <= 0 ? 0 : stok;
    }

    int getStok() {
        return stok;
    }

    boolean isTersedia() {
        return stok > 0;
    }

    void infoProduk() {
        System.out.println("========================================");
        System.out.println("Nama Produk  : " + nama);
        System.out.println("ID Produk    : " + ID);
        System.out.println("Harga Produk : " + formatHarga(harga));
        System.out.println("Stock Produk : " + stok);
        System.out.println("========================================");
        
        if(isTersedia()) {
            System.out.println(stok + " STOK PRODUK TERSEDIA!");
        } else {
            System.out.println("STOK PRODUK TIDAK TERSEDIA!");
        }
        System.out.println("========================================");

    }

    public static void main(String[] args) {
        
        Product laptop = new Product("Macbook M2",2, 16000000, -1);

        laptop.infoProduk();
    }
    
}
