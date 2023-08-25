
#include algorithm
#include <
#include array
#include vector
#include <string>
#include <iostream>

using namespace std;

typedef long long LL;
typedef pair<int, int> pii;
typedef pair<LL, LL> pll;
typedef pair<string, string> pss;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<pii> vii;
typedef vector<LL> vl;
typedef vector<vl> vvl;

double EPS = 1e-9;
int INF = 1000000005;
long long INFF = 1000000000000000005LL;
double PI = acos(-1);
int dirx[8] = {-1, 0, 0, 1, -1, -1, 1, 1};
int diry[8] = {0, 1, -1, 0, -1, 1, -1, 1};

#ifdef TESTING
#define DEBUG fprintf(stderr, "====TESTING====\n")
#define VALUE(x) cerr << "The value of " << #x << " is " << x << endl
#define debug(...) fprintf(stderr, __VA_ARGS__)
#else
#define DEBUG
#define VALUE(x)
#define debug(...)
#endif

#define FOR(a, b, c) for (int(a) = (b); (a) < (c); ++(a))
#define FORN(a, b, c) for (int(a) = (b); (a) <= (c); ++(a))
#define FORD(a, b, c) for (int(a) = (b); (a) >= (c); --(a))
#define FORSQ(a, b, c) for (int(a) = (b); (a) * (a) <= (c); ++(a))
#define FORC(a, b, c) for (char(a) = (b); (a) <= (c); ++(a))
#define FOREACH(a, b) for (auto &(a) : (b))
#define REP(i, n) FOR(i, 0, n)
#define REPN(i, n) FORN(i, 1, n)
#define MAX(a, b) a = max(a, b)
#define MIN(a, b) a = min(a, b)
#define SQR(x) ((LL)(x) * (x))
#define RESET(a, b) memset(a, b, sizeof(a))
#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define ALL(v) v.begin(), v.end()
#define ALLA(arr, sz) arr, arr + sz
#define SIZE(v) (int)v.size()
#define SORT(v) sort(ALL(v))
#define REVERSE(v) reverse(ALL(v))
#define SORTA(arr, sz) sort(ALLA(arr, sz))
#define REVERSEA(arr, sz) reverse(ALLA(arr, sz))
#define PERMUTE next_permutation
#define TC(t) while (t--)

inline string IntToString(LL a)
{
  char x[100];
  sprintf(x, "%lld", a);
  string s = x;
  return s;
}

inline LL StringToInt(string a)
{
  char x[100];
  LL res;
  strcpy(x, a.c_str());
  sscanf(x, "%lld", &res);
  return res;
}

inline string GetString(void)
{
  char x[1000005];
  scanf("%s", x);
  string s = x;
  return s;
}

inline string uppercase(string s)
{
  int n = SIZE(s);
  REP(i, n)
  if (s[i] >= 'a' && s[i] <= 'z')
    s[i] = s[i] - 'a' + 'A';
  return s;
}

inline string lowercase(string s)
{
  int n = SIZE(s);
  REP(i, n)
  if (s[i] >= 'A' && s[i] <= 'Z')
    s[i] = s[i] - 'A' + 'a';
  return s;
}

inline void OPEN(string s)
{
#ifndef TESTING
  freopen((s + ".in").c_str(), "r", stdin);
  freopen((s + ".out").c_str(), "w", stdout);
#endif
}

const int mxN = 2e5;
int n , a[mxN], k;

void wordBrek(string s, vector<string> wordDict){
  int memo [s.size()]; // -1 for null, 0 for false, 1 for true
  set<string> dictionary;
  for(string word : wordDict){
    dictionary.insert(word);
  }
  int ans = recursive(s, 0, dictionary, memo);
  cout << (ans == 1 ? true : false) << endl;  
}

int recursive(string s, int start_idx, set<string> dictionary, int memo[]){
  if(start_idx == s.size()) return true;
  if(memo[start_idx] != -1){
    return memo[start_idx];
  }

  for(int i = start_idx; i < s.size(); i++){
    if(dictionary.find(s.substr(start_idx, i + 1))){
      if(recursive(s, i + 1, dictionary, memo)){
        memo[start_idx] = 1;
        return memo[i] = 1;
    }
  }
  return memo[i] = 0;
}


void solve(){
  string s;
  cin >> s; 
  cin >> n;
  vector<string> wordDict(n);
  REP(i,n) {
    cin >> wordDict[i];
  };
  wordBrek(s, wordDict);
  
  
}

int main(){
  ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
  OPEN("TEST");
  int T;
  cin >> T;
  FORN(t,1,T) {
    cout << "Case #" << t << ": ";
    solve();
  };
  return 0;
}