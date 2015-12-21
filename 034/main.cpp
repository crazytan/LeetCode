#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<int> _searchRange(vector<int>& nums, int target, vector<int>::size_type begin, vector<int>::size_type end) {
        if ((target < nums[begin]) || (target > nums[end - 1])) {
            vector<int> ans(arr, arr + 2);
            return ans;
        }
        if ((begin + 1) >= end) {
            vector<int> ans(2, (int) begin);
            return ans;
        }
        vector<int>::size_type mid = (begin + end) / 2;
        vector<int> leftAns = _searchRange(nums, target, begin, mid);
        vector<int> rightAns = _searchRange(nums, target, mid, end);
        if (leftAns[0] < 0) return rightAns;
        if (rightAns[0] < 0) return leftAns;
        vector<int> ans(2);
        ans[0] = leftAns[0];
        ans[1] = rightAns[1];
        return ans;
    }

    int arr[2] = {-1, -1};
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if ((target < nums[0]) || (target > nums.back())) {
            vector<int> ans(arr, arr + 2);
            return ans;
        }
        return _searchRange(nums, target, 0, nums.size());
    }
};

int main() {
    Solution sol;
    int arr[] = {5,7,7,8,8,10};
    vector<int> nums(arr, arr + sizeof(arr) / sizeof(arr[0]));
    vector<int> ans = sol.searchRange(nums, 1);
    cout << ans[0] << "  " << ans[1] << endl;
    return 0;
}