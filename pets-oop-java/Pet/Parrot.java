package Pet;
import java.util.ArrayList;
import java.util.List;

public class Parrot extends Pet {
    private String featherColor;
    private int vocabularySize;
    private List<String> knownWords;
    

    public Parrot() {
        this("Кеша", 3, 0.3, "Зеленый");
    }
    
    public Parrot(String name, int age, double weight, String featherColor) {
        super(name, age, weight);
        this.featherColor = featherColor;
        this.vocabularySize = 0;
        this.knownWords = new ArrayList<>();
        learnWord("Привет"); 
    }
    

    public String getFeatherColor() {
        return featherColor;
    }
    
    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }
    
    public int getVocabularySize() {
        return vocabularySize;
    }
    
    public List<String> getKnownWords() {
        return new ArrayList<>(knownWords);
    }
    

    @Override
    public void makeSound() {
        System.out.println(getName() + " говорит: Попка дурак!");
    }
    

    public void learnWord(String word) {
        if (!knownWords.contains(word)) {
            knownWords.add(word);
            vocabularySize++;
            System.out.println(getName() + " выучил новое слово: '" + word + "'");
        }
    }
    
    public void speak() {
        if (!knownWords.isEmpty()) {
            String randomWord = knownWords.get((int)(Math.random() * knownWords.size()));
            System.out.println(getName() + " говорит: " + randomWord + "!");
        } else {
            System.out.println(getName() + " молчит... Нужно выучить слова!");
        }
    }
    
    public void fly() {
        System.out.println(getName() + " летает по комнате!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Цвет перьев: " + featherColor + ", Размер словаря: " + vocabularySize + " слов");
        if (!knownWords.isEmpty()) {
            System.out.println("  Известные слова: " + String.join(", ", knownWords));
        }
    }
    
    @Override
    public void play() {
        System.out.println(getName() + " играет с зеркалом!");
    }
}