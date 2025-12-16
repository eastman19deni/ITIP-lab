import java.util.Random;

public class ArraySumTask {
    private static int[] array;
    private static int totalSum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // Создаем массив из 100 случайных чисел
        array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // числа от 0 до 99
        }
        
        // Создаем два потока для обработки половин массива
        Thread thread1 = new Thread(new SumCalculator(0, array.length / 2));
        Thread thread2 = new Thread(new SumCalculator(array.length / 2, array.length));
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Общая сумма элементов массива: " + totalSum);
    }
    
    static class SumCalculator implements Runnable {
        private final int start;
        private final int end;
        
        public SumCalculator(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public void run() {
            int partialSum = 0;
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
            
            synchronized (lock) {
                totalSum += partialSum;
                System.out.println(Thread.currentThread().getName() + 
                                 ": сумма элементов с " + start + " по " + (end-1) + 
                                 " = " + partialSum);
            }
        }
    }
}