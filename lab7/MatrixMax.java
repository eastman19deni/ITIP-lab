import java.util.Random;

public class MatrixMax {
    private static int[][] matrix;
    private static int[] rowMaxResults;
    private static int finalMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int rows = 5;
        int cols = 5;
        
        // Инициализация матрицы случайными числами
        matrix = new int[rows][cols];
        Random random = new Random();
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(1000);
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
        
        // Массив для хранения максимальных значений по строкам
        rowMaxResults = new int[rows];
        
        // Создаем потоки для каждой строки
        Thread[] threads = new Thread[rows];
        for (int i = 0; i < rows; i++) {
            final int rowIndex = i;
            threads[i] = new Thread(() -> {
                int maxInRow = Integer.MIN_VALUE;
                for (int value : matrix[rowIndex]) {
                    if (value > maxInRow) {
                        maxInRow = value;
                    }
                }
                rowMaxResults[rowIndex] = maxInRow;
                System.out.println("Поток для строки " + rowIndex + 
                                 " нашел максимум: " + maxInRow);
            });
            threads[i].start();
        }
        
        // Ожидаем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Находим общий максимум в главном потоке
        for (int maxValue : rowMaxResults) {
            if (maxValue > finalMax) {
                finalMax = maxValue;
            }
        }
        
        System.out.println("Наибольший элемент в матрице: " + finalMax);
    }
}