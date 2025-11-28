package task3;
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("Демонстрация работы с исключениями:");
        
        // Тест 1: Нормальное деление
        System.out.println("\nТест 1: Нормальное деление");
        try {
            double result1 = DivisionCalculator.divide(10, 2);
            System.out.println("10 / 2 = " + result1);
        } catch (CustomDivisionException e) {
            System.err.println(e.getMessage());
        }
        
        // Тест 2: Деление на ноль
        System.out.println("\nТест 2: Деление на ноль");
        try {
            double result2 = DivisionCalculator.divide(10, 0);
            System.out.println("10 / 0 = " + result2);
        } catch (CustomDivisionException e) {
            System.err.println(e.getMessage());
        }
        
        // Тест 3: Деление отрицательных чисел
        System.out.println("\nТест 3: Деление отрицательных чисел");
        try {
            double result3 = DivisionCalculator.divide(-15, 3);
            System.out.println("-15 / 3 = " + result3);
        } catch (CustomDivisionException e) {
            System.err.println(e.getMessage());
        }
        
        // Тест 4: Еще одно деление на ноль
        System.out.println("\nТест 4: Деление на ноль с дробными числами");
        try {
            double result4 = DivisionCalculator.divide(5.5, 0);
            System.out.println("5.5 / 0 = " + result4);
        } catch (CustomDivisionException e) {
            System.err.println(e.getMessage());
        }
    }
}
