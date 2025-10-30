package Pet;
public class Cat extends Pet {
    private String color;
    private int miceCaught;
    

    public Cat() {
        this("Мурзик", 2, 4.5, "Рыжий");
    }
    
    public Cat(String name, int age, double weight, String color) {
        super(name, age, weight);
        this.color = color;
        this.miceCaught = 0;
    }
    

    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getMiceCaught() {
        return miceCaught;
    }
    

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит: Мяу-мяу!");
    }
    

    public void catchMouse() {
        miceCaught++;
        System.out.println(getName() + " поймал(а) мышь! Всего поймано: " + miceCaught);
    }
    
    public void purr() {
        System.out.println(getName() + " мурлычет: Мррррр...");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Цвет: " + color + ", Поймано мышей: " + miceCaught);
    }
    
    @Override
    public void play() {
        System.out.println(getName() + " играет с клубком ниток!");
    }
}