#include <iostream>

using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x): val(x), next(NULL) {}
};

class Solution {
public:
	ListNode *deleteDuplicates(ListNode *head) {
		ListNode *headCache = head;
		while (head != NULL) {
			if (head->next == NULL) break;
			if (head->val == (head->next)->val) 
				head->next = (head->next)->next;
			else head = head->next;
		}
		return headCache;
	}
};

int main() {
	int vals[100];
	int n;
	cin >> n;
	for (int i = 0;i < n;i++) cin >> vals[i];
	ListNode *prev = NULL;
	ListNode *tmp = NULL;
	for (int i = n - 1;i >= 0;i--) {
		tmp = new ListNode(vals[i]);
		tmp->next = prev;
		prev = tmp;
	}
	Solution solution;
	prev = solution.deleteDuplicates(prev);
	tmp = prev;
	while (tmp != NULL) {
		cout << tmp->val << endl;
		tmp = tmp->next;
	}
	while (prev != NULL) {
		tmp = prev->next;
		delete prev;
		prev = tmp;
	}
	return 0;
}
