#include <string.h>
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        backtrack(n, 0, 0, "", ans);
        return ans;
    }

    void backtrack(int n, int l, int r, string s, vector<string>& ans){
        if(l == r && l == n){
            ans.push_back(s);
            return;
        }

        if(r > l || l > n || r > n){
            return;
        }

        if(l < n){
            s.push_back('(');
            backtrack(n, l + 1, r, s, ans);
            s.pop_back();
        }

        if(r < l){
            s.push_back(')');
            backtrack(n, l, r + 1, s, ans);
            s.pop_back();
        }
    }
};