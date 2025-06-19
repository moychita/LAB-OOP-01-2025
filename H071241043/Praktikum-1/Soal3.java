import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] format = input.nextLine().split("-");
        // String[] format = tanggal.split("-");
        String hasil = format[0] + " ";
        input.close();
        switch(format[1]){
            case "01" : hasil += "Januari "; break;
            case "02" : hasil += "Februari "; break;
            case "03" : hasil += "Maret "; break;
            case "04" : hasil += "April "; break;
            case "05" : hasil += "Mei "; break;
            case "06" : hasil += "Juni "; break;
            case "07" : hasil += "Juli "; break;
            case "08" : hasil += "Agustus "; break;
            case "09" : hasil += "September "; break;
            case "10" : hasil += "Oktober "; break;
            case "11" : hasil += "November "; break;
            case"12" : hasil += "Desember "; break;
            default: hasil = "Inputan Tidak Valid"; break;
        }
        int tahun = Integer.valueOf(format[2]);
        if (tahun >= 0 && tahun <= 25){
            hasil += 2000 + tahun;
        } else if (tahun >= 26 && tahun <= 99){
            hasil += 1900 + tahun;
        } else {

        }
        System.out.println(hasil);
    }
}