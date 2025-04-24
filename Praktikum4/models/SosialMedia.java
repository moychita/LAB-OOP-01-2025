package Praktikum4.models;

import java.util.Random;

public class SosialMedia {
    private String platform;
    private String namaPengguna;
    private String otp;

    private String buatOtp() {
        Random acak = new Random();
        int kode = 100000 + acak.nextInt(900000);
        return String.valueOf(kode);
    }

    public boolean verifikasiOtp(String inputOtp) {
        return otp.equals(inputOtp);
    }

    public SosialMedia(String platform, String namaPengguna) {
        this.platform = platform;
        this.namaPengguna = namaPengguna;
        this.otp = buatOtp();
    }

    public String getPlatform() {
        return platform;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public String getOtp() {
        return otp;
    }

   
}

