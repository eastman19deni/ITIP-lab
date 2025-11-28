package task3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionLogger {
    private static final String LOG_FILE = "exceptions.log";
    
    public static void logException(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println("[" + timestamp + "] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            writer.println("Stack Trace:");
            e.printStackTrace(writer);
            writer.println("---");
        } catch (IOException ioException) {
            System.err.println("Ошибка при записи в лог-файл: " + ioException.getMessage());
        }
    }
}