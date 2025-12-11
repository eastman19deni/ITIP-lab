import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class TopWordsFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();
        
        try {
            Map<String, Integer> wordCount = new HashMap<>();
            
            // Чтение файла
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Pattern pattern = Pattern.compile("[\\p{Punct}\\s]+");
            
            while ((line = reader.readLine()) != null) {
                // Разделение строки на слова
                String[] words = pattern.split(line.toLowerCase());
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();
            
            // Сортировка по убыванию частоты
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
            sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            // Вывод топ-10 слов
            System.out.println("\nТоп-10 самых частых слов:");
            System.out.println("----------------------------");
            int limit = Math.min(10, sortedEntries.size());
            
            for (int i = 0; i < limit; i++) {
                Map.Entry<String, Integer> entry = sortedEntries.get(i);
                System.out.printf("%2d. %-20s - %d раз(а)%n", 
                    i + 1, entry.getKey(), entry.getValue());
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}