package praktikum3;

public class DevilFruit {
    String nama;
    String kemampuan;
    double damage;

    public DevilFruit() {
        this.nama = "Gomu Gomu No Mi";
        this.kemampuan = "Tubuh Karet";
        this.damage = 47;
    }

    public DevilFruit(String nama, String kemampuan, double damage){
        this.nama = nama;
        this.kemampuan = kemampuan;
        this.damage = damage;
    }

    public String getKemapuan(){
        return kemampuan;
    }

    public double getDamage(){
        return damage;
    }

}


