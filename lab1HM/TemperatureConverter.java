import java.util.Scanner;

public class TemperatureConverter {
    

    public static double toFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Введите температуру в градусах Цельсия: ");
        double celsius = scanner.nextDouble();
        

        double fahrenheit = toFahrenheit(celsius);
        System.out.println("Температура в градусах Фаренгейта: " + fahrenheit);
        
        scanner.close();
    }
}