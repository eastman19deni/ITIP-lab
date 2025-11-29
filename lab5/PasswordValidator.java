import java.util.regex.*;
import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();

            String regex = "^(?=.*[A-Z])(?=.*\\d)([A-Za-z\\d]{8,16})$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            
            if (matcher.matches()) {
                System.out.println("Пароль корректен!");
            } else {
                System.out.println("Пароль не соответствует требованиям:");
                System.out.println("- Длина от 8 до 16 символов");
                System.out.println("- Только латинские буквы и цифры");
                System.out.println("- Хотя бы одна заглавная буква");
                System.out.println("- Хотя бы одна цифра");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при проверке пароля: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}