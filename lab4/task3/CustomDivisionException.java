package task3;

public class CustomDivisionException extends Exception {
    public CustomDivisionException() {
        super("Ошибка: Деление на ноль запрещено!");
    }
    
    public CustomDivisionException(String message) {
        super(message);
    }
    
    public CustomDivisionException(String message, Throwable cause) {
        super(message, cause);
    }
}