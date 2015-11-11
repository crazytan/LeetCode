#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> vec;
        generate(0, n, "", vec);
        return vec;
    }

private:
    void generate(int right, int left, string curr, vector<string>& vec) {
        if ((right == 0) && (left == 0)) {
            vec.push_back(curr);
            return;
        }
        if (right > 0) generate(right - 1, left, curr + ')', vec);
        if (left > 0) generate(right + 1, left - 1, curr + '(', vec);
    }
};

int main()
{
    Solution s;
    vector<string> ans = s.generateParenthesis(3);
    for (int i = 0;i < ans.size(); i++)
        std::cout << ans[i] << std::endl;
    return 0;
}
