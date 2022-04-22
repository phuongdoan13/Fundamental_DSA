package DS5_Hash;
import java.util.*;
class MyHashMap {
    private int PRIME = 127;
    Bucket[] buckets;
    public MyHashMap() {
        buckets = new Bucket[PRIME];
        for(int i = 0 ; i < PRIME; i++){
            buckets[i] = new Bucket();
        }
    }
    
    public void put(int key, int value) {
        int hash = _hash(key);
        Bucket bucket = buckets[hash];
        bucket.put(key, value);
    }
    
    public int get(int key) {
        int hash = _hash(key);
        Bucket bucket = buckets[hash];
        return bucket.get(key);
    }
    
    public void remove(int key) {
        int hash = _hash(key);
        Bucket bucket = buckets[hash];
        bucket.remove(key);
    }
    private int _hash(int key){
        return key % PRIME;
    }
}

class Bucket{
    List<Pair> containers;
    public Bucket(){
        containers = new LinkedList<>();
    }

    public boolean contains(int key){
        for(Pair p : containers){
            if(p.key == key){
                return true;
            }
        }
        return false;
    }
    public int get(int key){
        for(Pair p : containers){
            if(p.key == key){
                return p.value;
            }
        }
        return -1;
    }
    public void put(int key, int value){

        if(this.contains(key)){
            for(Pair p : containers){
                if(p.key == key){
                    p.value = value;
                    break;
                }
            }
        }else{
            containers.add(new Pair(key, value));
        }
    }
    public void remove(int key){
        
        for(Pair p : containers){
            if(p.key == key){
                this.containers.remove(p);
                break;
            }
        }
        
    }

}

class Pair{
    int key;
    int value;
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
}
