package TypeRacer;

import java.util.ArrayList;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    // Bisa diganti sesuai keinginan masing-masing
    private String[] wordsToTypeList = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis porttitor, orci vel lacinia eleifend, odio ipsum pellentesque ante, vestibulum ornare nunc justo eu augue. Mauris vehicula consectetur magna et blandit. Nullam nulla ex, porta in velit in, eleifend congue massa. Cras maximus felis urna, sed molestie elit tempor ac. In sodales, dui ac consectetur pulvinar, metus enim sagittis tellus, a accumsan erat eros et odio. Nunc dapibus augue pharetra, dictum tortor sed, accumsan lectus. Cras feugiat laoreet sagittis. Aliquam quis."
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4)
    // Buat method addResult yang mana digunakan untuk menambahkan typer yang
    // telah selesai (mengetik semua kata), ke dalam list race standing.
    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5)
        // Tampilkan klasemen akhir dari kompetisi, dengan format
        // {posisi}. {nama} = {waktu penyelesaian dalam detik} detik
        // Urutkan berdasarkan waktu tercepat
        rareStanding.sort((a, b) -> Long.compare(a.getTimeTaken(), b.getTimeTaken()));
        int posisi = 1;
        for (Result result : rareStanding) {
            String nama = result.getTyper().getBotName();
            double waktuDetik = result.getTimeTaken() / 1000.0;
            System.out.printf("%d. %s = %d detik\n", posisi, nama, Math.round(waktuDetik));
            posisi++;
        }
    }

    public void startRace() {
        // TODO (6)
        // Jalankan kompetisi untuk tiap kontestan
        for (Typer typer : rareContestant) {
            typer.start();
        }
    }

    // TODO (7)
    // selama semua peserta belum selesai maka tampilkan typing progress-nya setiap
    // 2 detik, dengan format:
    // Typing Progress ...
    // ===================
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    // {nama kontestan} => {text yang telah dia ketik}
    public void displayRaceStandingPeriodically() throws InterruptedException {
        boolean allFinished = false;
        while (!allFinished) {
            System.out.println("\nTyping Progress ...");
            System.out.println("===================");
            for (Typer typer : rareContestant) {
                System.out.println(typer.getBotName() + " => " + typer.getWordsTyped());
            }
            Thread.sleep(2000);

            // Cek apakah semua sudah selesai (sudah ada "(Selesai)" di wordsTyped)
            allFinished = true;
            for (Typer typer : rareContestant) {
                if (!typer.getWordsTyped().contains("(Selesai)")) {
                    allFinished = false;
                    break;
                }
            }
        }

        // TODO (8)
        // Setelah semua typer selesai, tampilkan race standing setelah semua typer
        // selesai
        printRaceStanding();
    }
}
