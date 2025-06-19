package Praktikum5;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        runApp();
    }

    private static void runApp(){
        System.out.println("Pilih Karakter : ");
        System.out.println("1. Archer");
        System.out.println("2. Widzhar");
        System.out.println("3. Fighter");
        System.out.print("Masukkan karkter : ");
        int pilihHero = sc.nextInt();
        sc.nextLine();

        Menu(pilihHero);
    }

    private static void Menu(int pilihHero) {
        Hero karakter;
    
        if (pilihHero == 1) {
            karakter = new Archer("Ussop", 100, 75);
        } else if (pilihHero == 2) {
            karakter = new Wizard("Chopper", 200, 50);
        } else if (pilihHero == 3) {
            karakter = new Fighter("Franky", 175, 100);
        } else {
            System.out.println("Pilihan karakter tidak valid!");
            return; 
        }
    
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            int pilihAksi = sc.nextInt();
    
            if (pilihAksi == 1) {
                karakter.attack(); 
            } else if (pilihAksi == 2) {
                System.err.println("Game selesai!");
                break;
            } else {
                System.out.println("Aksi tidak valid!");
            }
        }
    sc.close();  
    }
}