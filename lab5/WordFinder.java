import java.util.regex.*;
import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Введите текст:");
            String text = scanner.nextLine();
            
            System.out.print("Введите букву для поиска: ");
            String letter = scanner.nextLine();
            
            if (letter.length() != 1 || !Character.isLetter(letter.charAt(0))) {
                System.out.println("Ошибка: введите одну букву!");
                return;
            }
            
            // Регулярное выражение для поиска слов, начинающихся с заданной буквы
            // \\b - граница слова
            // [" + letter + "] - искомая буква (регистронезависимо)
            // [a-zA-Z]* - остальные буквы слова
            // \\b - граница слова
            String regex = "\\b[" + letter.toLowerCase() + letter.toUpperCase() + "][a-zA-Z]*\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Слова, начинающиеся с буквы '" + letter + "':");
            boolean found = false;
            
            while (matcher.find()) {
                System.out.println("- " + matcher.group());
                found = true;
            }
            
            if (!found) {
                System.out.println("Слова, начинающиеся с буквы '" + letter + "', не найдены.");
            }
            
        } catch (Exception e) {
            System.out.println("Ошибка при поиске слов: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}