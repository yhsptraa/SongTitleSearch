import com.data.SongTitle;
import com.service.SearchService;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        SearchService service = new SearchService();

        for (String song : SongTitle.songs) {
            service.addSong(song);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Song Title Search ===");

        while (true) {
            System.out.print("\nMasukkan prefix lagu (atau 'exit' untuk keluar): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;

            if (input.isEmpty()) {
                System.out.println("Input tidak boleh kosong.");
                continue;
            }

            List<String> results = service.search(input);

            if (results.isEmpty()) {
                System.out.println("Tidak ada lagu dengan prefix \"" + input + "\".");
            } else {
                System.out.println("Hasil pencarian untuk \"" + input + "\":");
                for (int i = 0; i < results.size(); i++) {
                    System.out.println("  " + (i + 1) + ". " + results.get(i));
                }
            }
        }

        scanner.close();
        System.out.println("Terima kasih!");
    }
}
