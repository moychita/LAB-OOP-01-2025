package praktikum3;

public class Pirate {
    String nama;
    DevilFruit buahIblis;
    double health;
    Pirate rival;

    public Pirate() {
        this.nama = "Monkey D. Luffy";
        this.buahIblis = new DevilFruit();
        this.health = 100;
    }

    public Pirate(String nama, DevilFruit buahIblis, double health){
        this.nama = nama;
        this.buahIblis = buahIblis;
        this.health = health;
    }

    public void Serang(Pirate target){
        double damage = this.buahIblis.getDamage();
        target.health -= damage;
        System.out.println(this.nama + " menggunakan " + buahIblis.getKemapuan() + "! (damage " + damage + " HP)");
    }

    public void tampilkanStatus(){
        System.out.println("Nama: " + nama);
        System.out.println("Buah Iblis: " + buahIblis.getKemapuan());
        System.out.println("Health: " + health);
        if (rival != null) {
            System.out.println("Rival: " + rival.nama);
        }
    }

    public void setRival(Pirate rival) {
        this.rival = rival;
    }
    
    public String getNama() {
        return this.nama;
    }

    public double getHealth() {
        return this.health;
    }
}
