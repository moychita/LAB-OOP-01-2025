import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("masukkan bilangan : ");
        int a = input.nextInt();
        
        if (a < 0) {
            System.out.println("masukkan bilangan positif!");
        } else {
            System.out.println("Hasil faktorial : " + faktorial(a));
        }
        
        input.close(); 
    }

    public static int faktorial(int a) {
        if (a == 0 || a == 1) {
            return 1;
        } else {
            return a * faktorial(a - 1);
        }
    
    }
}