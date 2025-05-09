package Praktikum6;
public class Main {
    public static void main (String[] args){
        // KeretaApi keretafire = new KeretaApi("tutt tutt", "kereta malam");
        // keretafire.setJumlahGerbong(123);
        // keretafire.setAsal("Soffeng");
        // keretafire.setTujuan("Rumah");

        // keretafire.mulai();

        // keretafire.setKecepatan(300);
        // System.out.println("Kereta api dengan merek : " + keretafire.getMerek());
        // System.out.println("Kereta api dengan model : " + keretafire.getModel());
        // System.out.println("Asal : " + keretafire.getAsal());
        // System.out.println("Tujuan : " + keretafire.getTujuan());

        // keretafire.berhenti();
        Mobil mobil1 = new Mobil("Cacicu", "Terbang");
        mobil1.setKapasitasMesin(200);
        System.out.println("BALIK LAGI KESINI TANGGAL : " + mobil1.getWaktuServiceBerikutnya());
        System.out.println("PAJAK MOBIL INI : " + mobil1.hitungPajak());
    }
}
