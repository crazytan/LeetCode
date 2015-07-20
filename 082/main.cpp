#include <iostream>
#include </Users/tan/OneDrive/LeetCode/ListNode.h>

using namespace std;

class Solution {
public:
	ListNode *deleteDuplicates(ListNode *head) {
		ListNode *dummy = new ListNode(-1);
		dummy->next = head;
		ListNode *prev = dummy;
		ListNode *tmp;
		while ((head != NULL) && (head->next != NULL)) {
			if (head->val == (head->next)->val) {
				tmp = head;
				while (tmp->val == (tmp->next)->val) {
					tmp = tmp->next;
					if (tmp->next == NULL) break;
				}
				prev->next = tmp->next;
				head = tmp->next;
			}
			else {
				prev = head;
				head = head->next;
			}
		}
		return dummy->next;
	}
};

int main()
{
	int n;
	cin >> n;
	int *vals = new int[n];
	for (int i = 0;i < n;i++) cin >> vals[i];
	ListNode *head;
	head = createList(vals, n);
	printList(head);
	
	Solution solution;
	head = solution.deleteDuplicates(head);
	printList(head);
	deleteList(head);
	return 0;
}
