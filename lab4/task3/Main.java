package task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Калькулятор деления ===");
        
        try {
            System.out.print("Введите делимое: ");
            double dividend = scanner.nextDouble();
            
            System.out.print("Введите делитель: ");
            double divisor = scanner.nextDouble();
            
            double result = DivisionCalculator.divide(dividend, divisor);
            System.out.println("Результат: " + dividend + " / " + divisor + " = " + result);
            
        } catch (CustomDivisionException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ошибка ввода: пожалуйста, введите числовые значения");
            ExceptionLogger.logException(e);
        } finally {
            scanner.close();
        }
    }
}
