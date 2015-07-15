#include <iostream>

using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x): val(x), next(NULL) {}
};

class Solution {
public:
	ListNode *reverseBetween(ListNode *head, int m, int n) {
		if (m == n) return head;
		ListNode *m_ = NULL;
		ListNode *mm = NULL;
		ListNode *nn = NULL;
		ListNode *n_ = NULL;
		ListNode *prev = NULL;
		ListNode *headCache = head;
		int cnt = 1;
		while (cnt <= n) {
			if (cnt == (m - 1)) {
				m_ = head;
				head = head->next;
			}
			else if (cnt == m) {
				prev = mm = head;
				head = head->next;
			}
			else if ((cnt > m) && (cnt < n)) {
				ListNode *tmp = head->next;
				head->next = prev;
				prev = head;
				head = tmp;
			}
			else if (cnt == n) {
				nn = head;
				n_ = head->next;
				nn->next = prev;
				if (m_ != NULL) m_->next = nn;
				else mm->next = NULL;
				if (n_ != NULL) mm->next = n_;
				else mm->next = NULL;
			}
			else head = head->next;
			cnt++;
		}
		if (m_ == NULL) return nn;
		else return headCache;
	}
};

int main() {
	int cnt, m, n;
	int vals[100];
	cin >> cnt >> m >> n;
	for (int i = 0;i < cnt;i++)
		cin >> vals[i];
	ListNode *node = NULL;
	ListNode *tmp = NULL;
	for (int i = cnt - 1;i >= 0;i--) {
		tmp = new ListNode(vals[i]);
		tmp->next = node;
		node = tmp;
	}
	Solution solution;
	node = solution.reverseBetween(node, m, n);
    tmp = node;
	while (tmp != NULL) {
		cout << tmp->val << endl;
		tmp = tmp->next;
	}
	while (node != NULL) {
		tmp = node->next;
		delete node;
		node = tmp;
	}
	return 0;
}
