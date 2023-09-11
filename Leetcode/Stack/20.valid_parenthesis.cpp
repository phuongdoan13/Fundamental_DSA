#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>
#include <stack>
using namespace std;

bool isValid(string s)
{
  stack<char> st;
  for (auto &c : s)
  {
    string open = "([{";
    if (open.find(c) != string::npos)
    {
      st.push(c);
      continue;
    }

    if (c == ')' && (st.empty() || st.top() != '('))
    {
      return false;
    }
    else if (c == ']' && (st.empty() || st.top() != '['))
    {
      return false;
    }
    else if (c == '}' && (st.empty() || st.top() != '{'))
    {
      return false;
    }
    
    if (!st.empty())
    {
      st.pop();
    }
  }
  return st.empty();
}

int main() {
  string s;
  cin >> s;
  cout << isValid(s) << endl;
}