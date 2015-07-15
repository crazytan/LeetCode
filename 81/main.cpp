#include <iostream>
//#include </Users/tan/OneDrive/LeetCode/ListNode.h>

using namespace std;

class Solution {
public:
	bool search(int A[], int n, int target) {
		int l = 0, r = n - 1;
		int mid;
		while (l < r) {
			mid = (l + r) / 2;
			if (A[mid] == target) return true;
			if ((A[mid] > A[l]) && (A[mid] <= A[r])) {
				if (target > A[mid]) l = mid + 1;
				else r = mid;
			}
			else if ((A[mid] > A[l]) && (A[mid] > A[r])) {
				if ((target >= A[l]) && (target <= A[mid])) r = mid;
				else l = mid + 1;
			}
			else if (A[mid] < A[l]) {
				if ((target >= A[mid]) && (target <= A[r])) l = mid;
				else r = mid - 1;
			}
			else {
				if (A[l] > A[r]) l = mid + 1;
				else l++;
			}
		}

		if ((l == r) && (A[l] == target)) return true;
		return false;
	}
};

int main()
{
	int n, target;
	int vals[100];
	cin >> n >> target;
	for (int i = 0;i < n;i++) cin >> vals[i];
	Solution solution;
	cout << solution.search(vals, n, target) << endl;
	return 0;
}
