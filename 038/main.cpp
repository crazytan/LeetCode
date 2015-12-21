#include <iostream>

using namespace std;

class Solution {
private:
    string say(string s) {
        string ans;
        char prev = s[0];
        int cnt = 1;
        for (int i = 1;i < s.size();i++) {
            if (prev == s[i]) cnt++;
            else {
                ans += '0' + cnt;
                ans += prev;
                prev = s[i];
                cnt = 1;
            }
        }
        ans += '0' + cnt;
        ans += prev;
        return ans;
    }

public:
    string countAndSay(int n) {
        string s;
        s += '1';
        for (int i = 0;i < n - 1;i++)
            s = say(s);
        return s;
    }
};

int main() {
    Solution sol;
    cout << sol.countAndSay(2) << endl;
    return 0;
}