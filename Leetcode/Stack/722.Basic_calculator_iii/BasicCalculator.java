import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class BasicCalculator {
  public int calculate(String s) {
    Stack<String> st = new Stack<>();
    String curr = "";
    char prevOp = '+';
    s += "@";
    Set<String> ops = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        curr += c;
      } else if (c == '(') {
        st.push("" + prevOp);
        prevOp = '+';
      } else {
        if (prevOp == '*' || prevOp == '/') {
          st.push(evaluate(prevOp, st.pop(), curr));
        } else {
          st.push(evaluate(prevOp, curr, "0"));
        }
        curr = "";
        prevOp = c;

        if (c == ')') {
          int currentTerm = 0;
          while (!ops.contains(st.peek())) {
            currentTerm += Integer.parseInt(st.pop());
          }

          curr = Integer.toString(currentTerm);
          prevOp = st.pop().charAt(0);
        }
      }
    }

    int ans = 0;
    for (String num : st) {
      ans += Integer.parseInt(num);
    }

    return ans;
  }

  private String evaluate(char op, String first, String second) {
    int firstNum = Integer.parseInt(first);
    int secondNum = Integer.parseInt(second);

    int res = 0;

    if (op == '+') {
      res = firstNum;
    } else if (op == '-') {
      res = -firstNum;
    } else if (op == '*') {
      res = firstNum * secondNum;
    } else {
      res = firstNum / secondNum;
    }
    return Integer.toString(res);
  }
}