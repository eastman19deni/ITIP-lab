import java.util.regex.*;

public class CaseFinder {
    public static void main(String[] args) {
        try {
            String text = "ПриветМир ЛеГенДа";
            Pattern pattern = Pattern.compile("[а-я][А-Я]");
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Исходный текст: " + text);
            System.out.println("Найденные переходы строчная-заглавная:");
            
            while (matcher.find()) {
                String found = matcher.group();
                System.out.println("!" + found + "! на позиции " + matcher.start());
            }
            
            // Альтернативный вариант с заменой в тексте
            String result = text.replaceAll("([а-я])([А-Я])", "!$1$2!");
            System.out.println("Текст с выделением: " + result);
            
        } catch (Exception e) {
            System.out.println("Ошибка при поиске: " + e.getMessage());
        }
    }
}