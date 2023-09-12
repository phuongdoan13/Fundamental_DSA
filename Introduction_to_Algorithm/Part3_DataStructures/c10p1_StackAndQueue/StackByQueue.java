package Part3_DataStructures.c10p1_StackAndQueue;
import java.util.*;
public class StackByQueue {
    Deque<Integer> q;

    public StackByQueue() {
        this.q = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        // O(current_size);
        q.addLast(x);
        int sz = q.size();
        while(sz > 1){
            q.add(q.remove());
            sz--;
        }
    }
    
    public int pop() throws StackException{
        // O(1)
        if(q.isEmpty()){
            throw new StackException("The stack is empty.");
        }
        return q.removeFirst();
    }
    
    public int peek() throws StackException{
        // O(1)
        if(q.isEmpty()){
            throw new StackException("The stack is empty.");
        }
        return q.getFirst();
    }
    
    public boolean isEmpty() {
        // O(1)
        return q.isEmpty();
    }
}