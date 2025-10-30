import java.util.ArrayList;
import java.util.List;

import Pet.Cat;
import Pet.Fish;
import Pet.Parrot;
import Pet.Pet;

public class PetDemo {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ИЕРАРХИИ КЛАССОВ ДОМАШНИХ ЖИВОТНЫХ ===\n");
        

        System.out.println("1. СОЗДАНИЕ ОБЪЕКТОВ:");
        

        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Барсик", 5, 6.2, "Серый");
        Parrot parrot1 = new Parrot();
        Parrot parrot2 = new Parrot("Гоша", 2, 0.4, "Красный");
        Fish fish1 = new Fish();
        Fish fish2 = new Fish("Золотик", 2, 0.15, "Пресная", false);
        Fish glowingFish = new Fish("Светлячок", 1, 0.25, "Соленая", true);
        

        Pet smallPet = Pet.createSmallPet("Малыш");
        

        List<Pet> pets = new ArrayList<>();
        pets.add(cat1);
        pets.add(cat2);
        pets.add(parrot1);
        pets.add(parrot2);
        pets.add(fish1);
        pets.add(fish2);
        pets.add(glowingFish);
        pets.add(smallPet);
        
        for (Pet pet : pets) {
            pet.displayInfo();
            System.out.println();
        }
        
        System.out.println("Всего создано питомцев: " + Pet.getTotalPets());
        System.out.println("-".repeat(70));
        

        System.out.println("\n2. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА (ЗВУКИ ЖИВОТНЫХ):");
        for (Pet pet : pets) {
            System.out.print(pet.getName() + ": ");
            pet.makeSound();
        }
        
        System.out.println("-".repeat(70));
        

        System.out.println("\n3. ДЕМОНСТРАЦИЯ ПОВЕДЕНИЯ ЖИВОТНЫХ:");
        

        System.out.println("Кормление животных:");
        cat2.eat();
        parrot2.eat();
        fish2.eat();
        
        System.out.println("-".repeat(70));
        

        System.out.println("\n4. УНИКАЛЬНЫЕ СПОСОБНОСТИ:");
        
        if (cat2 instanceof Cat) {
            ((Cat) cat2).catchMouse();
            ((Cat) cat2).purr();
        }
        
        if (parrot2 instanceof Parrot) {
            Parrot p = (Parrot) parrot2;
            p.learnWord("Красивый");
            p.learnWord("Кушать");
            p.speak();
            p.fly();
        }
        
        if (glowingFish instanceof Fish) {
            Fish f = (Fish) glowingFish;
            f.swim();
            f.glow();
            f.forget();
        }
        
        System.out.println("-".repeat(70));
        

        System.out.println("\n5. РАБОТА С ГЕТТЕРАМИ И СЕТТЕРАМИ:");
        System.out.println("Имя кошки до изменения: " + cat1.getName());
        cat1.setName("Мурка");
        cat1.setAge(4);
        cat1.setWeight(5.2);
        System.out.println("Имя кошки после изменения: " + cat1.getName());
        System.out.println("Обновленная информация:");
        cat1.displayInfo();
        
        System.out.println("-".repeat(70));
        

        System.out.println("\n6. ИГРА С ЖИВОТНЫМИ:");
        for (Pet pet : new Pet[]{cat2, parrot2, fish2}) {
            pet.play();
        }
        
        System.out.println("-".repeat(70));
        

        System.out.println("\n7. СЧЕТЧИК ОБЪЕКТОВ:");
        System.out.println("Всего создано питомцев за всю программу: " + Pet.getTotalPets());
        

        Cat extraCat = new Cat("Дополнительный кот", 1, 3.0, "Черный");
        System.out.println("После создания дополнительного питомца: " + Pet.getTotalPets());
        

        System.out.println("-".repeat(70));
        System.out.println("\n8. ДЕМОНСТРАЦИЯ ИНКАПСУЛЯЦИИ:");
        
        Pet testPet = new Cat("Тестовый кот", 2, 4.0, "Белый");
        System.out.println("Вес до изменения: " + testPet.getWeight());
        testPet.setWeight(-5.0);
        System.out.println("Вес после попытки установить отрицательное значение: " + testPet.getWeight());
        

        System.out.println("-".repeat(70));
        System.out.println("\n9. РАБОТА С ПОПУГАЕМ:");
        Parrot smartParrot = new Parrot("Умник", 1, 0.35, "Синий");
        smartParrot.learnWord("Умник");
        smartParrot.learnWord("БУ испугался");
        smartParrot.learnWord("я добрый");
        smartParrot.displayInfo();
        
        System.out.println("\nПопугай демонстрирует словарный запас:");
        for (int i = 0; i < 3; i++) {
            smartParrot.speak();
        }
    }
}