package Pet;
import java.time.LocalDate;


public abstract class Pet {

    private static int totalPets = 0;
    

    private String name;
    private int age;
    private double weight;
    private final int id;
    private LocalDate registrationDate;
    

    public Pet() {
        this("Безымянный", 1, 5.0);
    }
    
    public Pet(String name, int age, double weight) {
        this.name = name;
        this.age = Math.max(0, age);
        this.weight = Math.max(0.1, weight);
        this.id = ++totalPets;
        this.registrationDate = LocalDate.now();
    }
    

    public abstract void makeSound();
    

    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public int getId() {
        return id;
    }
    
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    
    public static int getTotalPets() {
        return totalPets;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = Math.max(0, age);
    }
    
    public void setWeight(double weight) {
        this.weight = Math.max(0.1, weight);
    }
    

    public void eat() {
        weight += 0.1;
        System.out.println(name + " кушает... Вес увеличился до " + String.format("%.1f", weight) + " кг");
    }
    
    public void sleep() {
        System.out.println(name + " спит... Zzzzz");
    }
    
    public void displayInfo() {
        System.out.println("ID: " + id + ", Имя: " + name + 
                          ", Возраст: " + age + " лет, Вес: " + String.format("%.1f", weight) + " кг" +
                          ", Зарегистрирован: " + registrationDate);
    }
    

    public static Pet createSmallPet(String name) {
        return new Cat(name, 0, 1.0, "Белый");
    }
    

    public void play() {
        System.out.println(name + " играет и веселится!");
    }
}