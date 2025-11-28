import java.util.regex.*;
import java.util.Scanner;

public class IPValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите IP-адрес: ");
            String ipAddress = scanner.nextLine();
            
            // Регулярное выражение для проверки IPv4 адреса
            // ^ - начало строки
            // (25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?) - число от 0 до 255
            // \\. - точка
            // {3} - повторить 3 раза для первых трех октетов
            // $ - конец строки
            String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ipAddress);
            
            if (matcher.matches()) {
                System.out.println("IP-адрес корректен!");
                
                // Дополнительная проверка - разбиение на октеты
                String[] octets = ipAddress.split("\\.");
                System.out.println("Октеты IP-адреса:");
                for (int i = 0; i < octets.length; i++) {
                    System.out.println("Октет " + (i + 1) + ": " + octets[i]);
                }
            } else {
                System.out.println("IP-адрес некорректен!");
                System.out.println("IP-адрес должен:");
                System.out.println("- Состоять из 4 чисел, разделенных точками");
                System.out.println("- Каждое число должно быть в диапазоне от 0 до 255");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при проверке IP-адреса: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}