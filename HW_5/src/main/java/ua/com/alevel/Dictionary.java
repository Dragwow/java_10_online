package ua.com.alevel;

public class Dictionary<K, V> {
    private int size;
    private V[] values;
    private K[] keys;


    public Dictionary(){
       clear();
    }


   public int size(){
       return size;
   }

   public boolean isEmpty(){
       return size == 0;
   }

    public boolean containsKey(K key){
        boolean haveSuchKey = false;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)){
                haveSuchKey = true;
            }
        }
        return haveSuchKey;
    }

    public boolean containsValue(V value){
        boolean haveSuchValue = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)){
                haveSuchValue = true;
            }
        }
        return haveSuchValue;
    }

    public V get(K key){
        for (int i = 0; i < keys.length ; i++) {
            if (keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }

    public boolean put(K key, V value){
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)){
                keys[i] = key;
                values[i] = value;
                return true;
            }
        }
        return false;
    }

    public boolean remove(K key){
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].equals(key)){
                keys[i] = null;
                values[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean putAll(Dictionary<K, V> dictionary){
        for (int i = 0; i < keys.length; i++) {
            put((K) dictionary.keys[i], (V) dictionary.values[i]);
        }
        return true;
    }

    public boolean clear(){
        this.size = 0;
        this.keys = (K[]) new  Object[10];
        this.values = (V[]) new Object[10];
        return true;
    }

    public K[] keys(){
        return keys;
    }

    public V[] values(){
        return  values;
    }
}
