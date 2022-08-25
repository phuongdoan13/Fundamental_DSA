package Part3_DataStructures.c10p1_StackAndQueue;

public class StackAndQueue {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        try {
            System.out.println(st.peek());
            System.out.println(st.pop());
            st.pop();
            st.pop();
            st.pop();
            st.pop();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
