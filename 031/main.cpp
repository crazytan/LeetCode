#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    void swap(vector<int>& nums, vector<int>::size_type i, vector<int>::size_type j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    void reverse(vector<int>& nums, vector<int>::size_type st) {
        vector<int>::size_type n = nums.size(), l = n - st, i;
        for (i = st;i < st + l / 2;i++) swap(nums, i, 2 * st + l - i - 1);
    }

public:
    void nextPermutation(vector<int>& nums) {
        if (nums.size() <= 1) return;
        vector<int>::size_type i, n = nums.size();
        bool found = false;
        for (i = n - 1;i > 0;i--) {
            if (nums[i - 1] < nums[i]) {
                found = true;
                vector<int>::size_type pos = i;
                for (vector<int>::size_type j = i+1;j < n;j++) {
                    if (nums[j] > nums[i - 1])
                        pos = j;
                    else
                        break;
                }
                swap(nums, i - 1, pos);
                reverse(nums, i);
                break;
            }
        }
        if (!found) reverse(nums, 0);
    }
};

int main() {
    Solution sol;
    int arr[3] = {1,1,5};
    vector<int> nums(arr, arr + sizeof(arr) / sizeof(arr[0]));
    for (int i = 0;i < 10;i++) {
        sol.nextPermutation(nums);
        for (vector<int>::iterator iter = nums.begin(); iter != nums.end(); iter++)
            cout << *iter << " ";
        cout << endl;
    }
    return 0;
}