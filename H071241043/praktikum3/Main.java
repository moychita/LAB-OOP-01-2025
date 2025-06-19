package praktikum3;

public class Main {
    public static void main(String[] args) {
        DevilFruit mera = new DevilFruit("Mera Mera no Mi", "Api", 85);
        DevilFruit magu = new DevilFruit("Magu Magu no Mi", "Magma", 170);
        DevilFruit hie = new DevilFruit("Hie Hie no Mi", "Es", 165);

        Pirate ace = new Pirate("Portgas D. Ace", mera, 120);
        Pirate akainu = new Pirate("Admiral Akainu", magu, 150);
        Pirate aokiji = new Pirate("Aokiji", hie, 200);

        Battle duel = new Battle(ace, aokiji);
        duel.mulai();
    }
}