import java.util.LinkedList;

public class HashTable<K,V> {
  private static class Entry<K,V>{
    K key;
    V value;

    Entry(K key,V value){
      this.key = key;
      this.value = value
    }
  }
  private LinkedList<Entry<K,V>>[] table;
  private int size;
  private int capacity;

  @SuppresWarnings("unchecked")
  public HashTable(int capacity){
    this.capacity = capacity;
    this.size = 0;
    this.table = new LinkedList[capacity];
    for (int i = 0; i< capacity; i++){
      table[i] = new LinkedList<>();
    }
  }
  public HashTable(){
    this(10);
  }
  private int hash(K key){
    return Math.abs(key.hashCode()) % capacity;
  }
  public void put(K key, V value){
    int index = hash(key);
    LinkedList<Entry<K,V>> bucket = table[index];

    for(Entry<K,V> entry : bucket) {
      if(entry.key.equals(key)){
        entry.value = value;
        return;
      }
    }
    bucket.add(new Entry<>(key,value));
    size++;
  }
  public V get(K key){
    int index = hash(key);
    LinkedList<Entry<K,V>> bucket = table[index];

    for (Entry<K,V> entry: bucket){
      if(entry.key.equals(key)){
        return entry.value;
      }
    }
    return null;
  }
  public void remove(K key){
    int index = hash(key);
    LinkedList<Entry<K,V>> bucket = table[index];

    for(Entry<K,V> entry : bucket){
      if(entry.key.equals(key)){
        bucket.remove(entry);
        size--;
        return;
      }
    }

  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public boolean containsKey(K key){
    return get(key) != null;
  }

  @Override 
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < capacity; i++){
      LinkedList<Entry<K,V>> bucket = table[i];
      if(!bucket.isEmpty()){
        sb.append("Bucket").append(i).append(": ");
        for(Entry<K, V> entry: bucket){
          sb.append("[").append(entry.key).append("=").append(entry.value).append("]");
        }
        sb.append("\n");
      }
    }
    return sb.toString();
  }
}

