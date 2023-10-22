import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IncrementStack {
  int maxSize;
  Stack<Integer> st = new Stack<Integer>();
  List<Integer> inc = new ArrayList<Integer>();

  public IncrementStack(int maxSize) {
    this.maxSize = maxSize;
  }

  public void push(int x) {
    if (st.size() == maxSize) {
      return;
    }
    st.push(x);
    inc.add(0);
  }

  public int pop() {
    if (st.isEmpty()) {
      return -1;
    }
    int topE = st.pop();
    int topInc = inc.remove(inc.size() - 1);
    if (inc.size() != 0)
      inc.set(inc.size() - 1, inc.get(inc.size() - 1) + topInc);
    return topE + topInc;

  }

  public void increment(int k, int val) {
    if (st.isEmpty()) {
      return;
    }

    if (k >= st.size()) {
      k = st.size();
    }
    k = k - 1;

    if (!inc.isEmpty())
      inc.set(k, inc.get(k) + val);
  }

  public static void main(String[] args) {
    IncrementStack obj = new IncrementStack(3);
    obj.push(1);
    obj.push(2);
    obj.push(3);
    obj.push(4);
    obj.increment(5, 100);
    obj.increment(2, 100);
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
  }
}