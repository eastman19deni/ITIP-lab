import java.util.*;

class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %.2f руб.", name, price);
    }
}

public class SalesTracker {
    private List<Product> soldProducts;
    
    // Конструктор с выбором реализации
    public SalesTracker(boolean useLinkedList) {
        if (useLinkedList) {
            soldProducts = new LinkedList<>();
        } else {
            soldProducts = new ArrayList<>();
        }
    }
    
    // Добавление проданного товара
    public void addProduct(Product product) {
        soldProducts.add(product);
        System.out.println("Добавлен товар: " + product);
    }
    
    // Добавление проданного товара (перегруженный метод)
    public void addProduct(String name, double price) {
        addProduct(new Product(name, price));
    }
    
    // Вывод списка проданных товаров
    public void displaySoldProducts() {
        if (soldProducts.isEmpty()) {
            System.out.println("Список проданных товаров пуст.");
            return;
        }
        
        System.out.println("\n=== СПИСОК ПРОДАННЫХ ТОВАРОВ ===");
        for (int i = 0; i < soldProducts.size(); i++) {
            System.out.printf("%3d. %s%n", i + 1, soldProducts.get(i));
        }
    }
    
    // Расчет общей суммы продаж
    public double calculateTotalSales() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getPrice();
        }
        return total;
    }
    
    // Поиск наиболее популярного товара
    public String findMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            return "Нет проданных товаров";
        }
        
        Map<String, Integer> productCount = new HashMap<>();
        
        for (Product product : soldProducts) {
            String name = product.getName();
            productCount.put(name, productCount.getOrDefault(name, 0) + 1);
        }
        
        // Поиск товара с максимальным количеством продаж
        String mostPopular = null;
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        
        return mostPopular + " (продано " + maxCount + " раз)";
    }
    
    // Получение статистики
    public void displayStatistics() {
        System.out.println("\n=== СТАТИСТИКА ПРОДАЖ ===");
        System.out.printf("Общее количество продаж: %d%n", soldProducts.size());
        System.out.printf("Общая сумма продаж: %.2f руб.%n", calculateTotalSales());
        System.out.println("Самый популярный товар: " + findMostPopularProduct());
    }
    
    // Основной метод для тестирования
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Выберите реализацию списка:");
        System.out.println("1 - ArrayList");
        System.out.println("2 - LinkedList");
        System.out.print("Ваш выбор: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
        
        SalesTracker tracker = new SalesTracker(choice == 2);
        
        // Добавление тестовых данных
        tracker.addProduct("Хлеб", 45.50);
        tracker.addProduct("Молоко", 85.00);
        tracker.addProduct("Хлеб", 45.50);
        tracker.addProduct("Яйца", 120.00);
        tracker.addProduct("Молоко", 85.00);
        tracker.addProduct("Молоко", 85.00);
        tracker.addProduct("Сахар", 65.00);
        
        // Вывод результатов
        tracker.displaySoldProducts();
        tracker.displayStatistics();
        
        scanner.close();
    }
}