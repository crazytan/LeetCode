#include <iostream>
#include "ListNode.h"

ListNode *createList(int *vals, int n)
{
	ListNode *prev = NULL, *tmp;
	for (int i = n - 1;i >= 0;i--) {
		tmp = new ListNode(vals[i]);
		tmp->next = prev;
		prev = tmp;
	}
	return prev;
}

void deleteList(ListNode *head)
{
	ListNode *tmp;
	while (head != NULL) {
		tmp = head->next;
		delete head;
		head = tmp;
	}
}

void printList(ListNode *head)
{
	if (head == NULL) {
		std::cout << "NULL" << std::endl;
		return;
	}
	while (head != NULL) {
		std::cout << head->val << " ";
		head = head->next;
	}
	std::cout << std::endl;
}
