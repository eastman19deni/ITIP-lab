import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyVariant {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        
        // Использование try-with-resources для автоматического закрытия файлов
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
            
            System.out.println("Файлы успешно открыты");
            System.out.println("Начало процесса копирования...");
            
            byte[] buffer = new byte[1024];
            int totalBytes = 0;
            int bytesRead;
            
            // Чтение и запись данных с обработкой возможных ошибок
            while (true) {
                try {
                    bytesRead = inputStream.read(buffer);
                    if (bytesRead == -1) {
                        break; // Конец файла
                    }
                    
                    // Проверка на случай частичного чтения
                    if (bytesRead > 0) {
                        try {
                            outputStream.write(buffer, 0, bytesRead);
                            totalBytes += bytesRead;
                            System.out.println("Скопировано " + bytesRead + " байт");
                        } catch (IOException writeException) {
                            System.out.println("Ошибка записи в целевой файл: " + writeException.getMessage());
                            System.out.println("Уже скопировано: " + totalBytes + " байт");
                            throw writeException; // Повторно выбрасываем исключение
                        }
                    }
                    
                } catch (IOException readException) {
                    System.out.println("Ошибка чтения из исходного файла: " + readException.getMessage());
                    System.out.println("Уже скопировано: " + totalBytes + " байт");
                    throw readException; // Повторно выбрасываем исключение
                }
            }
            
            System.out.println("Копирование завершено успешно!");
            System.out.println("Всего скопировано: " + totalBytes + " байт");
            
        } catch (IOException e) {
            System.out.println("Критическая ошибка при копировании файлов: " + e.getMessage());
            System.out.println("Рекомендации:");
            
            if (e.getMessage().contains("No such file or directory")) {
                System.out.println("- Проверьте существование исходного файла");
                System.out.println("- Проверьте правильность пути к файлу");
            } else if (e.getMessage().contains("Permission denied")) {
                System.out.println("- Проверьте права доступа к файлам");
                System.out.println("- Запустите программу с правами администратора если необходимо");
            } else if (e.getMessage().contains("disk full")) {
                System.out.println("- Освободите место на диске");
                System.out.println("- Выберите другой диск для сохранения");
            } else {
                System.out.println("- Проверьте, не открыты ли файлы в другой программе");
                System.out.println("- Попробуйте перезапустить программу");
            }
        }
    }
}