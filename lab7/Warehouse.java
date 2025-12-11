package lab7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Random;

public class Warehouse {
    public static void main(String[] args) {
        BlockingQueue<Product> warehouse = new LinkedBlockingQueue<>();
        Random random = new Random();
        
        // Заполняем склад товарами
        for (int i = 1; i <= 20; i++) {
            int weight = random.nextInt(30) + 1; // Вес от 1 до 30 кг
            warehouse.add(new Product("Товар-" + i, weight));
        }
        
        System.out.println("Начальное количество товаров на складе: " + warehouse.size());
        
        // Создаем трех грузчиков
        Loader loader1 = new Loader("Грузчик-1", warehouse);
        Loader loader2 = new Loader("Грузчик-2", warehouse);
        Loader loader3 = new Loader("Грузчик-3", warehouse);
        
        // Запускаем грузчиков
        loader1.start();
        loader2.start();
        loader3.start();
        
        // Ждем завершения работы
        try {
            loader1.join();
            loader2.join();
            loader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Все товары перенесены на другой склад!");
    }
}

class Product {
    private final String name;
    private final int weight;
    
    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    @Override
    public String toString() {
        return name + " (" + weight + " кг)";
    }
}

class Loader extends Thread {
    private static final int MAX_WEIGHT_PER_TRIP = 150;
    private static final AtomicInteger totalWeightInCurrentTrip = new AtomicInteger(0);
    private static final Object tripLock = new Object();
    
    private final BlockingQueue<Product> warehouse;
    private int totalCarried = 0;
    
    public Loader(String name, BlockingQueue<Product> warehouse) {
        super(name);
        this.warehouse = warehouse;
    }
    
    @Override
    public void run() {
        while (!warehouse.isEmpty()) {
            try {
                // Берем товар со склада
                Product product = warehouse.poll();
                if (product == null) {
                    break; // Склад пуст
                }
                
                // Пытаемся добавить товар в текущую поездку
                boolean tripComplete = false;
                synchronized (tripLock) {
                    int currentWeight = totalWeightInCurrentTrip.get();
                    
                    if (currentWeight + product.getWeight() <= MAX_WEIGHT_PER_TRIP) {
                        // Добавляем товар к текущей поездке
                        totalWeightInCurrentTrip.addAndGet(product.getWeight());
                        totalCarried += product.getWeight();
                        System.out.println(getName() + " взял " + product + 
                                         " (текущий вес поездки: " + 
                                         totalWeightInCurrentTrip.get() + " кг)");
                        
                        // Проверяем, достигли ли лимита
                        if (totalWeightInCurrentTrip.get() >= MAX_WEIGHT_PER_TRIP) {
                            tripComplete = true;
                        }
                    } else {
                        // Товар не помещается - возвращаем обратно
                        warehouse.add(product);
                        tripComplete = true;
                    }
                }
                
                // Если поездка завершена, отправляемся на другой склад
                if (tripComplete) {
                    makeTrip();
                }
                
                // Небольшая задержка для имитации работы
                Thread.sleep(100);
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        // Проверяем, есть ли неотправленные товары
        if (totalWeightInCurrentTrip.get() > 0) {
            makeTrip();
        }
        
        System.out.println(getName() + " завершил работу. Всего перенес: " + 
                         totalCarried + " кг");
    }
    
    private void makeTrip() {
        synchronized (tripLock) {
            int tripWeight = totalWeightInCurrentTrip.getAndSet(0);
            if (tripWeight > 0) {
                System.out.println("═══════════════════════════════════════════════");
                System.out.println(getName() + " отправляется на другой склад " +
                                 "с " + tripWeight + " кг товаров");
                System.out.println("Разгрузка...");
                try {
                    Thread.sleep(500); // Имитация разгрузки
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(getName() + " вернулся на склад");
                System.out.println("═══════════════════════════════════════════════");
            }
        }
    }
}