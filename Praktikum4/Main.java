package Praktikum4;

import java.util.ArrayList;
import java.util.Scanner;
import Praktikum4.models.Profile;
import Praktikum4.models.User;
import Praktikum4.utils.StringUtils;
import Praktikum4.models.SosialMedia;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static ArrayList<SosialMedia> listSosialMedia = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            runApp();
        }
    }

    private static void runApp() {
        System.out.println("\n-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        int selectMenu = sc.nextInt();
        sc.nextLine();

        switch (selectMenu) {
            case 1 -> showLoginMenu();
            case 2 -> showRegisterMenu();
            default -> {
                System.out.println("Pilihan tidak tersedia!");
            }
        }
    }

    private static void showLoginMenu() {
        System.out.println("\n-------------------------");
        System.out.println("LOGIN");

        System.out.print("Masukkan Username: ");
        String usernameInput = sc.nextLine();


        for (int i = 0; i < listSosialMedia.size(); i++) {
            SosialMedia sm = listSosialMedia.get(i);
            if (sm.getNamaPengguna().equalsIgnoreCase(usernameInput)) {
                System.out.println("Akun ditemukan sebagai akun sosial media.");
                System.out.println("Platform: " + sm.getPlatform());
                System.out.println("Kode OTP: " + sm.getOtp());
                System.out.print("Masukkan OTP: ");
                String inputOtp = sc.nextLine();

                if (sm.verifikasiOtp(inputOtp)) {
                    System.out.println("Login berhasil via " + sm.getPlatform());
                    showDetailUser(listUserProfile.get(i));
                } else {
                    System.out.println("OTP salah!");
                }
                return;
            }
        }

       
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equalsIgnoreCase(usernameInput)) {
                System.out.println("Akun terdeteksi sebagai akun biasa.");
                System.out.print("Masukkan Password: ");
                String passwordInput = sc.nextLine();

                if (listUser.get(i).getPassword().equals(passwordInput)) {
                    System.out.println("Login berhasil.");
                    showDetailUser(listUserProfile.get(i));
                } else {
                    System.out.println("Password salah!");
                }
                return;
            }
        }

        System.out.println("Username tidak ditemukan.");
    }

    private static void showRegisterMenu() {
        System.out.println("\n-------------------------");
        System.out.println("REGISTER");

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = new User(username, password);

        System.out.print("Nama Lengkap: ");
        String fullName = sc.nextLine();
        System.out.print("Umur: ");
        int age = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Hobby: ");
        String hobby = sc.nextLine();

        Profile profile = new Profile();
        profile.setNamaLengkap(fullName);
        profile.setUmur(age);
        profile.setHobby(hobby);
        profile.setNamaPanggilan(StringUtils.buatNick(fullName));

        System.out.println("\nTambahkan akun sosial media:");
        System.out.print("Platform: ");
        String platform = sc.nextLine();
        System.out.print("Username Sosmed: ");
        String usernameSosmed = sc.nextLine();

        SosialMedia sm = new SosialMedia(platform, usernameSosmed);

        listUser.add(user);
        listUserProfile.add(profile);
        listSosialMedia.add(sm);

        System.out.println("\n-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("\n-------------------------");
        System.out.println("Detail User");
        System.out.println("Nama Lengkap : " + profile.getNamaLengkap());
        System.out.println("Nickname     : " + profile.getNamaPanggilan());
        System.out.println("Umur         : " + profile.getUmur());
        System.out.println("Hobby        : " + profile.getHobby());
    }
}