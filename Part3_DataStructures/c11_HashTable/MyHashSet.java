package Part3_DataStructures.c11_HashTable;

import java.util.*;

public class MyHashSet {
    private int PRIME = 127;
    Bucket[] buckets;

    public MyHashSet() {
        buckets = new Bucket[PRIME];
        for(int i = 0; i < PRIME; i++){
            this.buckets[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        int hash = key % this.PRIME;

        Bucket bucket = this.buckets[hash];
        bucket.insertKey(Integer.valueOf(key));

    }
    
    public void remove(int key) {
        int hash = key % this.PRIME;

        Bucket bucket = this.buckets[hash];
        bucket.removesKey(Integer.valueOf(key));
    }
    
    public boolean contains(int key) {
        int hash = key % this.PRIME;

        Bucket bucket = this.buckets[hash];
        return bucket.containsKey(Integer.valueOf(key));
    }
}

class Bucket{
    List<Integer> container;
    public Bucket(){
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
