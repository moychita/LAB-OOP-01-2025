package praktikum3;

public class Battle {
    private Pirate pirate1;
    private Pirate pirate2;

    public Battle(Pirate pirate1, Pirate pirate2) {
        this.pirate1 = pirate1;
        this.pirate2 = pirate2;
        pirate1.setRival(pirate2);
        pirate2.setRival(pirate1);
    }

    public void mulai() {
        System.out.println("Pertarungan dimulai antara " + pirate1.getNama() + " dan " + pirate2.getNama());
        int ronde = 1;

        while (pirate1.getHealth() > 0 && pirate2.getHealth() > 0) {
            System.out.println("\n=== Ronde " + ronde + " ===");
            pirate1.Serang(pirate2);
            if (pirate2.getHealth() <= 0) break;
            pirate2.Serang(pirate1);
            ronde++;
        }

        System.out.println("\nPertarungan selesai!");
        if (pirate1.getHealth() <= 0 && pirate2.getHealth() <= 0) {
            System.out.println("Seri! Keduanya tumbang bersamaan!");
        } else if (pirate1.getHealth() > 0) {
            System.out.println("Pemenang: " + pirate1.getNama());
        } else {
            System.out.println("Pemenang: " + pirate2.getNama());
        }

        System.out.println("\nSTATUS AKHIR:");
        pirate1.tampilkanStatus();
        System.out.println();
        pirate2.tampilkanStatus();
    }
}

