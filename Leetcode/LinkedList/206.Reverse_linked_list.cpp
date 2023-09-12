#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>
#include <stack>
using namespace std;

struct ListNode
{
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode *reverseList(ListNode *head)
{
  ListNode *prev = nullptr;
  while (head != nullptr)
  {
    ListNode *next = head->next;
    head->next = prev;
    prev = head;
    head = next;
  }
  return prev;
}

int main()
{
  ListNode *head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
  ListNode *ans = reverseList(head);
  while(ans != nullptr){
    cout << ans->val << endl;
    ans = ans->next;
  }
}