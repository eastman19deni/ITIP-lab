public class Fish extends Pet {
    private String waterType; 
    private int memoryDuration; 
    private boolean canGlow;
    

    public Fish() {
        this("Немо", 1, 0.2, "Соленая", false);
    }
    
    public Fish(String name, int age, double weight, String waterType, boolean canGlow) {
        super(name, age, weight);
        this.waterType = waterType;
        this.memoryDuration = 3; 
        this.canGlow = canGlow;
    }
    

    public String getWaterType() {
        return waterType;
    }
    
    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }
    
    public int getMemoryDuration() {
        return memoryDuration;
    }
    
    public void setMemoryDuration(int memoryDuration) {
        this.memoryDuration = Math.max(1, memoryDuration);
    }
    
    public boolean isCanGlow() {
        return canGlow;
    }
    
    public void setCanGlow(boolean canGlow) {
        this.canGlow = canGlow;
    }
    

    @Override
    public void makeSound() {
        System.out.println(getName() + " пускает пузыри: Буль-буль!");
    }
    

    public void swim() {
        System.out.println(getName() + " плавает в аквариуме!");
    }
    
    public void forget() {
        System.out.println(getName() + " забыл всё через " + memoryDuration + " секунды...");
    }
    
    public void glow() {
        if (canGlow) {
            System.out.println(getName() + " светится в темноте! ✨");
        } else {
            System.out.println(getName() + " не умеет светиться...");
        }
    }
    
    @Override
    public void eat() {
        setWeight(getWeight() + 0.01);
        System.out.println(getName() + " ест рыбный корм. Вес: " + String.format("%.2f", getWeight()) + " кг");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Тип воды: " + waterType + 
                          ", Память: " + memoryDuration + " сек" +
                          ", Светится: " + (canGlow ? "да" : "нет"));
    }
    
    @Override
    public void play() {
        System.out.println(getName() + " играет, плавая через кольцо!");
    }
}