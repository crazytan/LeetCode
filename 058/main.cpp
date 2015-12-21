#include <iostream>

using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        if (s.size() <= 0) return 0;
        bool empty = true;
        for (int i = 0;i < s.size();i++)
            if (s[i] != ' ') {
                empty = false;
                break;
            }
        if (empty) return 0;
        while (s.back() == ' ') s.pop_back();
        string::size_type pos = s.rfind(' ');
        if (pos == string::npos) return (int) s.size();
        return int(s.size() - pos - 1);
    }
};

int main() {
    Solution sol;
    cout << sol.lengthOfLastWord("Hello ") << endl;
    return 0;
}