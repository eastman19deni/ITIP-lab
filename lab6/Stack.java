public class Stack<T> {
    private T[] data;
    private int size;
    
    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    //кладет 
    public void push(T element) {
        if (size == data.length) {
            
            resize(data.length * 2);// Увеличиваем массив при необходимости
        }
        data[size] = element;
        size++;
    }
    //удаляет 
    public T pop() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        T element = data[size - 1];
        data[size - 1] = null; // Для сборщика мусора
        size--;
        
        // Уменьшаем массив при необходимости
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        
        return element;
    }
  //проверка стека  
    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Стек пуст");
        }
        return data[size - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

// Пример использования
class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("pop(): " + stack.pop()); // 3
        System.out.println("peek(): " + stack.peek()); // 2
        
        stack.push(4);
        System.out.println("pop(): " + stack.pop()); // 4
        
        System.out.println("Текущий стек: " + stack);
        System.out.println("Размер стека: " + stack.size());
    }
}