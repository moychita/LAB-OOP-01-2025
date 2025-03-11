import java.util.Random;
import java.util.Scanner;

public class Soal2v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] nums = new int[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                nums[i][j] = random.nextInt(9) + 1;

        try {
            System.out.print("Masukkan angka yang ingin dicari: ");
            String input = scanner.nextLine();
            int target = Integer.parseInt(input);
            boolean found = false;
            for (int i = 0; i < 3 && !found; i++)
                for (int j = 0; j < 3; j++)
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }

            if (!found) System.out.println("Angka tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Input tidak valid! Masukkan angka saja.");
        } finally {
            scanner.close();
        }
    }
}