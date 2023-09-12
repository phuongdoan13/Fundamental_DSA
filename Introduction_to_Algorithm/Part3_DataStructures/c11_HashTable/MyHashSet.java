package Part3_DataStructures.c11_HashTable;

import java.util.*;

public class MyHashSet {
    private int PRIME = 127;
    SetBucket[] setBuckets;

    public MyHashSet() {
        setBuckets = new SetBucket[PRIME];
        for(int i = 0; i < PRIME; i++){
            this.setBuckets[i] = new SetBucket();
        }
    }
    
    public void add(int key) {
        int hash = key % this.PRIME;

        SetBucket setBucket = this.setBuckets[hash];
        setBucket.insertKey(Integer.valueOf(key));

    }
    
    public void remove(int key) {
        int hash = key % this.PRIME;

        SetBucket setBucket = this.setBuckets[hash];
        setBucket.removesKey(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int hash = key % this.PRIME;

        SetBucket setBucket = this.setBuckets[hash];
        return setBucket.containsKey(Integer.valueOf(key));
    }
}

class SetBucket {
    List<Integer> container;
    public SetBucket(){
        this.container = new LinkedList<>();    
    }

    public void insertKey(Integer key){
        if(!this.containsKey(key))
            this.container.add(key);
    }

    public void removesKey(Integer key){
        this.container.remove(key);
    }

    public boolean containsKey(Integer key){
        return this.container.contains(key);
    }
}
