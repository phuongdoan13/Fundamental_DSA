package DS1_StackAndQueue;
import java.util.*;

public class Stack{
    LinkedList<Integer> st;

    public Stack(){
        this.st = new LinkedList<Integer>();
    }

    public boolean isEmpty(){
        // O(1)
        return this.st.isEmpty();
    }

    public void push(int data){
        // O(1)
        st.push(data);
    } 

    public int pop() throws StackException{
        // O(1)
        if(st.isEmpty()){
            throw new StackException("The stack is empty.");
        }
        int val = st.peekLast();
        st.removeLast();
        return val;
    }

    public int peek() throws StackException{
        if(st.isEmpty()){
            throw new StackException("The stack is empty.");
        }
        return st.peekLast();
    }
}