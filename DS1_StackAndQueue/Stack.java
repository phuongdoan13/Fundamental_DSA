// package DS1_StackAndQueue;
import java.util.*;

public class Stack{
    int size;

    LinkedList<Integer> st;


    public Stack(){
        this.st = new LinkedList();
    }
    public boolean isEmpty(){
        return this.size == 0;
    }

    public void push(int data){
        st.push(data);
        size++;
    } 

    public int pop() throws EmptyStackException{
        if(size == 0){
            throw new EmptyStackException("The stack is empty.");
        }
        int val = st.getLast();
        st.removeLast();
        return val;
    }

    public int peek() throws EmptyStackException{
        if(size == 0){
            throw new EmptyStackException("The stack is empty.");
        }
        return st.getLast();
    }
}

// class EmptyStackException extends Exception{
//     public EmptyStackException(String message){
//         super(message);
//     }
// }