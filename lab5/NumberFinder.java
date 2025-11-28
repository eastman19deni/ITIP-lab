import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            String text = "The price of the product is $19.99, there are 42 items, and temperature is -3.5 degrees.";
            Pattern pattern = Pattern.compile("-?\\d+\\.?\\d*");
            Matcher matcher = pattern.matcher(text);
            
            System.out.println("Найденные числа:");
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при поиске чисел: " + e.getMessage());
        }
    }
}
