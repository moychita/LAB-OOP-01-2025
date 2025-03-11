import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        try {
            int nomer = input.nextInt();

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == nomer) {
                        System.out.println("Found " + nomer + " at [" + i + "][" + j + "]");
                        input.close();
                        return;
                    }
                }
            }

            System.out.println("Angka " + nomer + " tidak ditemukan!");

        } catch (Exception e) {
            System.out.println("Input tidak valid!");
        }

        input.close();
    }
}